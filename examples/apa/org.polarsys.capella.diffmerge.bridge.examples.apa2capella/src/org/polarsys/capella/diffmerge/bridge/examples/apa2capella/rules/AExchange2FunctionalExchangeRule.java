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
import org.eclipse.emf.diffmerge.bridge.util.structures.Tuple3;
import org.polarsys.capella.core.data.capellamodeller.Project;
import org.polarsys.capella.core.data.fa.ComponentFunctionalAllocation;
import org.polarsys.capella.core.data.fa.FaFactory;
import org.polarsys.capella.core.data.fa.FunctionInputPort;
import org.polarsys.capella.core.data.fa.FunctionOutputPort;
import org.polarsys.capella.core.data.fa.FunctionalExchange;
import org.polarsys.capella.core.data.pa.PhysicalFunction;
import org.polarsys.capella.diffmerge.bridge.examples.apa.AExchange;
import org.polarsys.capella.diffmerge.bridge.examples.apa.AFunction;
import org.polarsys.capella.diffmerge.bridge.integration.scopes.CapellaUpdateScope;
import org.polarsys.capella.diffmerge.bridge.integration.util.CapellaUtil;
/**
 * @author Amine Lajmi
 *
 */
public class AExchange2FunctionalExchangeRule
extends Rule<AExchange, Tuple3<FunctionalExchange, FunctionInputPort, FunctionOutputPort>> {

	/**
	 * The rule identifier
	 */
	public static final RuleIdentifier<AExchange, Tuple3<FunctionalExchange, FunctionInputPort, FunctionOutputPort>> ID = new RuleIdentifier<AExchange, Tuple3<FunctionalExchange, FunctionInputPort, FunctionOutputPort>>(
			"AExchange2FunctionalExchangeRule"); //$NON-NLS-1$

	/**
	 * @param provider_p (non-null)
	 */
	public AExchange2FunctionalExchangeRule(IQuery<?, ? extends AExchange> provider_p) {
		super(provider_p, ID);
	}

	/**
	 * @see org.eclipse.emf.diffmerge.bridge.mapping.api.IRule#createTarget(java.lang.Object, org.eclipse.emf.diffmerge.bridge.mapping.api.IQueryExecution)
	 */
	public Tuple3<FunctionalExchange, FunctionInputPort, FunctionOutputPort> createTarget(AExchange source_p, IQueryExecution queryExecution_p) {
		FunctionalExchange functionalExchange = FaFactory.eINSTANCE.createFunctionalExchange();
		FunctionInputPort inputPort = FaFactory.eINSTANCE.createFunctionInputPort();
		FunctionOutputPort outputPort = FaFactory.eINSTANCE.createFunctionOutputPort();
		//workaround to force Capella Id creation
		functionalExchange.getId();
		inputPort.getId();
		outputPort.getId();
		return new Tuple3<FunctionalExchange, FunctionInputPort, FunctionOutputPort>(functionalExchange, inputPort, outputPort);
	}

	/**
	 * @see org.eclipse.emf.diffmerge.bridge.mapping.api.IRule#defineTarget(java.lang.Object, java.lang.Object, org.eclipse.emf.diffmerge.bridge.mapping.api.IQueryExecution, org.eclipse.emf.diffmerge.bridge.mapping.api.IMappingExecution)
	 */
	public void defineTarget(final AExchange source_p, final Tuple3<FunctionalExchange, FunctionInputPort, FunctionOutputPort>  target_p, IQueryExecution queryExecution_p, IMappingExecution mappingExecution_p) {		

		//source function
		AFunction sourceFunction = source_p.getSource();

		//target function
		AFunction targetFunction = source_p.getTarget();

		FunctionalExchange functionalExchange = target_p.get1();
		FunctionInputPort inputPort = target_p.get2();		
		FunctionOutputPort outputPort = target_p.get3();

		//functional exchange source and target
		functionalExchange.setSource(outputPort);
		functionalExchange.setTarget(inputPort);

		//source physical function
		Tuple2<PhysicalFunction, ComponentFunctionalAllocation> tupleSource =
		    mappingExecution_p.get(sourceFunction, AFunction2PhysicalFunctionRule.ID);
		PhysicalFunction sourcePhysicalFunction = tupleSource.get1();
		sourcePhysicalFunction.getOutputs().add(outputPort);

		//target physical function
		Tuple2<PhysicalFunction, ComponentFunctionalAllocation> tupleTarget =
		    mappingExecution_p.get(targetFunction, AFunction2PhysicalFunctionRule.ID);
		PhysicalFunction targetPhysicalFunction = tupleTarget.get1();
		targetPhysicalFunction.getInputs().add(inputPort);

		//glue to the topmost elements
		CapellaUpdateScope targetScope = mappingExecution_p.getTargetDataSet();
		Project project = targetScope.getProject();
    PhysicalFunction physicalFunction = CapellaUtil.getPhysicalFunctionRoot(project);
    physicalFunction.getOwnedFunctionalExchanges().add(functionalExchange);
	}
	
}