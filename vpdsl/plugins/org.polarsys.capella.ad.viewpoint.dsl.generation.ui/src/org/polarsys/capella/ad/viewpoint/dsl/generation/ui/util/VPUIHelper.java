/*******************************************************************************
* Copyright (c) 2006, 2017 THALES GLOBAL SERVICES.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*    Thales - initial API and implementation
*******************************************************************************/
package org.polarsys.capella.ad.viewpoint.dsl.generation.ui.util;

import org.eclipse.emf.common.util.EList;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.Aspect;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.Viewpoint;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpui.UI;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpui.UIContainer;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpui.UIDescription;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpui.UIField;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpui.UI_Field_Type;

/**
 * 
 * @author Faycal Abka
 *
 */
public class VPUIHelper {
	
	/**
	 * Look up of first field of the UI aspect typed with richtext in viewpoint
	 * @param vp viewpoint
	 * @return true if one field of the UI description is typed with richtext type
	 */
	public static boolean generateRichTextForUI(Viewpoint vp){
		UIDescription ui = getUIDescription(vp);
		if (ui != null){
			EList<UI> userIs = ui.getUIs();
			return generateRichTextForUI(userIs);
		}
		return false;
	}

	/**
	 * Look up of first field in the UIs
	 * @param userIntfs user interfaces
	 * @return true if one field of the UI description is typed with richtext type
	 */
	public static boolean generateRichTextForUI(EList<UI> userIntfs) {
		boolean result = false;
		for (UI ui : userIntfs) {
			EList<UIContainer> ui_Containers = ui.getUI_Containers();
			result = generateRichTextForUI_Containers(ui_Containers);
			if (result){
				break;
			}
		}
		return result;
	}

	/**
	 * Look up of first field in the UI containers typed with richtext
	 * @param ui_Containers containers
	 * @return true if one field of the UI description is typed with richtext type
	 */
	public static boolean generateRichTextForUI_Containers(EList<UIContainer> ui_Containers){
		boolean result = false;
		for (UIContainer uiContainer : ui_Containers) {
			result = generateRichTextForUI_Container(uiContainer);
			if (result){
				break;
			}
		}
		return result;
	}

	/**
	 * Look up of first field in the UI container typed with richtext
	 * @param uiContainer container
	 * @return true if one field of the UI Container is typed with richtext type
	 */
	public  static boolean generateRichTextForUI_Container(UIContainer uiContainer) {
		boolean result = false;
		EList<UIField> ui_fields = uiContainer.getUI_fields();
		result = generateRichTextForUI_Fields(ui_fields);
		if (!result){
			result = generateRichTextForUI_Containers(uiContainer.getSubContainers());
		}
		
		return result;
	}

	/**
	 * Look up of first field typed with richtext
	 * @param ui_fields fields
	 * @return true if one field of the UI Container is typed with richtext type
	 */
	public static boolean generateRichTextForUI_Fields(EList<UIField> ui_fields) {
		boolean result = false;
		for (UIField uiField : ui_fields) {
			result = generateRichTextForUI_Field(uiField);
			if (result){
				break;
			}
		}
		return result;
	}

	/**
	 * Check if the Field is typed with richtext type
	 * @param uiField field
	 * @return true if one field of the UI Container is typed with richtext type
	 */
	public static boolean generateRichTextForUI_Field(UIField uiField) {
		return uiField.getType().equals(UI_Field_Type.RICHTEXT);
	}

	private static UIDescription getUIDescription(Viewpoint vp) {
		EList<Aspect> vp_Aspects = vp.getVP_Aspects();
		for (Aspect aspect : vp_Aspects) {
			if (aspect instanceof UIDescription){
				return (UIDescription)aspect;
			}
		}
		return null;
	}
}
