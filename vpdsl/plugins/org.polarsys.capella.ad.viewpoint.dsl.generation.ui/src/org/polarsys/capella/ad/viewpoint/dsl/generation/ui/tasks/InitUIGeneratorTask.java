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
import org.eclipse.egf.model.domain.EMFDomain;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EPackage;
import org.polarsys.capella.ad.viewpoint.dsl.generation.ui.constant.GeneratorContracts;
import org.polarsys.capella.ad.viewpoint.dsl.generation.ui.util.GenmodelUtility;
import org.polarsys.capella.ad.viewpoint.dsl.generation.ui.util.UIProjectManager;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.provider.exception.ViewpointResourceException;

/**
 * @author Boubekeur Zendagui
 */
public class InitUIGeneratorTask implements ITaskProduction {

	public void preExecute(ITaskProductionContext productionContext,
			IProgressMonitor monitor) throws InvocationException {
	}

	public void doExecute(ITaskProductionContext productionContext,
			IProgressMonitor monitor) throws InvocationException {
		
		EMFDomain genmodel_domain = productionContext.getInputValue(GeneratorContracts.Generated_Genmodel, EMFDomain.class);
		EMFDomain ecore_domain = productionContext.getInputValue(GeneratorContracts.Generated_Ecore, EMFDomain.class);
		
		if (genmodel_domain != null && ecore_domain != null)
		{
			GenPackage genPackage = null;
			EList<Object> genmodel_c = genmodel_domain.getContent();
			if (genmodel_c != null && genmodel_c.size() > 0)
			{
				GenModel genModel = (GenModel) genmodel_c.get(0);
				genPackage = genModel.getGenPackages().get(0);
			}

			EPackage ePackage = null;
			EList<Object> ecore_c = ecore_domain.getContent();
			if (ecore_c != null && ecore_c.size() > 0)
				ePackage = (EPackage) ecore_c.get(0);

			GenmodelUtility.getInstance().load(ePackage, genPackage);
		} 
		else
		{
			try {
				GenmodelUtility.getInstance().load();
			} catch (ViewpointResourceException e) {
				e.printStackTrace();
			}
		}
		
		UIProjectManager.INSTANCE.init();
	}

	public void postExecute(ITaskProductionContext productionContext,
			IProgressMonitor monitor) throws InvocationException {
	}

}
