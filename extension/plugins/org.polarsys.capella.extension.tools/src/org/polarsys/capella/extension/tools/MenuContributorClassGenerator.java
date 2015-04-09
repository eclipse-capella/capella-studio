/*******************************************************************************
 * Copyright (c) 2015 Thales Global Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *   Thales Global Services S.A.S - initial API and implementation
 *******************************************************************************/
package org.polarsys.capella.extension.tools;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.polarsys.capella.extension.tools.HelperClassGenerator.HelperInfo;


/**
 * 
 * @author Thomas Guiu
 * 
 */
public class MenuContributorClassGenerator {
	private MenuContributorClassGenerator() {
	}

	public static String getClassname(GenClass model) {
		return model.getInterfaceName() + "ItemContribution";
	}

	public static String getPackagename(GenClass model) {
		return model.getGenPackage().getProviderPackageName() + ".contributions";
	}

	public static String getFullClassname(GenClass model) {
		return getPackagename(model) + "." + getClassname(model);
	}

	public static boolean isValidTarget(GenClass obj) {
		if (obj.isAbstract())
			return false;
		HelperInfo info = HelperClassGenerator.getInfo(obj.getEcoreClass());

		return info != null && info.getMenuContributorBaseClass() != null;
	}

}
