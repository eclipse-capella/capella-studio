//Generated with EGF 1.6.0.201805040915
package org.polarsys.capella.ad.viewpoint.dsl.generation.ui.extension;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import java.util.ArrayList;
import org.eclipse.core.runtime.IConfigurationElement;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpui.UI;
import org.polarsys.capella.ad.viewpoint.dsl.generation.ui.extensions.UIPropertiesExtensionsManager;
import org.eclipse.emf.common.util.EList;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.desc.helper.configuration.VpDslConfigurationHelper;

public class UI2PropertyTab extends org.polarsys.capella.ad.viewpoint.dsl.generation.ui.common.UIAbstractPattern {
	protected static String nl;

	public static synchronized UI2PropertyTab create(String lineSeparator) {
		nl = lineSeparator;
		UI2PropertyTab result = new UI2PropertyTab();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "<extension" + NL
			+ "\tpoint=\"org.eclipse.ui.views.properties.tabbed.propertyTabs\">" + NL + "\t<propertyTabs " + NL
			+ "\t\tcontributorId=\"";
	protected final String TEXT_2 = "\">" + NL + "\t\t\t";
	protected final String TEXT_3 = NL + "\t\t\t<propertyTab" + NL + "\t\t    \tafterTab=\"";
	protected final String TEXT_4 = "\"" + NL + "\t\t        category=\"";
	protected final String TEXT_5 = "\"" + NL + "\t\t        id=\"";
	protected final String TEXT_6 = "\"" + NL + "\t\t        label=\"";
	protected final String TEXT_7 = "\">" + NL + "\t\t    </propertyTab> " + NL + "\t\t\t";
	protected final String TEXT_8 = NL + "\t</propertyTabs>" + NL + "</extension> " + NL;
	protected final String TEXT_9 = NL;
	protected final String TEXT_10 = NL;

	public UI2PropertyTab() {
		//Here is the constructor
		StringBuffer stringBuffer = new StringBuffer();

		// add initialisation of the pattern variables (declaration has been already done).

	}

	public String generate(Object argument) throws Exception {
		final StringBuffer stringBuffer = new StringBuffer();

		InternalPatternContext ctx = (InternalPatternContext) argument;
		Map<String, String> queryCtx = null;
		IQuery.ParameterDescription paramDesc = null;
		Node.Container currentNode = ctx.getNode();

		List<Object> parameterList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)

		for (Object parameterParameter : parameterList) {

			this.parameter = (org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpui.UIDescription) parameterParameter;

			if (preCondition(ctx)) {
				ctx.setNode(new Node.Container(currentNode, getClass()));
				orchestration(ctx);
			}

		}
		ctx.setNode(currentNode);
		if (ctx.useReporter()) {
			ctx.getReporter().executionFinished(OutputManager.computeExecutionOutput(ctx), ctx);
		}

		stringBuffer.append(TEXT_9);
		stringBuffer.append(TEXT_10);
		return stringBuffer.toString();
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;

		super.orchestration(new SuperOrchestrationContext(ictx));

		method_getTargetApplicationName(new StringBuffer(), ictx);

		method_generatePropertyTabsExtensions(new StringBuffer(), ictx);

		if (ictx.useReporter()) {
			Map<String, Object> parameterValues = new HashMap<String, Object>();
			parameterValues.put("parameter", this.parameter);
			String outputWithCallBack = OutputManager.computeLoopOutput(ictx);
			String loop = OutputManager.computeLoopOutputWithoutCallback(ictx);
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
		}
		return null;
	}

	protected java.lang.String targetApplication = null;

	public void set_targetApplication(java.lang.String object) {
		this.targetApplication = object;
	}

	protected org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpui.UIDescription parameter = null;

	public void set_parameter(org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpui.UIDescription object) {
		this.parameter = object;
	}

	public Map<String, Object> getParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("parameter", this.parameter);
		return parameters;
	}

	protected void method_generatePropertyTabsExtensions(final StringBuffer stringBuffer, final PatternContext ctx)
			throws Exception {

		// Get the Properties Contributors list 
		ArrayList<IConfigurationElement> propertiesContributors = (ArrayList<IConfigurationElement>) UIPropertiesExtensionsManager
				.getPropertiesContributors(targetApplication);

		for (IConfigurationElement iPropertiesContributor : propertiesContributors) {
			ArrayList<IConfigurationElement> contributors = (ArrayList<IConfigurationElement>) UIPropertiesExtensionsManager
					.getContributors(iPropertiesContributor);
			for (IConfigurationElement iContributor : contributors) {
				String cID = UIPropertiesExtensionsManager.getContributorID(iContributor);
				String cCategory = UIPropertiesExtensionsManager.getPropertyTabCategory(iContributor);
				String cBase = UIPropertiesExtensionsManager.getBaseTabName(iContributor);
				stringBuffer.append(TEXT_1);
				stringBuffer.append(cID);
				stringBuffer.append(TEXT_2);
				for (UI iUI : parameter.getUIs()) {
					String ContainerName = iUI.getName();
					String uiLabel = iUI.getLabel();
					uiLabel = (uiLabel != null && uiLabel.trim().length() > 0 ? uiLabel : ContainerName);
					stringBuffer.append(TEXT_3);
					stringBuffer.append(cBase);
					stringBuffer.append(TEXT_4);
					stringBuffer.append(cCategory);
					stringBuffer.append(TEXT_5);
					stringBuffer.append(ContainerName);
					stringBuffer.append(TEXT_6);
					stringBuffer.append(uiLabel);
					stringBuffer.append(TEXT_7);
				}
				stringBuffer.append(TEXT_8);
			}
		}
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "generatePropertyTabsExtensions", stringBuffer.toString());
	}

	protected void method_getTargetApplicationName(final StringBuffer stringBuffer, final PatternContext ctx)
			throws Exception {

		Object value = ctx.getValue("domain");
		if (value instanceof EList<?>) {
			value = ((EList) value).get(0);
		}
		targetApplication = VpDslConfigurationHelper.getTargetApplication(value);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "getTargetApplicationName", stringBuffer.toString());
	}
}