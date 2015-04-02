//Generated with EGF 1.2.0.v20150211-1405
package org.polarsys.capella.extension.tools.patterns.model.generation;

import org.eclipse.egf.common.helper.*;
import org.polarsys.capella.extension.tools.*;
import java.util.*;
import org.eclipse.emf.codegen.ecore.genmodel.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

public class HelperClassPattern extends
		org.eclipse.egf.emf.pattern.base.GenClassJava {
	protected static String nl;

	public static synchronized HelperClassPattern create(String lineSeparator) {
		nl = lineSeparator;
		HelperClassPattern result = new HelperClassPattern();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties()
			.getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "package ";
	protected final String TEXT_2 = ";"
			+ NL
			+ ""
			+ NL
			+ "import org.eclipse.emf.ecore.EStructuralFeature;"
			+ NL
			+ "import org.polarsys.capella.common.model.helpers.HelperNotFoundException;"
			+ NL + "import ";
	protected final String TEXT_3 = ".";
	protected final String TEXT_4 = ";" + NL + "" + NL + "/**" + NL
			+ " * @generated" + NL + " */ " + NL + "public class ";
	protected final String TEXT_5 = " {" + NL + "" + NL
			+ "private static final ";
	protected final String TEXT_6 = " instance = new ";
	protected final String TEXT_7 = "();" + NL + "" + NL + "/**" + NL
			+ " * @generated" + NL + " */ " + NL + "public static ";
	protected final String TEXT_8 = " getInstance()" + NL + "{" + NL
			+ "\treturn instance;" + NL + "}" + NL + "" + NL + "/**" + NL
			+ " * @generated" + NL + " */ " + NL + "public Object doSwitch(";
	protected final String TEXT_9 = " object, EStructuralFeature feature) "
			+ NL + "{" + NL + "\t// handle derivated feature" + NL + "\t" + NL
			+ "\t" + NL + "\t";
	protected final String TEXT_10 = NL + "\t\treturn null;" + NL + "\t";
	protected final String TEXT_11 = NL + "\t\t";
	protected final String TEXT_12 = NL
			+ "\t\t// Unfortunately the generator was unable to find appropriate helper class"
			+ NL + "\t\tthrow new HelperNotFoundException();" + NL + "\t\t";
	protected final String TEXT_13 = NL + "\t\t// delegate to parent helper"
			+ NL + "\t\treturn ";
	protected final String TEXT_14 = ".getInstance().doSwitch(object, feature);"
			+ NL + "\t\t";
	protected final String TEXT_15 = NL + "\t";
	protected final String TEXT_16 = NL + "}" + NL + "" + NL + "" + NL + ""
			+ NL + "}";
	protected final String TEXT_17 = NL;
	protected final String TEXT_18 = NL;

	public HelperClassPattern() {
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

			this.parameter = (org.eclipse.emf.codegen.ecore.genmodel.GenClass) parameterParameter;

			if (preCondition(ctx)) {
				ctx.setNode(new Node.Container(currentNode, getClass()));
				orchestration(ctx);
			}

		}
		ctx.setNode(currentNode);
		if (ctx.useReporter()) {
			ctx.getReporter().executionFinished(
					OutputManager.computeExecutionOutput(ctx), ctx);
		}

		stringBuffer.append(TEXT_17);
		stringBuffer.append(TEXT_18);
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
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx,
					parameterValues);
		}
		return null;
	}

	public Map<String, Object> getParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("parameter", this.parameter);
		return parameters;
	}

	protected void method_doGenerate(final StringBuffer stringBuffer,
			final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_1);
		stringBuffer.append(packageName);
		stringBuffer.append(TEXT_2);
		stringBuffer
				.append(parameter.getGenPackage().getInterfacePackageName());
		stringBuffer.append(TEXT_3);
		stringBuffer.append(parameter.getInterfaceName());
		stringBuffer.append(TEXT_4);
		stringBuffer.append(className);
		stringBuffer.append(TEXT_5);
		stringBuffer.append(className);
		stringBuffer.append(TEXT_6);
		stringBuffer.append(className);
		stringBuffer.append(TEXT_7);
		stringBuffer.append(className);
		stringBuffer.append(TEXT_8);
		stringBuffer.append(parameter.getInterfaceName());
		stringBuffer.append(TEXT_9);
		if (HelperClassGenerator.getInfo(parameter.getEcoreClass()) == null) {
			stringBuffer.append(TEXT_10);
		} else {
			stringBuffer.append(TEXT_11);
			if (HelperClassGenerator.getInfo(parameter.getEcoreClass())
					.getHelperClass() == null) {
				stringBuffer.append(TEXT_12);
			} else {
				stringBuffer.append(TEXT_13);
				stringBuffer.append(HelperClassGenerator.getInfo(
						parameter.getEcoreClass()).getHelperClass());
				stringBuffer.append(TEXT_14);
			}
			stringBuffer.append(TEXT_15);
		}
		stringBuffer.append(TEXT_16);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "doGenerate",
				stringBuffer.toString());
	}

	protected void method_setReporterVariables(final StringBuffer stringBuffer,
			final PatternContext ctx) throws Exception {

		GenClass genClass = parameter;
		targetPath = genClass.getGenModel().getModelDirectory();
		packageName = HelperClassGenerator.getHelperPackagename(genClass
				.getGenPackage());
		className = HelperClassGenerator.getHelperClassname(genClass);

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setReporterVariables",
				stringBuffer.toString());
	}

	public boolean preCondition(PatternContext ctx) throws Exception {
		return CapellaMetamodelHelper.isCapellaGenClass(parameter);
	}
}