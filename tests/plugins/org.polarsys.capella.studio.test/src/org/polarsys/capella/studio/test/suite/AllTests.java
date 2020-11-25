/*******************************************************************************
 * Copyright (c) 2016 Thales Global Services S.A.S.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 *  
 * Contributors:
 *   Thales Global Services S.A.S - initial API and implementation
 *******************************************************************************/

package org.polarsys.capella.studio.test.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.polarsys.capella.studio.test.viewpoint.SiriusExpressionInterpreter;

@RunWith(Suite.class)
@SuiteClasses({
	SiriusExpressionInterpreter.class
})
public class AllTests {

}
