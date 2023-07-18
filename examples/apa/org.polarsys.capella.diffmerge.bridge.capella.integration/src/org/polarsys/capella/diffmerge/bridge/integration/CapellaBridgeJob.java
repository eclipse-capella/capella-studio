/*********************************************************************
 * Copyright (c) 2016-2019 Thales Global Services S.A.S.
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *    Thales Global Services S.A.S. - initial API and implementation
 **********************************************************************/
package org.polarsys.capella.diffmerge.bridge.integration;

import static org.eclipse.emf.diffmerge.impl.policies.ConfigurableMatchPolicy.CRITERION_SEMANTICS_DEFAULTCONTENTS;
import static org.eclipse.emf.diffmerge.impl.policies.ConfigurableMatchPolicy.CRITERION_STRUCTURE_ROOTS;
import static org.eclipse.emf.diffmerge.impl.policies.ConfigurableMatchPolicy.MatchCriterionKind.SEMANTICS;
import static org.eclipse.emf.diffmerge.impl.policies.ConfigurableMatchPolicy.MatchCriterionKind.STRUCTURE;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.diffmerge.generic.api.IDiffPolicy;
import org.eclipse.emf.diffmerge.generic.api.IMatchPolicy;
import org.eclipse.emf.diffmerge.generic.api.IMergePolicy;
import org.eclipse.emf.diffmerge.generic.api.IMergeSelector;
import org.eclipse.emf.diffmerge.api.scopes.IEditableModelScope;
import org.eclipse.emf.diffmerge.bridge.api.IBridge;
import org.eclipse.emf.diffmerge.bridge.api.IBridgeTrace;
import org.eclipse.emf.diffmerge.bridge.api.IBridgeTrace.Editable;
import org.eclipse.emf.diffmerge.bridge.interactive.BridgeJob;
import org.eclipse.emf.diffmerge.bridge.interactive.EMFInteractiveBridge;
import org.eclipse.emf.diffmerge.bridge.interactive.util.ResourceUtil;
import org.eclipse.emf.diffmerge.bridge.mapping.impl.emf.EMFMappingBridge;
import org.eclipse.emf.diffmerge.diffdata.EComparison;
import org.eclipse.emf.diffmerge.diffdata.impl.EComparisonImpl;
import org.eclipse.emf.diffmerge.impl.policies.ConfigurableDiffPolicy;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.polarsys.capella.common.ef.ExecutionManager;
import org.polarsys.capella.common.ef.ExecutionManagerRegistry;
import org.polarsys.capella.common.ef.command.ICommand;
import org.polarsys.capella.core.compare.CapellaMatchPolicy;
import org.polarsys.capella.core.data.capellamodeller.Project;
import org.polarsys.capella.core.model.handler.helpers.CapellaProjectHelper.ProjectApproach;
import org.polarsys.capella.core.model.skeleton.EngineeringDomain;
import org.polarsys.capella.core.model.skeleton.impl.SkeletonServicesImpl;
import org.polarsys.capella.core.model.skeleton.impl.cmd.CreateCapellaProjectCmd;
import org.polarsys.capella.diffmerge.bridge.integration.policies.DelegatingTraceBasedMatchPolicy;
import org.polarsys.capella.diffmerge.bridge.integration.scopes.CapellaIntermediateUpdateScope;
import org.polarsys.capella.diffmerge.bridge.integration.scopes.CapellaUpdateScope;


/**
 * A bridge job pre-configured for Capella models as targets.
 *
 * @author Amine Lajmi
 * 
 * @param <SD> the source data set
 */
public class CapellaBridgeJob<SD> extends BridgeJob<SD> {

	/**
	 * The default bridge job label
	 */
	private static final String DEFAULT_BRIDGE_JOB_LABEL = "Capella Bridge Job"; //$NON-NLS-1$

	/**
	 * The default constructor
	 * 
	 * @param context_p the (non-null) source data set
	 * @param targetURI_p the (non-null) uri of the target resource
	 */
	public CapellaBridgeJob(SD context_p, URI targetURI_p) {
		this(DEFAULT_BRIDGE_JOB_LABEL, context_p, targetURI_p);
	}

	/**
	 * Additional constructor with custom bridge job label
	 * 
	 * @param jobLabel_p the (non-null) job label
	 * @param context_p the (non-null) context
	 * @param targetURI_p the (non-null) uri of the target resource
	 */
	public CapellaBridgeJob(String jobLabel_p, SD context_p, URI targetURI_p) {
		super(jobLabel_p, context_p, targetURI_p);
	}

