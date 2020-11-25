/*******************************************************************************
* Copyright (c) 2006, 2020 THALES GLOBAL SERVICES.
* This program and the accompanying materials are made available under the
* terms of the Eclipse Public License 2.0 which is available at
* http://www.eclipse.org/legal/epl-2.0
*
* SPDX-License-Identifier: EPL-2.0
*
* Contributors:
*    Thales - initial API and implementation
*******************************************************************************/
package org.polarsys.capella.ad.viewpoint.dsl.generation.ui.tasks;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.ftask.producer.context.ITaskProductionContext;
import org.eclipse.egf.ftask.producer.invocation.ITaskProduction;
import org.polarsys.capella.ad.viewpoint.dsl.generation.ui.Activator;
import org.polarsys.capella.ad.viewpoint.dsl.generation.ui.constant.GeneratorContracts;
import org.polarsys.capella.ad.viewpoint.dsl.generation.ui.util.UIProjectManager;

/**
 * @author Boubekeur Zendagui
 */
public class RegisterUIProjectInManagerTask implements ITaskProduction {

	public void preExecute(ITaskProductionContext productionContext,
			IProgressMonitor monitor) throws InvocationException {
		//nothing to do
	}

	public void doExecute(ITaskProductionContext productionContext,
			IProgressMonitor monitor) throws InvocationException {
		String pname = productionContext.getInputValue(GeneratorContracts.Ui_Project_Name, String.class);
		try {
			UIProjectManager.INSTANCE.registerUIProject(pname);
		} catch (Exception e) {
			Activator.getDefault().getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "", e));
		}
	}

	public void postExecute(ITaskProductionContext productionContext,
			IProgressMonitor monitor) throws InvocationException {
		//nothing to do
	}

}
