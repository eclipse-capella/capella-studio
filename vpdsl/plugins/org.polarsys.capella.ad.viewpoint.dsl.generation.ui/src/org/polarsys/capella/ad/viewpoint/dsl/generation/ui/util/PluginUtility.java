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

import java.util.Iterator;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.pde.core.plugin.IExtensionsModelFactory;
import org.eclipse.pde.core.plugin.IPluginElement;
import org.eclipse.pde.core.plugin.IPluginExtension;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.core.plugin.IPluginModelFactory;
import org.eclipse.pde.core.plugin.IPluginParent;
import org.eclipse.pde.internal.core.plugin.WorkspacePluginModel;
import org.eclipse.pde.internal.core.project.PDEProject;

/**
 * @author Boubekeur Zendagui
 */
@SuppressWarnings("restriction")
public class PluginUtility {
	
	/***
	 * Not Used yet
	 */
	
	
	/**
	 * Add propertyTabs the a given Plug-in
	 * @param pluginName the project wherein add extensions
	 * @param propertyTabs <ContributorID, <AttributeName, AttributeValue>>
	 * @throws Exception
	 */
	public static void addPropertyTabsExtensions(String pluginName,
												Map<String, Map<String, String>> propertyTabs) throws Exception{
		// If the map is empty then there no extension to create
		if (propertyTabs == null || propertyTabs.size() == 0)
			return;
		
		WorkspacePluginModel model = getWorkspacePluginModel(pluginName);
		
		if (model == null)
			return;
		
		model.load();
		
		// Browse the map to get the Contributors ID and the Attributes Map 
		// in order to generate propertyTabs for each one 
		Iterator<String> contributorIt = propertyTabs.keySet().iterator(); 
		while (contributorIt.hasNext()){
			// Get a ContributorID from the Map
			String contributorID = contributorIt.next();
			// Get the attribute Map for the current ContributorID
			Map<String, String> attrMap = propertyTabs.get(contributorID);
			// Generate the extension
			createPropertyTabsExtensionElement(model, contributorID, attrMap);
		}
		
		model.save();
		model.dispose();
	}
	
	public static IPluginElement createPropertyTabsExtensionElement(IPluginModelBase pluginModelBase, 
															String contributor_ID,
															Map<String, String> propertyTabAttributes) throws Exception{
		// Extension creation
		IPluginExtension extension = null;
		try {
			extension = createExtension(pluginModelBase, UIConstants.EXTENSION_PROPERTY_TABS__ID);
		} catch (CoreException e) {
			e.printStackTrace();
		}
		
		if (extension == null)
			throw new Exception();
		
		// propertyTabs Element element creation
		IPluginElement propertyTabsElement = createPluginElement(extension, UIConstants.CONF_ELEMENT_PROPERTY_TABS);
		
		if (propertyTabsElement != null) {
            // Set it its id.
            propertyTabsElement.setAttribute(UIConstants.ATTRIBUTE_CONTRIBUTOR_ID, contributor_ID);
        }
		
		// propertyTab Element element creation
		IPluginElement propertyTabElement = createPluginElement(propertyTabsElement, UIConstants.CONF_ELEMENT_PROPERTY_TAB);
		
		if (propertyTabElement != null) {
			if (propertyTabAttributes != null && propertyTabAttributes.size() > 0){
				Iterator<String> attributeIt = propertyTabAttributes.keySet().iterator(); 
				while (attributeIt.hasNext()){
					String attrName = attributeIt.next();
					String attrValue = propertyTabAttributes.get(attrName);
					propertyTabElement.setAttribute(attrName, attrValue);
				}
			}
		}
		
		return propertyTabsElement;
			
	}
	
	public static IPluginExtension createExtension(IPluginModelBase pluginModelBase, String extensionPointId) throws CoreException {
	    IPluginExtension extension = null;
	    // Get the factory.
	    IPluginModelFactory pluginModelFactory = pluginModelBase.getPluginFactory();
	    if (pluginModelFactory == null) {
	      return null;
	    }
	    // Create an extension.
	    extension = pluginModelFactory.createExtension();
	    if (extension == null) {
	      return null;
	    }
	    // Set the matching extension point.
	    extension.setPoint(extensionPointId);
	    // Add it to the plug-in extensions container.
	    pluginModelBase.getExtensions().add(extension);
	    // Return extension
	    return extension;
	  }
	
	public static IPluginElement createPluginElement(IPluginParent parent, String name) throws CoreException {
	    if (parent == null) {
	      return null;
	    }
	    IPluginElement element = null;
	    // Get the factory.
	    IExtensionsModelFactory factory = parent.getModel().getFactory();
	    if (factory == null) {
	      return null;
	    }
	    element = factory.createElement(parent);
	    if (element == null) {
	      return null;
	    }
	    // Set element name.
	    element.setName(name);
	    // Add it to the extension content.
	    parent.add(element);
	    // Return element
	    return element;
	  }
	
	public static WorkspacePluginModel getWorkspacePluginModel(String pluginName){
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(pluginName);
		IFile file = PDEProject.getManifest(project);
		return file != null ? new WorkspacePluginModel(file, true) : null;
	}

}