	/**
	 * @see org.eclipse.emf.diffmerge.bridge.interactive.BridgeJob#getBridge()
	 */
	@Override
	protected EMFInteractiveBridge<SD, IEditableModelScope> getBridge() {
		EMFInteractiveBridge<SD, IEditableModelScope> result =
		    new EMFInteractiveBridge<SD, IEditableModelScope>(
		        createMappingBridge(), createDiffPolicy(), createMergePolicy(), createMergeSelector()) {
		  /**
		   * @see org.eclipse.emf.diffmerge.bridge.incremental.EMFIncrementalBridge#createIntermediateDataSet(java.lang.Object, org.eclipse.emf.diffmerge.api.scopes.IEditableModelScope)
		   */
			@Override
			public IEditableModelScope createIntermediateDataSet(SD sourceDataSet_p, IEditableModelScope targetDataSet_p) {
				if (targetDataSet_p instanceof CapellaUpdateScope) {
					// make an in-memory copy of the existing model
					final Project emptyProject = createEmptyProject(targetDataSet_p);
					CapellaUpdateScope scope = new CapellaUpdateScope(emptyProject);
					return createIntermediateCapellaScope(sourceDataSet_p, scope);
				}
				return super.createIntermediateDataSet(sourceDataSet_p,	targetDataSet_p);
			}
			/**
			 * @see org.eclipse.emf.diffmerge.bridge.incremental.EMFIncrementalBridge#compare(org.eclipse.emf.diffmerge.api.scopes.IEditableModelScope, org.eclipse.emf.diffmerge.api.scopes.IEditableModelScope, org.eclipse.emf.diffmerge.bridge.api.IBridgeTrace, org.eclipse.emf.diffmerge.bridge.api.IBridgeTrace, org.eclipse.core.runtime.IProgressMonitor)
			 */
			@Override
			protected EComparison compare(IEditableModelScope created_p, IEditableModelScope existing_p, IBridgeTrace createdTrace_p, IBridgeTrace existingTrace_p,	IProgressMonitor monitor_p) {
				EComparison comparison = new EComparisonImpl(existing_p, created_p);
				IMatchPolicy<EObject> delegate = createMatchPolicyDelegate();
				IMatchPolicy<EObject> matchPolicy = createDelegatingMatchPolicy(created_p, createdTrace_p, existingTrace_p, delegate);
				comparison.compute(matchPolicy, getDiffPolicy(), getMergePolicy(), monitor_p);
				return comparison;
			}
			
			/**
			 * @see org.eclipse.emf.diffmerge.bridge.incremental.EMFIncrementalBridge#createTrace()
			 */
			@Override
			protected Editable createTrace() {
				Editable trace = super.createTrace();
				return configureTrace(trace);
			}
		};
		return result;
	}

	/**
	 * For default trace customization
	 * 
	 * @param trace_p the (non-null) the default created trace
	 * @return the (non-null) trace with additional configurations, by default
	 *         do nothing.
	 */
	protected Editable configureTrace(Editable trace_p) {
		return trace_p;
	}

	/**
	 * @return the default merge policy
	 */
	protected IMergePolicy<EObject> createMergePolicy() {
		return null;
	}

	/**
	 * @return the default merge selector
	 */
	protected IMergeSelector<EObject> createMergeSelector() {
		return null;
	}

	/**
	 * @return the default configurable diff policy
	 */
	protected IDiffPolicy<EObject> createDiffPolicy() {
		return new ConfigurableDiffPolicy();
	}

	/**
	 * @return the extended EMF mapping bridge
	 */
	protected IBridge<SD, IEditableModelScope> createMappingBridge() {
		return new EMFMappingBridge<SD, IEditableModelScope>();
	}

	/**
	 * Creates and configures the match policy to delegate to. By default, the
	 * following fine-grained criteria are used:
	 *  <li> Structural matching of roots
	 *  <li> Semantic matching of project structure
	 * 
	 * @return the match policy to delegate to.
	 */
	protected IMatchPolicy<EObject> createMatchPolicyDelegate() {
	  CapellaMatchPolicy delegate = new CapellaMatchPolicy();
	  delegate.setUseCriterion(STRUCTURE, true);
    delegate.setUseCriterion(SEMANTICS, true);
		delegate.setUseFineGrainedCriterion(CRITERION_STRUCTURE_ROOTS, true);
		delegate.setUseFineGrainedCriterion(CRITERION_SEMANTICS_DEFAULTCONTENTS, true);
		return delegate;
	}
	
  /**
   * Creates and configures a delegating match policy with default delegation
   * configured to the match policy returned by
   * {@link org.polarsys.capella.diffmerge.bridge.integration.CapellaBridgeJob#createMatchPolicyDelegate()
   * createMatchPolicyDelegate}.
   * 
   * @param createdScope_p a non-null model scope
   * @param createdTrace_p a non-null trace
   * @param existingTrace_p a non-null trace
   * @param delegate_p the non-null match policy to delegate to
   * @return the delegating match policy.
   */
  protected IMatchPolicy<EObject> createDelegatingMatchPolicy(IEditableModelScope createdScope_p,
      IBridgeTrace createdTrace_p, IBridgeTrace existingTrace_p, IMatchPolicy<EObject> delegate_p) {
    IMatchPolicy<EObject> matchPolicy = new DelegatingTraceBasedMatchPolicy(
        createdScope_p, createdTrace_p, existingTrace_p, delegate_p);
    return matchPolicy;
  }

