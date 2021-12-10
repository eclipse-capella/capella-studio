//Generated with EGF 1.6.3.202110291409
package org.polarsys.capella.extension.tools.patterns.edit.generation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.egf.common.helper.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import org.polarsys.capella.extension.tools.MenuContributorClassGenerator;
import org.polarsys.capella.extension.tools.HelperClassGenerator;
import org.polarsys.capella.extension.tools.HelperClassGenerator.HelperInfo;

public class ItemContributionExtension extends org.polarsys.kitalpha.emde.egf.edit.EditPluginXMLExtension {

	public ItemContributionExtension() {
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
			ctx.getReporter().executionFinished(OutputManager.computeExecutionOutput(ctx), ctx);
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
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
		}
		return null;
	}

	protected void method_run(final StringBuffer out, final PatternContext ctx) throws Exception {
		Document doc = root.getOwnerDocument();

		root.appendChild(doc.createTextNode("\n"));
		root.appendChild(doc.createComment("@generated"));
		root.appendChild(doc.createTextNode("\n  "));
		Element extension = doc.createElement("extension");
		extension.setAttribute("point", "org.polarsys.capella.common.menu.dynamic.MDEMenuItemContribution");
		extension.appendChild(doc.createTextNode("\n"));
		root.appendChild(extension);
		root.appendChild(doc.createTextNode("\n"));

		TreeIterator<EObject> eAllContents = genModel.eAllContents();
		while (eAllContents.hasNext()) {
			EObject obj = eAllContents.next();
			if (obj instanceof GenClass && MenuContributorClassGenerator.isValidTarget((GenClass) obj)) {
				extension.appendChild(doc.createTextNode("    "));
				Element itemContribution = doc.createElement("MDEMenuItemContribution");
				itemContribution.setAttribute("class", MenuContributorClassGenerator.getFullClassname((GenClass) obj));
				itemContribution.setAttribute("id", MenuContributorClassGenerator.getFullClassname((GenClass) obj));
				extension.appendChild(itemContribution);
				extension.appendChild(doc.createTextNode("\n"));

			}
		}

		/*	
				root.appendChild(doc.createTextNode("\n"));
				root.appendChild(doc.createComment("@generated"));
				root.appendChild(doc.createTextNode("\n  "));
				extension = doc.createElement("extension");
				extension.setAttribute("point", "org.eclipse.ui.views.properties.tabbed.propertySections");
				extension.appendChild(doc.createTextNode("\n"));
				extension.appendChild(doc.createTextNode("    "));
				root.appendChild(extension);
				root.appendChild(doc.createTextNode("\n"));
		
				Element itemContribution = doc.createElement("propertySections");
				itemContribution.setAttribute("contributorId", "org.polarsys.capella.core.data.capellamodeller.properties");
				itemContribution.appendChild(doc.createTextNode("\n"));
				eAllContents = genModel.eAllContents();
				while (eAllContents.hasNext()) {
					EObject obj = eAllContents.next();
					if (obj instanceof GenClass) {
						GenClass genClass = (GenClass)obj;
						HelperInfo info = HelperClassGenerator.getInfo(genClass.getEcoreClass());
						if (info == null || info.getSectionClass() == null)
							continue ;
						Element subItemContribution = doc.createElement("propertySection");
						subItemContribution.setAttribute("class", info.getSectionClass());
						subItemContribution.setAttribute("id",    MenuContributorClassGenerator.getFullClassname(genClass) + ".section");
						subItemContribution.setAttribute("tab", "Base");
						itemContribution.appendChild(doc.createTextNode("        "));
						itemContribution.appendChild(subItemContribution);
						itemContribution.appendChild(doc.createTextNode("\n"));
						Element input = doc.createElement("input");
						GenPackage genPackage = genClass.getGenPackage();
						input.setAttribute("type", genPackage.getInterfacePackageName()+"."+genClass.getName());
						subItemContribution.appendChild(doc.createTextNode("\n"));
						subItemContribution.appendChild(doc.createTextNode("            "));
						subItemContribution.appendChild(input);
						subItemContribution.appendChild(doc.createTextNode("\n"));
						subItemContribution.appendChild(doc.createTextNode("        "));
					}
				}
				extension.appendChild(itemContribution);
				extension.appendChild(doc.createTextNode("\n"));
				extension.appendChild(doc.createTextNode("    "));
		*/

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "run", out.toString());
	}

	public Map<String, Object> getParameters() {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("root", this.root);
		parameters.put("genModel", this.genModel);
		return parameters;
	}

}
