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
package org.polarsys.capella.ad.viewpoint.dsl.generation.ui.extensions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;

/**
 * @author Boubekeur Zendagui
 */
public final class UIExtensionsManager {
	
	private static final IExtensionRegistry _extRegistry =  Platform.getExtensionRegistry();
	
	public static List<IConfigurationElement> getConfigurationElements(IConfigurationElement parent, 
  																			String configurationElementName){
		ArrayList<IConfigurationElement> result = new ArrayList<IConfigurationElement>();
		
		if (parent.getChildren().length == 0) {
			return null;
		}
		
		for (IConfigurationElement iChild : parent.getChildren()) {
			if (iChild.getName().equals(configurationElementName)){
				result.add(iChild);
			}
		}
		
		return result;
	}
	
	public static List<IConfigurationElement> getConfigurationElements(String extensionPointID, 
																  			String configurationElementName){
		
		ArrayList<IConfigurationElement> result = new ArrayList<IConfigurationElement>();
		IConfigurationElement[] config =  _extRegistry.getConfigurationElementsFor(extensionPointID);
		
		if (config.length != 0) {
			for (IConfigurationElement iConfigurationElement : config) { 
				if (iConfigurationElement.getName().equals(configurationElementName)) {
					result.add(iConfigurationElement);
				}
			}
		}
		
		return result;
	}

	private UIExtensionsManager() {
		super();
	}
}
