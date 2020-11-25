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
public final class VPUIHelper {
	
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
			EList<UIContainer> uiContainers = ui.getUI_Containers();
			result = generateRichTextForUI_Containers(uiContainers);
			if (result){
				break;
			}
		}
		return result;
	}

	/**
	 * Look up of first field in the UI containers typed with richtext
	 * @param uiContainers containers
	 * @return true if one field of the UI description is typed with richtext type
	 */
	public static boolean generateRichTextForUI_Containers(EList<UIContainer> uiContainers){
		boolean result = false;
		for (UIContainer uiContainer : uiContainers) {
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
		EList<UIField> uiFields = uiContainer.getUI_fields();
		result = generateRichTextForUI_Fields(uiFields);
		if (!result){
			result = generateRichTextForUI_Containers(uiContainer.getSubContainers());
		}
		
		return result;
	}

	/**
	 * Look up of first field typed with richtext
	 * @param uiFields fields
	 * @return true if one field of the UI Container is typed with richtext type
	 */
	public static boolean generateRichTextForUI_Fields(EList<UIField> uiFields) {
		boolean result = false;
		for (UIField uiField : uiFields) {
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
		EList<Aspect> vpAspects = vp.getVP_Aspects();
		for (Aspect aspect : vpAspects) {
			if (aspect instanceof UIDescription){
				return (UIDescription)aspect;
			}
		}
		return null;
	}

	private VPUIHelper() {
		super();
	}
}
