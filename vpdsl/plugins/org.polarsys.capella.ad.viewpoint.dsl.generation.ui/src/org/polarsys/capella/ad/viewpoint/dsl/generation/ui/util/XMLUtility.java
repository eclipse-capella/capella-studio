/*******************************************************************************
* Copyright (c) 2006, 2018 THALES GLOBAL SERVICES.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*    Thales - initial API and implementation
*******************************************************************************/
package org.polarsys.capella.ad.viewpoint.dsl.generation.ui.util;

/**
 * @author Boubekeur Zendagui
 */
public class XMLUtility {
	
	private static final String[] specialCharacters = {"&", "<", ">", "\"", "\'"};
	private static final String[] xmlValidCharacters = {"&amp;", "&lt;", "&gt;", "&quot;", "&#39;"};
	
	public static String getValidXMLString(String input){
		String output = input;
		
		for (int i = 0; i < specialCharacters.length; i++) {
			output = output.replaceAll(specialCharacters[i], xmlValidCharacters[i]);
		}
		
		return output;
	}

	private XMLUtility() {
		super();
	}

}
