//Generated with EGF 1.5.0.v20170706-0846
package org.polarsys.capella.ad.viewpoint.dsl.generation.ui.javaclasses;

import org.polarsys.capella.ad.viewpoint.dsl.generation.ui.util.VPUIHelper;
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
	protected final String TEXT_10 = NL + "\t\t\t";
	protected final String TEXT_11 = NL + "\t\t\t\timport ";
	protected final String TEXT_12 = ";" + NL + "\t\t\t\t";
	protected final String TEXT_13 = NL + "\t\t\t";
	protected final String TEXT_14 = NL + "\t\t";
	protected final String TEXT_15 = NL + "\t";
	protected final String TEXT_16 = NL + "\t";
	protected final String TEXT_17 = NL + "\t\t";
	protected final String TEXT_18 = NL + "\t\t";
	protected final String TEXT_19 = NL + "\t\t\t";
	protected final String TEXT_20 = NL + "\t\t\t\timport ";
	protected final String TEXT_21 = ";" + NL + "\t\t\t\t";
	protected final String TEXT_22 = NL + "\t\t\t";
	protected final String TEXT_23 = NL + "\t\t";
	protected final String TEXT_24 = NL + "\t";
	protected final String TEXT_25 = NL + "\t";
	protected final String TEXT_26 = NL;
	protected final String TEXT_27 = NL + NL;
	protected final String TEXT_28 = "import org.polarsys.capella.core.data.capellacore.CapellaElement;";
	protected final String TEXT_29 = NL + "\t\t\t\t\timport ";
	protected final String TEXT_30 = ";";
	protected final String TEXT_31 = NL;
	protected final String TEXT_32 = "/**" + NL + " * <!-- begin-user-doc -->" + NL
			+ " * This class is an implementation of the section '<em><b>[";
	protected final String TEXT_33 = "]</b></em>'." + NL + " * <!-- end-user-doc -->" + NL + " * <p>" + NL + " * </p>"
			+ NL + " *" + NL + " * @generated" + NL + " */ " + NL + " " + NL + " ";
	protected final String TEXT_34 = "public class ";
	protected final String TEXT_35 = " extends ";
	protected final String TEXT_36 = "{ " + NL;
	protected final String TEXT_37 = NL + "\t";
	protected final String TEXT_38 = NL + "\t\t";
	protected final String TEXT_39 = NL + "\t\t";
	protected final String TEXT_40 = NL + "\t\t";
	protected final String TEXT_41 = NL + "\t\t/**";
	protected final String TEXT_42 = NL + "\t\t* <!-- begin-model-doc -->" + NL + "\t\t* ";
	protected final String TEXT_43 = NL + "\t\t* <!-- end-model-doc -->";
	protected final String TEXT_44 = NL + "\t\t* <!-- begin-model-doc -->" + NL + "\t\t* <!-- end-model-doc -->";
	protected final String TEXT_45 = NL + "\t\t* <!-- begin-user-doc -->" + NL + "\t\t* <!-- end-user-doc -->" + NL
			+ "\t\t* @generated" + NL + "\t\t*/" + NL + "\t\tprivate ";
	protected final String TEXT_46 = " ";
	protected final String TEXT_47 = ";" + NL + "\t" + NL + "\t";
	protected final String TEXT_48 = NL + "\t";
	protected final String TEXT_49 = NL;
	protected final String TEXT_50 = NL;
	protected final String TEXT_51 = NL + "\t";
	protected final String TEXT_52 = NL + "\t\t";
	protected final String TEXT_53 = NL + "\t\t";
	protected final String TEXT_54 = NL + "\t\t/**";
	protected final String TEXT_55 = NL + "\t\t* <!-- begin-model-doc -->" + NL + "\t\t* ";
	protected final String TEXT_56 = NL + "\t\t* <!-- end-model-doc -->";
	protected final String TEXT_57 = NL + "\t\t* <!-- begin-model-doc -->" + NL + "\t\t* <!-- end-model-doc -->";
	protected final String TEXT_58 = NL + " \t\t* <!-- begin-user-doc -->" + NL + " \t\t* <!-- end-user-doc -->" + NL
			+ " \t\t* @generated" + NL + " \t\t*/" + NL + "\t\tprivate Group ";
	protected final String TEXT_59 = ";" + NL + "\t\t" + NL + "\t";
	protected final String TEXT_60 = NL + "\t" + NL + "\t";
	protected final String TEXT_61 = NL;
	protected final String TEXT_62 = NL + "\t/**" + NL + "\t* <!-- begin-user-doc -->" + NL
			+ "\t* <!-- end-user-doc -->" + NL + "\t* @param eObject: current object" + NL + "\t* @generated" + NL
			+ "\t*/" + NL + "\tpublic boolean select(Object eObject) {" + NL
			+ "\t\tEObject eObjectToTest = super.selection(eObject);" + NL + "\t\t";
	protected final String TEXT_63 = NL + "\t\t";
	protected final String TEXT_64 = NL + "\t\t\tif (eObjectToTest == null){" + NL + "\t\t\t\treturn false; " + NL
			+ "\t\t\t} else if (";
	protected final String TEXT_65 = "){" + NL + "\t\t\t\treturn true;" + NL + "\t\t\t}\t";
	protected final String TEXT_66 = NL + "\t\t\telse {" + NL + "\t\t\t\tEObject children = get";
	protected final String TEXT_67 = "Object(eObjectToTest);" + NL + "\t\t\t\tif (children != null) {" + NL
			+ "\t\t\t\t\treturn true;" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\t";
	protected final String TEXT_68 = NL + NL + "\t\treturn false;" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL
			+ "\t* <!-- begin-user-doc -->" + NL + "\t* <!-- end-user-doc -->" + NL + "\t* @param part" + NL
			+ "\t* @param selection" + NL + "\t* @generated" + NL + "\t*/" + NL
			+ "\tpublic void setInput(IWorkbenchPart part, ISelection selection) {" + NL
			+ "\t\tEObject newEObject = super.setInputSelection(part, selection);";
	protected final String TEXT_69 = "\t\t" + NL + "" + NL + "\t\tif (newEObject != null && !(newEObject instanceof ";
	protected final String TEXT_70 = "))" + NL + "\t\t\tnewEObject = get";
	protected final String TEXT_71 = "Object(newEObject);" + NL;
	protected final String TEXT_72 = "\t\t\t" + NL + "\t\tif (newEObject != null){" + NL
			+ "\t\t\tloadData((CapellaElement) newEObject);" + NL + "\t\t}else{" + NL + "\t\t\treturn;" + NL + "\t\t}"
			+ NL + "\t}\t" + NL;
	protected final String TEXT_73 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL
			+ "\t * <!-- end-user-doc -->" + NL
			+ "\t * @param parent: An EObject. It is considered as the Parent of an EMDE extension (a Viewpoint element)"
			+ NL + "\t * @return " + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate EObject get";
	protected final String TEXT_74 = "Object(EObject parent){" + NL + "\t\tif (parent == null)" + NL
			+ "\t\t\treturn null;" + NL + "" + NL + "\t\tif (!isViewpointActive(parent))" + NL + "\t\t\treturn null;"
			+ NL + "" + NL + "\t\tif (parent.eContents() == null)" + NL + "\t\t\treturn null;" + NL + "\t\t\t " + NL
			+ "\t\tEObject result = null;" + NL + "\t\tfor (EObject iEObject : parent.eContents()) " + NL + "\t\t{" + NL
			+ "\t\t\tif (iEObject instanceof ";
	protected final String TEXT_75 = ")" + NL + "\t\t\t{" + NL + "\t\t\t\tresult = (result == null ? (";
	protected final String TEXT_76 = ")iEObject : null );" + NL
			+ "\t\t\t\t// This case is true when there is more then one extension of the same type. " + NL
			+ "\t\t\t\tif (result == null)" + NL + "\t\t\t\t\tbreak;" + NL + "\t\t\t}" + NL + "\t\t}" + NL
			+ "\t\treturn result;" + NL + "\t}" + NL;
	protected final String TEXT_77 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL
			+ "\t * <!-- end-user-doc -->" + NL + "\t * @return True is the AF viewpoint is active. False else. " + NL
			+ "\t * @generated" + NL + "\t */" + NL + "\tprivate boolean isViewpointActive(EObject modelElement) {" + NL
			+ "\t\treturn ViewpointManager.getInstance(modelElement).isUsed(\"";
	protected final String TEXT_78 = "\")" + NL
			+ "\t\t\t\t&& ! ViewpointManager.getInstance(modelElement).isFiltered(\"";
	protected final String TEXT_79 = "\");" + NL + "\t}";
	protected final String TEXT_80 = NL + "\t/**" + NL + "\t* <!-- begin-user-doc -->" + NL
			+ "\t* <!-- end-user-doc -->" + NL + "\t* @param parent:" + NL + "\t* @param aTabbedPropertySheetPage:" + NL
			+ "\t* @generated" + NL + "\t*/" + NL
			+ "\tpublic void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {" + NL
			+ "\t\tsuper.createControls(parent, aTabbedPropertySheetPage);" + NL + "\t\t";
	protected final String TEXT_81 = NL + "\t\t";
	protected final String TEXT_82 = " " + NL + "\t\t";
	protected final String TEXT_83 = NL + "\t\t\t";
	protected final String TEXT_84 = NL + "\t\t\t";
	protected final String TEXT_85 = NL + "\t\t\t";
	protected final String TEXT_86 = NL + "\t\t\t";
	protected final String TEXT_87 = NL + "\t\t\t";
	protected final String TEXT_88 = NL + "\t\t\t";
	protected final String TEXT_89 = NL + "\t\t\t";
	protected final String TEXT_90 = NL + "\t\t\t";
	protected final String TEXT_91 = " = getWidgetFactory().createGroup(";
	protected final String TEXT_92 = ", ";
	protected final String TEXT_93 = ");" + NL + "\t\t\t";
	protected final String TEXT_94 = ".setLayout(new GridLayout(";
	protected final String TEXT_95 = ", false));" + NL + "\t\t\t";
	protected final String TEXT_96 = NL + "\t\t\t\tGridData gd";
	protected final String TEXT_97 = " = new GridData(GridData.FILL_BOTH);" + NL + "\t\t\t";
	protected final String TEXT_98 = NL + "\t\t\t\tGridData gd";
	protected final String TEXT_99 = " = new GridData(GridData.FILL_HORIZONTAL);" + NL + "\t\t\t";
	protected final String TEXT_100 = NL + "\t\t\tgd";
	protected final String TEXT_101 = ".horizontalSpan = ((GridLayout)";
	protected final String TEXT_102 = ".getLayout()).numColumns;" + NL + "\t\t\t";
	protected final String TEXT_103 = ".setLayoutData(gd";
	protected final String TEXT_104 = ");" + NL + "\t\t";
	protected final String TEXT_105 = NL + "\t";
	protected final String TEXT_106 = NL + "\t\t";
	protected final String TEXT_107 = " = new ";
	protected final String TEXT_108 = "(";
	protected final String TEXT_109 = ", " + NL + "\t\t\t\t\t\t\t\t\t\t\"";
	protected final String TEXT_110 = " :\", " + NL + "\t\t\t\t\t\t\t\t\t\tgetWidgetFactory(), ";
	protected final String TEXT_111 = ");\t" + NL + "\t\t\t  ";
	protected final String TEXT_112 = NL + "\t\t";
	protected final String TEXT_113 = " = new ";
	protected final String TEXT_114 = "(";
	protected final String TEXT_115 = "," + NL + "\t\t\t\t\t\t\t\t\t\tgetWidgetFactory());\t\t\t" + NL + "\t\t\t  ";
	protected final String TEXT_116 = NL + "\t\t\t";
	protected final String TEXT_117 = " = new SimpleSemanticField(";
	protected final String TEXT_118 = ", " + NL + "\t\t\t\t\t\t\t\t\t\t\t\"";
	protected final String TEXT_119 = " :\", " + NL + "\t\t\t\t\t\t\t\t\t\t\tgetWidgetFactory(), " + NL
			+ "\t\t\t\t\t\t\t\t\t\t\tnew SimpleSemanticFieldController()); " + NL + "\t\t\t\t";
	protected final String TEXT_120 = NL + "\t\t";
	protected final String TEXT_121 = " = new ";
	protected final String TEXT_122 = "(";
	protected final String TEXT_123 = ", " + NL + "\t\t\t\t\t\t\t\t\t\t\"";
	protected final String TEXT_124 = " :\", " + NL + "\t\t\t\t\t\t\t\t\t\tgetWidgetFactory()," + NL
			+ "\t\t\t\t\t\t\t\t\t\tnew ";
	protected final String TEXT_125 = ");" + NL + "\t\t\t\t";
	protected final String TEXT_126 = NL + "\t\t\t\t";
	protected final String TEXT_127 = " = createRichtextControl(";
	protected final String TEXT_128 = ", \"";
	protected final String TEXT_129 = " :\");" + NL + "\t\t\t";
	protected final String TEXT_130 = NL;
	protected final String TEXT_131 = NL + "\t}";
	protected final String TEXT_132 = NL + "\t/**" + NL + "\t* <!-- begin-user-doc -->" + NL
			+ "\t* <!-- end-user-doc -->" + NL + "\t* @param parent" + NL + "\t* @param label" + NL + "\t* @generated"
			+ NL + "\t*/" + NL + "\tpublic MDERichTextWidget createRichtextControl(Composite parent, String label) {"
			+ NL + "\t\tLabel labelWidget = new Label(parent, SWT.NONE);" + NL + "\t\tlabelWidget.setText(label);" + NL
			+ "\t\tfinal MDERichTextWidget widget = (new MDERichTextFactory()).createMinimalRichTextWidget(parent);"
			+ NL + "\t\twidget.setSaveStrategy(new SaveStrategy() {" + NL + "\t\t\t@Override" + NL
			+ "\t\t\tpublic void save(final String editorText, final EObject owner, final EStructuralFeature feature) {"
			+ NL + "\t\t\t\tif (NotificationHelper.isNotificationRequired(owner, feature, editorText)) {" + NL
			+ "\t\t\t\t      AbstractReadWriteCommand command = new AbstractReadWriteCommand() {" + NL
			+ "\t\t\t\t        public void run() {" + NL + "\t\t\t\t        \towner.eSet(feature, editorText);" + NL
			+ "\t\t\t\t        }" + NL + "\t\t\t\t      };" + NL + "\t\t\t\t      executeCommand(command);" + NL
			+ "\t\t\t\t }" + NL + "\t\t\t}" + NL + "\t\t\t" + NL
			+ "\t\t\tprotected void executeCommand(final ICommand command) {" + NL + "\t\t\t    // Precondition" + NL
			+ "\t\t\t    if ((null == command)) {" + NL + "\t\t\t      return;" + NL + "\t\t\t    }" + NL
			+ "\t\t\t    ICommand cmd = command;" + NL + "\t\t\t    if (command instanceof AbstractReadWriteCommand) {"
			+ NL + "\t\t\t      cmd = new AbstractReadWriteCommand() {" + NL + "\t\t\t        /**" + NL
			+ "\t\t\t         * @see java.lang.Runnable#run()" + NL + "\t\t\t         */" + NL
			+ "\t\t\t        public void run() {" + NL + "\t\t\t          command.run();" + NL + "\t\t\t        }" + NL
			+ "" + NL + "\t\t\t        /**" + NL
			+ "\t\t\t         * @see org.polarsys.capella.common.tig.ef.command.AbstractCommand#getAffectedObjects()"
			+ NL + "\t\t\t         */" + NL + "\t\t\t        @SuppressWarnings(\"synthetic-access\")" + NL
			+ "\t\t\t        @Override" + NL + "\t\t\t        public Collection<?> getAffectedObjects() {" + NL
			+ "\t\t\t          return Collections.singletonList(widget.getElement());" + NL + "\t\t\t        }" + NL
			+ "" + NL + "\t\t\t        /**" + NL
			+ "\t\t\t         * @see org.polarsys.capella.common.tig.ef.command.AbstractCommand#getName()" + NL
			+ "\t\t\t         */" + NL + "\t\t\t        @Override" + NL + "\t\t\t        public String getName() {" + NL
			+ "\t\t\t          return \"Model Edition\"; //$NON-NLS-1$" + NL + "\t\t\t        }" + NL + "" + NL
			+ "\t\t\t        /**" + NL
			+ "\t\t\t         * @see org.polarsys.capella.common.tig.ef.command.AbstractCommand#commandInterrupted()"
			+ NL + "\t\t\t         */" + NL + "\t\t\t        @Override" + NL
			+ "\t\t\t        public void commandInterrupted() {" + NL + "\t\t\t          commandRolledBack();" + NL
			+ "\t\t\t        }" + NL + "" + NL + "\t\t\t        /**" + NL
			+ "\t\t\t         * @see org.polarsys.capella.common.tig.ef.command.AbstractCommand#commandRolledBack()"
			+ NL + "\t\t\t         */" + NL + "\t\t\t        @SuppressWarnings(\"synthetic-access\")" + NL
			+ "\t\t\t        @Override" + NL + "\t\t\t        public void commandRolledBack() {" + NL
			+ "\t\t\t          // Reload data >> refresh the UI." + NL
			+ "\t\t\t          loadData(widget.getElement());" + NL + "\t\t\t        }" + NL + "\t\t\t      };" + NL
			+ "\t\t\t    }" + NL + "\t\t\t    // Execute it against the TED." + NL
			+ "\t\t\t    TransactionHelper.getExecutionManager(widget.getElement()).execute(cmd);" + NL + "\t\t\t  }"
			+ NL + "\t\t});" + NL + "\t\treturn widget;" + NL + "\t}";
	protected final String TEXT_133 = NL + "\t";
	protected final String TEXT_134 = NL + "\t\t\t";
	protected final String TEXT_135 = ".loadData(capellaElement_p, " + NL + "\t\t\t\t\t\t\t\t\t";
	protected final String TEXT_136 = ");\t" + NL + "\t\t\t  \t";
	protected final String TEXT_137 = NL + "\t\t\t";
	protected final String TEXT_138 = ".bind(capellaElement_p, " + NL + "\t\t\t\t\t\t\t\t\t";
	protected final String TEXT_139 = ");\t" + NL + "\t\t\t\t";
	protected final String TEXT_140 = NL + "\t\t\t";
	protected final String TEXT_141 = ".loadData(capellaElement_p);\t\t\t" + NL + "\t\t\t  \t";
	protected final String TEXT_142 = NL + "\t";
	protected final String TEXT_143 = NL + "\t";
	protected final String TEXT_144 = NL + "\t\tabstractSemanticFields.add(";
	protected final String TEXT_145 = ");" + NL + "\t\t";
	protected final String TEXT_146 = NL + "\t";
	protected final String TEXT_147 = NL;
	protected final String TEXT_148 = NL + NL + "\t/**" + NL + "\t* <!-- begin-user-doc -->" + NL
			+ "\t* <!-- end-user-doc -->" + NL + "\t* @param capellaElement_p" + NL + "\t* @generated" + NL + "\t*/"
			+ NL + "\tpublic void loadData(CapellaElement capellaElement_p) {" + NL
			+ "\t\tsuper.loadData(capellaElement_p);" + NL + "\t\t";
	protected final String TEXT_149 = NL + "\t} " + NL + "\t" + NL + "   /**" + NL + "\t* <!-- begin-user-doc -->" + NL
			+ "\t* <!-- end-user-doc -->" + NL + "\t* @generated" + NL + "\t*/" + NL
			+ "\tpublic List<AbstractSemanticField> getSemanticFields() {" + NL
			+ "\t\tList<AbstractSemanticField> abstractSemanticFields = new ArrayList<AbstractSemanticField>();" + NL
			+ "\t\t";
	protected final String TEXT_150 = NL + "\t\treturn abstractSemanticFields;" + NL + "\t}" + NL + "\t";
	protected final String TEXT_151 = NL;
	protected final String TEXT_152 = NL;

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

		stringBuffer.append(TEXT_151);
		stringBuffer.append(TEXT_152);
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
			private ArrayList<String> alreadyGeneratedImports = new ArrayList<String>();

			// Group declaration generation recursive method 
			private void generateImports(UIContainer container) {
				stringBuffer.append(TEXT_7);
				for (UIField uiField : container.getUI_fields()) {
					stringBuffer.append(TEXT_8);
					DataWidget iDataWidget = epfUtility.getDataOf(uiField);
					stringBuffer.append(TEXT_9);
					for (String currentImport : iDataWidget.generatedClassesImports) {
						stringBuffer.append(TEXT_10);
						if (!alreadyGeneratedImports.contains(currentImport)) {
							stringBuffer.append(TEXT_11);
							stringBuffer.append(currentImport);
							stringBuffer.append(TEXT_12);
							alreadyGeneratedImports.add(currentImport);
							stringBuffer.append(TEXT_13);
						}
						stringBuffer.append(TEXT_14);
					}
					stringBuffer.append(TEXT_15);
				}
				stringBuffer.append(TEXT_16);
				for (UIField uiField : container.getUI_fields()) {
					stringBuffer.append(TEXT_17);
					DataWidget iDataWidget = epfUtility.getDataOf(uiField);
					stringBuffer.append(TEXT_18);
					for (String currentImport : iDataWidget.additionalImports) {
						stringBuffer.append(TEXT_19);
						if (!alreadyGeneratedImports.contains(currentImport)) {
							stringBuffer.append(TEXT_20);
							stringBuffer.append(currentImport);
							stringBuffer.append(TEXT_21);
							alreadyGeneratedImports.add(currentImport);
							stringBuffer.append(TEXT_22);
						}
						stringBuffer.append(TEXT_23);
					}
					stringBuffer.append(TEXT_24);
				}
				stringBuffer.append(TEXT_25);
				if (container.getSubContainers() != null && container.getSubContainers().size() > 0) {
					for (UIContainer iUIContainer : container.getSubContainers()) {
						generateImports(iUIContainer);
					}
				}
			}
		}
		stringBuffer.append(TEXT_26);
		widgetPropertyGenerator wpg = new widgetPropertyGenerator();
		wpg.generateImports(parameter);
		stringBuffer.append(TEXT_27);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "genWidgetDependentImports", stringBuffer.toString());
	}

	protected void method_genModelDependentImports(final StringBuffer stringBuffer, final PatternContext ctx)
			throws Exception {

		stringBuffer.append(TEXT_28);
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
							stringBuffer.append(TEXT_29);
							stringBuffer.append(currentImport);
							stringBuffer.append(TEXT_30);
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
		stringBuffer.append(TEXT_31);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "genModelDependentImports", stringBuffer.toString());
	}

	protected void method_genJavaClassComment(final StringBuffer stringBuffer, final PatternContext ctx)
			throws Exception {

		stringBuffer.append(TEXT_32);
		stringBuffer.append(classname);
		stringBuffer.append(TEXT_33);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "genJavaClassComment", stringBuffer.toString());
	}

	protected void method_genJavaClassDeclaration(final StringBuffer stringBuffer, final PatternContext ctx)
			throws Exception {

		stringBuffer.append(TEXT_34);
		stringBuffer.append(classname);
		stringBuffer.append(TEXT_35);
		stringBuffer.append(sectionClassToExtends);
		stringBuffer.append(TEXT_36);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "genJavaClassDeclaration", stringBuffer.toString());
	}

	protected void method_genWidgetDeclaration(final StringBuffer stringBuffer, final PatternContext ctx)
			throws Exception {

		class widgetPropertyGenerator {
			// Group declaration generation recursive method 
			private void generateWidgets(UIContainer uiContainer) {
				stringBuffer.append(TEXT_37);
				for (UIField uiField : uiContainer.getUI_fields()) {
					stringBuffer.append(TEXT_38);
					String widgetName = epfUtility.getWidgetName(uiField);
					stringBuffer.append(TEXT_39);
					String className = epfUtility.getWidgetClassName(uiField);
					stringBuffer.append(TEXT_40);
					String description = uiField.getDescription();
					stringBuffer.append(TEXT_41);
					if (description != null && description.trim().length() > 0) {
						stringBuffer.append(TEXT_42);
						stringBuffer.append(description);
						stringBuffer.append(TEXT_43);
					} else {
						stringBuffer.append(TEXT_44);
					}
					stringBuffer.append(TEXT_45);
					stringBuffer.append(className);
					stringBuffer.append(TEXT_46);
					stringBuffer.append(widgetName);
					stringBuffer.append(TEXT_47);
				}
				stringBuffer.append(TEXT_48);
				if (uiContainer.getSubContainers() != null && uiContainer.getSubContainers().size() > 0) {
					for (UIContainer iUIContainer : uiContainer.getSubContainers()) {
						generateWidgets(iUIContainer);
					}
				}
			}
		}
		stringBuffer.append(TEXT_49);
		widgetPropertyGenerator wpg = new widgetPropertyGenerator();
		wpg.generateWidgets(parameter);
		stringBuffer.append(TEXT_50);
		class GroupPropertyGenerator {
			// Group declaration generation recursive method 
			private void generateGroups(UIContainer uiContainer) {
				stringBuffer.append(TEXT_51);
				if (uiContainer.eContainer() instanceof UIContainer) {
					stringBuffer.append(TEXT_52);
					String groupName = uiContainer.getName();
					stringBuffer.append(TEXT_53);
					String description = uiContainer.getDescription();
					stringBuffer.append(TEXT_54);
					if (description != null && description.trim().length() > 0) {
						stringBuffer.append(TEXT_55);
						stringBuffer.append(description);
						stringBuffer.append(TEXT_56);
					} else {
						stringBuffer.append(TEXT_57);
					}
					stringBuffer.append(TEXT_58);
					stringBuffer.append(groupName);
					stringBuffer.append(TEXT_59);
				}
				stringBuffer.append(TEXT_60);
				if (uiContainer.getSubContainers() != null && uiContainer.getSubContainers().size() > 0) {
					for (UIContainer iUIContainer : uiContainer.getSubContainers()) {
						generateGroups(iUIContainer);
					}
				}
			}
		}
		stringBuffer.append(TEXT_61);
		GroupPropertyGenerator gpg = new GroupPropertyGenerator();
		gpg.generateGroups(parameter);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "genWidgetDeclaration", stringBuffer.toString());
	}

	protected void method_genFilterMethod(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_62);
		class WidgetSelectGenerator {
			private List<String> classList = new ArrayList<String>();

			// Group creation generation recursive method 
			private void init() {
				stringBuffer.append(TEXT_63);
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
					stringBuffer.append(TEXT_64);
					stringBuffer.append(result);
					stringBuffer.append(TEXT_65);
					if (UISectionUtility.canGenerateSelectionForContainer(parameter)
							&& getFirstClassName().trim().length() > 0) {
						stringBuffer.append(TEXT_66);
						stringBuffer.append(getFirstClassName());
						stringBuffer.append(TEXT_67);
					}
				}
			}
		}
		WidgetSelectGenerator wsg = new WidgetSelectGenerator();
		wsg.generateSelect(parameter);
		String extensionClassName = wsg.getFirstClassName();
		stringBuffer.append(TEXT_68);
		if (UISectionUtility.canGenerateSelectionForContainer(parameter)
				&& wsg.getFirstClassName().trim().length() > 0) {
			stringBuffer.append(TEXT_69);
			stringBuffer.append(extensionClassName);
			stringBuffer.append(TEXT_70);
			stringBuffer.append(extensionClassName);
			stringBuffer.append(TEXT_71);
		}
		stringBuffer.append(TEXT_72);
		if (UISectionUtility.canGenerateSelectionForContainer(parameter) && extensionClassName.trim().length() > 0) {
			stringBuffer.append(TEXT_73);
			stringBuffer.append(extensionClassName);
			stringBuffer.append(TEXT_74);
			stringBuffer.append(extensionClassName);
			stringBuffer.append(TEXT_75);
			stringBuffer.append(wsg.getFirstClassName());
			stringBuffer.append(TEXT_76);
			String afViewpointID = VpDslConfigurationHelper.getRootProjectName(parameter);
			stringBuffer.append(TEXT_77);
			stringBuffer.append(afViewpointID);
			stringBuffer.append(TEXT_78);
			stringBuffer.append(afViewpointID);
			stringBuffer.append(TEXT_79);
		}
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "genFilterMethod", stringBuffer.toString());
	}

	protected void method_genView(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_80);
		// UIField 2 widget 
		class widgetCreationGenerator {
			boolean generateRichTextCreateControl = false;

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
				stringBuffer.append(TEXT_81);
				// Ignore the UIContainers child of an UI. These UIContainer are used to define the PropertySection
				stringBuffer.append(TEXT_82);
				if (!(container.eContainer() instanceof UI)) {
					stringBuffer.append(TEXT_83);
					//Data initialization 
					stringBuffer.append(TEXT_84);
					String groupName = container.getName();
					stringBuffer.append(TEXT_85);
					String groupLabel = (container.getLabel() != null && container.getLabel().trim().length() > 0
							? "\"" + container.getLabel() + "\"" : "ICommonConstants.EMPTY_STRING");
					stringBuffer.append(TEXT_86);
					String groupParent = "";
					stringBuffer.append(TEXT_87);
					EObject parent = container.eContainer();
					stringBuffer.append(TEXT_88);
					if (parent.eContainer() instanceof UI)
						groupParent = "rootParentComposite";
					else
						groupParent = ((UIContainer) parent).getName();
					stringBuffer.append(TEXT_89);
					//Code generation
					stringBuffer.append(TEXT_90);
					stringBuffer.append(groupName);
					stringBuffer.append(TEXT_91);
					stringBuffer.append(groupParent);
					stringBuffer.append(TEXT_92);
					stringBuffer.append(groupLabel);
					stringBuffer.append(TEXT_93);
					stringBuffer.append(groupName);
					stringBuffer.append(TEXT_94);
					stringBuffer.append(getParentColumns(container));
					stringBuffer.append(TEXT_95);
					if (VPUIHelper.generateRichTextForUI_Container(container)) {
						stringBuffer.append(TEXT_96);
						stringBuffer.append(groupName);
						stringBuffer.append(TEXT_97);
					} else {
						stringBuffer.append(TEXT_98);
						stringBuffer.append(groupName);
						stringBuffer.append(TEXT_99);
					}
					stringBuffer.append(TEXT_100);
					stringBuffer.append(groupName);
					stringBuffer.append(TEXT_101);
					stringBuffer.append(groupParent);
					stringBuffer.append(TEXT_102);
					stringBuffer.append(groupName);
					stringBuffer.append(TEXT_103);
					stringBuffer.append(groupName);
					stringBuffer.append(TEXT_104);
				}
			}

			private String TextValueWidgetSkipParent(UIField uiField) {
				if (uiField.eContainer().eContainer() instanceof UI)
					return "false";
				return "true";
			}

			// Widget creation generation recursive method 
			private void generateWidgets(UIContainer uiContainer) {
				stringBuffer.append(TEXT_105);
				for (UIField uiField : uiContainer.getUI_fields()) {
					DataWidget iDatawidget = epfUtility.getDataOf(uiField);
					String widgetName = iDatawidget.widgetName;
					String className = iDatawidget.widgetGraphicalClassName;
					String widgetLabel = iDatawidget.widgetLabel;
					String widgetParent = iDatawidget.widgetParentName;

					switch (uiField.getType()) {
					case TEXT:
					case TEXTAREA:
						stringBuffer.append(TEXT_106);
						stringBuffer.append(widgetName);
						stringBuffer.append(TEXT_107);
						stringBuffer.append(className);
						stringBuffer.append(TEXT_108);
						stringBuffer.append(widgetParent);
						stringBuffer.append(TEXT_109);
						stringBuffer.append(widgetLabel);
						stringBuffer.append(TEXT_110);
						stringBuffer.append(TextValueWidgetSkipParent(uiField));
						stringBuffer.append(TEXT_111);
						break;

					case CHECKBOX:
					case RADIOBOX:
						stringBuffer.append(TEXT_112);
						stringBuffer.append(widgetName);
						stringBuffer.append(TEXT_113);
						stringBuffer.append(className);
						stringBuffer.append(TEXT_114);
						stringBuffer.append(widgetParent);
						stringBuffer.append(TEXT_115);
						break;

					case SIMPLE_CHOICE_LIST:
						stringBuffer.append(TEXT_116);
						stringBuffer.append(widgetName);
						stringBuffer.append(TEXT_117);
						stringBuffer.append(widgetParent);
						stringBuffer.append(TEXT_118);
						stringBuffer.append(widgetLabel);
						stringBuffer.append(TEXT_119);
						break;
					case MULTIPLE_CHOICE_LIST:
						stringBuffer.append(TEXT_120);
						stringBuffer.append(widgetName);
						stringBuffer.append(TEXT_121);
						stringBuffer.append(className);
						stringBuffer.append(TEXT_122);
						stringBuffer.append(widgetParent);
						stringBuffer.append(TEXT_123);
						stringBuffer.append(widgetLabel);
						stringBuffer.append(TEXT_124);
						stringBuffer.append(widgetName + "FieldController()");
						stringBuffer.append(TEXT_125);
						break;
					case RICHTEXT: {
						if (!generateRichTextCreateControl)
							generateRichTextCreateControl = true;
						stringBuffer.append(TEXT_126);
						stringBuffer.append(widgetName);
						stringBuffer.append(TEXT_127);
						stringBuffer.append(widgetParent);
						stringBuffer.append(TEXT_128);
						stringBuffer.append(widgetLabel);
						stringBuffer.append(TEXT_129);
					}
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
		stringBuffer.append(TEXT_130);
		widgetCreationGenerator wcg = new widgetCreationGenerator();
		wcg.generateWidgets(parameter);
		stringBuffer.append(TEXT_131);
		if (wcg.generateRichTextCreateControl) {
			stringBuffer.append(TEXT_132);
		}
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "genView", stringBuffer.toString());
	}

	protected void method_genController(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		class widgetPropertyGenerator {
			// Group UIFields generation recursive method 
			private void generateLoadData(UIContainer container) {
				stringBuffer.append(TEXT_133);
				for (UIField uiField : container.getUI_fields()) {
					String widgetName = epfUtility.getWidgetName(uiField);
					String widgetFieldAccessorName = epfUtility.getWidgetAccessor(uiField);
					switch (uiField.getType()) {
					case TEXT:
					case TEXTAREA:
					case MULTIPLE_CHOICE_LIST:
					case SIMPLE_CHOICE_LIST:
					case RADIOBOX:
						stringBuffer.append(TEXT_134);
						stringBuffer.append(widgetName);
						stringBuffer.append(TEXT_135);
						stringBuffer.append(widgetFieldAccessorName);
						stringBuffer.append(TEXT_136);
						break;
					case RICHTEXT:
						stringBuffer.append(TEXT_137);
						stringBuffer.append(widgetName);
						stringBuffer.append(TEXT_138);
						stringBuffer.append(widgetFieldAccessorName);
						stringBuffer.append(TEXT_139);
						break;
					case CHECKBOX:
						stringBuffer.append(TEXT_140);
						stringBuffer.append(widgetName);
						stringBuffer.append(TEXT_141);
						break;
					default:
						break;
					}
				}
				stringBuffer.append(TEXT_142);
				if (container.getSubContainers() != null && container.getSubContainers().size() > 0) {
					for (UIContainer iUIContainer : container.getSubContainers()) {
						generateLoadData(iUIContainer);
					}
				}
			}

			// Group UIFields generation recursive method 
			private void generateAddSematics(UIContainer container) {
				stringBuffer.append(TEXT_143);
				for (UIField uiField : container.getUI_fields()) {
					String widgetName = epfUtility.getWidgetName(uiField);
					if (!uiField.getType().equals(UI_Field_Type.RICHTEXT)) {
						stringBuffer.append(TEXT_144);
						stringBuffer.append(widgetName);
						stringBuffer.append(TEXT_145);
					}
				}
				stringBuffer.append(TEXT_146);
				if (container.getSubContainers() != null && container.getSubContainers().size() > 0) {
					for (UIContainer iUIContainer : container.getSubContainers()) {
						generateAddSematics(iUIContainer);
					}
				}
			}
		}
		stringBuffer.append(TEXT_147);
		widgetPropertyGenerator wpg = new widgetPropertyGenerator();
		stringBuffer.append(TEXT_148);
		wpg.generateLoadData(parameter);
		stringBuffer.append(TEXT_149);
		wpg.generateAddSematics(parameter);
		stringBuffer.append(TEXT_150);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "genController", stringBuffer.toString());
	}

	public boolean preCondition(PatternContext ctx) throws Exception {
		return parameter.eContainer() instanceof UI;
	}
}