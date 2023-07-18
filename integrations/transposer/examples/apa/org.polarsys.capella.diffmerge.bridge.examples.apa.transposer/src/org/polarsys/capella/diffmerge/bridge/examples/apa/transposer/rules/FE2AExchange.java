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

import org.eclipse.emf.ecore.EObject;
import org.polarsys.capella.core.data.fa.FunctionalExchange;
import org.polarsys.capella.core.data.pa.PhysicalArchitecture;
import org.polarsys.capella.core.data.pa.PhysicalComponent;
import org.polarsys.capella.diffmerge.bridge.examples.apa.AExchange;
import org.polarsys.capella.diffmerge.bridge.examples.apa.AFunction;
import org.polarsys.capella.diffmerge.bridge.examples.apa.AScope;
import org.polarsys.capella.diffmerge.bridge.examples.apa.ApaFactory;
import org.polarsys.kitalpha.transposer.rules.handler.rules.api.IContext;
import org.polarsys.kitalpha.transposer.rules.handler.rules.api.IPremise;
import org.polarsys.kitalpha.transposer.transformation.context.ContextHelper;
import org.polarsys.kitalpha.transposer.transformation.rule.AbstractTransformationRule;


/**
 * Rule: FunctionalExchange -> AExchange
 * @author Olivier Constant
 */
public class FE2AExchange extends AbstractTransformationRule<FunctionalExchange> {
  
  /**
   * @see org.polarsys.kitalpha.transposer.transformation.rule.AbstractTransformationRule#create(java.lang.Object, org.polarsys.kitalpha.transposer.rules.handler.rules.api.IContext)
   */
  @Override
  protected Object create(FunctionalExchange element_p, IContext context_p)
      throws Exception {
    AExchange result = ApaFactory.eINSTANCE.createAExchange();
    // Name
    result.setName(element_p.getName());
    // Container
    PhysicalArchitecture archi = getOwningPhysicalArchitecture(element_p); // Should not be null because of premises
    PhysicalComponent mainComponent = (PhysicalComponent)archi.getSystem();
    AScope container = (AScope)ContextHelper.getMainTarget(context_p, mainComponent);
    result.setOwningScope(container);
    // Source
    EObject sourceElement = element_p.getSource().eContainer();
    AFunction sourceAFunction = (AFunction)ContextHelper.getMainTarget(context_p, sourceElement);
    if (sourceAFunction != null)
      result.setSource(sourceAFunction);
    // Target
    EObject targetElement = element_p.getTarget().eContainer();
    AFunction targetAFunction = (AFunction)ContextHelper.getMainTarget(context_p, targetElement);
    if (targetAFunction != null)
      result.setTarget(targetAFunction);
    return result;
  }
  
  /**
   * Return the physical architecture that contains the given element, if any
   * @param element_p a non-null element
   * @return a potentially null object
   */
  protected PhysicalArchitecture getOwningPhysicalArchitecture(EObject element_p) {
    PhysicalArchitecture result = null;
    EObject container = element_p.eContainer();
    while (!(container instanceof PhysicalArchitecture) && container != null) {
      container = container.eContainer();
    }
    if (container instanceof PhysicalArchitecture)
      result = (PhysicalArchitecture)container;
    return result;
  }
  
  /**
   * @see org.polarsys.kitalpha.transposer.rules.handler.rules.api.IRule#isApplicableOn(java.lang.Object)
   */
  public boolean isApplicableOn(FunctionalExchange element_p) {
    return true;
  }
  
  /**
   * @see org.polarsys.kitalpha.transposer.rules.handler.rules.api.IRule#getPremises(java.lang.Object)
   */
  public List<IPremise> getPremises(FunctionalExchange element_p) {
    List<IPremise> result = new ArrayList<IPremise>();
    result.add(createPrecedencePremise(element_p.getSource().eContainer(), "exchangeSource")); //$NON-NLS-1$
    result.add(createPrecedencePremise(element_p.getTarget().eContainer(), "exchangeTarget")); //$NON-NLS-1$
    return result;
  }
  
  /**
   * @see org.polarsys.kitalpha.transposer.transformation.rule.AbstractTransformationRule#update(java.lang.Object, java.lang.Object, org.polarsys.kitalpha.transposer.rules.handler.rules.api.IContext)
   */
  @Override
  protected void update(Object object_p, FunctionalExchange element_p,
      IContext context_p) throws Exception {
    // No update
  }
  
}
