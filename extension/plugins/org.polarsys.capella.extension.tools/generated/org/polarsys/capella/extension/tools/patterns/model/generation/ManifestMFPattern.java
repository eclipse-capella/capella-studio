//Generated with EGF 1.6.4.202309201142
package org.polarsys.capella.extension.tools.patterns.model.generation;

import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.egf.common.helper.*;
import org.polarsys.capella.extension.tools.*;
import org.polarsys.capella.extension.tools.HelperClassGenerator.*;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;

public class ManifestMFPattern extends org.polarsys.kitalpha.emde.egf.model.ManifestMF {

	public ManifestMFPattern() {
		//Here is the constructor
		// add initialisation of the pattern variables (declaration has been already done).

	}

	public void generate(Object argument) throws Exception {
		InternalPatternContext ctx = (InternalPatternContext) argument;
		IQuery.ParameterDescription paramDesc = null;
		Map<String, String> queryCtx = null;
		Node.Container currentNode = ctx.getNode();
		List<Object> genModelList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)

		for (Object genModelParameter : genModelList) {

			this.genModel = (org.eclipse.emf.codegen.ecore.genmodel.GenModel) genModelParameter;

			if (preCondition(ctx)) {
				ctx.setNode(new Node.Container(currentNode, getClass()));
				orchestration((PatternContext) argument);

			}
		}
		if (ctx.useReporter()) {
			ctx.getReporter().executionFinished(OutputManager.computeExecutionOutput(ctx), ctx);
		}
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		Node.Container currentNode = ictx.getNode();
		method_addRequirements(new StringBuffer(), ictx);
		super.orchestration(new SuperOrchestrationContext(ictx));
		ictx.setNode(currentNode);
		if (ictx.useReporter()) {
			Map<String, Object> parameterValues = new HashMap<String, Object>();
			parameterValues.put("genModel", this.genModel);
			String outputWithCallBack = OutputManager.computeLoopOutput(ictx);
			String loop = OutputManager.computeLoopOutputWithoutCallback(ictx);
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
		}
		return null;
	}

	protected void method_addRequirements(final StringBuffer out, final PatternContext ctx) throws Exception {
		genModel.getModelPluginVariables().add("org.polarsys.capella.core.data.helpers");

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "addRequirements", out.toString());
	}

	public Map<String, Object> getParameters() {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("genModel", this.genModel);
		return parameters;
	}

}
