/*******************************************************************************
* Copyright (c) 2006, 2017 THALES GLOBAL SERVICES.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*    Thales - initial API and implementation
*******************************************************************************/
package org.polarsys.capella.ad.viewpoint.dsl.generation.ui.reporters;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.egf.model.pattern.PatternContext;
import org.eclipse.egf.model.pattern.PatternExecutionReporter;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

import org.polarsys.capella.ad.viewpoint.dsl.generation.ui.extensions.UIPropertiesExtensionsManager;
import org.polarsys.capella.ad.viewpoint.dsl.generation.ui.util.GenmodelUtility;
import org.polarsys.capella.ad.viewpoint.dsl.generation.ui.util.UIProjectManager;
import org.polarsys.capella.ad.viewpoint.dsl.generation.ui.util.VPUIHelper;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.Viewpoint;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpui.UI;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpui.UIContainer;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpui.UIDescription;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.desc.helper.configuration.VpDslConfigurationHelper;

import  org.polarsys.kitalpha.ad.viewpoint.dsl.generation.helper.pde.PDEUtility;

/**
 * @author Boubekeur Zendagui
 */
public class PluginXmlReporter implements PatternExecutionReporter {
	
	private static final String pluginEnd =   "</plugin>";
	private static final String extensionEnd = "</extension>\n";
	private static final String pluginBegin = "<?xml version=\"1.0\" encoding=\"UTF-8\"?> \n" +
						 					  "<?eclipse version=\"3.4\"?>\n" +
						 					  "<plugin>\n";
		
	private String tabExtensions = "";
	private String additionalExtensions = "";
	private ArrayList<String> sections = new ArrayList<String>();
	
	private String computeSectionsOutput(String targetApplication){
		// Get the Properties Contributors list 
		ArrayList<IConfigurationElement> propertiesContributors = 
			UIPropertiesExtensionsManager.getPropertiesContributors(targetApplication);

		String propertiesSections ="";
		
		for (IConfigurationElement iPropertiesContributor : propertiesContributors) {
			ArrayList<IConfigurationElement> contributors = UIPropertiesExtensionsManager.
																	getContributors(iPropertiesContributor);
			for (IConfigurationElement iContributor : contributors) {
				String cID = UIPropertiesExtensionsManager.getContributorID(iContributor);
				propertiesSections +=	
					"<extension\n" +
					"	point=\"org.eclipse.ui.views.properties.tabbed.propertySections\">\n" +
					"		<propertySections\n"+
					"			contributorId=\""+ cID+ "\">\n";

				for (String iSection : sections) {
					propertiesSections += iSection;
				}
				propertiesSections += "</propertySections>\n" + extensionEnd;
			}
		}
		return propertiesSections;
	}

	@SuppressWarnings("unchecked")
	public void executionFinished(String output, PatternContext context) {
		Viewpoint vp = ((EDataTypeUniqueEList<Viewpoint>)context.getValue("domain")).get(0);
		String targetApplication = VpDslConfigurationHelper.getTargetApplication(vp);
		final IProject project = UIProjectManager.INSTANCE.getUiProject();
		final String finalOutput = 
			pluginBegin
			+	tabExtensions
			+	computeSectionsOutput(targetApplication)
			+	additionalExtensions
			+pluginEnd;
		
		try {
			ArrayList<String> requiredBundles = new ArrayList<String>();
			requiredBundles.add(GenmodelUtility.getInstance().getModelPluginID());
			requiredBundles.add("org.polarsys.kitalpha.ad.services");
			requiredBundles.add("org.polarsys.capella.core.ui.properties");
			if (VPUIHelper.generateRichTextForUI(vp)){
				requiredBundles.add("org.polarsys.kitalpha.richtext.widget");
			}
			PDEUtility.updateRequiredBundles(project, requiredBundles, new NullProgressMonitor());
			PDEUtility.updatePluginXml(project, finalOutput);
			PDEUtility.updateBuild_BinInclude(project, "plugin.xml", false, new NullProgressMonitor());
			
		} catch (InvocationTargetException e1) {
			e1.printStackTrace();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		try {
			project.refreshLocal(IProject.DEPTH_INFINITE, new NullProgressMonitor());
		} catch (CoreException e) {
			e.printStackTrace();
		}
		sections.clear();
	}

	public void loopFinished(String output, String outputWithCallBack,
			PatternContext context, Map<String, Object> parameterValues) {
		if (output == null || output.trim().length() == 0)
		{
			return;
		}

		Object object = parameterValues.get("parameter"); 
		if (object instanceof UIContainer && ((UIContainer)object).eContainer() instanceof UI)
			sections.add(output);
			
		if (object instanceof UIDescription)
			tabExtensions = output;
		
		if (object instanceof UI)
			additionalExtensions += "\n"+output;
	}

}
