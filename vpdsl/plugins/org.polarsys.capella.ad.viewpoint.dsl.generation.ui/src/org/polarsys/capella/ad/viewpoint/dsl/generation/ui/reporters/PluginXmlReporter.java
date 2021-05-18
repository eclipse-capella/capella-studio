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
package org.polarsys.capella.ad.viewpoint.dsl.generation.ui.reporters;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.egf.model.pattern.PatternContext;
import org.eclipse.egf.model.pattern.PatternExecutionReporter;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.polarsys.capella.ad.viewpoint.dsl.generation.ui.Activator;
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
	
	private static final String PLUGIN_END =   "</plugin>";
	private static final String EXTENSION_END = "</extension>\n";
	private static final String PLUGIN_BEGIN = "<?xml version=\"1.0\" encoding=\"UTF-8\"?> \n" +
						 					  "<?eclipse version=\"3.4\"?>\n" +
						 					  "<plugin>\n";
		
	private String tabExtensions = "";
	private String additionalExtensions = "";
	private List<String> sections = new ArrayList<>();
	
	private String computeSectionsOutput(String targetApplication){
		// Get the Properties Contributors list 
		ArrayList<IConfigurationElement> propertiesContributors = 
			(ArrayList<IConfigurationElement>) UIPropertiesExtensionsManager.getPropertiesContributors(targetApplication);

		StringBuilder propertiesSections = new StringBuilder();
		
		for (IConfigurationElement iPropertiesContributor : propertiesContributors) {
			List<IConfigurationElement> contributors = UIPropertiesExtensionsManager.
																	getContributors(iPropertiesContributor);
			for (IConfigurationElement iContributor : contributors) {
				String cID = UIPropertiesExtensionsManager.getContributorID(iContributor);
				propertiesSections.append(	
					"<extension\n" +
					"	point=\"org.eclipse.ui.views.properties.tabbed.propertySections\">\n" +
					"		<propertySections\n"+
					"			contributorId=\"").append(cID).append("\">\n");

				for (String iSection : sections) {
					propertiesSections.append(iSection);
				}
				propertiesSections.append("</propertySections>\n").append(EXTENSION_END);
			}
		}
		return propertiesSections.toString();
	}

	@SuppressWarnings("unchecked")
	public void executionFinished(String output, PatternContext context) {
		Viewpoint vp = ((EDataTypeUniqueEList<Viewpoint>)context.getValue("domain")).get(0);
		String targetApplication = VpDslConfigurationHelper.getTargetApplication(vp);
		final IProject project = UIProjectManager.INSTANCE.getUiProject();
		final String finalOutput = 
			PLUGIN_BEGIN
			+	tabExtensions
			+	computeSectionsOutput(targetApplication)
			+	additionalExtensions
			+PLUGIN_END;
		
		try {
			ArrayList<String> requiredBundles = new ArrayList<>();
			requiredBundles.add(GenmodelUtility.getInstance().getModelPluginID());
			requiredBundles.add("org.polarsys.kitalpha.ad.services");
			requiredBundles.add("org.polarsys.capella.core.ui.properties");
			if (VPUIHelper.generateRichTextForUI(vp)){
				requiredBundles.add("org.polarsys.kitalpha.richtext.common");
				requiredBundles.add("org.polarsys.kitalpha.richtext.widget");
			}
			PDEUtility.updateRequiredBundles(project, requiredBundles, new NullProgressMonitor());
			PDEUtility.updatePluginXml(project, finalOutput);
			PDEUtility.updateBuild_BinInclude(project, "plugin.xml", false, new NullProgressMonitor());
			
		} catch (InvocationTargetException|InterruptedException e) {
			Activator.getDefault().getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "", e));
			Thread.currentThread().interrupt();
		}
		try {
			project.refreshLocal(IProject.DEPTH_INFINITE, new NullProgressMonitor());
		} catch (CoreException e) {
			Activator.getDefault().getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "", e));
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
		if (object instanceof UIContainer && ((UIContainer)object).eContainer() instanceof UI) {
			sections.add(output);
		}
			
		if (object instanceof UIDescription) {
			tabExtensions = output;
		}
		
		if (object instanceof UI) {
			additionalExtensions += "\n"+output;
		}
	}

}