	/**
	 * Creates an intermediate model scope tailored for Capella models
	 * 
	 * @param sourceDataSet_p the (non-null) source data set
	 * @param scope the (non-null) Capella model scope
	 * @return the intermediate model scope
	 */
	protected IEditableModelScope createIntermediateCapellaScope(SD sourceDataSet_p, CapellaUpdateScope scope) {
		return new CapellaIntermediateUpdateScope(sourceDataSet_p, scope);
	}

	/**
	 * Creates a fake resource hosting a freshly created empty Capella model
	 * 
	 * @param targetDataSet_p
	 *            the target data set from which to retrieve and load the
	 *            Capella model
	 * @return a fresh empty Capella model root
	 */
	protected Project createEmptyProject(final IEditableModelScope targetDataSet_p) {
		TransactionalEditingDomain editingDomain = getTargetEditingDomain(targetDataSet_p);
		Project capellaRoot = ((CapellaUpdateScope) targetDataSet_p).getProject();
		URI targetURI = capellaRoot.eResource().getURI();

		// create a new empty model
		ExecutionManager executionManager = ExecutionManagerRegistry
				.getInstance().getExecutionManager(editingDomain);
		ResourceSet resourceSet = editingDomain.getResourceSet();

		Resource resource = resourceSet.getResource(targetURI, true);
		final Project project = (Project) resource.getContents().get(0);

		ICommand command = null;
		Resource semanticResource = null;
		String projectName = project.getName();

		URI uri = URI.createURI("dummy:/" + targetURI.devicePath()); //$NON-NLS-1$

		semanticResource = resourceSet.createResource(uri);
		command = createInitialElementsCommand(semanticResource, projectName, new NullProgressMonitor());
		if (command != null) {
			executionManager.execute(command);
		}
		// invoke the skeleton services used by default in Capella to create the
		// in-memory empty Capella project
		SkeletonServicesImpl skeletonServicesImpl = new SkeletonServicesImpl();
		EngineeringDomain engDomain = EngineeringDomain.System;
		Project tmpProject = (Project) semanticResource.getContents().get(0);
		skeletonServicesImpl.doSystemEngineering(tmpProject, projectName, engDomain, true);
		return tmpProject;
	}

	/**
	 * Returns the transactional editing domain given the target data set
	 * 
	 * @param targetDataSet_p the (non-null) target data set
	 * @return the (possibly null) editing domain
	 */
	protected TransactionalEditingDomain getTargetEditingDomain(IEditableModelScope targetDataSet_p) {
		if (targetDataSet_p instanceof CapellaUpdateScope) {
			EObject scopeRoot = ((CapellaUpdateScope) targetDataSet_p).getProject();
			ResourceSet resourceSet = scopeRoot.eResource().getResourceSet();
			return (TransactionalEditingDomain) AdapterFactoryEditingDomain.getEditingDomainFor(resourceSet);
		}
		return null;
	}

	/**
	 * Issues the initial Capella model elements creation command
	 * 
	 * @param resource_p the initially empty semantic resource
	 * @param projectName_p the (non-null) Capella project name
	 * @param monitor_p a (non-null) progress monitor
	 * @return the initial elements creation command
	 */
	protected ICommand createInitialElementsCommand(Resource resource_p, String projectName_p, IProgressMonitor monitor_p) {
		return new CreateCapellaProjectCmd(resource_p, projectName_p, ProjectApproach.SingletonComponents);
	}

	/**
	 * @see org.eclipse.emf.diffmerge.bridge.interactive.BridgeJob#getTargetEditingDomain()
	 */
	@Override
	protected EditingDomain getTargetEditingDomain() {
		EditingDomain result = null;
		ResourceSet rs = getTargetResourceSet();
		result = AdapterFactoryEditingDomain.getEditingDomainFor(rs);
		return result;
	}

	/**
	 * @see org.eclipse.emf.diffmerge.bridge.interactive.BridgeJob#initializeTargetResourceSet()
	 */
	@Override
	protected ResourceSet initializeTargetResourceSet() {
		ExecutionManager executionManager = ExecutionManagerRegistry.getInstance().addNewManager();
		TransactionalEditingDomain domain = executionManager.getEditingDomain();
		return domain.getResourceSet();
	}

	/**
	 * Loads trace resource into a separate resource set.
	 * 
	 * @param traceURI_p
	 *            the (non-null) trace URI
	 * @return trace resource
	 */
	@Override
	protected Resource getCreateTraceResource(URI traceURI_p) {
		ResourceSetImpl rs = new ResourceSetImpl();
		Resource traceResource = ResourceUtil.getCreateResourceForUri(traceURI_p, rs);
		ResourceUtil.ensureLoaded(traceResource);
		return traceResource;
	}

	/**
	 * @see org.eclipse.emf.diffmerge.bridge.interactive.BridgeJob#getTargetScope(org.eclipse.emf.ecore.resource.Resource)
	 */
	@Override
	protected IEditableModelScope getTargetScope(final Resource resource_p) {
		Project project = (Project) resource_p.getContents().get(0);
		return new CapellaUpdateScope(project);
	}
}
