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
package org.polarsys.capella.ad.viewpoint.dsl.generation.ui.util;

import java.util.List;

import org.eclipse.emf.common.util.BasicEList;

import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.AbstractFeature;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.Class;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpui.FieldMapping;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpui.UIContainer;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpui.UIField;

/**
 * @author Boubekeur Zendagui
 */
public final class UISectionUtility {
	
	public static boolean canGenerateSelectionForContainer(UIContainer container){
		boolean isSingleClassSection = getAssociatedClasses(container).size() == 1;
		boolean isSectionAssociatedToExtension = isSectionAssociatedToExtension(container); 

		return isSingleClassSection && isSectionAssociatedToExtension;
	}
	
	public static boolean isSectionAssociatedToExtension(UIContainer container){
		List<Class> classes = getAssociatedClasses(container);

		if (classes != null && classes.size() == 1)
		{
			Class clazz = classes.get(0);
			return clazz.getExtends() != null && !clazz.getExtends().isEmpty();
		}
		
		return false;
	}
	
	private static List<Class> getAssociatedClasses(UIContainer container){
		List<Class> result = new BasicEList<>();
		
		/**
		 * Get Associated Classes with UI Fields
		 */
		for (UIField iUIField : container.getUI_fields()) 
		{
			FieldMapping mapping = iUIField.getMapping();
			if (mapping != null)
			{
				AbstractFeature feature = mapping.getUI_Field_Mapped_To();
				
				Class clazz = (feature != null && feature.eContainer() != null ? 
													(Class)feature.eContainer() : null);
				
				if (clazz != null && ! result.contains(clazz)) {
					result.add(clazz);
				}
			}
		}
		
		/**
		 * Check UI Fields for of the sub containers of the a given container 
		 */
		for (UIContainer subContainer : container.getSubContainers())
		{
			List<Class> classes = getAssociatedClasses(subContainer);
			for (Class clazz : classes) 
			{
				if (! result.contains(clazz))
                                {
					result.add(clazz);
                                }
			}
		}
		
		return result;
	}

	private UISectionUtility() {
		super();
	}
	
}
