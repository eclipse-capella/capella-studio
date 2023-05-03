/*********************************************************************
 * Copyright (c) 2014-2019 Thales Global Services S.A.S.
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *    Thales Global Services S.A.S. - initial API and implementation
 **********************************************************************/
package org.polarsys.capella.diffmerge.bridge.examples.apa.operations;

import java.util.Collection;
import java.util.List;

import org.apache.log4j.Level;
import org.eclipse.emf.diffmerge.api.scopes.IEditableModelScope;
import org.eclipse.emf.diffmerge.bridge.api.IBridge;
import org.eclipse.emf.diffmerge.bridge.impl.AbstractBridge;
import org.eclipse.emf.diffmerge.bridge.interactive.BridgeJob;
import org.eclipse.emf.diffmerge.bridge.interactive.EMFInteractiveBridge;
import org.eclipse.emf.diffmerge.bridge.mapping.api.IMappingExecution;
import org.eclipse.emf.diffmerge.bridge.mapping.api.IQuery;
import org.eclipse.emf.diffmerge.bridge.mapping.api.IQueryExecution;
import org.eclipse.emf.diffmerge.bridge.mapping.impl.CommonRule;
import org.eclipse.emf.diffmerge.bridge.mapping.impl.Query;
import org.eclipse.emf.diffmerge.bridge.mapping.impl.Rule;
import org.eclipse.emf.diffmerge.bridge.mapping.impl.emf.EMFMappingBridge;
import org.eclipse.emf.diffmerge.impl.policies.ConfigurableDiffPolicy;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.polarsys.capella.core.data.capellacore.Type;
import org.polarsys.capella.core.data.cs.DeployableElement;
import org.polarsys.capella.core.data.cs.Part;
import org.polarsys.capella.core.data.fa.AbstractFunction;
import org.polarsys.capella.core.data.fa.ComponentFunctionalAllocation;
import org.polarsys.capella.core.data.fa.FunctionalExchange;
import org.polarsys.capella.core.data.pa.PhysicalArchitecture;
import org.polarsys.capella.core.data.pa.PhysicalComponent;
import org.polarsys.capella.core.data.pa.PhysicalComponentNature;
import org.polarsys.capella.core.data.pa.deployment.PartDeploymentLink;
import org.polarsys.capella.diffmerge.bridge.examples.apa.ABehavior;
import org.polarsys.capella.diffmerge.bridge.examples.apa.AExchange;
import org.polarsys.capella.diffmerge.bridge.examples.apa.AFunction;
import org.polarsys.capella.diffmerge.bridge.examples.apa.ANode;
import org.polarsys.capella.diffmerge.bridge.examples.apa.AScope;
import org.polarsys.capella.diffmerge.bridge.examples.apa.ApaFactory;
import org.polarsys.capella.diffmerge.bridge.examples.apa.ApaPackage;
import org.polarsys.capella.diffmerge.bridge.examples.apa.Messages;


/**
 * A job that turns certain types of Capella physical architectures into models of a simplified metamodel.
 * @author Olivier Constant
 */
public class APABridgeJob extends BridgeJob<PhysicalArchitecture> {
  
	/**
	 * Constructor
	 * @param context_p a non-null physical architecture
	 */
	public APABridgeJob(PhysicalArchitecture context_p) {
	  super(Messages.APABridgeJob_Name, context_p,
	      context_p.eResource().getURI().trimFileExtension().appendFileExtension(ApaPackage.eNAME));
	}
	
