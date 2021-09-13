//Generated with EGF 1.6.2.202001031546
package org.polarsys.capella.cdoxml.ta.portfolio;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.egf.model.pattern.Node;
import org.eclipse.egf.model.pattern.PatternContext;
import org.eclipse.egf.pattern.execution.InternalPatternContext;
import org.eclipse.egf.pattern.execution.OutputManager;
import org.eclipse.egf.pattern.query.IQuery;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;

public class AddEAnnotations {

	public AddEAnnotations() {
		//Here is the constructor
		// add initialisation of the pattern variables (declaration has been already done).

	}

	public void generate(Object argument) throws Exception {
		InternalPatternContext ctx = (InternalPatternContext) argument;
		IQuery.ParameterDescription paramDesc = null;
		Map<String, String> queryCtx = null;
		Node.Container currentNode = ctx.getNode();
		List<Object> eClassList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)

		for (Object eClassParameter : eClassList) {

			this.eClass = (org.eclipse.emf.ecore.EClass) eClassParameter;

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
		method_body(new StringBuffer(), ictx);
		ictx.setNode(currentNode);
		if (ictx.useReporter()) {
			Map<String, Object> parameterValues = new HashMap<String, Object>();
			parameterValues.put("eClass", this.eClass);
			String outputWithCallBack = OutputManager.computeLoopOutput(ictx);
			String loop = OutputManager.computeLoopOutputWithoutCallback(ictx);
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
		}
		return null;
	}

	protected void method_body(final StringBuffer out, final PatternContext ctx) throws Exception {
		for (EReference eReference : eClass.getEAllReferences()) {
			EAnnotation eAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
			eAnnotation.setSource("http://com.thalesgroup.mde/simplifiedM2/Navigable");
			eReference.getEAnnotations().add(eAnnotation);
			eClass.eResource().save(java.util.Collections.EMPTY_MAP);
		}

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "body", out.toString());
	}

	public boolean preCondition(PatternContext ctx) throws Exception {
		return true;
	}

	protected org.eclipse.emf.ecore.EClass eClass;

	public void set_eClass(org.eclipse.emf.ecore.EClass eClass) {
		this.eClass = eClass;
	}

	public Map<String, Object> getParameters() {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("eClass", this.eClass);
		return parameters;
	}

}
