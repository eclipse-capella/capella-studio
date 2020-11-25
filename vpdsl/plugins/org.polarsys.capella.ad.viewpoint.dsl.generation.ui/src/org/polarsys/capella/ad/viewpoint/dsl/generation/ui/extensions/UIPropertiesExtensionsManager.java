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
package org.polarsys.capella.ad.viewpoint.dsl.generation.ui.extensions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.polarsys.capella.ad.viewpoint.dsl.generation.ui.util.XMLUtility;

/**
 * @author Boubekeur Zendagui
 */
public class UIPropertiesExtensionsManager {
	
	private static final String PROPERTY_CONTRIBUTOR_EXTENSION_POINT_ID = 
			"org.polarsys.capella.ad.viewpoint.dsl.generation.ui.UIPropertiesContributors";
	
	private static final String PROPERTIES_CONTRIBUTORS_CONFIGURATION_ELEMENT = "propertiesContributors";
	private static final String CONTRIBUTOR_CONFIGURATION_ELEMENT = "Contributor";
	
	/**
	 * Attributes
	 */
	// Contributor
	private static final String CONTRIBUTOR_NAME_ATTRIBUTE = "name";
	private static final String CONTRIBUTOR_ID_ATTRIBUTE = "id";
	private static final String PROPERTY_TAB_CATEGORY_ATTRIBUTE = "propertyTabCategory";
	private static final String PROPERTY_BASE_TAB_NAME_ATTRIBUTE = "baseTabName";
	// PropertiesContributors
	private static final String TARGET_APPLICATION_ATTRIBUTE = "targetApplication";
	
	
	public static String getContributorName(IConfigurationElement contributor){
		return contributor.getAttribute(CONTRIBUTOR_NAME_ATTRIBUTE);
	}
	
	public static String getContributorID(IConfigurationElement contributor){
		return contributor.getAttribute(CONTRIBUTOR_ID_ATTRIBUTE);
	}
	
	public static String getPropertyTabCategory(IConfigurationElement contributor){
		String cat = contributor.getAttribute(PROPERTY_TAB_CATEGORY_ATTRIBUTE);
		return XMLUtility.getValidXMLString(cat);
	}
	
	public static String getBaseTabName(IConfigurationElement contributor){
		String cat = contributor.getAttribute(PROPERTY_BASE_TAB_NAME_ATTRIBUTE);
		return XMLUtility.getValidXMLString(cat);
	}
	
	public static List<IConfigurationElement> getContributors(IConfigurationElement parent){
		return UIExtensionsManager.getConfigurationElements(parent, CONTRIBUTOR_CONFIGURATION_ELEMENT);
	}
	
	public static List<IConfigurationElement> getPropertiesContributors(String targetApplication){
		
		List<IConfigurationElement> availableContributors = UIExtensionsManager.getConfigurationElements(
													PROPERTY_CONTRIBUTOR_EXTENSION_POINT_ID, 
													PROPERTIES_CONTRIBUTORS_CONFIGURATION_ELEMENT);
		
		ArrayList<IConfigurationElement> result = new ArrayList<IConfigurationElement>();
		
		for (IConfigurationElement iContributor : availableContributors) {
			if (iContributor.getAttribute(TARGET_APPLICATION_ATTRIBUTE).equals(targetApplication)){
				result.add(iContributor);
			}
		}
		
		return result;
	}

	private UIPropertiesExtensionsManager() {
		super();
	}

}
