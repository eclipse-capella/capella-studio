/*******************************************************************************
 * Copyright (c) 2016, 2020 Thales Global Services.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 *  
 * Contributors:
 *   Thales - initial API and implementation
 *******************************************************************************/
package org.polarsys.capella.cdo.ta.definition;

import java.util.List;

import org.eclipse.egf.portfolio.genchain.extension.ExtensionHelper;
import org.polarsys.capella.extension.genchain.CapellaCdoGenerationExtension;
import org.polarsys.capella.ta.definition.CapellaTargetApplication;


/**
 * @author Thomas Guiu
 */

public class CDOForCapellaTargetApplication extends CapellaTargetApplication {

	@Override
	public List<ExtensionHelper> getGenerationExtensionHelpers() {
		List<ExtensionHelper> generationExtensionHelpers = super.getGenerationExtensionHelpers();
		generationExtensionHelpers.add(new CapellaCdoGenerationExtension());
		return generationExtensionHelpers;
	}

}
