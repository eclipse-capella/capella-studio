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

import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.pde.core.plugin.IExtensionsModelFactory;
import org.eclipse.pde.core.plugin.IPluginElement;
import org.eclipse.pde.core.plugin.IPluginExtension;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.core.plugin.IPluginModelFactory;
import org.eclipse.pde.core.plugin.IPluginParent;
import org.eclipse.pde.internal.core.plugin.WorkspacePluginModel;
import org.eclipse.pde.internal.core.project.PDEProject;
import org.polarsys.capella.ad.viewpoint.dsl.generation.ui.Activator;

/**
 * @author Boubekeur Zendagui
 */
@SuppressWarnings("restriction")
public final class PluginUtility {
	
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
												Map<String, Map<String, String>> propertyTabs) throws CoreException{
		// If the map is empty then there no extension to create
		if (propertyTabs == null || propertyTabs.size() == 0) {
			return;
                }
		
		WorkspacePluginModel model = getWorkspacePluginModel(pluginName);
		
		if (model == null) {
			return;
                }
		
		model.load();
		
		// Browse the map to get the Contributors ID and the Attributes Map 
		// in order to generate propertyTabs for each one 
		for(Entry<String, Map<String, String>> tab: propertyTabs.entrySet()) {
			// Get a ContributorID from the Map
			String contributorID = tab.getKey();
			// Get the attribute Map for the current ContributorID
			Map<String, String> attrMap = propertyTabs.get(contributorID);
			// Generate the extension
			createPropertyTabsExtensionElement(model, contributorID, attrMap);
		}
		
		model.save();
		model.dispose();
	}
	
	public static IPluginElement createPropertyTabsExtensionElement(IPluginModelBase pluginModelBase, 
															String contributorID,
															Map<String, String> propertyTabAttributes) throws CoreException{
		// Extension creation
		IPluginExtension extension = null;
		try {
			extension = createExtension(pluginModelBase, UIConstants.EXTENSION_PROPERTY_TABS__ID);
		} catch (CoreException e) {
			Activator.getDefault().getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "", e));
		}
		
		if (extension == null) {
			throw new IllegalStateException();
                }
		
		// propertyTabs Element element creation
		IPluginElement propertyTabsElement = createPluginElement(extension, UIConstants.CONF_ELEMENT_PROPERTY_TABS);
		
		if (propertyTabsElement != null) {
            // Set it its id.
            propertyTabsElement.setAttribute(UIConstants.ATTRIBUTE_CONTRIBUTOR_ID, contributorID);
        }
		
		// propertyTab Element element creation
		IPluginElement propertyTabElement = createPluginElement(propertyTabsElement, UIConstants.CONF_ELEMENT_PROPERTY_TAB);
		
		if (propertyTabElement != null && propertyTabAttributes != null && !propertyTabAttributes.isEmpty()){
			for (Entry<String, String> attribute: propertyTabAttributes.entrySet()) {
				String attrName = attribute.getKey();
				String attrValue = propertyTabAttributes.get(attrName);
				propertyTabElement.setAttribute(attrName, attrValue);
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

	private PluginUtility() {
		super();
	}

}
