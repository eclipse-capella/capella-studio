//Generated with EGF 1.6.3.202110291409
package org.polarsys.capella.extension.tools.patterns.edit.generation;

import org.polarsys.capella.extension.tools.HelperClassGenerator.HelperInfo;
import org.polarsys.capella.extension.tools.HelperClassGenerator;
import org.eclipse.egf.emf.pattern.base.*;
import org.polarsys.capella.extension.tools.MenuContributorClassGenerator;
import org.eclipse.emf.codegen.ecore.genmodel.*;
import org.eclipse.emf.codegen.ecore.genmodel.impl.*;
import org.eclipse.emf.codegen.ecore.genmodel.generator.*;
import org.eclipse.emf.codegen.util.*;
import org.eclipse.emf.ecore.util.*;
import org.eclipse.emf.common.util.*;
import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

public class ItemContributionPattern extends org.eclipse.egf.emf.pattern.base.GenClassJava {
	protected static String nl;

	public static synchronized ItemContributionPattern create(String lineSeparator) {
		nl = lineSeparator;
		ItemContributionPattern result = new ItemContributionPattern();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = NL + "/**" + NL + " * <copyright>" + NL + " *" + NL
			+ " * Copyright (c) 2002-2007 IBM Corporation and others." + NL
			+ " * All rights reserved.   This program and the accompanying materials" + NL
			+ " * are made available under the terms of the Eclipse Public License v1.0" + NL
			+ " * which accompanies this distribution, and is available at" + NL
			+ " * http://www.eclipse.org/legal/epl-v10.html" + NL + " *" + NL + " * Contributors:" + NL
			+ " *   IBM - Initial API and implementation" + NL + " *" + NL + " * </copyright>" + NL + " */" + NL;
	protected final String TEXT_2 = NL;
	protected final String TEXT_3 = NL + "package ";
	protected final String TEXT_4 = ";" + NL + NL;
	protected final String TEXT_5 = NL + NL + "/**" + NL + " * This is the item provider adapter for a {@link ";
	protected final String TEXT_6 = "} object." + NL + " * <!-- begin-user-doc -->" + NL + " * <!-- end-user-doc -->"
			+ NL + " * @generated" + NL + " */" + NL + "public class ";
	protected final String TEXT_7 = " extends ";
	protected final String TEXT_8 = NL + "{" + NL + "  /**" + NL + "   * @generated" + NL + "   */" + NL + "  @Override"
			+ NL + "  public EClass getMetaclass() {" + NL + "    return ";
	protected final String TEXT_9 = ";" + NL + "  }" + NL + "}";

	public ItemContributionPattern() {
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
			ctx.getReporter().executionFinished(OutputManager.computeExecutionOutput(ctx), ctx);
		}

		stringBuffer.append(TEXT_2);
		stringBuffer.append(TEXT_2);
		return stringBuffer.toString();
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;

		super.orchestration(new SuperOrchestrationContext(ictx));

		method_preGenerate(new StringBuffer(), ictx);

		method_doGenerate(new StringBuffer(), ictx);
		{
			final Map<String, Object> parameters = getParameters();
			CallbackContext ctx_callback = new CallbackContext(ictx);
			CallHelper.callBack(ctx_callback, parameters);
		}

		method_postGenerate(new StringBuffer(), ictx);

		if (ictx.useReporter()) {
			Map<String, Object> parameterValues = new HashMap<String, Object>();
			parameterValues.put("parameter", this.parameter);
			String outputWithCallBack = OutputManager.computeLoopOutput(ictx);
			String loop = OutputManager.computeLoopOutputWithoutCallback(ictx);
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
		}
		return null;
	}

	protected java.lang.String menuContributorBaseClass = null;

	public void set_menuContributorBaseClass(java.lang.String object) {
		this.menuContributorBaseClass = object;
	}

