//Generated with EGF 1.2.0.v20150211-1405
package org.polarsys.capella.extension.genchain.patterns;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.egf.model.pattern.Node;
import org.eclipse.egf.model.domain.Domain;
import org.eclipse.egf.model.domain.DomainFactory;
import org.eclipse.egf.model.domain.EMFDomain;
import org.eclipse.egf.model.domain.DomainViewpoint;
import org.eclipse.egf.model.domain.TypeDomain;
import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.model.fcore.FactoryComponent;
import org.eclipse.egf.model.fcore.OrchestrationParameter;
import org.eclipse.egf.model.fprod.ProductionPlan;
import org.eclipse.egf.model.pattern.PatternContext;
import org.eclipse.egf.model.types.Type;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.IQuery;
import org.eclipse.egf.portfolio.genchain.generationChain.EmfGeneration;
import org.eclipse.egf.portfolio.genchain.generationChain.GenerationElement;
import org.eclipse.egf.portfolio.genchain.tools.FcoreBuilderConstants;
import org.eclipse.egf.portfolio.genchain.tools.utils.ActivityInvocationHelper;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;

public class CapellaGenerationPattern {

	public CapellaGenerationPattern() {
		//Here is the constructor
		// add initialisation of the pattern variables (declaration has been already done).
		this.modelActivity = "platform:/plugin/org.polarsys.capella.extension.tools/egf/capellaTools.fcore#_fRRLIB_3EeCuNfuGnuOPDw";
		this.editActivity = "platform:/plugin/org.polarsys.capella.extension.tools/egf/capellaTools.fcore#_WJu-4B_3EeCuNfuGnuOPDw";
		this.editorActivity = "platform:/plugin/org.polarsys.capella.extension.tools/egf/capellaTools.fcore#_eBZesB_3EeCuNfuGnuOPDw";
		this.testActivity = "platform:/plugin/org.polarsys.kitalpha.emde.portfolio.emf.egf/egf/emf.gen.tests.fcore#_79dGwDYdEeGWF-mrFIsVzA";
		this.javadocActivity = "platform:/plugin/org.polarsys.kitalpha.emde.portfolio.emf.egf/egf/javadoc.fcore#_CycMIDYfEeGWF-mrFIsVzA";
	}

	public void generate(Object argument) throws Exception {
		InternalPatternContext ctx = (InternalPatternContext) argument;
		IQuery.ParameterDescription paramDesc = null;
		Map<String, String> queryCtx = null;
		Node.Container currentNode = ctx.getNode();
		List<Object> parameterList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)

		for (Object parameterParameter : parameterList) {

			this.parameter = (org.polarsys.capella.extension.genchain.capellaextension.CapellaEmfGeneration) parameterParameter;

			if (preCondition(ctx)) {
				ctx.setNode(new Node.Container(currentNode, getClass()));
				orchestration((PatternContext) argument);

			}
		}
		if (ctx.useReporter()) {
			ctx.getReporter().executionFinished(
					OutputManager.computeExecutionOutput(ctx), ctx);
		}
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		Node.Container currentNode = ictx.getNode();
		method_body(new StringBuffer(), ictx);
		ictx.setNode(currentNode);
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

