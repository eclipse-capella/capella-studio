//Generated with EGF 1.4.1.v20161010-1511
package org.polarsys.capella.ad.viewpoint.dsl.generation.ui.javaclasses;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import java.text.SimpleDateFormat;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.desc.helper.configuration.VpDslConfigurationHelper;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.NamedElement;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpui.UI;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpui.UIContainer;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpui.UIField;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpui.UI_Field_Type;
import org.polarsys.capella.ad.viewpoint.dsl.generation.ui.util.DataWidget;
import org.polarsys.capella.ad.viewpoint.dsl.generation.ui.util.EPFUtility;
import org.polarsys.capella.ad.viewpoint.dsl.generation.ui.util.JDTUtility;
import org.polarsys.capella.ad.viewpoint.dsl.generation.ui.util.UIProjectManager;
import org.polarsys.capella.ad.viewpoint.dsl.generation.ui.util.UISectionUtility;

public class SectionJavaClass
		extends org.polarsys.capella.ad.viewpoint.dsl.generation.ui.common.AbstractLoopFinishedJavaClass {
	protected static String nl;

	public static synchronized SectionJavaClass create(String lineSeparator) {
		nl = lineSeparator;
		SectionJavaClass result = new SectionJavaClass();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "}" + NL;
	protected final String TEXT_2 = "package ";
	protected final String TEXT_3 = ";" + NL + NL;
	protected final String TEXT_4 = "import org.polarsys.capella.core.ui.properties.sections.AbstractSection;" + NL;
	protected final String TEXT_5 = "import java.util.ArrayList;" + NL + "import java.util.List;" + NL + "" + NL
			+ "import org.eclipse.emf.ecore.EObject;" + NL + "" + NL + "import org.eclipse.jface.viewers.ISelection;"
			+ NL + "import org.eclipse.swt.widgets.*;" + NL + "import org.eclipse.swt.layout.*;" + NL
			+ "import org.eclipse.ui.IWorkbenchPart;" + NL
			+ "import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;  " + NL + "" + NL
			+ "import org.polarsys.capella.core.ui.properties.controllers.*;" + NL
			+ "import org.polarsys.capella.common.mdsofa.common.constant.ICommonConstants;" + NL + "" + NL
			+ "import org.polarsys.kitalpha.ad.services.manager.ViewpointManager;" + NL + NL;
	protected final String TEXT_6 = "import org.polarsys.capella.core.ui.properties.fields.*;";
	protected final String TEXT_7 = NL + "\t";
	protected final String TEXT_8 = NL + "\t\t";
	protected final String TEXT_9 = NL + "\t\t";
	protected final String TEXT_10 = NL + "\t\t\timport ";
	protected final String TEXT_11 = ";" + NL + "\t\t";
	protected final String TEXT_12 = NL + "\t";
	protected final String TEXT_13 = NL + "\t";
	protected final String TEXT_14 = NL;
	protected final String TEXT_15 = NL + NL;
	protected final String TEXT_16 = "import org.polarsys.capella.core.data.capellacore.CapellaElement;";
	protected final String TEXT_17 = NL + "\t\t\t\t\timport ";
	protected final String TEXT_18 = ";";
	protected final String TEXT_19 = NL;
	protected final String TEXT_20 = "/**" + NL + " * <!-- begin-user-doc -->" + NL
			+ " * This class is an implementation of the section '<em><b>[";
	protected final String TEXT_21 = "]</b></em>'." + NL + " * <!-- end-user-doc -->" + NL + " * <p>" + NL + " * </p>"
			+ NL + " *" + NL + " * @generated" + NL + " */ " + NL + " " + NL + " ";
	protected final String TEXT_22 = "public class ";
	protected final String TEXT_23 = " extends ";
	protected final String TEXT_24 = "{ " + NL;
	protected final String TEXT_25 = NL + "\t";
	protected final String TEXT_26 = NL + "\t\t";
	protected final String TEXT_27 = NL + "\t\t";
	protected final String TEXT_28 = NL + "\t\t";
	protected final String TEXT_29 = NL + "\t\t/**";
	protected final String TEXT_30 = NL + "\t\t* <!-- begin-model-doc -->" + NL + "\t\t* ";
	protected final String TEXT_31 = NL + "\t\t* <!-- end-model-doc -->";
	protected final String TEXT_32 = NL + "\t\t* <!-- begin-model-doc -->" + NL + "\t\t* <!-- end-model-doc -->";
	protected final String TEXT_33 = NL + "\t\t* <!-- begin-user-doc -->" + NL + "\t\t* <!-- end-user-doc -->" + NL
			+ "\t\t* @generated" + NL + "\t\t*/" + NL + "\t\tprivate ";
	protected final String TEXT_34 = " ";
	protected final String TEXT_35 = ";" + NL + "\t" + NL + "\t";
	protected final String TEXT_36 = NL + "\t";
	protected final String TEXT_37 = NL;
	protected final String TEXT_38 = NL;
	protected final String TEXT_39 = NL + "\t";
	protected final String TEXT_40 = NL + "\t\t";
	protected final String TEXT_41 = NL + "\t\t";
	protected final String TEXT_42 = NL + "\t\t/**";
	protected final String TEXT_43 = NL + "\t\t* <!-- begin-model-doc -->" + NL + "\t\t* ";
	protected final String TEXT_44 = NL + "\t\t* <!-- end-model-doc -->";
	protected final String TEXT_45 = NL + "\t\t* <!-- begin-model-doc -->" + NL + "\t\t* <!-- end-model-doc -->";
	protected final String TEXT_46 = NL + " \t\t* <!-- begin-user-doc -->" + NL + " \t\t* <!-- end-user-doc -->" + NL
			+ " \t\t* @generated" + NL + " \t\t*/" + NL + "\t\tprivate Group ";
	protected final String TEXT_47 = ";" + NL + "\t\t" + NL + "\t";
	protected final String TEXT_48 = NL + "\t" + NL + "\t";
	protected final String TEXT_49 = NL;
	protected final String TEXT_50 = NL + "\t/**" + NL + "\t* <!-- begin-user-doc -->" + NL
			+ "\t* <!-- end-user-doc -->" + NL + "\t* @param eObject: current object" + NL + "\t* @generated" + NL
			+ "\t*/" + NL + "\tpublic boolean select(Object eObject) {" + NL
			+ "\t\tEObject eObjectToTest = super.selection(eObject);" + NL + "\t\t";
	protected final String TEXT_51 = NL + "\t\t";
	protected final String TEXT_52 = NL + "\t\t\tif (eObjectToTest == null){" + NL + "\t\t\t\treturn false; " + NL
			+ "\t\t\t} else if (";
	protected final String TEXT_53 = "){" + NL + "\t\t\t\treturn true;" + NL + "\t\t\t}\t";
	protected final String TEXT_54 = NL + "\t\t\telse {" + NL + "\t\t\t\tEObject children = get";
	protected final String TEXT_55 = "Object(eObjectToTest);" + NL + "\t\t\t\tif (children != null) {" + NL
			+ "\t\t\t\t\treturn true;" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\t";
	protected final String TEXT_56 = NL + NL + "\t\treturn false;" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL
			+ "\t* <!-- begin-user-doc -->" + NL + "\t* <!-- end-user-doc -->" + NL + "\t* @param part" + NL
			+ "\t* @param selection" + NL + "\t* @generated" + NL + "\t*/" + NL
			+ "\tpublic void setInput(IWorkbenchPart part, ISelection selection) {" + NL
			+ "\t\tEObject newEObject = super.setInputSelection(part, selection);";
	protected final String TEXT_57 = "\t\t" + NL + "" + NL + "\t\tif (newEObject != null && !(newEObject instanceof ";
	protected final String TEXT_58 = "))" + NL + "\t\t\tnewEObject = get";
	protected final String TEXT_59 = "Object(newEObject);" + NL;
	protected final String TEXT_60 = "\t\t\t" + NL + "\t\tif (newEObject != null){" + NL
			+ "\t\t\tloadData((CapellaElement) newEObject);" + NL + "\t\t}else{" + NL + "\t\t\treturn;" + NL + "\t\t}"
			+ NL + "\t}\t" + NL;
	protected final String TEXT_61 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL
			+ "\t * <!-- end-user-doc -->" + NL
			+ "\t * @param parent: An EObject. It is considered as the Parent of an EMDE extension (a Viewpoint element)"
			+ NL + "\t * @return " + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate EObject get";
	protected final String TEXT_62 = "Object(EObject parent){" + NL + "\t\tif (! isViewpointActive(parent))" + NL
			+ "\t\t\treturn null;" + NL + "\t\t\t" + NL
			+ "\t\tif (parent == null || (parent != null && parent.eContents() == null))" + NL + "\t\t\treturn null;"
			+ NL + "\t\t\t " + NL + "\t\tEObject result = null;" + NL
			+ "\t\tfor (EObject iEObject : parent.eContents()) " + NL + "\t\t{" + NL + "\t\t\tif (iEObject instanceof ";
	protected final String TEXT_63 = ")" + NL + "\t\t\t{" + NL + "\t\t\t\tresult = (result == null ? (";
	protected final String TEXT_64 = ")iEObject : null );" + NL
			+ "\t\t\t\t// This case is true when there is more then one extension of the same type. " + NL
			+ "\t\t\t\tif (result == null)" + NL + "\t\t\t\t\tbreak;" + NL + "\t\t\t}" + NL + "\t\t}" + NL
			+ "\t\treturn result;" + NL + "\t}" + NL;
	protected final String TEXT_65 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL
			+ "\t * <!-- end-user-doc -->" + NL + "\t * @return True is the AF viewpoint is active. False else. " + NL
			+ "\t * @generated" + NL + "\t */" + NL + "\tprivate boolean isViewpointActive(EObject modelElement) {" + NL
			+ "\t\treturn ViewpointManager.getInstance(modelElement).isUsed(\"";
	protected final String TEXT_66 = "\")" + NL
			+ "\t\t\t\t&& ! ViewpointManager.getInstance(modelElement).isFiltered(\"";
	protected final String TEXT_67 = "\");" + NL + "\t}";
	protected final String TEXT_68 = NL + "\t/**" + NL + "\t* <!-- begin-user-doc -->" + NL
			+ "\t* <!-- end-user-doc -->" + NL + "\t* @param parent:" + NL + "\t* @param aTabbedPropertySheetPage:" + NL
			+ "\t* @generated" + NL + "\t*/" + NL
			+ "\tpublic void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {" + NL
			+ "\t\tsuper.createControls(parent, aTabbedPropertySheetPage);" + NL + "\t\t";
	protected final String TEXT_69 = NL + "\t\t";
	protected final String TEXT_70 = " " + NL + "\t\t";
	protected final String TEXT_71 = NL + "\t\t\t";
	protected final String TEXT_72 = NL + "\t\t\t";
	protected final String TEXT_73 = NL + "\t\t\t";
	protected final String TEXT_74 = NL + "\t\t\t";
	protected final String TEXT_75 = NL + "\t\t\t";
	protected final String TEXT_76 = NL + "\t\t\t";
	protected final String TEXT_77 = NL + "\t\t\t";
	protected final String TEXT_78 = NL + "\t\t\t";
	protected final String TEXT_79 = " = getWidgetFactory().createGroup(";
	protected final String TEXT_80 = ", ";
	protected final String TEXT_81 = ");" + NL + "\t\t\t";
	protected final String TEXT_82 = ".setLayout(new GridLayout(";
	protected final String TEXT_83 = ", false));" + NL + "\t\t\tGridData gd";
	protected final String TEXT_84 = " = new GridData(GridData.FILL_HORIZONTAL);" + NL + "\t\t\tgd";
	protected final String TEXT_85 = ".horizontalSpan = ((GridLayout)";
	protected final String TEXT_86 = ".getLayout()).numColumns;" + NL + "\t\t\t";
	protected final String TEXT_87 = ".setLayoutData(gd";
	protected final String TEXT_88 = ");" + NL + "\t\t";
	protected final String TEXT_89 = NL + "\t";
	protected final String TEXT_90 = NL + "\t\t";
	protected final String TEXT_91 = " = new ";
	protected final String TEXT_92 = "(";
	protected final String TEXT_93 = ", " + NL + "\t\t\t\t\t\t\t\t\t\t\"";
	protected final String TEXT_94 = " :\", " + NL + "\t\t\t\t\t\t\t\t\t\tgetWidgetFactory(), ";
	protected final String TEXT_95 = ");\t" + NL + "\t\t\t  ";
	protected final String TEXT_96 = NL + "\t\t";
	protected final String TEXT_97 = " = new ";
	protected final String TEXT_98 = "(";
	protected final String TEXT_99 = "," + NL + "\t\t\t\t\t\t\t\t\t\tgetWidgetFactory());\t\t\t" + NL + "\t\t\t  ";
	protected final String TEXT_100 = NL + "\t\t\t";
	protected final String TEXT_101 = " = new SimpleSemanticField(";
	protected final String TEXT_102 = ", " + NL + "\t\t\t\t\t\t\t\t\t\t\t\"";
	protected final String TEXT_103 = " :\", " + NL + "\t\t\t\t\t\t\t\t\t\t\tgetWidgetFactory(), " + NL
			+ "\t\t\t\t\t\t\t\t\t\t\tnew SimpleSemanticFieldController()); " + NL + "\t\t\t\t";
	protected final String TEXT_104 = NL + "\t\t";
	protected final String TEXT_105 = " = new ";
	protected final String TEXT_106 = "(";
	protected final String TEXT_107 = ", " + NL + "\t\t\t\t\t\t\t\t\t\t\"";
	protected final String TEXT_108 = " :\", " + NL + "\t\t\t\t\t\t\t\t\t\tgetWidgetFactory()," + NL
			+ "\t\t\t\t\t\t\t\t\t\tnew ";
	protected final String TEXT_109 = ");" + NL + "\t\t\t\t";
	protected final String TEXT_110 = NL;
	protected final String TEXT_111 = NL + "\t}";
	protected final String TEXT_112 = NL + "\t";
	protected final String TEXT_113 = NL + "\t\t\t";
	protected final String TEXT_114 = ".loadData(capellaElement_p, " + NL + "\t\t\t\t\t\t\t\t\t";
	protected final String TEXT_115 = ");\t" + NL + "\t\t\t  \t";
	protected final String TEXT_116 = NL + "\t\t\t";
	protected final String TEXT_117 = ".loadData(capellaElement_p);\t\t\t" + NL + "\t\t\t  \t";
	protected final String TEXT_118 = NL + "\t";
	protected final String TEXT_119 = NL + "\t";
	protected final String TEXT_120 = NL + "\t\tabstractSemanticFields.add(";
	protected final String TEXT_121 = ");" + NL + "\t";
	protected final String TEXT_122 = NL + "\t";
	protected final String TEXT_123 = NL;
	protected final String TEXT_124 = NL + NL + "\t/**" + NL + "\t* <!-- begin-user-doc -->" + NL
			+ "\t* <!-- end-user-doc -->" + NL + "\t* @param capellaElement_p" + NL + "\t* @generated" + NL + "\t*/"
			+ NL + "\tpublic void loadData(CapellaElement capellaElement_p) {" + NL
			+ "\t\tsuper.loadData(capellaElement_p);" + NL + "\t\t";
	protected final String TEXT_125 = NL + "\t} " + NL + "\t" + NL + "   /**" + NL + "\t* <!-- begin-user-doc -->" + NL
			+ "\t* <!-- end-user-doc -->" + NL + "\t* @generated" + NL + "\t*/" + NL
			+ "\tpublic List<AbstractSemanticField> getSemanticFields() {" + NL
			+ "\t\tList<AbstractSemanticField> abstractSemanticFields = new ArrayList<AbstractSemanticField>();" + NL
			+ "\t\t";
	protected final String TEXT_126 = NL + "\t\treturn abstractSemanticFields;" + NL + "\t}" + NL + "\t";
	protected final String TEXT_127 = NL;
	protected final String TEXT_128 = NL;

	public SectionJavaClass() {
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

		stringBuffer.append(TEXT_127);
		stringBuffer.append(TEXT_128);
		return stringBuffer.toString();
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;

		super.orchestration(new SuperOrchestrationContext(ictx));

		method_setEPFUtility(new StringBuffer(), ictx);

		method_setParameters(new StringBuffer(), ictx);

		method_setSectionClassToExtend(new StringBuffer(), ictx);

		method_setInterfaceToImplement(new StringBuffer(), ictx);

		method_genPackageName(new StringBuffer(), ictx);

		method_genSectionSuperClassesImport(new StringBuffer(), ictx);

		method_gentDefaultImports(new StringBuffer(), ictx);

		method_genWidgetDependentImports(new StringBuffer(), ictx);

		method_genModelDependentImports(new StringBuffer(), ictx);

		method_genJavaClassComment(new StringBuffer(), ictx);

		method_genJavaClassDeclaration(new StringBuffer(), ictx);

		method_genWidgetDeclaration(new StringBuffer(), ictx);

		method_genFilterMethod(new StringBuffer(), ictx);

		method_genView(new StringBuffer(), ictx);

		method_genController(new StringBuffer(), ictx);

		method_javaBlockEnd(new StringBuffer(), ictx);

		if (ictx.useReporter()) {
			Map<String, Object> parameterValues = new HashMap<String, Object>();
			parameterValues.put("parameter", this.parameter);
			String outputWithCallBack = OutputManager.computeLoopOutput(ictx);
			String loop = OutputManager.computeLoopOutputWithoutCallback(ictx);
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
		}
		return null;
	}

	protected java.lang.String sectionClassToExtends = null;

	public void set_sectionClassToExtends(java.lang.String object) {
		this.sectionClassToExtends = object;
	}

	protected java.lang.String sectionInterfaceToImplement = null;

	public void set_sectionInterfaceToImplement(java.lang.String object) {
		this.sectionInterfaceToImplement = object;
	}

	protected java.lang.String doGenInternalClasses = null;

	public void set_doGenInternalClasses(java.lang.String object) {
		this.doGenInternalClasses = object;
	}

	protected org.polarsys.capella.ad.viewpoint.dsl.generation.ui.util.EPFUtility epfUtility = null;

	public void set_epfUtility(org.polarsys.capella.ad.viewpoint.dsl.generation.ui.util.EPFUtility object) {
		this.epfUtility = object;
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

	protected void method_javaBlockEnd(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_1);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "javaBlockEnd", stringBuffer.toString());
	}

	protected void method_setParameters(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		String tabID = ((UI) parameter.eContainer()).getName();
		classname = JDTUtility.getValidClassName(tabID + "_" + parameter.getName());
		projectname = UIProjectManager.INSTANCE.getUiProject().getName();
		packagename = JDTUtility.getValidPackageName(projectname + ".sections");
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setParameters", stringBuffer.toString());
	}

	protected void method_setEPFUtility(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		epfUtility = EPFUtility.getEPFUtilityFor(parameter);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setEPFUtility", stringBuffer.toString());
	}

	protected void method_setSectionClassToExtend(final StringBuffer stringBuffer, final PatternContext ctx)
			throws Exception {

		sectionClassToExtends = "AbstractSection";
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setSectionClassToExtend", stringBuffer.toString());
	}

	protected void method_setInterfaceToImplement(final StringBuffer stringBuffer, final PatternContext ctx)
			throws Exception {

		sectionInterfaceToImplement = "IFilter";
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setInterfaceToImplement", stringBuffer.toString());
	}

	protected void method_genPackageName(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_2);
		stringBuffer.append(packagename);
		stringBuffer.append(TEXT_3);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "genPackageName", stringBuffer.toString());
	}

	protected void method_genSectionSuperClassesImport(final StringBuffer stringBuffer, final PatternContext ctx)
			throws Exception {

		stringBuffer.append(TEXT_4);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "genSectionSuperClassesImport", stringBuffer.toString());
	}

	protected void method_gentDefaultImports(final StringBuffer stringBuffer, final PatternContext ctx)
			throws Exception {

		stringBuffer.append(TEXT_5);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "gentDefaultImports", stringBuffer.toString());
	}

	protected void method_genWidgetDependentImports(final StringBuffer stringBuffer, final PatternContext ctx)
			throws Exception {

		stringBuffer.append(TEXT_6);
		class widgetPropertyGenerator {
			// Group declaration generation recursive method 
			private void generateImports(UIContainer container) {
				stringBuffer.append(TEXT_7);
				for (UIField uiField : container.getUI_fields()) {
					stringBuffer.append(TEXT_8);
					DataWidget iDataWidget = epfUtility.getDataOf(uiField);
					stringBuffer.append(TEXT_9);
					for (String currentImport : iDataWidget.generatedClassesImports) {
						stringBuffer.append(TEXT_10);
						stringBuffer.append(currentImport);
						stringBuffer.append(TEXT_11);
					}
					stringBuffer.append(TEXT_12);
				}
				stringBuffer.append(TEXT_13);
				if (container.getSubContainers() != null && container.getSubContainers().size() > 0) {
					for (UIContainer iUIContainer : container.getSubContainers()) {
						generateImports(iUIContainer);
					}
				}
			}
		}
		stringBuffer.append(TEXT_14);
		widgetPropertyGenerator wpg = new widgetPropertyGenerator();
		wpg.generateImports(parameter);
		stringBuffer.append(TEXT_15);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "genWidgetDependentImports", stringBuffer.toString());
	}

	protected void method_genModelDependentImports(final StringBuffer stringBuffer, final PatternContext ctx)
			throws Exception {

		stringBuffer.append(TEXT_16);
		class WidgetModelDependentImportGenerator {
			ArrayList<String> imported = new ArrayList<String>();

			private void init() {
				imported.clear();
			}

			private void createImportList(UIContainer container) {
				//Parse all UIFields to collect data 
				for (UIField uiField : container.getUI_fields()) {
					ArrayList<String> importList = epfUtility.getSematicImportsFor(uiField);
					for (String currentImport : importList) {
						if (!imported.contains(currentImport)) {
							stringBuffer.append(TEXT_17);
							stringBuffer.append(currentImport);
							stringBuffer.append(TEXT_18);
							imported.add(currentImport);
						}
					}
				}
				if (container.getSubContainers() != null && container.getSubContainers().size() > 0) {
					for (UIContainer iUIContainer : container.getSubContainers()) {
						createImportList(iUIContainer);
					}
				}
			}
		}
		WidgetModelDependentImportGenerator wmdig = new WidgetModelDependentImportGenerator();
		wmdig.init();
		wmdig.createImportList(parameter);
		stringBuffer.append(TEXT_19);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "genModelDependentImports", stringBuffer.toString());
	}

	protected void method_genJavaClassComment(final StringBuffer stringBuffer, final PatternContext ctx)
			throws Exception {

		stringBuffer.append(TEXT_20);
		stringBuffer.append(classname);
		stringBuffer.append(TEXT_21);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "genJavaClassComment", stringBuffer.toString());
	}

	protected void method_genJavaClassDeclaration(final StringBuffer stringBuffer, final PatternContext ctx)
			throws Exception {

		stringBuffer.append(TEXT_22);
		stringBuffer.append(classname);
		stringBuffer.append(TEXT_23);
		stringBuffer.append(sectionClassToExtends);
		stringBuffer.append(TEXT_24);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "genJavaClassDeclaration", stringBuffer.toString());
	}

	protected void method_genWidgetDeclaration(final StringBuffer stringBuffer, final PatternContext ctx)
			throws Exception {

		class widgetPropertyGenerator {
			// Group declaration generation recursive method 
			private void generateWidgets(UIContainer uiContainer) {
				stringBuffer.append(TEXT_25);
				for (UIField uiField : uiContainer.getUI_fields()) {
					stringBuffer.append(TEXT_26);
					String widgetName = epfUtility.getWidgetName(uiField);
					stringBuffer.append(TEXT_27);
					String className = epfUtility.getWidgetClassName(uiField);
					stringBuffer.append(TEXT_28);
					String description = uiField.getDescription();
					stringBuffer.append(TEXT_29);
					if (description != null && description.trim().length() > 0) {
						stringBuffer.append(TEXT_30);
						stringBuffer.append(description);
						stringBuffer.append(TEXT_31);
					} else {
						stringBuffer.append(TEXT_32);
					}
					stringBuffer.append(TEXT_33);
					stringBuffer.append(className);
					stringBuffer.append(TEXT_34);
					stringBuffer.append(widgetName);
					stringBuffer.append(TEXT_35);
				}
				stringBuffer.append(TEXT_36);
				if (uiContainer.getSubContainers() != null && uiContainer.getSubContainers().size() > 0) {
					for (UIContainer iUIContainer : uiContainer.getSubContainers()) {
						generateWidgets(iUIContainer);
					}
				}
			}
		}
		stringBuffer.append(TEXT_37);
		widgetPropertyGenerator wpg = new widgetPropertyGenerator();
		wpg.generateWidgets(parameter);
		stringBuffer.append(TEXT_38);
		class GroupPropertyGenerator {
			// Group declaration generation recursive method 
			private void generateGroups(UIContainer uiContainer) {
				stringBuffer.append(TEXT_39);
				if (uiContainer.eContainer() instanceof UIContainer) {
					stringBuffer.append(TEXT_40);
					String groupName = uiContainer.getName();
					stringBuffer.append(TEXT_41);
					String description = uiContainer.getDescription();
					stringBuffer.append(TEXT_42);
					if (description != null && description.trim().length() > 0) {
						stringBuffer.append(TEXT_43);
						stringBuffer.append(description);
						stringBuffer.append(TEXT_44);
					} else {
						stringBuffer.append(TEXT_45);
					}
					stringBuffer.append(TEXT_46);
					stringBuffer.append(groupName);
					stringBuffer.append(TEXT_47);
				}
				stringBuffer.append(TEXT_48);
				if (uiContainer.getSubContainers() != null && uiContainer.getSubContainers().size() > 0) {
					for (UIContainer iUIContainer : uiContainer.getSubContainers()) {
						generateGroups(iUIContainer);
					}
				}
			}
		}
		stringBuffer.append(TEXT_49);
		GroupPropertyGenerator gpg = new GroupPropertyGenerator();
		gpg.generateGroups(parameter);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "genWidgetDeclaration", stringBuffer.toString());
	}

	protected void method_genFilterMethod(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_50);
		class WidgetSelectGenerator {
			private List<String> classList = new ArrayList<String>();

			// Group creation generation recursive method 
			private void init() {
				stringBuffer.append(TEXT_51);
				classList.clear();
			}

			public String getFirstClassName() {
				String result = "";
				if (classList != null && classList.size() > 0)
					result = classList.get(0);
				return result;
			}

			private void createSelectList(UIContainer container) {
				//Parse all UIFields to collect data 
				for (UIField uiField : container.getUI_fields()) {
					boolean addClass = true;
					String className = ((NamedElement) uiField.getMapping().getUI_Field_Mapped_To().eContainer())
							.getName();
					for (String clazzName : classList) {
						if (clazzName.equals(className))
							addClass = false;
					}
					if (addClass)
						classList.add(className);
				}

				// Loop in the UIContainer child of the current UIContainer 
				if (container.getSubContainers() != null && container.getSubContainers().size() > 0) {
					for (UIContainer iUIContainer : container.getSubContainers()) {
						createSelectList(iUIContainer);
					}
				}
			}

			private void generateSelect(UIContainer container) {
				init();
				createSelectList(container);
				// Generate the selection instruction
				String result = "";
				for (String clazzName : classList) {
					if (result.trim().length() != 0)
						result += " || ";

					result += "eObjectToTest instanceof " + clazzName;
				}

				if (result.trim().length() != 0) {
					stringBuffer.append(TEXT_52);
					stringBuffer.append(result);
					stringBuffer.append(TEXT_53);
					if (UISectionUtility.canGenerateSelectionForContainer(parameter)
							&& getFirstClassName().trim().length() > 0) {
						stringBuffer.append(TEXT_54);
						stringBuffer.append(getFirstClassName());
						stringBuffer.append(TEXT_55);
					}
				}
			}
		}
		WidgetSelectGenerator wsg = new WidgetSelectGenerator();
		wsg.generateSelect(parameter);
		String extensionClassName = wsg.getFirstClassName();
		stringBuffer.append(TEXT_56);
		if (UISectionUtility.canGenerateSelectionForContainer(parameter)
				&& wsg.getFirstClassName().trim().length() > 0) {
			stringBuffer.append(TEXT_57);
			stringBuffer.append(extensionClassName);
			stringBuffer.append(TEXT_58);
			stringBuffer.append(extensionClassName);
			stringBuffer.append(TEXT_59);
		}
		stringBuffer.append(TEXT_60);
		if (UISectionUtility.canGenerateSelectionForContainer(parameter) && extensionClassName.trim().length() > 0) {
			stringBuffer.append(TEXT_61);
			stringBuffer.append(extensionClassName);
			stringBuffer.append(TEXT_62);
			stringBuffer.append(extensionClassName);
			stringBuffer.append(TEXT_63);
			stringBuffer.append(wsg.getFirstClassName());
			stringBuffer.append(TEXT_64);
			String afViewpointID = VpDslConfigurationHelper.getRootProjectName(parameter);
			stringBuffer.append(TEXT_65);
			stringBuffer.append(afViewpointID);
			stringBuffer.append(TEXT_66);
			stringBuffer.append(afViewpointID);
			stringBuffer.append(TEXT_67);
		}
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "genFilterMethod", stringBuffer.toString());
	}

	protected void method_genView(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_68);
		// UIField 2 widget 
		class widgetCreationGenerator {
			private int getParentColumns(UIContainer container) {
				int result = 1;
				for (UIField uiField : container.getUI_fields())
					if (uiField.getType().equals(UI_Field_Type.SIMPLE_CHOICE_LIST)
							|| uiField.getType().equals(UI_Field_Type.MULTIPLE_CHOICE_LIST)) {
						result = 6;
						break;
					}
				return result;
			}

			private void generateGroups(UIContainer container) {
				stringBuffer.append(TEXT_69);
				// Ignore the UIContainers child of an UI. These UIContainer are used to define the PropertySection
				stringBuffer.append(TEXT_70);
				if (!(container.eContainer() instanceof UI)) {
					stringBuffer.append(TEXT_71);
					//Data initialization 
					stringBuffer.append(TEXT_72);
					String groupName = container.getName();
					stringBuffer.append(TEXT_73);
					String groupLabel = (container.getLabel() != null && container.getLabel().trim().length() > 0
							? "\"" + container.getLabel() + "\"" : "ICommonConstants.EMPTY_STRING");
					stringBuffer.append(TEXT_74);
					String groupParent = "";
					stringBuffer.append(TEXT_75);
					EObject parent = container.eContainer();
					stringBuffer.append(TEXT_76);
					if (parent.eContainer() instanceof UI)
						groupParent = "_rootParentComposite";
					else
						groupParent = ((UIContainer) parent).getName();
					stringBuffer.append(TEXT_77);
					//Code generation
					stringBuffer.append(TEXT_78);
					stringBuffer.append(groupName);
					stringBuffer.append(TEXT_79);
					stringBuffer.append(groupParent);
					stringBuffer.append(TEXT_80);
					stringBuffer.append(groupLabel);
					stringBuffer.append(TEXT_81);
					stringBuffer.append(groupName);
					stringBuffer.append(TEXT_82);
					stringBuffer.append(getParentColumns(container));
					stringBuffer.append(TEXT_83);
					stringBuffer.append(groupName);
					stringBuffer.append(TEXT_84);
					stringBuffer.append(groupName);
					stringBuffer.append(TEXT_85);
					stringBuffer.append(groupParent);
					stringBuffer.append(TEXT_86);
					stringBuffer.append(groupName);
					stringBuffer.append(TEXT_87);
					stringBuffer.append(groupName);
					stringBuffer.append(TEXT_88);
				}
			}

			private String TextValueWidgetSkipParent(UIField uiField) {
				if (uiField.eContainer().eContainer() instanceof UI)
					return "false";
				return "true";
			}

			// Widget creation generation recursive method 
			private void generateWidgets(UIContainer uiContainer) {
				stringBuffer.append(TEXT_89);
				for (UIField uiField : uiContainer.getUI_fields()) {
					DataWidget iDatawidget = epfUtility.getDataOf(uiField);
					String widgetName = iDatawidget.widgetName;
					String className = iDatawidget.widgetGraphicalClassName;
					String widgetLabel = iDatawidget.widgetLabel;
					String widgetParent = iDatawidget.widgetParentName;

					switch (uiField.getType()) {
					case TEXT:
					case TEXTAREA:
						stringBuffer.append(TEXT_90);
						stringBuffer.append(widgetName);
						stringBuffer.append(TEXT_91);
						stringBuffer.append(className);
						stringBuffer.append(TEXT_92);
						stringBuffer.append(widgetParent);
						stringBuffer.append(TEXT_93);
						stringBuffer.append(widgetLabel);
						stringBuffer.append(TEXT_94);
						stringBuffer.append(TextValueWidgetSkipParent(uiField));
						stringBuffer.append(TEXT_95);
						break;

					case CHECKBOX:
					case RADIOBOX:
						stringBuffer.append(TEXT_96);
						stringBuffer.append(widgetName);
						stringBuffer.append(TEXT_97);
						stringBuffer.append(className);
						stringBuffer.append(TEXT_98);
						stringBuffer.append(widgetParent);
						stringBuffer.append(TEXT_99);
						break;

					case SIMPLE_CHOICE_LIST:
						stringBuffer.append(TEXT_100);
						stringBuffer.append(widgetName);
						stringBuffer.append(TEXT_101);
						stringBuffer.append(widgetParent);
						stringBuffer.append(TEXT_102);
						stringBuffer.append(widgetLabel);
						stringBuffer.append(TEXT_103);
						break;
					case MULTIPLE_CHOICE_LIST:
						stringBuffer.append(TEXT_104);
						stringBuffer.append(widgetName);
						stringBuffer.append(TEXT_105);
						stringBuffer.append(className);
						stringBuffer.append(TEXT_106);
						stringBuffer.append(widgetParent);
						stringBuffer.append(TEXT_107);
						stringBuffer.append(widgetLabel);
						stringBuffer.append(TEXT_108);
						stringBuffer.append(widgetName + "FieldController()");
						stringBuffer.append(TEXT_109);
						break;
					default:
						break;
					}
				}
				if (uiContainer.getSubContainers() != null && uiContainer.getSubContainers().size() > 0) {
					for (UIContainer iUIContainer : uiContainer.getSubContainers()) {
						generateGroups(iUIContainer);
						generateWidgets(iUIContainer);
					}
				}
			}
		}
		stringBuffer.append(TEXT_110);
		widgetCreationGenerator wcg = new widgetCreationGenerator();
		wcg.generateWidgets(parameter);
		stringBuffer.append(TEXT_111);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "genView", stringBuffer.toString());
	}

	protected void method_genController(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		class widgetPropertyGenerator {
			// Group UIFields generation recursive method 
			private void generateLoadData(UIContainer container) {
				stringBuffer.append(TEXT_112);
				for (UIField uiField : container.getUI_fields()) {
					String widgetName = epfUtility.getWidgetName(uiField);
					String widgetFieldAccessorName = epfUtility.getWidgetAccessor(uiField);
					switch (uiField.getType()) {
					case TEXT:
					case TEXTAREA:
					case MULTIPLE_CHOICE_LIST:
					case SIMPLE_CHOICE_LIST:
					case RADIOBOX:
						stringBuffer.append(TEXT_113);
						stringBuffer.append(widgetName);
						stringBuffer.append(TEXT_114);
						stringBuffer.append(widgetFieldAccessorName);
						stringBuffer.append(TEXT_115);
						break;

					case CHECKBOX:
						stringBuffer.append(TEXT_116);
						stringBuffer.append(widgetName);
						stringBuffer.append(TEXT_117);
						break;
					default:
						break;
					}
				}
				stringBuffer.append(TEXT_118);
				if (container.getSubContainers() != null && container.getSubContainers().size() > 0) {
					for (UIContainer iUIContainer : container.getSubContainers()) {
						generateLoadData(iUIContainer);
					}
				}
			}

			// Group UIFields generation recursive method 
			private void generateAddSematics(UIContainer container) {
				stringBuffer.append(TEXT_119);
				for (UIField uiField : container.getUI_fields()) {
					String widgetName = epfUtility.getWidgetName(uiField);
					stringBuffer.append(TEXT_120);
					stringBuffer.append(widgetName);
					stringBuffer.append(TEXT_121);
				}
				stringBuffer.append(TEXT_122);
				if (container.getSubContainers() != null && container.getSubContainers().size() > 0) {
					for (UIContainer iUIContainer : container.getSubContainers()) {
						generateAddSematics(iUIContainer);
					}
				}
			}
		}
		stringBuffer.append(TEXT_123);
		widgetPropertyGenerator wpg = new widgetPropertyGenerator();
		stringBuffer.append(TEXT_124);
		wpg.generateLoadData(parameter);
		stringBuffer.append(TEXT_125);
		wpg.generateAddSematics(parameter);
		stringBuffer.append(TEXT_126);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "genController", stringBuffer.toString());
	}

	public boolean preCondition(PatternContext ctx) throws Exception {
		return parameter.eContainer() instanceof UI;
	}
}