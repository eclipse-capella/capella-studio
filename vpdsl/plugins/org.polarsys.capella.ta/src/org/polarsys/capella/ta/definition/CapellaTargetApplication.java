/*******************************************************************************
* Copyright (c) 2006, 2019 THALES GLOBAL SERVICES.
* This program and the accompanying materials are made available under the
* terms of the Eclipse Public License 2.0 which is available at
* http://www.eclipse.org/legal/epl-2.0
*
* SPDX-License-Identifier: EPL-2.0
*
* Contributors:
*    Thales - initial API and implementation
*******************************************************************************/
package org.polarsys.capella.ta.definition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.egf.portfolio.genchain.extension.ExtensionHelper;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.polarsys.kitalpha.ad.ta.extension.ITargetApplication;
import org.polarsys.kitalpha.ad.ta.extension.TargetApplicationAdapter;
import org.polarsys.kitalpha.doc.gen.business.ecore.genchain.extension.KitalphaDocumentationExtension;

import org.polarsys.capella.extension.genchain.CapellaGenerationExtension;

/**
 * @author Faycal Abka, Boubekeur Zendagui
 */
public class CapellaTargetApplication extends TargetApplicationAdapter {
	
	public static final CapellaTargetApplication INSTANCE = new CapellaTargetApplication();
	
	private static final String CAPELLA_CORE_RESOURCE = "platform:/plugin/org.polarsys.capella.core.data.gen/model/CapellaCore.ecore";//$NON-NLS-0$
	
	private List<EClass> basicSemanticElement = null;

	public CapellaTargetApplication(){
		loadSemanticResource();
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.polarsys.kitalpha.ad.ta.extension.TargetApplicationAdapter#getInstance()
	 */
	@Override
	public ITargetApplication getInstance() {
		return INSTANCE;
	}

	/*
	 * (non-Javadoc)
	 * @see org.polarsys.kitalpha.ad.ta.extension.TargetApplicationAdapter#getBasicSemanticElement()
	 */
	@Override
	public List<EClass> getBasicSemanticElement() {
		if (basicSemanticElement != null && !basicSemanticElement.isEmpty()) {
			return basicSemanticElement;
		}
		
		return Collections.emptyList();
	}

	/*
	 * (non-Javadoc)
	 * @see org.polarsys.kitalpha.ad.ta.extension.TargetApplicationAdapter#getGenerationExtensionHelpers()
	 */
	@Override
	public List<ExtensionHelper> getGenerationExtensionHelpers() {
		List<ExtensionHelper> result = new ArrayList<ExtensionHelper>();
		result.add(new CapellaGenerationExtension());
		result.add(new KitalphaDocumentationExtension());
		return result;
	}
	
	/**
	 * Load semantic resource containing default semantic elements. These elements are used during generation 
	 * to add default inheritance for generated EClasses.
	 */
	private void loadSemanticResource(){
		ResourceSet set = new ResourceSetImpl();
		URI uri = URI.createURI(CAPELLA_CORE_RESOURCE);
		Resource capellaCoreResource = set.getResource(uri, true);
		
		if (capellaCoreResource != null && !capellaCoreResource.getContents().isEmpty())
		{
			List<EClass> result = new ArrayList<EClass>();
			EPackage capellaCorePkg = (EPackage) capellaCoreResource.getContents().get(0);
			result.add((EClass) capellaCorePkg.getEClassifier("NamedElement"));
			basicSemanticElement = result;
		}
		else
		{
			throw new IllegalStateException("Capella Target Applciation Core Resourse is not loaded");
		}
	}
}
