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
package org.polarsys.capella.diffmerge.bridge.examples.apa2capella.rules;

import org.eclipse.emf.diffmerge.bridge.mapping.api.IMappingExecution;
import org.eclipse.emf.diffmerge.bridge.mapping.api.IQuery;
import org.eclipse.emf.diffmerge.bridge.mapping.api.IQueryExecution;
import org.eclipse.emf.diffmerge.bridge.mapping.impl.Rule;
import org.eclipse.emf.diffmerge.bridge.mapping.impl.RuleIdentifier;
import org.eclipse.emf.diffmerge.bridge.util.structures.Tuple2;
import org.polarsys.capella.core.data.cs.CsFactory;
import org.polarsys.capella.core.data.cs.Part;
import org.polarsys.capella.core.data.information.AggregationKind;
import org.polarsys.capella.core.data.pa.PaFactory;
import org.polarsys.capella.core.data.pa.PhysicalComponent;
import org.polarsys.capella.core.data.pa.PhysicalComponentNature;
import org.polarsys.capella.diffmerge.bridge.examples.apa.ANode;
import org.polarsys.capella.diffmerge.bridge.integration.scopes.CapellaUpdateScope;
import org.polarsys.capella.diffmerge.bridge.integration.util.CapellaUtil;

/**
 * @author Amine Lajmi
 *
 */
public class ANode2PhysicalComponentRule  extends Rule<ANode, Tuple2<PhysicalComponent, Part>> {

  /**
   * The rule identifier
   */
  public static final RuleIdentifier<ANode, Tuple2<PhysicalComponent, Part>> ID = new RuleIdentifier<ANode, Tuple2<PhysicalComponent, Part>>(
      "ANode2PhysicalComponentRule"); //$NON-NLS-1$

  /**
   * @param provider_p (non-null)
   */
  public ANode2PhysicalComponentRule(IQuery<?, ? extends ANode> provider_p) {
    super(provider_p, ID);
  }

  /**
   * @see org.eclipse.emf.diffmerge.bridge.mapping.api.IRule#createTarget(java.lang.Object,
   *      org.eclipse.emf.diffmerge.bridge.mapping.api.IQueryExecution)
   */
  public Tuple2<PhysicalComponent, Part> createTarget(ANode source_p,
      IQueryExecution queryExecution_p) {
    PhysicalComponent pc = PaFactory.eINSTANCE.createPhysicalComponent();
    Part pt = CsFactory.eINSTANCE.createPart();

    // workaround to force Capella Id creation
    pc.getId();
    pt.getId();
    return new Tuple2<PhysicalComponent, Part>(pc, pt);
  }

  /**
   * @see org.eclipse.emf.diffmerge.bridge.mapping.api.IRule#defineTarget(java.lang.Object, java.lang.Object, org.eclipse.emf.diffmerge.bridge.mapping.api.IQueryExecution, org.eclipse.emf.diffmerge.bridge.mapping.api.IMappingExecution)
   */
  public void defineTarget(final ANode source_p,
		  final Tuple2<PhysicalComponent, Part> target_p,
		  IQueryExecution queryExecution_p, IMappingExecution mappingExecution_p) {
	  // Physical Component
	  PhysicalComponent physicalComponent = target_p.get1();
	  physicalComponent.setName(source_p.getName());
	  physicalComponent.setNature(PhysicalComponentNature.NODE);
	  // Part
	  Part physicalPart = target_p.get2();
	  physicalPart.setName(source_p.getName());
	  physicalPart.setAggregationKind(AggregationKind.UNSET);
	  physicalPart.setAbstractType(physicalComponent);
	  // Storage
    CapellaUpdateScope targetScope = mappingExecution_p.getTargetDataSet();
    PhysicalComponent rootPhysicalSystem = CapellaUtil.getPhysicalSystemRoot(targetScope.getProject());
    rootPhysicalSystem.getOwnedPhysicalComponents().add(physicalComponent);
    rootPhysicalSystem.getOwnedFeatures().add(physicalPart);
  }
}