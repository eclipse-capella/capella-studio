/*******************************************************************************
* Copyright (c) 2006, 2019 THALES GLOBAL SERVICES.
* This program and the accompanying materials are made available under the
* terms of the Eclipse Public License 2.0 which is available at
* http://www.eclipse.org/legal/epl-2.0
*
* SPDX-License-Identifier: EPL-2.0
*
* Contributors:
*    Thales - initial API and implementation
*******************************************************************************/
package org.polarsys.capella.ad.viewpoint.dsl.generation.ui.constant;

import org.eclipse.osgi.util.NLS;

/**
 * @author Boubekeur Zendagui
 */
public final class GeneratorContracts extends NLS {
	private static final String BUNDLE_NAME = "org.polarsys.capella.ad.viewpoint.dsl.generation.ui.constant.contracts"; //$NON-NLS-1$

	// Main factory component contracts
	public static String Vpdesc_Model;
	public static String Generated_Ecore;
	public static String Generated_Genmodel;
	public static String Plugin_Name_Sufix;
	public static String Feature_Name_Sufix;
	
	// Register.UIProject.In.Manager task contract
	public static String Ui_Project_Name;
	
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, GeneratorContracts.class);
	}

	private GeneratorContracts() {
	}
	
}
