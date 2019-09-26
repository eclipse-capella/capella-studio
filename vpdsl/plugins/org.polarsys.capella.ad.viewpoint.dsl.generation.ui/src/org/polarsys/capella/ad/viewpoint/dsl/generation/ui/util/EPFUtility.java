/*******************************************************************************
* Copyright (c) 2006, 2019 THALES GLOBAL SERVICES.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*    Thales - initial API and implementation
*******************************************************************************/
package org.polarsys.capella.ad.viewpoint.dsl.generation.ui.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpui.UIContainer;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpui.UIField;

/**
 * @author Boubekeur Zendagui
 */
public class EPFUtility {
	
	/******************************** CLASS AREA *************************************/
	
	private static final Map<UIContainer, EPFUtility> EPF_Utility_List = new HashMap<>();
	
	public static EPFUtility getEPFUtilityFor(UIContainer section){
		EPFUtility result = EPF_Utility_List.get(section);
		if (result == null){
			result = new EPFUtility();
			EPF_Utility_List.put(section, result);
		}
		return result;
	}
	
	public static void unloadResources(){
		EPF_Utility_List.clear();
	}
	
	/***************************** INSTANCE OBJECT AREA ********************************/
	// this list contains all widget
	protected List<DataWidget> generatedWidgetList = new ArrayList<>();
	protected List<UIContainer> generatedGroupList = new ArrayList<>();
	
	public void registerClassToImportInMainClass(UIField uiField, String classQualifiedName){
		DataWidget currentDataWidget = getDataOf(uiField);
		if (currentDataWidget != null &&
				! currentDataWidget.generatedClassesImports.contains(classQualifiedName)){
			currentDataWidget.generatedClassesImports.add(classQualifiedName);
		}
	}
	
	public List<DataWidget> getGeneratedWidgetList(){
		return generatedWidgetList;
	}
	
	public void generateDataforUIField(UIField uiField){
		generatedWidgetList.add(new DataWidget(uiField));
	}
	
	public List<String> getSemanticImportsFor(UIField uiField){
		DataWidget currentDataWidget = getDataOf(uiField);
		return currentDataWidget.widgetSemanticImports;
	}
	
	public String getWidgetName(UIField uiField){
		DataWidget currentDataWidget = getDataOf(uiField);
		return (currentDataWidget != null ? currentDataWidget.widgetName : null);
	}
	
	public String getWidgetLabel(UIField uiField){
		DataWidget currentDataWidget = getDataOf(uiField);
		return (currentDataWidget != null ? currentDataWidget.widgetLabel : null);
	}
	
	public String getWidgetAccessor(UIField uiField){
		DataWidget currentDataWidget = getDataOf(uiField);
		return (currentDataWidget != null ? currentDataWidget.widgetFieldAccessorName : null);
	}
	
	public String getWidgetClassName(UIField uiField){
		DataWidget currentDataWidget = getDataOf(uiField);
		return (currentDataWidget != null ? currentDataWidget.widgetGraphicalClassName : null);
	}
	
	public DataWidget getDataOf(UIField uiField){
		if (generatedWidgetList.isEmpty()) {
			return null;
		}
		
		for (DataWidget iWidgetData : generatedWidgetList) { 
			if (iWidgetData.uiField.equals(uiField)) {
				return iWidgetData;
			}
		}
		
		return null;
	}
}