	public Map<String, Object> getParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("parameter", this.parameter);
		return parameters;
	}

	protected void method_setReporterVariables(final StringBuffer stringBuffer, final PatternContext ctx)
			throws Exception {

		GenClass genClass = parameter;
		targetPath = genClass.getGenModel().getEditDirectory();
		packageName = MenuContributorClassGenerator.getPackagename(genClass);
		className = MenuContributorClassGenerator.getClassname(genClass);
		HelperInfo info = HelperClassGenerator.getInfo(genClass.getEcoreClass());
		menuContributorBaseClass = info == null ? "no_type" : info.getMenuContributorBaseClass();

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setReporterVariables", stringBuffer.toString());
	}

	protected void method_setArgument(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		GenClass genClass = parameter;
		argument = parameter;

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setArgument", stringBuffer.toString());
	}

	protected void method_ensureProjectExists(final StringBuffer stringBuffer, final PatternContext ctx)
			throws Exception {

		new CodegenGeneratorAdapter(parameter).ensureProjectExists(genModel.getEditDirectory(), genModel,
				GenBaseGeneratorAdapter.EDIT_PROJECT_TYPE, genModel.isUpdateClasspath(), new BasicMonitor());

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "ensureProjectExists", stringBuffer.toString());
	}

	protected void method_doGenerate(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_1);
		GenClass genClass = (GenClass) argument;
		GenPackage genPackage = genClass.getGenPackage();
		GenModel genModel = genPackage.getGenModel();
		stringBuffer.append(TEXT_2);
		{
			//<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern.base/egf/EMF_Pattern_Base.fcore#LogicalName=org.eclipse.egf.emf.pattern.base.HeaderJava" args="parameter:argument"%>

			InternalPatternContext ictx = (InternalPatternContext) ctx;
			new Node.DataLeaf(ictx.getNode(), getClass(), null, stringBuffer.toString());
			stringBuffer.setLength(0);

			final Map<String, Object> callParameters = new HashMap<String, Object>();
			callParameters.put("argument", parameter);
			CallHelper.executeWithParameterInjection(
					"platform:/plugin/org.eclipse.egf.emf.pattern.base/egf/EMF_Pattern_Base.fcore#_XHLrsCwtEd-jc5T-XaRJlg",
					new ExecutionContext((InternalPatternContext) ctx), callParameters);
			stringBuffer.setLength(0);
		}

		stringBuffer.append(TEXT_3);
		stringBuffer.append(packageName);
		stringBuffer.append(TEXT_4);
		genModel.addImport("org.eclipse.emf.ecore.EClass");
		genModel.addImport("org.eclipse.emf.common.notify.Notification");
		genModel.addImport("org.eclipse.emf.common.util.ResourceLocator");
		genModel.addImport("org.eclipse.emf.edit.provider.IEditingDomainItemProvider");
		genModel.addImport("org.eclipse.emf.edit.provider.IItemLabelProvider");
		genModel.addImport("org.eclipse.emf.edit.provider.IItemPropertySource");
		genModel.addImport("org.eclipse.emf.edit.provider.IStructuredItemContentProvider");
		genModel.addImport("org.eclipse.emf.edit.provider.ITreeItemContentProvider");
		String _List = genModel.getImportedName(
				genModel.useGenerics() ? "java.util.List<org.eclipse.emf.edit.provider.IItemPropertyDescriptor>"
						: "java.util.List");
		genModel.markImportLocation(stringBuffer);
		stringBuffer.append(TEXT_5);
		stringBuffer.append(className);
		stringBuffer.append(TEXT_6);
		stringBuffer.append(className);
		stringBuffer.append(TEXT_7);
		stringBuffer.append(menuContributorBaseClass);
		stringBuffer.append(TEXT_8);
		stringBuffer.append(genClass.getQualifiedClassifierAccessor());
		stringBuffer.append(TEXT_9);
		genModel.emitSortedImports();
		stringBuffer.append(TEXT_2);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "doGenerate", stringBuffer.toString());
	}

	public boolean preCondition(PatternContext ctx) throws Exception {
		GenClass genClass = parameter;
		genModel = parameter.getGenModel();
		boolean canGenerate = new CodegenGeneratorAdapter(parameter)
				.canGenerate("org.eclipse.emf.codegen.ecore.genmodel.generator.EditProject");
		canGenerate = canGenerate && MenuContributorClassGenerator.isValidTarget(parameter);
		return canGenerate;
	}
}