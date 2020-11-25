/*******************************************************************************
* Copyright (c) 2006, 2020 THALES GLOBAL SERVICES.
* This program and the accompanying materials are made available under the
* terms of the Eclipse Public License 2.0 which is available at
* http://www.eclipse.org/legal/epl-2.0
*
* SPDX-License-Identifier: EPL-2.0
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
