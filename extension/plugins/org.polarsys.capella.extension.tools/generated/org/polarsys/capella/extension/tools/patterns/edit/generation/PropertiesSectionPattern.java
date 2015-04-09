//Generated with EGF 1.2.0.v20150211-1405
package org.polarsys.capella.extension.tools.patterns.edit.generation;

import org.eclipse.emf.codegen.ecore.genmodel.*;
import org.eclipse.egf.emf.pattern.base.*;
import org.polarsys.capella.extension.tools.*;
import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

public class PropertiesSectionPattern extends
		org.eclipse.egf.emf.pattern.base.GenClassJava {
	protected static String nl;

	public static synchronized PropertiesSectionPattern create(
			String lineSeparator) {
		nl = lineSeparator;
		PropertiesSectionPattern result = new PropertiesSectionPattern();
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
			+ "import org.eclipse.emf.ecore.EObject;"
			+ NL
			+ "import org.polarsys.capella.core.data.core.properties.sections.NamedElementSection;"
			+ NL
			+ "import org.polarsys.capella.core.model.handler.helpers.CapellaAdapterHelper;"
			+ NL + "import ";
	protected final String TEXT_3 = ";" + NL + "" + NL + "/**" + NL
			+ " * This is the item provider adapter for a {@link ";
	protected final String TEXT_4 = "} object." + NL
			+ " * <!-- begin-user-doc -->" + NL + " * <!-- end-user-doc -->"
			+ NL + " * @generated" + NL + " */" + NL + "public class ";
	protected final String TEXT_5 = " extends NamedElementSection"
			+ NL
			+ "{"
			+ NL
			+ "\t/**"
			+ NL
			+ "\t * @generated"
			+ NL
			+ "\t */"
			+ NL
			+ "\t@Override"
			+ NL
			+ "\tpublic boolean select(Object toTest) {"
			+ NL
			+ "\t\tEObject obj = CapellaAdapterHelper.resolveSemanticObject(toTest);"
			+ NL + "\t\t" + NL + "\t\treturn ";
	protected final String TEXT_6 = ";" + NL + "\t}" + NL + "}" + NL + NL;
	protected final String TEXT_7 = NL;
	protected final String TEXT_8 = NL;

	public PropertiesSectionPattern() {
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

		stringBuffer.append(TEXT_7);
		stringBuffer.append(TEXT_8);
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
		stringBuffer.append(SectionClassGenerator.getFullClassname(parameter));
		stringBuffer.append(TEXT_3);
		stringBuffer.append(className);
		stringBuffer.append(TEXT_4);
		stringBuffer.append(className);
		stringBuffer.append(TEXT_5);
		stringBuffer.append(SectionClassGenerator.getFilterTest(parameter));
		stringBuffer.append(TEXT_6);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "doGenerate",
				stringBuffer.toString());
	}

	protected void method_setReporterVariables(final StringBuffer stringBuffer,
			final PatternContext ctx) throws Exception {

		GenClass genClass = parameter;
		targetPath = genClass.getGenModel().getEditDirectory();
		packageName = SectionClassGenerator.getPackagename(genClass);
		className = SectionClassGenerator.getClassname(genClass);

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setReporterVariables",
				stringBuffer.toString());
	}

	public boolean preCondition(PatternContext ctx) throws Exception {
		GenClass genClass = parameter;
		genModel = parameter.getGenModel();
		boolean canGenerate = new CodegenGeneratorAdapter(parameter)
				.canGenerate("org.eclipse.emf.codegen.ecore.genmodel.generator.EditProject");
		return canGenerate;
	}
}