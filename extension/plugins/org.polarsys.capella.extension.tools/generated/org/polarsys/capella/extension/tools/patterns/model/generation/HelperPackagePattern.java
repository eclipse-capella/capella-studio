//Generated with EGF 1.6.4.202309201142
package org.polarsys.capella.extension.tools.patterns.model.generation;

import org.polarsys.capella.extension.tools.HelperClassGenerator.HelperInfo;
import org.eclipse.egf.common.helper.*;
import org.polarsys.capella.extension.tools.*;
import java.util.*;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.ecore.*;
import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

public class HelperPackagePattern extends org.eclipse.egf.emf.pattern.base.GenPackageJava {
	protected static String nl;

	public static synchronized HelperPackagePattern create(String lineSeparator) {
		nl = lineSeparator;
		HelperPackagePattern result = new HelperPackagePattern();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "/**" + NL + " * <copyright>" + NL + " *" + NL + " * </copyright>" + NL + " */" + NL
			+ "" + NL + "package ";
	protected final String TEXT_2 = ";" + NL + "" + NL + "import org.eclipse.emf.common.util.BasicEList;" + NL + "" + NL
			+ "import org.eclipse.emf.ecore.EAnnotation;" + NL + "import org.eclipse.emf.ecore.EObject;" + NL
			+ "import org.eclipse.emf.ecore.EStructuralFeature;" + NL + "" + NL
			+ "import org.polarsys.capella.common.model.helpers.IHelper;" + NL;
	protected final String TEXT_3 = NL + "\timport ";
	protected final String TEXT_4 = ".";
	protected final String TEXT_5 = ";";
	protected final String TEXT_6 = NL + "/**" + NL + " * @generated " + NL + " */" + NL + "public class ";
	protected final String TEXT_7 = " implements  IHelper {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL
			+ "\t */" + NL
			+ "\tpublic Object getValue(EObject object, EStructuralFeature feature, EAnnotation annotation) {" + NL
			+ "\t\tObject ret = null;" + NL + "\t\t" + NL;
	protected final String TEXT_8 = NL + "if (ret == null && object instanceof ";
	protected final String TEXT_9 = ")" + NL + "{" + NL + "\tret = ";
	protected final String TEXT_10 = ".getInstance().doSwitch((";
	protected final String TEXT_11 = ")object, feature);" + NL + "}";
	protected final String TEXT_12 = NL + "\t\t\treturn ret;" + NL + "\t}" + NL + "" + NL + "}" + NL;
	protected final String TEXT_13 = NL;

	public HelperPackagePattern() {
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

			this.parameter = (org.eclipse.emf.codegen.ecore.genmodel.GenPackage) parameterParameter;

			if (preCondition(ctx)) {
				ctx.setNode(new Node.Container(currentNode, getClass()));
				orchestration(ctx);
			}

		}
		ctx.setNode(currentNode);
		if (ctx.useReporter()) {
			ctx.getReporter().executionFinished(OutputManager.computeExecutionOutput(ctx), ctx);
		}

		stringBuffer.append(TEXT_13);
		stringBuffer.append(TEXT_13);
		return stringBuffer.toString();
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;

		super.orchestration(new SuperOrchestrationContext(ictx));

		method_doGenerate(new StringBuffer(), ictx);

		if (ictx.useReporter()) {
			Map<String, Object> parameterValues = new HashMap<String, Object>();
			parameterValues.put("parameter", this.parameter);
			String outputWithCallBack = OutputManager.computeLoopOutput(ictx);
			String loop = OutputManager.computeLoopOutputWithoutCallback(ictx);
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
		}
		return null;
	}

	public Map<String, Object> getParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("parameter", this.parameter);
		return parameters;
	}

	protected void method_setReporterVariables(final StringBuffer stringBuffer, final PatternContext ctx)
			throws Exception {

		GenPackage genPackage = parameter;
		targetPath = genPackage.getGenModel().getModelDirectory();
		packageName = HelperClassGenerator.getHelperPackagename(genPackage);
		className = HelperClassGenerator.getHelperClassname(genPackage);
		//className = genPackage.getPrefix()+"Helper"; 

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setReporterVariables", stringBuffer.toString());
	}

	protected void method_doGenerate(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_1);
		stringBuffer.append(packageName);
		stringBuffer.append(TEXT_2);

		for (GenClass feature : CapellaMetamodelHelper.getCapellaGenClasses(parameter.getGenClasses())) {

			stringBuffer.append(TEXT_3);
			stringBuffer.append(parameter.getInterfacePackageName());
			stringBuffer.append(TEXT_4);
			stringBuffer.append(feature.getInterfaceName());
			stringBuffer.append(TEXT_5);

		}

		stringBuffer.append(TEXT_6);
		stringBuffer.append(className);
		stringBuffer.append(TEXT_7);

		for (GenClass feature : CapellaMetamodelHelper.getCapellaGenClasses(parameter.getGenClasses())) {

			stringBuffer.append(TEXT_8);
			stringBuffer.append(feature.getInterfaceName());
			stringBuffer.append(TEXT_9);
			stringBuffer.append(HelperClassGenerator.getHelperClassname(feature));
			stringBuffer.append(TEXT_10);
			stringBuffer.append(feature.getInterfaceName());
			stringBuffer.append(TEXT_11);

		}

		stringBuffer.append(TEXT_12);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "doGenerate", stringBuffer.toString());
	}

	public boolean preCondition(PatternContext ctx) throws Exception {
		return CapellaMetamodelHelper.hasCapellaGenClasses(parameter);
	}
}