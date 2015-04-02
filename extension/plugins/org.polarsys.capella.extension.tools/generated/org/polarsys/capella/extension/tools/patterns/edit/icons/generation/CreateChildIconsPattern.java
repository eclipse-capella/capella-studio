//Generated with EGF 1.2.0.v20150211-1405
package org.polarsys.capella.extension.tools.patterns.edit.icons.generation;

import org.eclipse.egf.emf.pattern.base.CodegenGeneratorAdapter;
import org.eclipse.emf.codegen.ecore.genmodel.*;
import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

public class CreateChildIconsPattern extends
		org.eclipse.egf.emf.pattern.edit.CreateChildIconsForGenClass {
	protected static String nl;

	public static synchronized CreateChildIconsPattern create(
			String lineSeparator) {
		nl = lineSeparator;
		CreateChildIconsPattern result = new CreateChildIconsPattern();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties()
			.getProperty("line.separator")) : nl;
	protected final String TEXT_1 = NL;
	protected final String TEXT_2 = NL;
	protected final String TEXT_3 = NL;

	public CreateChildIconsPattern() {
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

		stringBuffer.append(TEXT_2);
		stringBuffer.append(TEXT_3);
		return stringBuffer.toString();
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;

		super.orchestration(new SuperOrchestrationContext(ictx));

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

		GenClass genClass = parameter;
		GenModel genModel = genClass.getGenModel();
		if (genModel.isCreationCommands() && genModel.isCreationIcons()) {
			for (GenFeature feature : genClass
					.getAllCreateChildFeaturesIncludingDelegation()) {
				for (GenClass childClass : genClass.getChildrenClasses(feature)) {
					GenClass parentClass = feature.getGenClass();
					if (childClass.equals(parameter))
						new CodegenGeneratorAdapter(parameter)
								.generateGIF("edit/CreateChild.gif", genClass
										.getCreateChildIconFileName(feature,
												childClass),
										genClass.getName(), childClass
												.getName(), false);
				}
			}
		}

		stringBuffer.append(TEXT_1);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "doGenerate",
				stringBuffer.toString());
	}
}