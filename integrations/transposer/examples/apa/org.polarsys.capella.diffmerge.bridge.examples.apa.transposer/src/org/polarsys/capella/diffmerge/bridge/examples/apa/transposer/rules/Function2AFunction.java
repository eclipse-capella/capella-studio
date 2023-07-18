/*********************************************************************
 * Copyright (c) 2015-2019 Thales Global Services S.A.S.
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *    Thales Global Services S.A.S. - initial API and implementation
 **********************************************************************/
package org.polarsys.capella.diffmerge.bridge.examples.apa.transposer.rules;

import java.util.ArrayList;
import java.util.List;

import org.polarsys.capella.common.data.modellingcore.AbstractTypedElement;
import org.polarsys.capella.core.data.cs.AbstractDeploymentLink;
import org.polarsys.capella.core.data.cs.Part;
import org.polarsys.capella.core.data.fa.AbstractFunction;
import org.polarsys.capella.core.data.pa.PhysicalComponent;
import org.polarsys.capella.core.data.pa.deployment.PartDeploymentLink;
import org.polarsys.capella.diffmerge.bridge.examples.apa.ABehavior;
import org.polarsys.capella.diffmerge.bridge.examples.apa.AFunction;
import org.polarsys.capella.diffmerge.bridge.examples.apa.ApaFactory;
import org.polarsys.kitalpha.transposer.rules.handler.rules.api.IContext;
import org.polarsys.kitalpha.transposer.rules.handler.rules.api.IPremise;
import org.polarsys.kitalpha.transposer.transformation.context.ContextHelper;
import org.polarsys.kitalpha.transposer.transformation.rule.AbstractTransformationRule;


/**
 * Rule: AbstractFunction -> AFunction
 * @author Olivier Constant
 */
public class Function2AFunction extends AbstractTransformationRule<AbstractFunction> {
  
  /**
   * @see org.polarsys.kitalpha.transposer.transformation.rule.AbstractTransformationRule#create(java.lang.Object, org.polarsys.kitalpha.transposer.rules.handler.rules.api.IContext)
   */
  @Override
  protected Object create(AbstractFunction element_p, IContext context_p)
      throws Exception {
    AFunction result = ApaFactory.eINSTANCE.createAFunction();
    // Name
    result.setName(element_p.getName());
    // Container
    PhysicalComponent allocationComponent =
        (PhysicalComponent)element_p.getAllocationBlocks().get(0);
    Part allocationPart = (Part) allocationComponent.getTypedElements().get(0); // Monopart assumed
    PartDeploymentLink dLink = (PartDeploymentLink)allocationPart.getDeployingLinks().iterator().next();
    ABehavior container = (ABehavior)ContextHelper.getMainTarget(context_p, dLink);
    result.setOwningBehavior(container);
    return result;
  }
  
  /**
   * @see org.polarsys.kitalpha.transposer.rules.handler.rules.api.IRule#isApplicableOn(java.lang.Object)
   */
  public boolean isApplicableOn(AbstractFunction element_p) {
    boolean result = false;
    if (element_p.getAllocationBlocks().size() == 1 &&
        element_p.getAllocationBlocks().get(0) instanceof PhysicalComponent) {
      PhysicalComponent pc = (PhysicalComponent)element_p.getAllocationBlocks().get(0);
      if (pc.getAbstractTypedElements().size() == 1) {
        AbstractTypedElement typedElement = pc.getAbstractTypedElements().iterator().next();
        if (typedElement instanceof Part) {
          Part part = (Part)typedElement;
          if (part.getDeployingLinks().size() == 1) {
            AbstractDeploymentLink dLink = part.getDeployingLinks().iterator().next();
            result = dLink instanceof PartDeploymentLink;
          }
        }
      }
    }
    return result;
  }
  
  /**
   * @see org.polarsys.kitalpha.transposer.rules.handler.rules.api.IRule#getPremises(java.lang.Object)
   */
  public List<IPremise> getPremises(AbstractFunction element_p) {
    List<IPremise> result = new ArrayList<IPremise>();
    PhysicalComponent pc = (PhysicalComponent)element_p.getAllocationBlocks().get(0);
    AbstractTypedElement typedElement = pc.getAbstractTypedElements().iterator().next();
    PartDeploymentLink dLink = (PartDeploymentLink)((Part)typedElement).getDeployingLinks().iterator().next();
    result.add(createPrecedencePremise(dLink, "allocationTarget")); //$NON-NLS-1$
    return result;
  }
  
  /**
   * @see org.polarsys.kitalpha.transposer.transformation.rule.AbstractTransformationRule#update(java.lang.Object, java.lang.Object, org.polarsys.kitalpha.transposer.rules.handler.rules.api.IContext)
   */
  @Override
  protected void update(Object object_p, AbstractFunction element_p,
      IContext context_p) throws Exception {
    // No update
  }
  
}
