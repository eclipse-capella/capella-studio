//Generated with EGF 1.6.1.201906060805
package org.polarsys.capella.ad.viewpoint.dsl.generation.ui.extension;

import java.util.Map.Entry;
import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpui.UI;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpui.UIContainer;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpui.UIField;
import org.polarsys.capella.ad.viewpoint.dsl.generation.ui.util.DataWidget;
import org.polarsys.capella.ad.viewpoint.dsl.generation.ui.util.EPFUtility;
import org.polarsys.capella.ad.viewpoint.dsl.generation.ui.util.PluginExtensionEntry;

public class widgetGeneratedContributions {
	protected static String nl;

	public static synchronized widgetGeneratedContributions create(String lineSeparator) {
		nl = lineSeparator;
		widgetGeneratedContributions result = new widgetGeneratedContributions();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "\t";
	protected final String TEXT_2 = NL + "<extension " + NL + "\tpoint=\"";
	protected final String TEXT_3 = "\">" + NL + "\t\t\t\t";
	protected final String TEXT_4 = NL + "\t";
	protected final String TEXT_5 = NL + "\t\t\t\t";
	protected final String TEXT_6 = NL + "</extension>";
	protected final String TEXT_7 = NL + "\t\t";
	protected final String TEXT_8 = " ";
	protected final String TEXT_9 = NL;

	public widgetGeneratedContributions() {
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

			this.parameter = (org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpui.UI) parameterParameter;

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
		stringBuffer.append(TEXT_9);
		return stringBuffer.toString();
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;

		method_genExtensions(new StringBuffer(), ictx);

		if (ictx.useReporter()) {
			Map<String, Object> parameterValues = new HashMap<String, Object>();
			parameterValues.put("parameter", this.parameter);
			String outputWithCallBack = OutputManager.computeLoopOutput(ictx);
			String loop = OutputManager.computeLoopOutputWithoutCallback(ictx);
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
		}
		return null;
	}

	protected org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpui.UI parameter = null;

	public void set_parameter(org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpui.UI object) {
		this.parameter = object;
	}

	public Map<String, Object> getParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("parameter", this.parameter);
		return parameters;
	}

	protected void method_genExtensions(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		class WidgetExtensionGenerator {
			Map<String, ArrayList<String>> availableExtesionPoint = new HashMap<String, ArrayList<String>>();

			private void init() {
				stringBuffer.append(TEXT_1);
				availableExtesionPoint.clear();
			}

			private void browseUIContainer(UIContainer container, EPFUtility epfUtility) {
				for (UIField uiField : container.getUI_fields()) {
					DataWidget iDataWidget = epfUtility.getDataOf(uiField);
					List<PluginExtensionEntry> pluginExtensionEntryList = iDataWidget.PluginExtensionEntries;
					if (pluginExtensionEntryList != null && !pluginExtensionEntryList.isEmpty()) {
						for (PluginExtensionEntry pluginExtensionEntry : pluginExtensionEntryList) {
							String point = pluginExtensionEntry.extensionPoint_ID;
							if (pluginExtensionEntry.share_ExtensionPoint_ID) {
								if (availableExtesionPoint.containsKey(point)) {
									((ArrayList<String>) availableExtesionPoint.get(point))
											.add(pluginExtensionEntry.extension);
								} else {
									ArrayList<String> array = new ArrayList<String>();
									array.add(pluginExtensionEntry.extension);
									availableExtesionPoint.put(point, array);
								}
							} else {
								ArrayList<String> array = new ArrayList<String>();
								array.add(pluginExtensionEntry.extension);
								availableExtesionPoint.put(point, array);
							}
						}
					}
				}
				if (container.getSubContainers() != null && container.getSubContainers().size() > 0) {
					for (UIContainer iUIContainer : container.getSubContainers()) {
						browseUIContainer(iUIContainer, epfUtility);
					}
				}
			}

			private void generateExtensions(UI ui) {
				init();
				for (UIContainer uiContainer : ui.getUI_Containers()) {
					EPFUtility epfUtility = EPFUtility.getEPFUtilityFor(uiContainer);
					browseUIContainer(uiContainer, epfUtility);
				}
				// Generation of the Extensions
				if (!availableExtesionPoint.isEmpty()) {
					for (Entry<String, ArrayList<String>> extension : availableExtesionPoint.entrySet()) {
						ArrayList<String> array = extension.getValue();
						stringBuffer.append(TEXT_2);
						stringBuffer.append(extension.getKey());
						stringBuffer.append(TEXT_3);
						for (String iExtension : array) {
							stringBuffer.append(TEXT_4);
							stringBuffer.append(iExtension + "\n");
							stringBuffer.append(TEXT_5);
						}
						stringBuffer.append(TEXT_6);
						stringBuffer.append("\n");
						stringBuffer.append(TEXT_7);
					}
				}
			}
		}
		WidgetExtensionGenerator weg = new WidgetExtensionGenerator();
		stringBuffer.append(TEXT_8);
		weg.generateExtensions(parameter);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "genExtensions", stringBuffer.toString());
	}

	public boolean preCondition(PatternContext ctx) throws Exception {
		return true;
	}
}