/*******************************************************************************
 * Copyright (c) 2015 Thales Global Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *   Thales Global Services S.A.S - initial API and implementation
 *******************************************************************************/
package org.polarsys.capella.extension.tools.ui;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.egf.portfolio.genchain.generationChain.EmfGeneration;
import org.eclipse.egf.portfolio.genchain.generationChain.GenerationChain;
import org.eclipse.egf.portfolio.genchain.generationChain.GenerationChainFactory;
import org.eclipse.egf.portfolio.genchain.generationChain.GenerationElement;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWizard;
import org.polarsys.kitalpha.emde.extension.utils.ExtensionAnnotationsHelper;

/**
 * @author Thomas Guiu
 * 
 */
public abstract class NewExtensionProjectWizard extends Wizard implements INewWizard {
	protected final TransactionalEditingDomain EDITING_DOMAIN = TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain();
	private final ResourceSet RESOURCE_SET = EDITING_DOMAIN.getResourceSet();
	protected NewExtensionProjectPage page;
	protected ISelection selection;
	private static final List<String> ECORE_VIEWPOINTS = new ArrayList<String>();
	static {
		ECORE_VIEWPOINTS.add("Extensibility");
		ECORE_VIEWPOINTS.add("Thales Documentation");
	}

	/**
	 * Constructor for NewExtensionProjectWizard.
	 */
	public NewExtensionProjectWizard() {
		super();
		setNeedsProgressMonitor(true);
	}

