//Generated with EGF 1.2.0.v20150211-1405
package org.polarsys.capella.extension.tools.patterns.model.generation;

import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.egf.common.helper.*;
import org.polarsys.capella.extension.tools.*;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class HelperExtension extends
		org.polarsys.kitalpha.emde.egf.model.ModelPluginXMLExtension {

	public HelperExtension() {
		//Here is the constructor
		// add initialisation of the pattern variables (declaration has been already done).
	}

	public void generate(Object argument) throws Exception {
		InternalPatternContext ctx = (InternalPatternContext) argument;
		IQuery.ParameterDescription paramDesc = null;
		Map<String, String> queryCtx = null;
		Node.Container currentNode = ctx.getNode();
		List<Object> rootList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> genModelList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)

		for (Object rootParameter : rootList) {
			for (Object genModelParameter : genModelList) {

				this.root = (org.w3c.dom.Element) rootParameter;
				this.genModel = (org.eclipse.emf.codegen.ecore.genmodel.GenModel) genModelParameter;

				if (preCondition(ctx)) {
					ctx.setNode(new Node.Container(currentNode, getClass()));
					orchestration((PatternContext) argument);

				}
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
		super.orchestration(new SuperOrchestrationContext(ictx));
		ictx.setNode(currentNode);
		if (ictx.useReporter()) {
			Map<String, Object> parameterValues = new HashMap<String, Object>();
			parameterValues.put("root", this.root);
			parameterValues.put("genModel", this.genModel);
			String outputWithCallBack = OutputManager.computeLoopOutput(ictx);
			String loop = OutputManager.computeLoopOutputWithoutCallback(ictx);
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx,
					parameterValues);
		}
		return null;
	}

	protected void method_run(final StringBuffer out, final PatternContext ctx)
			throws Exception {
		Document doc = root.getOwnerDocument();

		for (GenPackage genPackage : genModel
				.getAllGenPackagesWithClassifiers()) {
			root.appendChild(doc.createTextNode("\n"));
			root.appendChild(doc.createComment("@generated"));
			root.appendChild(doc.createTextNode("\n  "));
			Element extension = doc.createElement("extension");
			extension.setAttribute("point",
					"org.polarsys.capella.common.model.helpers.helper");
			extension.appendChild(doc.createTextNode("\n    "));
			Element helper = doc.createElement("helperImpl");
			helper.setAttribute("class",
					HelperClassGenerator.getHelperFullClassname(genPackage));
			helper.setAttribute("nsURI", genPackage.getEcorePackage()
					.getNsURI());
			extension.appendChild(helper);
			extension.appendChild(doc.createTextNode("\n  "));
			root.appendChild(extension);
			root.appendChild(doc.createTextNode("\n"));
		}

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "run", out.toString());
	}

	public boolean preCondition(PatternContext ctx) throws Exception {
		return CapellaMetamodelHelper.hasCapellaGenClasses(genModel);
	}

	public Map<String, Object> getParameters() {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("root", this.root);
		parameters.put("genModel", this.genModel);
		return parameters;
	}

}
