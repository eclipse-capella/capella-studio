//Generated with EGF 1.6.4.202309201142
package org.polarsys.capella.ad.viewpoint.dsl.generation.ui.common;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.common.java.JavaClassReporter;

public class AbstractLoopFinishedJavaClass
		extends org.polarsys.kitalpha.ad.viewpoint.dsl.generation.common.java.patterns.JavaAbstractPattern {
	protected static String nl;

	public static synchronized AbstractLoopFinishedJavaClass create(String lineSeparator) {
		nl = lineSeparator;
		AbstractLoopFinishedJavaClass result = new AbstractLoopFinishedJavaClass();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "";
	protected final String TEXT_2 = NL;

	public AbstractLoopFinishedJavaClass() {
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

		if (preCondition(ctx)) {
			ctx.setNode(new Node.Container(currentNode, getClass()));
			orchestration(ctx);
		}

		ctx.setNode(currentNode);
		if (ctx.useReporter()) {
			ctx.getReporter().executionFinished(OutputManager.computeExecutionOutput(ctx), ctx);
		}

		stringBuffer.append(TEXT_1);
		stringBuffer.append(TEXT_2);
		return stringBuffer.toString();
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;

		method_setSaveTime(new StringBuffer(), ictx);
		super.orchestration(new SuperOrchestrationContext(ictx));

		return null;
	}

	public Map<String, Object> getParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		return parameters;
	}

	protected void method_setSaveTime(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		savetime = JavaClassReporter.whenLoopFinished;
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setSaveTime", stringBuffer.toString());
	}
}