	/**
	 * This method is called when 'Finish' button is pressed in the wizard. We will create an operation and run it using wizard as execution context.
	 */
	public boolean performFinish() {
		final String fileName = page.getFileName();
		final String ecorePath = page.getEcoreModelPath();
		IRunnableWithProgress op = new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor) throws InvocationTargetException {
				try {
					doFinish(fileName, ecorePath, monitor);
				} catch (CoreException e) {
					throw new InvocationTargetException(e);
				} finally {
					monitor.done();
				}
			}
		};
		try {
			getContainer().run(true, false, op);
		} catch (InterruptedException e) {
			return false;
		} catch (InvocationTargetException e) {
			Throwable realException = e.getTargetException();
			MessageDialog.openError(getShell(), "Error", realException.getMessage());
			Activator.getDefault().getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "", realException));
			return false;
		}
		return true;
	}

	/**
	 * The worker method. It will find the container, create the file if missing or just replace its contents, and open the editor on the newly created file.
	 * 
	 * @param ecorePath
	 */

	private void doFinish(final String projectName, final String ecorePath, final IProgressMonitor monitor) throws CoreException {
		// create a sample file
		EDITING_DOMAIN.getCommandStack().execute(new RecordingCommand(EDITING_DOMAIN) {

			@Override
			protected void doExecute() {

				monitor.beginTask("Creating artifacts for extension " + projectName, 4);

				final IProject project = ResourceHelper.createProject(projectName);
				monitor.worked(1);

				String fileName = getFileName(projectName);
				List<Resource> ecoreResources = getEcoreModel(project, fileName, ecorePath);
				monitor.worked(1);

				Resource genChainResource = getGenChainResource(project, fileName, ecoreResources);
				monitor.worked(1);

				generateDiagrams(project, fileName, ecoreResources, genChainResource);
				monitor.worked(1);
			}

		});
	}

	private String getFileName(String projectName) {
		String[] split = projectName.split("\\.");
		if (split == null || split.length == 0) 
			return projectName;
			return split[split.length - 1];
	}

	private void generateDiagrams(IProject project, String fileName, final List<Resource> ecoreResources, final Resource genChainResource) {
	}

	private Resource getGenChainResource(IProject project, String fileName, List<Resource> ecoreResources) {
		Resource resource = RESOURCE_SET.createResource(URI.createPlatformResourceURI(project.getName() + "/model/" + fileName + ".generationchain", false));
		GenerationChain root = GenerationChainFactory.eINSTANCE.createGenerationChain();
		resource.getContents().add(root);

		root.setName(fileName);
		root.setFactoryComponentName(project.getName() + ".fc");
		for (Resource ecoreResource : ecoreResources) {
			final GenerationChain chain = GenerationChainFactory.eINSTANCE.createGenerationChain();
			EPackage ePackage = (EPackage) ecoreResource.getContents().get(0);
			chain.setName(ePackage.getName());
			root.getElements().add(chain);

			List<URI> uriList = new ArrayList<URI>();
			uriList.add(ecoreResource.getURI());

			CompoundCommand command = new CompoundCommand();

			addGenerationCommands(chain, uriList, command);

			RecordingCommand command3 = new RecordingCommand(EDITING_DOMAIN) {

				@Override
				protected void doExecute() {
					patch(chain);

				}

			};
			command.append(command3);

			EDITING_DOMAIN.getCommandStack().execute(command);

		}
		try {
			resource.save(null);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return resource;
	}

	protected abstract void addGenerationCommands(final GenerationChain chain, List<URI> uriList, CompoundCommand command);

	private void patch(GenerationChain chain) {
		for (GenerationElement element : chain.getElements()) {
			if (element instanceof EmfGeneration) {
				EmfGeneration model = (EmfGeneration) element;
				model.setGenerateEditor(false);
			}
		}

	}

	private List<Resource> getEcoreModel(IProject project, String resourceName, String ecorePath) {
		List<Resource> result = new ArrayList<Resource>();
		if (ecorePath != null && ecorePath.length() != 0) {
			StringTokenizer tokenizer = new StringTokenizer(ecorePath);
			while (tokenizer.hasMoreTokens()) {
				String uri = tokenizer.nextToken();
				Resource resource = RESOURCE_SET.getResource(URI.createURI(uri), true);
				if (resource != null) {
					result.add(resource);
				}
			}
		} else {
			Resource resource = RESOURCE_SET.createResource(URI.createPlatformResourceURI(project.getName() + "/model/" + resourceName + ".ecore", false));
			EClass elementExtensionCls = (EClass) RESOURCE_SET.getEObject(URI.createURI("platform:/plugin/org.polarsys.kitalpha.emde/model/eMDE.ecore#//ElementExtension"), true);
			EClass lcCls = (EClass) RESOURCE_SET.getEObject(URI.createURI("platform:/plugin/org.polarsys.capella.core.data.gen/model/LogicalArchitecture.ecore#//LogicalComponent"), true);
			EClass namedElementCls = (EClass) RESOURCE_SET.getEObject(URI.createURI("platform:/plugin/org.polarsys.capella.core.data.gen/model/CapellaCore.ecore#//NamedElement"), true);
			EPackage ePackage = EcoreFactory.eINSTANCE.createEPackage();
			ePackage.setName(resourceName);
			ePackage.setNsPrefix(resourceName);
			ePackage.setNsURI("http://" + resourceName + "/1.0.0");
			EAnnotation anno = EcoreFactory.eINSTANCE.createEAnnotation();
			anno.setSource(ExtensionAnnotationsHelper.EXTENSION_NS_URI);
			anno.getDetails().put("extensibleProviderFactory", "true");
			anno.getDetails().put("childCreationExtenders", "true");
			anno.getDetails().put(ExtensionAnnotationsHelper.USE_UUIDS, "true");
			anno.getDetails().put(ExtensionAnnotationsHelper.USE_ID_ATTRIBUTES, "false");
			ePackage.getEAnnotations().add(anno);

			EClass cls1 = EcoreFactory.eINSTANCE.createEClass();
			cls1.setName("InheritanceSample");
			cls1.getESuperTypes().add(lcCls);
			cls1.getESuperTypes().add(elementExtensionCls);

			EClass cls2 = EcoreFactory.eINSTANCE.createEClass();
			cls2.setName("AggregationSample");
			cls2.getESuperTypes().add(namedElementCls);
			cls2.getESuperTypes().add(elementExtensionCls);
			anno = EcoreFactory.eINSTANCE.createEAnnotation();
			anno.setSource(ExtensionAnnotationsHelper.CONSTRAINT_NS_URI);
			anno.getDetails().put(ExtensionAnnotationsHelper.EXTENDED_ELEMENT, "http://www.polarsys.org/capella/core/la/0.8.0#//LogicalComponent");
			cls2.getEAnnotations().add(anno);

			ePackage.getEClassifiers().add(cls1);
			ePackage.getEClassifiers().add(cls2);
			try {
				resource.getContents().add(ePackage);
				resource.save(null);
				result.add(resource);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * We will accept the selection in the workbench to see if we can initialize from it.
	 * 
	 * @see IWorkbenchWizard#init(IWorkbench, IStructuredSelection)
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.selection = selection;
	}

}
