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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.polarsys.capella.core.data.cs.CsPackage;
import org.polarsys.capella.core.data.pa.PhysicalComponent;
import org.polarsys.capella.diffmerge.bridge.examples.apa.AScope;
import org.polarsys.capella.diffmerge.bridge.examples.apa.ApaFactory;
import org.polarsys.kitalpha.transposer.rules.handler.rules.api.IContext;
import org.polarsys.kitalpha.transposer.rules.handler.rules.api.IPremise;
import org.polarsys.kitalpha.transposer.transformation.emf.resource.ResourceUtil;
import org.polarsys.kitalpha.transposer.transformation.rule.AbstractTransformationRule;


/**
 * Rule: PC -> AScope
 * @author Olivier Constant
 */
public class PC2AScope extends AbstractTransformationRule<PhysicalComponent> {
  
  /**
   * Attach the given element to the target model as root
   * @param element_p a non-null element
   * @param context_p a non-null context
   */
  protected void attach(EObject element_p, IContext context_p) {
    ResourceSet rs = (ResourceSet) context_p.get(ResourceUtil.TRANSPOSER_RESOURCE_SET);
    if (rs != null && !rs.getResources().isEmpty()) {
      Resource resource = rs.getResources().get(0);
      resource.getContents().add(element_p);
    }
  }
  
  /**
   * @see org.polarsys.kitalpha.transposer.transformation.rule.AbstractTransformationRule#create(java.lang.Object, org.polarsys.kitalpha.transposer.rules.handler.rules.api.IContext)
   */
  @Override
  protected Object create(PhysicalComponent element_p, IContext context_p)
      throws Exception {
    AScope result = ApaFactory.eINSTANCE.createAScope();
    result.setName(element_p.getName());
    attach(result, context_p);
    return result;
  }
  
  /**
   * @see org.polarsys.kitalpha.transposer.rules.handler.rules.api.IRule#isApplicableOn(java.lang.Object)
   */
  public boolean isApplicableOn(PhysicalComponent element_p) {
    return CsPackage.eINSTANCE.getBlockArchitecture_System() ==
        element_p.eContainingFeature();
  }
  
  /**
   * @see org.polarsys.kitalpha.transposer.rules.handler.rules.api.IRule#getPremises(java.lang.Object)
   */
  public List<IPremise> getPremises(PhysicalComponent element_p) {
    return Collections.emptyList();
  }
  
  /**
   * @see org.polarsys.kitalpha.transposer.transformation.rule.AbstractTransformationRule#update(java.lang.Object, java.lang.Object, org.polarsys.kitalpha.transposer.rules.handler.rules.api.IContext)
   */
  @Override
  protected void update(Object object_p, PhysicalComponent element_p,
      IContext context_p) throws Exception {
    // No update
  }
  
}
