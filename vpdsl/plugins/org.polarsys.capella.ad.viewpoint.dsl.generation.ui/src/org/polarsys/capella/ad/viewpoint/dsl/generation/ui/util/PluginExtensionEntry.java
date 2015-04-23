/*******************************************************************************
* Copyright (c) 2006, 2015 THALES GLOBAL SERVICES.
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
public class PluginExtensionEntry {
	public String extensionPoint_ID;
	public boolean share_ExtensionPoint_ID = true;
	public String extension;

	public PluginExtensionEntry(String _extensionPoint_ID, 
									boolean _share_ExtensionPoint_ID, 
									String _extension){
		extensionPoint_ID= _extensionPoint_ID;
		share_ExtensionPoint_ID= _share_ExtensionPoint_ID;
		extension= _extension;
	}
}
