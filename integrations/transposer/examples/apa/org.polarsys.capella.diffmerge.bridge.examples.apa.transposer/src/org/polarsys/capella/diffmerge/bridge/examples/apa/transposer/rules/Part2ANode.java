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
import org.polarsys.capella.core.data.cs.Part;
import org.polarsys.capella.core.data.pa.PhysicalComponent;
import org.polarsys.capella.core.data.pa.PhysicalComponentNature;
import org.polarsys.capella.diffmerge.bridge.examples.apa.ANode;
import org.polarsys.capella.diffmerge.bridge.examples.apa.AScope;
import org.polarsys.capella.diffmerge.bridge.examples.apa.ApaFactory;
import org.polarsys.kitalpha.transposer.rules.handler.rules.api.IContext;
import org.polarsys.kitalpha.transposer.rules.handler.rules.api.IPremise;
import org.polarsys.kitalpha.transposer.transformation.context.ContextHelper;
import org.polarsys.kitalpha.transposer.transformation.rule.AbstractTransformationRule;


/**
 * Rule: Part -> ANode
 * @author Olivier Constant
 */
public class Part2ANode extends AbstractTransformationRule<Part> {
  
  /**
   * @see org.polarsys.kitalpha.transposer.transformation.rule.AbstractTransformationRule#create(java.lang.Object, org.polarsys.kitalpha.transposer.rules.handler.rules.api.IContext)
   */
  @Override
  protected Object create(Part element_p, IContext context_p)
      throws Exception {
    ANode result = ApaFactory.eINSTANCE.createANode();
    result.setName(element_p.getName());
    AScope container = (AScope)ContextHelper.getMainTarget(context_p, element_p.eContainer());
    result.setOwningScope(container);
    return result;
  }
  
  /**
   * @see org.polarsys.kitalpha.transposer.rules.handler.rules.api.IRule#isApplicableOn(java.lang.Object)
   */
  public boolean isApplicableOn(Part element_p) {
    boolean result = false;
    Type type = element_p.getType();
    if (type instanceof PhysicalComponent) {
      PhysicalComponent pc = (PhysicalComponent)type;
      result = pc.getNature() == PhysicalComponentNature.NODE;
    }
    return result;
  }
  
  /**
   * @see org.polarsys.kitalpha.transposer.rules.handler.rules.api.IRule#getPremises(java.lang.Object)
   */
  public List<IPremise> getPremises(Part element_p) {
    return Collections.<IPremise>singletonList(
        createPrecedencePremise(element_p.eContainer(), "container")); //$NON-NLS-1$
  }
  
  /**
   * @see org.polarsys.kitalpha.transposer.transformation.rule.AbstractTransformationRule#update(java.lang.Object, java.lang.Object, org.polarsys.kitalpha.transposer.rules.handler.rules.api.IContext)
   */
  @Override
  protected void update(Object object_p, Part element_p,
      IContext context_p) throws Exception {
    // No update
  }
  
}
