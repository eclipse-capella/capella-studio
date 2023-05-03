/*********************************************************************
 * Copyright (c) 2015-2019 Thales Global Services S.A.S.
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *    Thales Global Services S.A.S. - initial API and implementation
 **********************************************************************/
package org.polarsys.capella.diffmerge.bridge.examples.apa2capella.queries;

import org.eclipse.emf.diffmerge.bridge.mapping.api.IQueryExecution;
import org.eclipse.emf.diffmerge.bridge.mapping.api.IQueryHolder;
import org.eclipse.emf.diffmerge.bridge.mapping.impl.Query;
import org.polarsys.capella.diffmerge.bridge.examples.apa.AScope;


/**
 * @author Amine Lajmi
 *
 */
public class AScopeQuery extends Query<AScope, AScope>{

	/**
	 * @param parent_p (non-null)
	 */
	public AScopeQuery(IQueryHolder<? extends AScope> parent_p) {
		super(parent_p);
	}

	/**
	 * @see org.eclipse.emf.diffmerge.bridge.mapping.api.IQuery#evaluate(java.lang.Object, org.eclipse.emf.diffmerge.bridge.mapping.api.IQueryExecution)
	 */
	public Iterable<AScope> evaluate(AScope input_p, IQueryExecution environment_p) {
		return newIterable(input_p);
	}
}