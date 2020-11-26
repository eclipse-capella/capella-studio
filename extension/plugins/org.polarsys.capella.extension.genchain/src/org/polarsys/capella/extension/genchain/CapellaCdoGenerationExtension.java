/*******************************************************************************
 * Copyright (c) 2015, 2020 Thales Global Services S.A.S.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 *  
 * Contributors:
 *   Thales Global Services S.A.S - initial API and implementation
 *******************************************************************************/
package org.polarsys.capella.extension.genchain;

import java.util.Arrays;
import java.util.List;

import org.eclipse.egf.portfolio.genchain.cdo.CdoGenerationExtension;
import org.eclipse.egf.portfolio.genchain.cdo.cdoExtension.CdoGeneration;
import org.eclipse.emf.common.util.URI;
import org.polarsys.capella.extension.genchain.capellaextension.CapellaExtensionFactory;
import org.polarsys.kitalpha.ad.common.utils.URIFix;

/**
 * @author Thomas Guiu
 * 
 */
public class CapellaCdoGenerationExtension extends CdoGenerationExtension {
	private static final URI PATTERN_CDO = URIFix.createPlatformPluginURI("/org.polarsys.capella.extension.genchain/egf/capellaExtension.fcore#_asT3kGS9EeiSLtpvrnge2A", false);

	private static final List<String> CONFLICT_LIST = Arrays.asList("cdo.generation", "emde.cdo.generation" );

	@Override
	public List<String> getConflictingExtensions() {
		return CONFLICT_LIST;
	}

	@Override
	public String getLabel() {
		return "Capella CDO Emf Generation";
	}


	@Override
	protected CdoGeneration doCreateEcoreElement() {
		return CapellaExtensionFactory.eINSTANCE.createCapellaCdoEmfGeneration();
	}

	@Override
	protected URI getCdoPattern() {
		return PATTERN_CDO;
	}

}
