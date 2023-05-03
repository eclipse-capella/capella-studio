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

import java.util.List;

import org.eclipse.emf.diffmerge.bridge.mapping.api.IMappingExecution;
import org.eclipse.emf.diffmerge.bridge.mapping.api.IQuery;
import org.eclipse.emf.diffmerge.bridge.mapping.api.IQueryExecution;
import org.eclipse.emf.diffmerge.bridge.mapping.impl.Rule;
import org.eclipse.emf.diffmerge.bridge.mapping.impl.RuleIdentifier;
import org.eclipse.emf.diffmerge.bridge.util.structures.Tuple2;
import org.polarsys.capella.core.data.cs.Part;
import org.polarsys.capella.core.data.fa.ComponentFunctionalAllocation;
import org.polarsys.capella.core.data.fa.FaFactory;
import org.polarsys.capella.core.data.pa.PaFactory;
import org.polarsys.capella.core.data.pa.PhysicalComponent;
import org.polarsys.capella.core.data.pa.PhysicalFunction;
import org.polarsys.capella.core.data.pa.PhysicalFunctionPkg;
import org.polarsys.capella.diffmerge.bridge.examples.apa.ABehavior;
import org.polarsys.capella.diffmerge.bridge.examples.apa.AFunction;
import org.polarsys.capella.diffmerge.bridge.integration.scopes.CapellaUpdateScope;
import org.polarsys.capella.diffmerge.bridge.integration.util.CapellaUtil;

/**
 * @author Amine Lajmi
 *
 */
public class AFunction2PhysicalFunctionRule extends Rule<AFunction, Tuple2<PhysicalFunction, ComponentFunctionalAllocation>> {

  /**
   * The rule identifier
   */
  public static final RuleIdentifier<AFunction, Tuple2<PhysicalFunction, ComponentFunctionalAllocation>> ID = new RuleIdentifier<AFunction, Tuple2<PhysicalFunction, ComponentFunctionalAllocation>>(
      "AFunction2PhysicalFunctionRule"); //$NON-NLS-1$

  /**
   * @param provider_p (non-null)
   */
  public AFunction2PhysicalFunctionRule(IQuery<?, ? extends AFunction> provider_p) {
    super(provider_p, ID);
  }

  /**
   * @see org.eclipse.emf.diffmerge.bridge.mapping.api.IRule#createTarget(java.lang.Object,
   *      org.eclipse.emf.diffmerge.bridge.mapping.api.IQueryExecution)
   */
  public Tuple2<PhysicalFunction, ComponentFunctionalAllocation> createTarget(AFunction source_p, IQueryExecution queryExecution_p) {
    PhysicalFunction pf = PaFactory.eINSTANCE.createPhysicalFunction();
    ComponentFunctionalAllocation allocation = FaFactory.eINSTANCE.createComponentFunctionalAllocation();
    // workaround to force Capella Id creation
    pf.getId();
    allocation.getId();
    return new Tuple2<PhysicalFunction, ComponentFunctionalAllocation>(pf, allocation);
  }

  /**
   * @see org.eclipse.emf.diffmerge.bridge.mapping.api.IRule#defineTarget(java.lang.Object, java.lang.Object, org.eclipse.emf.diffmerge.bridge.mapping.api.IQueryExecution, org.eclipse.emf.diffmerge.bridge.mapping.api.IMappingExecution)
   */
  public void defineTarget(final AFunction source_p, final Tuple2<PhysicalFunction, ComponentFunctionalAllocation> target_p,
      IQueryExecution queryExecution_p, IMappingExecution mappingExecution_p) {

    // Container
    final Tuple2<PhysicalComponent, Part> container = mappingExecution_p.get(
        (ABehavior) source_p.eContainer(), ABehaviour2PhysicalComponentRule.ID);

    // Store the function
    PhysicalFunction function = target_p.get1();
    function.setName(source_p.getName());
    CapellaUpdateScope targetScope = mappingExecution_p.getTargetDataSet();
    PhysicalFunctionPkg physicalFunctionPkg = CapellaUtil.getPhysicalFunctionPackage(targetScope.getProject());
    List<PhysicalFunction> rootFunctions = physicalFunctionPkg.getOwnedPhysicalFunctions();
    if (rootFunctions.isEmpty())
      physicalFunctionPkg.getOwnedPhysicalFunctions().add(function);
    else
      rootFunctions.get(0).getOwnedFunctions().add(function);

    // set it as owned by the behavior component
    ComponentFunctionalAllocation allocation = target_p.get2();
    PhysicalComponent behaviourComponent = container.get1();
    behaviourComponent.getOwnedFunctionalAllocation().add(allocation);

    // set source and target of allocation
    allocation.setSourceElement(behaviourComponent);
    allocation.setTargetElement(function);
  }
}