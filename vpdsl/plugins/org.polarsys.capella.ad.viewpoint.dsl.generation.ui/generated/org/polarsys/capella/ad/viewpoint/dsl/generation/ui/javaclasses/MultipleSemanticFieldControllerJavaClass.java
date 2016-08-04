//Generated with EGF 1.4.0.v20160519-0641
package org.polarsys.capella.ad.viewpoint.dsl.generation.ui.javaclasses;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpui.UI;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpui.UIContainer;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpui.UI_Field_Type;
import org.polarsys.capella.ad.viewpoint.dsl.generation.ui.util.DataWidget;
import org.polarsys.capella.ad.viewpoint.dsl.generation.ui.util.EPFUtility;
import org.polarsys.capella.ad.viewpoint.dsl.generation.ui.util.JDTUtility;
import org.polarsys.capella.ad.viewpoint.dsl.generation.ui.util.UIProjectManager;

public class MultipleSemanticFieldControllerJavaClass
		extends org.polarsys.capella.ad.viewpoint.dsl.generation.ui.common.AbstractLoopFinishedJavaClass {
	protected static String nl;

	public static synchronized MultipleSemanticFieldControllerJavaClass create(String lineSeparator) {
		nl = lineSeparator;
		MultipleSemanticFieldControllerJavaClass result = new MultipleSemanticFieldControllerJavaClass();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "package ";
	protected final String TEXT_2 = ";";
	protected final String TEXT_3 = NL + "  /**" + NL + " * <!-- begin-user-doc -->" + NL + " * The '<em><b>[";
	protected final String TEXT_4 = "]</b></em>' customized MultipleSemanticFieldController." + NL
			+ " * <!-- end-user-doc -->" + NL + " * <p>" + NL + " * </p>" + NL + " *" + NL + " * @generated" + NL
			+ " */" + NL + "  " + NL + "public class ";
	protected final String TEXT_5 = " extends AbstractMultipleSemanticFieldController {" + NL + "  /**" + NL
			+ "   * <!-- begin-user-doc -->" + NL + "   * <!-- end-user-doc -->" + NL
			+ "   * @see org.polarsys.capella.core.ui.properties.controllers.AbstractMultipleSemanticFieldController#getReadOpenValuesQuery(org.polarsys.capella.core.data.capellacore.CapellaElement)"
			+ NL + "   * @param semanticElement_p" + NL + "   * @generated" + NL + "   */" + NL + "  @Override" + NL
			+ "  protected IBusinessQuery getReadOpenValuesQuery(EObject semanticElement_p) {" + NL
			+ "    return BusinessQueriesProvider.getInstance().getContribution(semanticElement_p.eClass(), ";
	protected final String TEXT_6 = ");" + NL + "  }" + NL + "}";
	protected final String TEXT_7 = NL + "import org.eclipse.emf.ecore.EObject;" + NL
			+ "import org.polarsys.capella.core.ui.properties.controllers.AbstractMultipleSemanticFieldController;" + NL
			+ "import org.polarsys.capella.core.business.queries.IBusinessQuery;" + NL
			+ "import org.polarsys.capella.core.business.queries.capellacore.BusinessQueriesProvider;";
	protected final String TEXT_8 = "import org.polarsys.capella.core.data.capellacore.CapellaElement;";
	protected final String TEXT_9 = NL + "\t\timport ";
	protected final String TEXT_10 = ";" + NL + "\t";
	protected final String TEXT_11 = NL;
	protected final String TEXT_12 = NL;

	public MultipleSemanticFieldControllerJavaClass() {
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

			this.parameter = (org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpui.UIField) parameterParameter;

			if (preCondition(ctx)) {
				ctx.setNode(new Node.Container(currentNode, getClass()));
				orchestration(ctx);
			}

		}
		ctx.setNode(currentNode);
		if (ctx.useReporter()) {
			ctx.getReporter().executionFinished(OutputManager.computeExecutionOutput(ctx), ctx);
		}

		stringBuffer.append(TEXT_11);
		stringBuffer.append(TEXT_12);
		return stringBuffer.toString();
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;

		method_setSection(new StringBuffer(), ictx);

		method_setEPFUtility(new StringBuffer(), ictx);
		super.orchestration(new SuperOrchestrationContext(ictx));

		method_genPackage(new StringBuffer(), ictx);

		method_genDefaultImport(new StringBuffer(), ictx);

		method_genSematicImports(new StringBuffer(), ictx);

		method_genClass(new StringBuffer(), ictx);

		if (ictx.useReporter()) {
			Map<String, Object> parameterValues = new HashMap<String, Object>();
			parameterValues.put("parameter", this.parameter);
			String outputWithCallBack = OutputManager.computeLoopOutput(ictx);
			String loop = OutputManager.computeLoopOutputWithoutCallback(ictx);
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
		}
		return null;
	}

	protected org.polarsys.capella.ad.viewpoint.dsl.generation.ui.util.EPFUtility epfUtility = null;

	public void set_epfUtility(org.polarsys.capella.ad.viewpoint.dsl.generation.ui.util.EPFUtility object) {
		this.epfUtility = object;
	}

	protected org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpui.UIContainer section = null;

	public void set_section(org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpui.UIContainer object) {
		this.section = object;
	}

	protected org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpui.UIField parameter = null;

	public void set_parameter(org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpui.UIField object) {
		this.parameter = object;
	}

	public Map<String, Object> getParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("parameter", this.parameter);
		return parameters;
	}

	protected void method_setParameters(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		classname = epfUtility.getWidgetName(parameter) + "FieldController";
		projectname = UIProjectManager.INSTANCE.getUiProject().getName();
		String tabID = ((UI) section.eContainer()).getName();
		packagename = JDTUtility.getValidPackageName(projectname + ".controllers");
		epfUtility.registerClassToImportInMainClass(parameter, packagename + "." + classname);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setParameters", stringBuffer.toString());
	}

	protected void method_setEPFUtility(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		epfUtility = EPFUtility.getEPFUtilityFor(section);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setEPFUtility", stringBuffer.toString());
	}

	protected void method_setSection(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		EObject eObject = parameter.eContainer();
		while (eObject instanceof UIContainer && !(eObject.eContainer() instanceof UI)) {
			eObject = eObject.eContainer();
		}
		section = (UIContainer) eObject;

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setSection", stringBuffer.toString());
	}

	protected void method_genPackage(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_1);
		stringBuffer.append(packagename);
		stringBuffer.append(TEXT_2);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "genPackage", stringBuffer.toString());
	}

	protected void method_genClass(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		DataWidget iDataWidget = epfUtility.getDataOf(parameter);
		String associatedEStructuralFeature = iDataWidget.widgetFieldAccessorName;
		String inWidgetControllerName = iDataWidget.widgetName + "FieldController";

		char first = Character.toUpperCase(inWidgetControllerName.charAt(0));
		inWidgetControllerName = first + inWidgetControllerName.substring(1);

		stringBuffer.append(TEXT_3);
		stringBuffer.append(inWidgetControllerName);
		stringBuffer.append(TEXT_4);
		stringBuffer.append(inWidgetControllerName);
		stringBuffer.append(TEXT_5);
		stringBuffer.append(associatedEStructuralFeature);
		stringBuffer.append(TEXT_6);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "genClass", stringBuffer.toString());
	}

	protected void method_genDefaultImport(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_7);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "genDefaultImport", stringBuffer.toString());
	}

	protected void method_genSematicImports(final StringBuffer stringBuffer, final PatternContext ctx)
			throws Exception {

		stringBuffer.append(TEXT_8);
		ArrayList<String> importList = epfUtility.getSematicImportsFor(parameter);
		for (String currentImport : importList) {
			stringBuffer.append(TEXT_9);
			stringBuffer.append(currentImport);
			stringBuffer.append(TEXT_10);
		}
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "genSematicImports", stringBuffer.toString());
	}

	public boolean preCondition(PatternContext ctx) throws Exception {
		return parameter.getType().equals(UI_Field_Type.MULTIPLE_CHOICE_LIST);
	}
}