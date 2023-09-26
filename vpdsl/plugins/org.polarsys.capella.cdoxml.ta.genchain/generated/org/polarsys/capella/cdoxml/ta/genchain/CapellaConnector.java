//Generated with EGF 1.6.4.202309201142
package org.polarsys.capella.cdoxml.ta.genchain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.egf.model.pattern.Node;
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
import org.eclipse.egf.portfolio.genchain.generationChain.GenerationElement;
import org.eclipse.egf.portfolio.genchain.tools.FcoreBuilderConstants;
import org.eclipse.egf.portfolio.genchain.tools.utils.ActivityInvocationHelper;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;

public class CapellaConnector {

	public CapellaConnector() {
		//Here is the constructor
		// add initialisation of the pattern variables (declaration has been already done).

	}

	public void generate(Object argument) throws Exception {
		InternalPatternContext ctx = (InternalPatternContext) argument;
		IQuery.ParameterDescription paramDesc = null;
		Map<String, String> queryCtx = null;
		Node.Container currentNode = ctx.getNode();
		List<Object> parameterList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)

		for (Object parameterParameter : parameterList) {

			this.parameter = (org.polarsys.capella.cdoxml.ta.genchain.connectorextension.ConnectorGeneration) parameterParameter;

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
			parameterValues.put("parameter", this.parameter);
			String outputWithCallBack = OutputManager.computeLoopOutput(ictx);
			String loop = OutputManager.computeLoopOutputWithoutCallback(ictx);
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
		}
		return null;
	}

	protected void method_body(final StringBuffer out, final PatternContext ctx) throws Exception {
		Map<GenerationElement, FactoryComponent> fcs = (Map<GenerationElement, FactoryComponent>) ctx
				.getValue(FcoreBuilderConstants.CURRENT_FCORE);
		FactoryComponent fc = fcs.get((GenerationElement) (parameter.eContainer()));

		ProductionPlan pp = (ProductionPlan) fc.getOrchestration();
		DomainViewpoint dvp = (DomainViewpoint) fc.getViewpointContainer().getViewpoint(DomainViewpoint.class);
		ResourceSet resourceSet = fc.eResource().getResourceSet();

		URI uri = URI.createPlatformResourceURI(parameter.getModelPath(), false);
		EMFDomain ecoreDomain = ActivityInvocationHelper.getDomain(dvp, uri);

		if (parameter.isAddConnectorEAnnotations()) {
			Map<String, Type> contracts1 = new HashMap<String, Type>();
			Map<String, OrchestrationParameter> parameters1 = new HashMap<String, OrchestrationParameter>();

			TypeDomain typeDomain1 = DomainFactory.eINSTANCE.createTypeDomain();
			typeDomain1.setDomain(ecoreDomain);
			contracts1.put("ecoreModel", typeDomain1);

			String activity1 = "platform:/plugin/org.polarsys.capella.cdoxml.ta.portfolio/egf/addEAnnotations.fcore#_3jrwsRIEEeKTuJ3Ft5PbJQ";
			ActivityInvocationHelper.addInvocation(pp,
					(Activity) resourceSet.getEObject(URI.createURI(activity1, false), true), contracts1, parameters1);
		}

		Map<String, Type> contracts2 = new HashMap<String, Type>();
		Map<String, OrchestrationParameter> parameters2 = new HashMap<String, OrchestrationParameter>();

		TypeDomain typeDomain2 = DomainFactory.eINSTANCE.createTypeDomain();
		typeDomain2.setDomain(ecoreDomain);
		contracts2.put("ecoreModel", typeDomain2);

		String activity2 = "platform:/plugin/org.polarsys.capella.cdoxml.ta.portfolio/egf/connectorAdditionalDescription.fcore#_n2ZGgBIGEeKTuJ3Ft5PbJQ";
		ActivityInvocationHelper.addInvocation(pp,
				(Activity) resourceSet.getEObject(URI.createURI(activity2, false), true), contracts2, parameters2);

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "body", out.toString());
	}

	public boolean preCondition(PatternContext ctx) throws Exception {
		return true;
	}

	protected org.polarsys.capella.cdoxml.ta.genchain.connectorextension.ConnectorGeneration parameter;

	public void set_parameter(
			org.polarsys.capella.cdoxml.ta.genchain.connectorextension.ConnectorGeneration parameter) {
		this.parameter = parameter;
	}

	public Map<String, Object> getParameters() {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("parameter", this.parameter);
		return parameters;
	}

}
