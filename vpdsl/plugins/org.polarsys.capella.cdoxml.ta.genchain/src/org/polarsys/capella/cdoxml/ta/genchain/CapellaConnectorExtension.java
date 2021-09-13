/*******************************************************************************
 * Copyright (c) 2021 Thales Global Services.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 *  
 * Contributors:
 *   Thales Global Services - initial API and implementation
 *******************************************************************************/
package org.polarsys.capella.cdoxml.ta.genchain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.egf.core.domain.TargetPlatformResourceSet;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternFactory;
import org.eclipse.egf.model.pattern.Substitution;
import org.eclipse.egf.portfolio.genchain.extension.ExtensionHelper;
import org.eclipse.egf.portfolio.genchain.generationChain.EcoreElement;
import org.eclipse.emf.common.util.URI;
import org.polarsys.capella.cdoxml.ta.genchain.connectorextension.ConnectorExtensionFactory;
import org.polarsys.capella.cdoxml.ta.genchain.connectorextension.ConnectorGeneration;

/**
 * @author Matthieu Helleboid
 */
public class CapellaConnectorExtension extends ExtensionHelper {
	private static final URI PATTERN_CONNECTOR = URI.createURI("platform:/plugin/org.polarsys.capella.cdoxml.ta.genchain/egf/capellaConnectorExtension.fcore#_heLDYBIKEeKYHMigmt5qAQ", false);

	@Override
	public EcoreElement createEcoreElement(Map<String, String> properties) {
		ConnectorGeneration elt = ConnectorExtensionFactory.eINSTANCE.createConnectorGeneration();
		String modelPath = properties.get(MODEL_PATH);
		elt.setModelPath(modelPath);
		return elt;
	}

	@Override
	public List<Substitution> getSubstitutions() {
		TargetPlatformResourceSet set = new TargetPlatformResourceSet();
		List<Substitution> substitutions = new ArrayList<Substitution>();
		final Substitution substitution = PatternFactory.eINSTANCE.createSubstitution();
		substitutions.add(substitution);
		Pattern pattern = (Pattern) set.getEObject(PATTERN_CONNECTOR, true);
		substitution.getReplacement().add(pattern);
		return substitutions;
	}
	
	@Override
	public String getLabel() {
		return "Capella Connector Add-on Generation";
	}

}
