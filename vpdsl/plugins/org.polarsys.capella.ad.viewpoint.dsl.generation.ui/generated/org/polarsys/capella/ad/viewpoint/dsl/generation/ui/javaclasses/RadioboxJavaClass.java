//Generated with EGF 1.6.1.201906060805
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

public class RadioboxJavaClass
		extends org.polarsys.capella.ad.viewpoint.dsl.generation.ui.common.AbstractLoopFinishedJavaClass {
	protected static String nl;

	public static synchronized RadioboxJavaClass create(String lineSeparator) {
		nl = lineSeparator;
		RadioboxJavaClass result = new RadioboxJavaClass();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "package ";
	protected final String TEXT_2 = ";";
	protected final String TEXT_3 = NL + NL + " /**" + NL + " * <!-- begin-user-doc -->" + NL + " * The '<em><b>[";
	protected final String TEXT_4 = "]</b></em>' customized RadioboxGroup field. " + NL + " * <!-- end-user-doc -->"
			+ NL + " * <p>" + NL + " * </p>" + NL + " *" + NL + " * @generated" + NL + " */ " + NL + " " + NL
			+ "public class ";
	protected final String TEXT_5 = " extends AbstractSemanticKindGroup {" + NL;
	protected final String TEXT_6 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL
			+ "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate Button _";
	protected final String TEXT_7 = ";" + NL + "\t";
	protected final String TEXT_8 = NL + NL + "  /**" + NL + "   * Constructor." + NL + "   * <!-- begin-user-doc -->"
			+ NL + "   * <!-- end-user-doc -->" + NL + "   * @param parent_p" + NL + "   * @param widgetFactory_p" + NL
			+ "   * @generated" + NL + "   */" + NL + "  public ";
	protected final String TEXT_9 = "(Composite parent_p, TabbedPropertySheetWidgetFactory widgetFactory_p) {" + NL
			+ "    super(parent_p, widgetFactory_p, ";
	protected final String TEXT_10 = ", 6); //$NON-NLS-1$" + NL;
	protected final String TEXT_11 = NL + "\t_";
	protected final String TEXT_12 = " = createButton(";
	protected final String TEXT_13 = ");";
	protected final String TEXT_14 = NL + "  }" + NL + "" + NL + "  /**" + NL + "   * <!-- begin-user-doc -->" + NL
			+ "   * <!-- end-user-doc -->" + NL + "   * {@inheritDoc}" + NL + "   * @generated   " + NL + "   */" + NL
			+ "  @Override" + NL + "  public List<Button> getSemanticFields() {" + NL
			+ "    List<Button> fields = new ArrayList<Button>();";
	protected final String TEXT_15 = NL + "\tfields.add(_";
	protected final String TEXT_16 = NL + "    return fields;" + NL + "  }" + NL + "" + NL + "   /**" + NL
			+ "   * <!-- begin-user-doc -->" + NL + "   * <!-- end-user-doc -->" + NL + "   * {@inheritDoc}" + NL
			+ "   * @generated   " + NL + "   */" + NL + "  @Override" + NL
			+ "  public Button getDefaultSemanticField() {";
	protected final String TEXT_17 = NL + "    return _";
	protected final String TEXT_18 = ";" + NL + "  }" + NL + "}" + NL;
	protected final String TEXT_19 = NL + "import java.util.ArrayList;" + NL + "import java.util.List;" + NL + "" + NL
			+ "import org.eclipse.swt.widgets.Button;" + NL + "import org.eclipse.swt.widgets.Composite;" + NL
			+ "import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;" + NL + "" + NL
			+ "import org.polarsys.capella.core.ui.properties.fields.AbstractSemanticKindGroup;";
	protected final String TEXT_20 = NL + "import ";
	protected final String TEXT_21 = ";" + NL;
	protected final String TEXT_22 = NL;

	public RadioboxJavaClass() {
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

		stringBuffer.append(TEXT_22);
		stringBuffer.append(TEXT_22);
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

		classname = epfUtility.getWidgetClassName(parameter);
		projectname = UIProjectManager.INSTANCE.getUiProject().getName();
		String tabID = ((UI) section.eContainer()).getName();
		packagename = JDTUtility.getValidPackageName(projectname + ".fields");
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
		String enumName = iDataWidget.widgetFieldTypeEnumerator.enumName;
		List<String> enumLiterals = iDataWidget.widgetFieldTypeEnumerator.enumLiterals;
		String inClassName = iDataWidget.widgetGraphicalClassName;

		char first = Character.toUpperCase(inClassName.charAt(0));
		inClassName = first + inClassName.substring(1);

		String label = "\"" + iDataWidget.widgetLabel + "\"";

		stringBuffer.append(TEXT_3);
		stringBuffer.append(inClassName);
		stringBuffer.append(TEXT_4);
		stringBuffer.append(inClassName);
		stringBuffer.append(TEXT_5);
		for (String enumLiteral : enumLiterals) {
			stringBuffer.append(TEXT_6);
			stringBuffer.append(enumName + "Btn" + enumLiteral);
			stringBuffer.append(TEXT_7);
		}
		stringBuffer.append(TEXT_8);
		stringBuffer.append(inClassName);
		stringBuffer.append(TEXT_9);
		stringBuffer.append(label);
		stringBuffer.append(TEXT_10);
		for (String enumLiteral : enumLiterals) {
			stringBuffer.append(TEXT_11);
			stringBuffer.append(enumName + "Btn" + enumLiteral);
			stringBuffer.append(TEXT_12);
			stringBuffer.append(enumName + "." + enumLiteral);
			stringBuffer.append(TEXT_13);
		}
		stringBuffer.append(TEXT_14);
		for (String enumLiteral : enumLiterals) {
			stringBuffer.append(TEXT_15);
			stringBuffer.append(enumName + "Btn" + enumLiteral);
			stringBuffer.append(TEXT_13);
		}
		stringBuffer.append(TEXT_16);
		String enumLiteral = enumLiterals.get(0);
		stringBuffer.append(TEXT_17);
		stringBuffer.append(enumName + "Btn" + enumLiteral);
		stringBuffer.append(TEXT_18);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "genClass", stringBuffer.toString());
	}

	protected void method_genDefaultImport(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_19);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "genDefaultImport", stringBuffer.toString());
	}

	protected void method_genSematicImports(final StringBuffer stringBuffer, final PatternContext ctx)
			throws Exception {

		DataWidget dataWidget = epfUtility.getDataOf(parameter);
		stringBuffer.append(TEXT_20);
		stringBuffer.append(dataWidget.widgetFieldTypeEnumerator.enumImportName);
		stringBuffer.append(TEXT_21);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "genSematicImports", stringBuffer.toString());
	}

	public boolean preCondition(PatternContext ctx) throws Exception {
		return parameter.getType().equals(UI_Field_Type.RADIOBOX);
	}
}