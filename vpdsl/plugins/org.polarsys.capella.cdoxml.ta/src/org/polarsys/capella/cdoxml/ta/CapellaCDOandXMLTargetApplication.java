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
package org.polarsys.capella.cdoxml.ta;

import org.polarsys.capella.cdoxml.ta.genchain.CapellaConnectorExtension;
import org.polarsys.capella.ta.definition.CapellaTargetApplication;

import java.util.List;
import org.eclipse.egf.portfolio.genchain.extension.ExtensionHelper;
import org.eclipse.egf.portfolio.genchain.cdo.CdoGenerationExtension;

public class CapellaCDOandXMLTargetApplication extends CapellaTargetApplication  {

	@Override
	public List<ExtensionHelper> getGenerationExtensionHelpers() {
		List<ExtensionHelper> generationExtensionHelpers = super.getGenerationExtensionHelpers();
		generationExtensionHelpers.add(new CdoGenerationExtension());
		generationExtensionHelpers.add(new CapellaConnectorExtension());
		return generationExtensionHelpers;
	}

}
