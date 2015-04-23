/*******************************************************************************
* Copyright (c) 2006, 2015 THALES GLOBAL SERVICES.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*    Thales - initial API and implementation
*******************************************************************************/
package org.polarsys.capella.ad.viewpoint.dsl.generation.ui.tasks;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.ftask.producer.context.ITaskProductionContext;
import org.eclipse.egf.ftask.producer.invocation.ITaskProduction;
import org.polarsys.capella.ad.viewpoint.dsl.generation.ui.constant.GeneratorContracts;
import org.polarsys.capella.ad.viewpoint.dsl.generation.ui.util.UIProjectManager;

/**
 * @author Boubekeur Zendagui
 */
public class RegisterUIProjectInManagerTask implements ITaskProduction {

	public void preExecute(ITaskProductionContext productionContext,
			IProgressMonitor monitor) throws InvocationException {
	}

	public void doExecute(ITaskProductionContext productionContext,
			IProgressMonitor monitor) throws InvocationException {
		String pname = productionContext.getInputValue(GeneratorContracts.Ui_Project_Name, String.class);
		try {
			UIProjectManager.INSTANCE.registerUIProject(pname);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void postExecute(ITaskProductionContext productionContext,
			IProgressMonitor monitor) throws InvocationException {
	}

}
