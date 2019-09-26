//Generated with EGF 1.6.1.201906060805
package org.polarsys.capella.ad.viewpoint.dsl.generation.ui.javaclasses;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpui.UI;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpui.UI_Field_Type;
import org.polarsys.capella.ad.viewpoint.dsl.generation.ui.util.DataWidget;
import org.polarsys.capella.ad.viewpoint.dsl.generation.ui.util.JDTUtility;
import org.polarsys.capella.ad.viewpoint.dsl.generation.ui.util.UIProjectManager;
import org.polarsys.capella.ad.viewpoint.dsl.generation.ui.util.EPFUtility;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpui.UIContainer;

public class CheckboxJavaClass
		extends org.polarsys.capella.ad.viewpoint.dsl.generation.ui.common.AbstractLoopFinishedJavaClass {
	protected static String nl;

	public static synchronized CheckboxJavaClass create(String lineSeparator) {
		nl = lineSeparator;
		CheckboxJavaClass result = new CheckboxJavaClass();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "package ";
	protected final String TEXT_2 = ";";
	protected final String TEXT_3 = NL + NL + " /**" + NL + " * <!-- begin-user-doc -->" + NL + " * The '<em><b>[";
	protected final String TEXT_4 = "]</b></em>' customized CheckboxGroup field. " + NL + " * <!-- end-user-doc -->"
			+ NL + " * <p>" + NL + " * </p>" + NL + " *" + NL + " * @generated" + NL + " */ " + NL + " " + NL
			+ "public class ";
	protected final String TEXT_5 = " extends AbstractSemanticCheckboxGroup {" + NL + "" + NL + "\t/**" + NL
			+ "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */"
			+ NL + "  private Button ";
	protected final String TEXT_6 = ";" + NL + "" + NL + "  /**" + NL + "   * Constructor." + NL
			+ "   * <!-- begin-user-doc -->" + NL + "   * <!-- end-user-doc -->" + NL + "   * @param parent_p" + NL
			+ "   * @param widgetFactory_p" + NL + "   * @generated" + NL + "   */" + NL + "  public ";
	protected final String TEXT_7 = "(Composite parent_p, TabbedPropertySheetWidgetFactory widgetFactory_p) {" + NL
			+ "    super(parent_p, widgetFactory_p);";
	protected final String TEXT_8 = NL + "    ";
	protected final String TEXT_9 = " = createButton(";
	protected final String TEXT_10 = ", ";
	protected final String TEXT_11 = ", parent_p); //$NON-NLS-1$ " + NL + "    // Set the GridData of the checkBox" + NL
			+ "    Layout parentLayout = parent_p.getLayout();" + NL
			+ "\tif (parentLayout != null && parentLayout instanceof GridLayout){" + NL
			+ "\t\tGridData gd = new GridData(GridData.FILL_HORIZONTAL);" + NL
			+ "\t\tgd.horizontalSpan = ((GridLayout)parentLayout).numColumns;" + NL + "\t\t";
	protected final String TEXT_12 = ".setLayoutData(gd);" + NL + "\t}" + NL + "  }" + NL + "" + NL + "  /**" + NL
			+ "   * <!-- begin-user-doc -->" + NL + "   * <!-- end-user-doc -->" + NL + "   * {@inheritDoc}" + NL
			+ "   * @generated   " + NL + "   */" + NL + "  @Override" + NL
			+ "  public List<Button> getSemanticFields() {" + NL + "    List<Button> fields = new ArrayList<Button>();"
			+ NL + "    fields.add(";
	protected final String TEXT_13 = ");" + NL + "    return fields;" + NL + "  }" + NL + "}";
	protected final String TEXT_14 = NL + "import java.util.List;" + NL + "import java.util.ArrayList;" + NL + "" + NL
			+ "import org.eclipse.swt.widgets.*;" + NL + "import org.eclipse.swt.layout.*;" + NL + "" + NL
			+ "import org.polarsys.capella.core.ui.properties.fields.*;" + NL
			+ "import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;" + NL;
	protected final String TEXT_15 = NL + "\t\timport ";
	protected final String TEXT_16 = ";" + NL + "\t";
	protected final String TEXT_17 = NL;

	public CheckboxJavaClass() {
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

		stringBuffer.append(TEXT_17);
		stringBuffer.append(TEXT_17);
		return stringBuffer.toString();
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;

		method_setSection(new StringBuffer(), ictx);

		method_setEPFUtility(new StringBuffer(), ictx);
		super.orchestration(new SuperOrchestrationContext(ictx));

		method_genPackage(new StringBuffer(), ictx);

		method_genDefaultImport(new StringBuffer(), ictx);

		method_genSemanticImports(new StringBuffer(), ictx);

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
		String inClassName = iDataWidget.widgetGraphicalClassName;
		char first = Character.toUpperCase(inClassName.charAt(0));
		inClassName = first + inClassName.substring(1);
		String inWidgetName = "_" + iDataWidget.widgetName + "Button";
		String associatedEStructuralFeature = iDataWidget.widgetFieldAccessorName;
		String label = "\"" + iDataWidget.widgetLabel + "\"";

		stringBuffer.append(TEXT_3);
		stringBuffer.append(inClassName);
		stringBuffer.append(TEXT_4);
		stringBuffer.append(inClassName);
		stringBuffer.append(TEXT_5);
		stringBuffer.append(inWidgetName);
		stringBuffer.append(TEXT_6);
		stringBuffer.append(inClassName);
		stringBuffer.append(TEXT_7);
		stringBuffer.append(TEXT_8);
		stringBuffer.append(inWidgetName);
		stringBuffer.append(TEXT_9);
		stringBuffer.append(associatedEStructuralFeature);
		stringBuffer.append(TEXT_10);
		stringBuffer.append(label);
		stringBuffer.append(TEXT_11);
		stringBuffer.append(inWidgetName);
		stringBuffer.append(TEXT_12);
		stringBuffer.append(inWidgetName);
		stringBuffer.append(TEXT_13);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "genClass", stringBuffer.toString());
	}

	protected void method_genDefaultImport(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_14);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "genDefaultImport", stringBuffer.toString());
	}

	protected void method_genSemanticImports(final StringBuffer stringBuffer, final PatternContext ctx)
			throws Exception {

		List<String> importList = epfUtility.getSemanticImportsFor(parameter);
		for (String currentImport : importList) {
			stringBuffer.append(TEXT_15);
			stringBuffer.append(currentImport);
			stringBuffer.append(TEXT_16);
		}
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "genSematicImports", stringBuffer.toString());
	}

	public boolean preCondition(PatternContext ctx) throws Exception {
		return parameter.getType().equals(UI_Field_Type.CHECKBOX);
	}
}