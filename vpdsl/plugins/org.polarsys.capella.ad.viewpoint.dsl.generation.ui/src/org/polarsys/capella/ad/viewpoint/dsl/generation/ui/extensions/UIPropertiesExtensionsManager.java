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
package org.polarsys.capella.ad.viewpoint.dsl.generation.ui.extensions;

import java.util.ArrayList;

import org.eclipse.core.runtime.IConfigurationElement;
import org.polarsys.capella.ad.viewpoint.dsl.generation.ui.util.XMLUtility;

/**
 * @author Boubekeur Zendagui
 */
public class UIPropertiesExtensionsManager {
	
	private static final String _propertyContributorExtensionPointID = 
			"org.polarsys.capella.ad.viewpoint.dsl.generation.ui.UIPropertiesContributors";
	
	private static final String _propertiesContributorsConfigurationElement = "propertiesContributors";
	private static final String _contributorConfigurationElement = "Contributor";
	
	/**
	 * Attributes
	 */
	// Contributor
	private static final String _contributor_Name_Attribute = "name";
	private static final String _contributor_ID_Attribute = "id";
	private static final String _propertyTabCategory_Attribute = "propertyTabCategory";
	// PropertiesContributors
	private static final String _TargetApplication_Attribute = "targetApplication";
	
	
	public static String getContributorName(IConfigurationElement contributor){
		return contributor.getAttribute(_contributor_Name_Attribute);
	}
	
	public static String getContributorID(IConfigurationElement contributor){
		return contributor.getAttribute(_contributor_ID_Attribute);
	}
	
	public static String getPropertyTabCategory(IConfigurationElement contributor){
		String cat = contributor.getAttribute(_propertyTabCategory_Attribute);
		return XMLUtility.getValidXMLString(cat);
	}
	
	public static ArrayList<IConfigurationElement> getContributors(IConfigurationElement parent){
		return UIExtensionsManager.getConfigurationElements(parent, _contributorConfigurationElement);
	}
	
	public static ArrayList<IConfigurationElement> getPropertiesContributors(String targetApplication){
		
		ArrayList<IConfigurationElement> availableContributors = UIExtensionsManager.getConfigurationElements(
													_propertyContributorExtensionPointID, 
													_propertiesContributorsConfigurationElement);
		
		ArrayList<IConfigurationElement> result = new ArrayList<IConfigurationElement>();
		
		for (IConfigurationElement iContributor : availableContributors) {
			if (iContributor.getAttribute(_TargetApplication_Attribute).equals(targetApplication)){
				result.add(iContributor);
			}
		}
		
		return result;
	}

}
