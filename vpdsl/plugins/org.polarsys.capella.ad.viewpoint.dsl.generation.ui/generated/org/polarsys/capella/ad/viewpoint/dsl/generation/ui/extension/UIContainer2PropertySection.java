//Generated with EGF 1.4.0.v20160519-0641
package org.polarsys.capella.ad.viewpoint.dsl.generation.ui.extension;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpui.LocalClass;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpui.UI;
import org.polarsys.capella.ad.viewpoint.dsl.generation.ui.util.GenmodelUtility;
import org.polarsys.capella.ad.viewpoint.dsl.generation.ui.util.JDTUtility;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.Class;

public class UIContainer2PropertySection
		extends org.polarsys.capella.ad.viewpoint.dsl.generation.ui.common.UIAbstractPattern {
	protected static String nl;

	public static synchronized UIContainer2PropertySection create(String lineSeparator) {
		nl = lineSeparator;
		UIContainer2PropertySection result = new UIContainer2PropertySection();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "\t\t\t<propertySection" + NL + "\t\t    \tclass=\"";
	protected final String TEXT_2 = "\"" + NL + "\t\t        filter=\"";
	protected final String TEXT_3 = "\"" + NL + "\t\t        id=\"";
	protected final String TEXT_4 = "\"" + NL + "\t\t        tab=\"";
	protected final String TEXT_5 = "\">" + NL + "\t\t        ";
	protected final String TEXT_6 = "<input" + NL + "                  type=\"";
	protected final String TEXT_7 = "\">" + NL + "               </input>";
	protected final String TEXT_8 = NL + "\t\t    </propertySection> " + NL + "\t\t    ";
	protected final String TEXT_9 = NL;
	protected final String TEXT_10 = NL;

	public UIContainer2PropertySection() {
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

			this.parameter = (org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpui.UIContainer) parameterParameter;

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

		method_setTabID(new StringBuffer(), ictx);

		method_setPackageName(new StringBuffer(), ictx);

		method_generatePropertySectionsExtensions(new StringBuffer(), ictx);

		if (ictx.useReporter()) {
			Map<String, Object> parameterValues = new HashMap<String, Object>();
			parameterValues.put("parameter", this.parameter);
			String outputWithCallBack = OutputManager.computeLoopOutput(ictx);
			String loop = OutputManager.computeLoopOutputWithoutCallback(ictx);
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
		}
		return null;
	}

	protected java.lang.String packageName = null;

	public void set_packageName(java.lang.String object) {
		this.packageName = object;
	}

	protected java.lang.String tabID = null;

	public void set_tabID(java.lang.String object) {
		this.tabID = object;
	}

	protected org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpui.UIContainer parameter = null;

	public void set_parameter(org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpui.UIContainer object) {
		this.parameter = object;
	}

	public Map<String, Object> getParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("parameter", this.parameter);
		return parameters;
	}

	protected void method_generatePropertySectionsExtensions(final StringBuffer stringBuffer, final PatternContext ctx)
			throws Exception {

		String ctName = JDTUtility.getValidClassName(tabID + "_" + parameter.getName());
		String className = packageName + "." + ctName;

		UI ui = (UI) parameter.eContainer();
		EObject ds = ui.getUI_DataSource();
		String datasourceImport = null;
		if (ds != null) {
			LocalClass localClass = (LocalClass) ui.getUI_DataSource();
			Class clazz = (Class) localClass.getUI_For_LocalClass();
			datasourceImport = GenmodelUtility.getInstance().getSemanticEClassImport(clazz);
		}

		JDTUtility.createPackage(projectName, packageName);
		String sectionID = tabID + "." + parameter.getName();
		stringBuffer.append(TEXT_1);
		stringBuffer.append(className);
		stringBuffer.append(TEXT_2);
		stringBuffer.append(className);
		stringBuffer.append(TEXT_3);
		stringBuffer.append(sectionID);
		stringBuffer.append(TEXT_4);
		stringBuffer.append(tabID);
		stringBuffer.append(TEXT_5);
		if (datasourceImport != null && datasourceImport.trim().length() > 0) {
			stringBuffer.append(TEXT_6);
			stringBuffer.append(datasourceImport);
			stringBuffer.append(TEXT_7);
		}
		stringBuffer.append(TEXT_8);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "generatePropertySectionsExtensions", stringBuffer.toString());
	}

	protected void method_setPackageName(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		packageName = projectName + ".sections";
		packageName = JDTUtility.getValidPackageName(packageName);

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setPackageName", stringBuffer.toString());
	}

	protected void method_setTabID(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		tabID = ((UI) parameter.eContainer()).getName();
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setTabID", stringBuffer.toString());
	}

	public boolean preCondition(PatternContext ctx) throws Exception {
		return parameter.eContainer() instanceof UI;
	}
}