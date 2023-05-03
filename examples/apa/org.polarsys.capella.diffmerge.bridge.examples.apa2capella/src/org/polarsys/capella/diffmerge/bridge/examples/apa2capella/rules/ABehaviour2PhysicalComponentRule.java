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
import org.polarsys.capella.core.data.cs.CsFactory;
import org.polarsys.capella.core.data.cs.Part;
import org.polarsys.capella.core.data.information.AggregationKind;
import org.polarsys.capella.core.data.pa.PaFactory;
import org.polarsys.capella.core.data.pa.PhysicalComponent;
import org.polarsys.capella.core.data.pa.PhysicalComponentNature;
import org.polarsys.capella.core.data.pa.deployment.DeploymentFactory;
import org.polarsys.capella.core.data.pa.deployment.PartDeploymentLink;
import org.polarsys.capella.diffmerge.bridge.examples.apa.ABehavior;
import org.polarsys.capella.diffmerge.bridge.examples.apa.ANode;
import org.polarsys.capella.diffmerge.bridge.integration.scopes.CapellaUpdateScope;
import org.polarsys.capella.diffmerge.bridge.integration.util.CapellaUtil;

/**
 * @author Amine Lajmi
 *
 */
public class ABehaviour2PhysicalComponentRule extends Rule<ABehavior, Tuple3<PhysicalComponent, Part, PartDeploymentLink>> {

	/**
	 * The rule identifier
	 */
	public static final RuleIdentifier<ABehavior, Tuple3<PhysicalComponent, Part, PartDeploymentLink>> ID = new RuleIdentifier<ABehavior, Tuple3<PhysicalComponent, Part, PartDeploymentLink>>(
			"ABehaviour2PhysicalComponentRule"); //$NON-NLS-1$

	/**
	 * @param provider_p (non-null)
	 */
	public ABehaviour2PhysicalComponentRule(IQuery<?, ? extends ABehavior> provider_p) {
		super(provider_p, ID);
	}

	/**
	 * @see org.eclipse.emf.diffmerge.bridge.mapping.api.IRule#createTarget(java.lang.Object,
	 *      org.eclipse.emf.diffmerge.bridge.mapping.api.IQueryExecution)
	 */
	public Tuple3<PhysicalComponent, Part, PartDeploymentLink> createTarget(ABehavior source_p,
			IQueryExecution queryExecution_p) {
		PhysicalComponent pc = PaFactory.eINSTANCE.createPhysicalComponent();
		Part pt = CsFactory.eINSTANCE.createPart();
		PartDeploymentLink dl = DeploymentFactory.eINSTANCE.createPartDeploymentLink();

		// workaround to force Capella id creation
		pc.getId();
		pt.getId();
		dl.getId();
		return new Tuple3<PhysicalComponent, Part, PartDeploymentLink>(pc, pt, dl);
	}

	/**
	 * @see org.eclipse.emf.diffmerge.bridge.mapping.api.IRule#defineTarget(java.lang.Object, java.lang.Object, org.eclipse.emf.diffmerge.bridge.mapping.api.IQueryExecution, org.eclipse.emf.diffmerge.bridge.mapping.api.IMappingExecution)
	 */
	public void defineTarget(final ABehavior source_p,
			final Tuple3<PhysicalComponent, Part, PartDeploymentLink> target_p, IQueryExecution queryExecution_p,
			IMappingExecution mappingExecution_p) {

    // The parent
		final Tuple2<PhysicalComponent, Part> parent = mappingExecution_p.get((ANode) source_p.eContainer(),
				ANode2PhysicalComponentRule.ID);
		
		// Physical Component
		PhysicalComponent behaviourComponent = target_p.get1();
		behaviourComponent.setName(source_p.getName());
		behaviourComponent.setNature(PhysicalComponentNature.BEHAVIOR);
		
		// Part
		Part behaviourPart = target_p.get2();
		behaviourPart.setName(source_p.getName());
		behaviourPart.setAggregationKind(AggregationKind.UNSET);
		behaviourPart.setAbstractType(behaviourComponent);
		
		// Deployment link
		Part parentPart = parent.get2();
		PartDeploymentLink deploymentLink = target_p.get3();
		deploymentLink.setLocation(parentPart);
		deploymentLink.setDeployedElement(behaviourPart);
		parentPart.getOwnedDeploymentLinks().add(deploymentLink);

    // Storage
    CapellaUpdateScope targetScope = mappingExecution_p.getTargetDataSet();
    PhysicalComponent rootPhysicalSystem = CapellaUtil.getPhysicalSystemRoot(targetScope.getProject());
    rootPhysicalSystem.getOwnedPhysicalComponents().add(behaviourComponent);
    rootPhysicalSystem.getOwnedFeatures().add(behaviourPart);
	}
}