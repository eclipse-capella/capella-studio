/*******************************************************************************
* Copyright (c) 2016, 2020 THALES GLOBAL SERVICES.
* This program and the accompanying materials are made available under the
* terms of the Eclipse Public License 2.0 which is available at
* http://www.eclipse.org/legal/epl-2.0
*
* SPDX-License-Identifier: EPL-2.0
*
* Contributors:
*    Thales - initial API and implementation
*******************************************************************************/

package org.polarsys.capella.ad.viewpoint.dsl.tests.ta;

import org.eclipse.egf.portfolio.genchain.extension.ExtensionHelper;
import org.eclipse.emf.ecore.EClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.polarsys.capella.ta.definition.CapellaTargetApplication;
import org.polarsys.kitalpha.ad.ta.extension.TargetApplicationExtensionManager;

import java.util.List;

public class CapellaTargetApplicationTests {

	private static final CapellaTargetApplication C_TA = CapellaTargetApplication.INSTANCE;
	/**
	 * Checking if the Target Application Capella is available in the platform
	 */
	@Test
	public void checkCapellaTAExistence(){
		String[] supportedTargetApplication = TargetApplicationExtensionManager.getSupportedTargetApplication();
		boolean available = false;
		for (int i = 0; i < supportedTargetApplication.length; i++) 
		{
			final String currentTA = supportedTargetApplication[i];
			if (currentTA.equalsIgnoreCase("Capella"))
			{
				available = true;
				break;
			}
		}
		
		assertEquals(true, available);
	}
	
	/**
	 * Checking if the NamedElement EClass is well accessible
	 */
	@Test
	public void testGetBasicSemanticElement() {
		List<EClass> basicSemanticElement = C_TA.getBasicSemanticElement();
		assertEquals(1, basicSemanticElement.size());
		
		EClass eClass = basicSemanticElement.get(0);
		assertEquals("NamedElement", eClass.getName());
	}

	/**
	 * Checking if there are two default extension
	 */
	@Test
	public void testGetGenerationExtensionHelpers() {
		List<ExtensionHelper> helpers = C_TA.getGenerationExtensionHelpers();
		assertEquals(true, helpers.size() >= 2);
	}

}
