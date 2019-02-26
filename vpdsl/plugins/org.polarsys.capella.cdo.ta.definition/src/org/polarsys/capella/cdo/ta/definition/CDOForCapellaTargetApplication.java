/*******************************************************************************
 * Copyright (c) 2016, 2019 Thales Global Services.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *   Thales - initial API and implementation
 *******************************************************************************/
package org.polarsys.capella.cdo.ta.definition;

import java.util.List;

import org.eclipse.egf.portfolio.genchain.cdo.CdoGenerationExtension;
import org.eclipse.egf.portfolio.genchain.extension.ExtensionHelper;
import org.polarsys.capella.ta.definition.CapellaTargetApplication;


/**
 * @author Thomas Guiu
 */

public class CDOForCapellaTargetApplication extends CapellaTargetApplication {

	@Override
	public List<ExtensionHelper> getGenerationExtensionHelpers() {
		List<ExtensionHelper> generationExtensionHelpers = super.getGenerationExtensionHelpers();
		generationExtensionHelpers.add(new CdoGenerationExtension());
		return generationExtensionHelpers;
	}

}
