/*******************************************************************************
 * Copyright (c) 2016, 2020 Thales Global Services S.A.S.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 *  
 * Contributors:
 *   Thales Global Services S.A.S - initial API and implementation
 *******************************************************************************/

package org.polarsys.capella.studio.test.viewpoint;

import static org.junit.Assert.*;

import org.junit.Test;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.diagram.expression.helper.sirius.ExpressionInterpreter;

public class SiriusExpressionInterpreter {

	@Test
	public void testFormatFeature() {
		String featureFormat = ExpressionInterpreter.Feature.format("name");
		assertEquals("feature:name", featureFormat);
	}
	
	@Test
	public void testFormatVar() {
		String featureFormat = ExpressionInterpreter.Variable.format("self");
		assertEquals("var:self", featureFormat);
	}
	
//	@Test
//	public void testFormatService() {
//		String featureFormat = ExpressionInterpreter.Service.format("getResult()");
//		assertEquals("service:getResult()", featureFormat);
//	}
	
	@Test
	public void testIsFormatedFeature() {
		boolean formated = ExpressionInterpreter.Feature.isFormated("Feature:name");
		assertEquals(true, formated);
		boolean notFormated = ExpressionInterpreter.Feature.isFormated("name");
		assertEquals(false, notFormated);
	}
	
//	@Test
//	public void testIsFormatedVariable() {
//		fail("Not yet implemented");
//	}
//	
//	@Test
//	public void testIsFormatedService() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testIsInterpreterExpression() {
//		fail("Not yet implemented");
//	}
}
