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

import java.util.Collections;
import java.util.List;

import org.polarsys.capella.core.data.capellacore.Type;
import org.polarsys.capella.core.data.cs.DeployableElement;
import org.polarsys.capella.core.data.cs.DeploymentTarget;
import org.polarsys.capella.core.data.cs.Part;
import org.polarsys.capella.core.data.pa.deployment.PartDeploymentLink;
import org.polarsys.capella.diffmerge.bridge.examples.apa.ABehavior;
import org.polarsys.capella.diffmerge.bridge.examples.apa.ANode;
import org.polarsys.capella.diffmerge.bridge.examples.apa.ApaFactory;
import org.polarsys.kitalpha.transposer.rules.handler.rules.api.IContext;
import org.polarsys.kitalpha.transposer.rules.handler.rules.api.IPremise;
import org.polarsys.kitalpha.transposer.transformation.context.ContextHelper;
import org.polarsys.kitalpha.transposer.transformation.rule.AbstractTransformationRule;


/**
 * Rule: PartDeploymentLink -> ABehavior
 * @author Olivier Constant
 */
public class PDL2ABehavior extends AbstractTransformationRule<PartDeploymentLink> {
  
  /**
   * @see org.polarsys.kitalpha.transposer.transformation.rule.AbstractTransformationRule#create(java.lang.Object, org.polarsys.kitalpha.transposer.rules.handler.rules.api.IContext)
   */
  @Override
  protected Object create(PartDeploymentLink element_p, IContext context_p)
      throws Exception {
    ABehavior result = ApaFactory.eINSTANCE.createABehavior();
    // Attributes
    DeployableElement deployed = element_p.getDeployedElement();
    Type deployedType = ((Part)deployed).getType();
    result.setName(deployedType.getName());
    // Container
    DeploymentTarget deploymentTarget = element_p.getLocation();
    ANode container = (ANode)ContextHelper.getMainTarget(context_p, deploymentTarget);
    result.setOwningNode(container);
    return result;
  }
  
  /**
   * @see org.polarsys.kitalpha.transposer.rules.handler.rules.api.IRule#isApplicableOn(java.lang.Object)
   */
  public boolean isApplicableOn(PartDeploymentLink element_p) {
    return true;
  }
  
  /**
   * @see org.polarsys.kitalpha.transposer.rules.handler.rules.api.IRule#getPremises(java.lang.Object)
   */
  public List<IPremise> getPremises(PartDeploymentLink element_p) {
    return Collections.<IPremise>singletonList(
        createPrecedencePremise(element_p.getLocation(), "location")); //$NON-NLS-1$
  }
  
  /**
   * @see org.polarsys.kitalpha.transposer.transformation.rule.AbstractTransformationRule#update(java.lang.Object, java.lang.Object, org.polarsys.kitalpha.transposer.rules.handler.rules.api.IContext)
   */
  @Override
  protected void update(Object object_p, PartDeploymentLink element_p,
      IContext context_p) throws Exception {
    // No update
  }
  
}