	/**
	 * @see org.eclipse.emf.diffmerge.bridge.interactive.BridgeJob#getBridge()
	 */
	@Override
	protected EMFInteractiveBridge<PhysicalArchitecture, IEditableModelScope> getBridge() {
    // Bridge
	  final int PAUSE = getPauseDuration();
	  pause(PAUSE);
    final EMFMappingBridge<PhysicalArchitecture, IEditableModelScope> mapping =
        new EMFMappingBridge<PhysicalArchitecture, IEditableModelScope>();
    //******** QUERIES ********
    // Main component query
    final Query<PhysicalArchitecture, PhysicalComponent> mainPCQuery =
        new Query<PhysicalArchitecture, PhysicalComponent>(mapping) {
          public Iterable<PhysicalComponent> evaluate(
              PhysicalArchitecture source_p, IQueryExecution environment_p) {
            pause(PAUSE);
            return newIterable((PhysicalComponent)source_p.getSystem());
          }
        };
    // Nodes query
    final IQuery<PhysicalComponent, Part> nodesQuery =
        new Query<PhysicalComponent, Part>(mainPCQuery) {
          public Iterable<Part> evaluate(
              PhysicalComponent source_p, IQueryExecution environment_p) {
            pause(PAUSE);
            Collection<Part> result = newIterable();
            for (Part partition : source_p.getContainedParts()) {
              Type type = partition.getType();
              if (type instanceof PhysicalComponent &&
                  ((PhysicalComponent)type).getNature() ==
                  PhysicalComponentNature.NODE)
                result.add(partition);
            }
            return result;
          }
        };
    // Deployments query
    final IQuery<Part, PartDeploymentLink> deploymentsQuery =
        new Query<Part, PartDeploymentLink>(nodesQuery) {
          @SuppressWarnings({ "unchecked", "rawtypes" })
          public Iterable<PartDeploymentLink> evaluate(
              Part source_p, IQueryExecution environment_p) {
            pause(PAUSE);
            return ((Collection)source_p.getOwnedDeploymentLinks());
          }
        };
    // Allocated Functions query
    final IQuery<PartDeploymentLink, AbstractFunction> allocationsQuery =
        new Query<PartDeploymentLink, AbstractFunction>(deploymentsQuery) {
          public Iterable<AbstractFunction> evaluate(
              PartDeploymentLink source_p, IQueryExecution environment_p) {
            pause(PAUSE);
            List<AbstractFunction> result = newIterable();
            DeployableElement deployed = source_p.getDeployedElement();
            if (deployed instanceof Part) {
              Type type = ((Part)deployed).getType();
              if (type instanceof PhysicalComponent) {
                for (ComponentFunctionalAllocation allocation :
                  ((PhysicalComponent)type).getOwnedFunctionalAllocation()) {
                  result.add(allocation.getFunction());
                }
              }
            }
            return result;
          }
        };
    // Functional Exchanges query
    final IQuery<AbstractFunction, FunctionalExchange> exchangesQuery =
        new Query<AbstractFunction, FunctionalExchange>(allocationsQuery) {
          @SuppressWarnings({ "rawtypes", "unchecked" })
          public Iterable<FunctionalExchange> evaluate(
              AbstractFunction source_p, IQueryExecution environment_p) {
            pause(PAUSE);
            return (Collection)source_p.getOutgoing();
          }
        };
    //******** RULES ********
    // Rule: main PhysicalComponent -> AScope
    final Rule<PhysicalComponent, AScope> mainRule =
        new Rule<PhysicalComponent, AScope>(mainPCQuery, "PC2AScope") { //$NON-NLS-1$
      public void defineTarget(PhysicalComponent source_p,
          AScope target_p, IQueryExecution queryEnv_p,
          IMappingExecution ruleEnv_p) {
        pause(PAUSE);
        // Attachment to target scope
        ((IEditableModelScope)ruleEnv_p.getTargetDataSet()).add(target_p);
        // Name
        target_p.setName(source_p.getName());
      }
      public AScope createTarget(PhysicalComponent source_p, IQueryExecution queryExecution_p) {
        return ApaFactory.eINSTANCE.createAScope();
      }
    };
    // Rule: Node Part -> ANode
    final Rule<Part, ANode> nodeRule = new Rule<Part, ANode>(nodesQuery, "Part2ANode") { //$NON-NLS-1$
      public void defineTarget(Part source_p,
          ANode target_p, IQueryExecution queryEnv_p,
          IMappingExecution ruleEnv_p) {
        pause(PAUSE);
        // Name
        target_p.setName(source_p.getName());
        // Container
        AScope container = ruleEnv_p.get(
            (PhysicalComponent)source_p.eContainer(), mainRule);
        target_p.setOwningScope(container);
      }
      public ANode createTarget(Part source_p, IQueryExecution queryExecution_p) {
        return ApaFactory.eINSTANCE.createANode();
      }
    };
    // Rule: Behavior PartDeploymentLink -> ABehavior, trace on the deployed PhysicalComponent
    final CommonRule<PartDeploymentLink, PhysicalComponent, ABehavior> behaviorRule =
        new CommonRule<PartDeploymentLink, PhysicalComponent, ABehavior>(
            deploymentsQuery, "DeploymentLink2ABehavior") { //$NON-NLS-1$
      public void defineTarget(PartDeploymentLink source_p,
          ABehavior target_p, IQueryExecution queryEnv_p,
          IMappingExecution ruleEnv_p) {
        pause(PAUSE);
        // Name
        PhysicalComponent tracedSource = traceSource(source_p);
        target_p.setName(tracedSource.getName());
        // Container
        Part part = queryEnv_p.get(nodesQuery);
        ANode container = ruleEnv_p.get(part, nodeRule);
        target_p.setOwningNode(container);
      }
      public PhysicalComponent traceSource(PartDeploymentLink source_p) {
        return (PhysicalComponent)((Part)source_p.getDeployedElement()).getType();
      }
      public ABehavior createTarget(PartDeploymentLink source_p, IQueryExecution queryExecution_p) {
        return ApaFactory.eINSTANCE.createABehavior();
      }
    };
    // Rule: AbstractFunction -> AFunction
    final Rule<AbstractFunction, AFunction> functionRule =
        new Rule<AbstractFunction, AFunction>(allocationsQuery, "Function2AFunction") { //$NON-NLS-1$
      public void defineTarget(AbstractFunction source_p,
          AFunction target_p, IQueryExecution queryEnv_p,
          IMappingExecution ruleEnv_p) {
        pause(PAUSE);
        // Name
        target_p.setName(source_p.getName());
        // Container
        PartDeploymentLink dLink = queryEnv_p.get(deploymentsQuery);
        ABehavior container = ruleEnv_p.get(behaviorRule.traceSource(dLink), behaviorRule);
        target_p.setOwningBehavior(container);
      }
      public AFunction createTarget(AbstractFunction source_p, IQueryExecution queryExecution_p) {
        return ApaFactory.eINSTANCE.createAFunction();
      }
    };
    // Rule: FunctionalExchange -> AExchange
    new Rule<FunctionalExchange, AExchange>(exchangesQuery, "Exchange2AExchange") { //$NON-NLS-1$
      public void defineTarget(FunctionalExchange source_p,
          AExchange target_p, IQueryExecution queryEnv_p,
          IMappingExecution ruleEnv_p) {
        pause(PAUSE);
        // Name
        target_p.setName(source_p.getName());
        // Container
        PhysicalComponent mainComponent = queryEnv_p.get(mainPCQuery);
        AScope container = ruleEnv_p.get(mainComponent, mainRule);
        target_p.setOwningScope(container);
        // Source
        EObject sourceNode = source_p.getSource().eContainer();
        AFunction sourceAFunction = ruleEnv_p.get((AbstractFunction)sourceNode, functionRule);
        if (sourceAFunction != null)
          target_p.setSource(sourceAFunction);
        // Target
        EObject targetNode = source_p.getTarget().eContainer();
        AFunction targetAFunction = ruleEnv_p.get((AbstractFunction)targetNode, functionRule);
        if (targetAFunction != null)
          target_p.setTarget(targetAFunction);
      }
      public AExchange createTarget(FunctionalExchange source_p, IQueryExecution queryExecution_p) {
        return ApaFactory.eINSTANCE.createAExchange();
      }
    };
    ConfigurableDiffPolicy diffPolicy = new ConfigurableDiffPolicy();
    diffPolicy.setIgnoreOrders(true);
    EMFInteractiveBridge<PhysicalArchitecture, IEditableModelScope> result = 
        new EMFInteractiveBridge<PhysicalArchitecture, IEditableModelScope>(
            mapping, diffPolicy, null, null);
    setupLog(result);
    return result;
	}
	
	/**
	 * Return the duration for pauses
	 * @return a positive int or 0
	 */
  protected int getPauseDuration() {
    return 0;
  }
	
	/**
	 * Pause for the given duration, for testing purposes
	 * @param duration_p a positive int
	 */
  protected void pause(int duration_p) {
    try {
      Thread.sleep(duration_p);
    } catch (InterruptedException e) {
      // Proceed
    }
  }
	
  /**
   * Set up the log system of the given bridge if applicable
   * @param bridge_p a non-null bridge
   */
  protected void setupLog(IBridge<?,?> bridge_p) {
    if (bridge_p instanceof AbstractBridge<?,?>) {
      AbstractBridge<?,?> bridge = (AbstractBridge<?,?>)bridge_p;
      final boolean[] isLog = new boolean[1];
      Display.getDefault().syncExec(new Runnable() {
        /**
         * @see java.lang.Runnable#run()
         */
        public void run() {
          Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
          isLog[0] = MessageDialog.openQuestion(
              shell, Messages.APABridgeJob_Name, Messages.APABridgeJob_Log);
        }
      });
      Level logLevel = isLog[0]? Level.DEBUG: Level.OFF;
      bridge.getLogger().setLevel(logLevel);
    }
  }
  
}