	protected void method_body(final StringBuffer out, final PatternContext ctx)
			throws Exception {
		Map<GenerationElement, FactoryComponent> fcs = (Map<GenerationElement, FactoryComponent>) ctx
				.getValue(FcoreBuilderConstants.CURRENT_FCORE);

		FactoryComponent fc = fcs.get((GenerationElement) (parameter
				.eContainer()));

		ProductionPlan pp = (ProductionPlan) fc.getOrchestration();
		DomainViewpoint dvp = (DomainViewpoint) fc.getViewpointContainer()
				.getViewpoint(DomainViewpoint.class);

		EMFDomain genModelDomain = null;
		URI uri = ((HashMap<String, URI>) ctx
				.getValue(FcoreBuilderConstants.GENMODEL_URIS)).get(parameter
				.getModelPath());
		genModelDomain = ActivityInvocationHelper.getDomain(dvp, uri);
		if (genModelDomain == null) {
			genModelDomain = DomainFactory.eINSTANCE.createEMFDomain();
			genModelDomain.setUri(uri);
			dvp.getDomains().add(genModelDomain);
		}

		Map<String, Type> contracts = new HashMap<String, Type>();
		Map<String, OrchestrationParameter> parameters = new HashMap<String, OrchestrationParameter>();

		for (OrchestrationParameter param : pp.getOrchestrationParameters()) {
			if (ActivityInvocationHelper.GENERATION_EXTENSION_PARAMETER_NAME
					.equals(param.getName())) {
				parameters.put("pattern.substitutions", param);
			}
		}

		ResourceSet resourceSet = fc.eResource().getResourceSet();
		if (parameter.isGenerateModel()) {
			TypeDomain typeDomain = DomainFactory.eINSTANCE.createTypeDomain();
			typeDomain.setDomain(genModelDomain);
			contracts.put("genModelURI", typeDomain);
			ActivityInvocationHelper.addInvocation(
					pp,
					(Activity) resourceSet.getEObject(
							URI.createURI(this.modelActivity, false), true),
					contracts, parameters);
		}
		if (parameter.isGenerateEdit()) {
			TypeDomain typeDomain = DomainFactory.eINSTANCE.createTypeDomain();
			typeDomain.setDomain(genModelDomain);
			contracts.put("genModelURI", typeDomain);
			ActivityInvocationHelper.addInvocation(
					pp,
					(Activity) resourceSet.getEObject(
							URI.createURI(this.editActivity, false), true),
					contracts, parameters);
		}
		if (parameter.isGenerateEditor()) {
			TypeDomain typeDomain = DomainFactory.eINSTANCE.createTypeDomain();
			typeDomain.setDomain(genModelDomain);
			contracts.put("genModelURI", typeDomain);
			ActivityInvocationHelper.addInvocation(
					pp,
					(Activity) resourceSet.getEObject(
							URI.createURI(this.editorActivity, false), true),
					contracts, parameters);
		}
		if (parameter.isGenerateTest()) {
			TypeDomain typeEMFDomain = DomainFactory.eINSTANCE
					.createTypeDomain();
			typeEMFDomain.setDomain(genModelDomain);
			contracts.put("genModelURI", typeEMFDomain);
			ActivityInvocationHelper.addInvocation(
					pp,
					(Activity) resourceSet.getEObject(
							URI.createURI(this.testActivity, false), true),
					contracts, parameters);
		}
		if (parameter.isGenerateJavadoc()) {
			TypeDomain typeEMFDomain = DomainFactory.eINSTANCE
					.createTypeDomain();
			typeEMFDomain.setDomain(genModelDomain);
			contracts.put("genModelURI", typeEMFDomain);
			ActivityInvocationHelper.addInvocation(
					pp,
					(Activity) resourceSet.getEObject(
							URI.createURI(this.javadocActivity, false), true),
					contracts, parameters);
		}

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "body", out.toString());
	}

	public boolean preCondition(PatternContext ctx) throws Exception {
		return true;
	}

	protected org.polarsys.capella.extension.genchain.capellaextension.CapellaEmfGeneration parameter;

	public void set_parameter(
			org.polarsys.capella.extension.genchain.capellaextension.CapellaEmfGeneration parameter) {
		this.parameter = parameter;
	}

	protected java.lang.String modelActivity;

	public void set_modelActivity(java.lang.String modelActivity) {
		this.modelActivity = modelActivity;
	}

	protected java.lang.String editActivity;

	public void set_editActivity(java.lang.String editActivity) {
		this.editActivity = editActivity;
	}

	protected java.lang.String editorActivity;

	public void set_editorActivity(java.lang.String editorActivity) {
		this.editorActivity = editorActivity;
	}

	protected java.lang.String testActivity;

	public void set_testActivity(java.lang.String testActivity) {
		this.testActivity = testActivity;
	}

	protected java.lang.String javadocActivity;

	public void set_javadocActivity(java.lang.String javadocActivity) {
		this.javadocActivity = javadocActivity;
	}

	public Map<String, Object> getParameters() {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("parameter", this.parameter);
		return parameters;
	}

}
