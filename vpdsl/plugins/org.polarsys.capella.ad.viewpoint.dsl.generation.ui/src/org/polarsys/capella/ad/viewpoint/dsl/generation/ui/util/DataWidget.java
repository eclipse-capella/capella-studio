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

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.codegen.ecore.genmodel.GenEnum;
import org.eclipse.emf.codegen.ecore.genmodel.GenEnumLiteral;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.polarsys.capella.ad.viewpoint.dsl.generation.ui.Activator;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.AbstractAttributeType;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.AbstractFeature;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.Attribute;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.Enumeration;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.ExternalAttributeType;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.LocalAttributeType;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpui.FieldMapping;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpui.UI;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpui.UIContainer;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpui.UIField;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpui.UI_Field_Type;

/**
 * @author Boubekeur Zendagui
 */
public class DataWidget{
	public UIField uiField;
	// the widget name
	public String widgetName;
	// the widget label
	public String widgetLabel;
	// The group Parent of the Widget
	public String widgetParentName;
	// get the widget class name
	public String widgetGraphicalClassName;
	// The informations of the attribute mapped to the UIField 
	public String widgetFieldAccessorName;
	public String widgetFieldGetter;
	public String widgetFieldContainerAccessorName;
	public String widgetFieldContainerLiteral;
	public WidgetEnumerator widgetFieldTypeEnumerator;
	//get the field type mapped to the graphical element. It is useful in the case of an EReference
	public String widgetFieldETypeName;
	public String widgetFieldETypeLiteral;
	// get the semantic element to import, get the class containing the attribute mapped to the widget
	public List<String> widgetSemanticImports;
	// get the graphical class used to create the widget
	public List<String> widgetGraphicalImports;
	// This property is used in the main generated class to import the other generated EClasses
	public List<String> generatedClassesImports;
	
	// This property is used in the main generated additional imports
	public List<String> additionalImports;
	
	// Each widget can have some extension to add to Plugin.xml. 
	// These extensions are created by Pattern during generation
	public List<PluginExtensionEntry> PluginExtensionEntries;
	
	public static class WidgetEnumerator{
		public String enumName;
		public String enumImportName;
		public List<String> enumLiterals;
		
		public WidgetEnumerator(String name, String importName, List<String> literals){
			this.enumName = name;
			this.enumImportName = importName;
			this.enumLiterals = literals;
		}
	}
	
	public DataWidget(UIField field){
		this.uiField = field;
		widgetName = computeWidgetName();
		widgetLabel = computeWidgetLabel();
		widgetGraphicalClassName = computeWidgetClassName();
		widgetFieldAccessorName = computeWidgetFieldAccessorName();
		widgetFieldGetter = computeWidgetFieldGetterName();
		widgetSemanticImports = computeSematicImports();
		widgetFieldETypeName = computeWidgetFieldETypeName();
		widgetFieldETypeLiteral = computeWidgetFieldETypeLiteral(); 
		widgetFieldContainerAccessorName = computeWidgetFieldContainerAccessorName();
		widgetFieldContainerLiteral = computeWidgetFieldContainerLiteral();
		widgetParentName = computeWidgetParentName();
		
		widgetFieldTypeEnumerator = initEnumerator();
		
		generatedClassesImports = new ArrayList<>();
		additionalImports = computeAdditionalImports();
		PluginExtensionEntries = new ArrayList<>();
	}
	
	private List<String> computeAdditionalImports() {
		ArrayList<String> result = new ArrayList<>();
		if (this.uiField.getType().equals(UI_Field_Type.RICHTEXT))
		{
			result.add("org.polarsys.kitalpha.richtext.common.intf.MDERichTextWidget");
			result.add("org.polarsys.kitalpha.richtext.widget.factory.MDERichTextFactory");
			result.add("org.polarsys.kitalpha.richtext.common.intf.SaveStrategy");
			result.add("org.polarsys.capella.core.ui.properties.helpers.NotificationHelper");
			result.add("org.polarsys.capella.common.ef.command.AbstractReadWriteCommand");
			result.add("org.polarsys.capella.common.ef.command.ICommand");
			result.add("java.util.Collection");
			result.add("java.util.Collections");
			result.add("org.polarsys.capella.common.helpers.TransactionHelper");
			result.add("org.eclipse.emf.ecore.EStructuralFeature");
			result.add("org.eclipse.swt.SWT");
			
			//TODO remove these imports when found a generic solution to save the descrition in model
			result.add("org.eclipse.ui.ISelectionListener");
			result.add("org.eclipse.ui.PlatformUI");
			result.add("org.polarsys.kitalpha.richtext.common.intf.BrowserBasedMDERichTextWidget");
			result.add("org.eclipse.swt.events.DisposeListener");
			result.add("org.eclipse.swt.events.DisposeEvent");
			//End of previous TODO - remove
		}
		
		return result;
	}

	private String computeWidgetParentName(){
		UIContainer uiContainer = (UIContainer)this.uiField.eContainer();
		if (uiContainer.eContainer() instanceof UI)
		{
			switch (this.uiField.getType()) {
				case SIMPLE_CHOICE_LIST:
				case MULTIPLE_CHOICE_LIST:
					return "getReferencesGroup()";
				case CHECKBOX:
					return "getCheckGroup()";
				default:
					return "rootParentComposite";
			}
		}
		else
		{
			return uiContainer.getName();
		}
	}
	
	public WidgetEnumerator initEnumerator(){
		final FieldMapping mapping = this.uiField.getMapping();
		final AbstractFeature mappedAttribute = mapping.getUI_Field_Mapped_To();
		if ( ! (mappedAttribute instanceof Attribute))
		{
			return null;
		}
		
		final Attribute attribute = (Attribute)mappedAttribute;
		final AbstractAttributeType attributeType = attribute.getOwned_type();
		String enumName ="";
		GenEnum genEnum = null;
		if (attributeType instanceof LocalAttributeType)
		{
			LocalAttributeType localAttributeType = (LocalAttributeType)attributeType;
			Enumeration type = localAttributeType.getType();
			enumName = type.getName();
			genEnum = GenmodelUtility.getInstance().getGenEnum(enumName);
		}
		else
		{
			final EDataType externalAttributeType = ((ExternalAttributeType) attributeType).getType();
			final String attributeTypeName = externalAttributeType.getName();
			// Check if the attribute type is well a generated or available enumeration
			if (!attributeTypeName.equals("EEnumerator")  
					&& !(externalAttributeType instanceof EEnum))
			{
				return null;
			}
			
			if (attributeTypeName.equals("EEnumerator")){
				// The case of a generate EEnum
				enumName = attribute.getName()+"_Type";
				genEnum = GenmodelUtility.getInstance().getGenEnum(enumName);

			}
			else
			{
				// The case of the use of an external EEnum
				enumName = attributeTypeName;
				String enumEPackageNSURI = externalAttributeType.getEPackage().getNsURI();
				URI genModelURI = EcorePlugin.getEPackageNsURIToGenModelLocationMap().get(enumEPackageNSURI);
				ResourceSet rs = new ResourceSetImpl();
				Resource r = rs.createResource(genModelURI);
				try {
					r.load(null);
				} catch (IOException e) {
					Activator.getDefault().getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "", e));
				}
				for (GenPackage genPackage : ((GenModel)r.getContents().get(0)).getGenPackages()) 
				{
					// check the GenPackage EEnum elements
					for (GenEnum iGenEnum : genPackage.getGenEnums()) 
					{
						if (iGenEnum.getName().equalsIgnoreCase(enumName) &&
								enumEPackageNSURI.equals(genPackage.getEcorePackage().getNsURI()))
						{
							genEnum = iGenEnum;
							break;
						}
					}

					if (genEnum != null)
					{
						break;
					}

					// FIXME: This code take only sub package of a package. It must take into account sub sub sub ... packages  
					// check the EEnum elements of each Nested GenPackage in the current <genPackage>
					for (GenPackage nestedGenPackage :genPackage.getNestedGenPackages())
					{
						for (GenEnum nestedGenEnum : nestedGenPackage.getGenEnums()) 
						{
							if (nestedGenEnum.getName().equalsIgnoreCase(enumName) )
							{
								genEnum = nestedGenEnum;
								break;
							}
						}
					}

					if (genEnum != null)
					{
						break;
					}
				}
			}
		}
		
		if (genEnum == null)
		{
			return null;
		}
		
		String genEnumName = genEnum.getClassifierAccessorName();
		String importName = genEnum.getQualifiedName();
		ArrayList<String> genEnumLiteralsList = new ArrayList<>();		
		for (GenEnumLiteral iGenEnumLiteral : genEnum.getGenEnumLiterals())
		{
			genEnumLiteralsList.add(iGenEnumLiteral.getEnumLiteralInstanceConstantName());
		}
		
		return new WidgetEnumerator(genEnumName, importName, genEnumLiteralsList);
	}
	
	public String computeWidgetFieldETypeEPackage(){
		String ePackageImport = "";
		try {
			ePackageImport = GenmodelUtility.getInstance().
											getFeatureETypeEPackageImport(
													this.uiField.getMapping().getUI_Field_Mapped_To());
		} catch (Exception e) {
			Activator.getDefault().getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "", e));
		}
		
		return ePackageImport;
	}
	
	private String computeWidgetFieldContainerAccessorName(){
		String containerAccessorName = "";
		try {
			containerAccessorName = GenmodelUtility.getInstance().
											getFeatureContainerAccessorName(
													this.uiField.getMapping().getUI_Field_Mapped_To());
		} catch (Exception e) {
			Activator.getDefault().getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "", e));
		}
		
		return containerAccessorName;
	}
	
	private String computeWidgetFieldContainerLiteral(){
		String containerLiteral = "";
		try {
			containerLiteral = GenmodelUtility.getInstance().
											getFeatureContainerLiteral(
													this.uiField.getMapping().getUI_Field_Mapped_To());
		} catch (Exception e) {
			Activator.getDefault().getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "", e));
		}
		
		return containerLiteral;
	}
	
	private String computeWidgetFieldETypeLiteral(){
		String eTypeName = "";
		try {
			eTypeName = GenmodelUtility.getInstance().
											getFeatureETypeLiteral(
													this.uiField.getMapping().getUI_Field_Mapped_To());
		} catch (Exception e) {
			Activator.getDefault().getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "", e));
		}
		
		return eTypeName;
	}
	
	private String computeWidgetFieldETypeName(){
		String eTypeName = "";
		try {
			eTypeName = GenmodelUtility.getInstance().
											getFeatureETypeName(
													this.uiField.getMapping().getUI_Field_Mapped_To());
		} catch (Exception e) {
			Activator.getDefault().getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "", e));
		}
		
		return eTypeName;
	}
	
	
	private String computeWidgetFieldGetterName(){
		String accessorName = "";
		try {
			accessorName = GenmodelUtility.getInstance().
									getFeatureShortAccessorName(
											this.uiField.getMapping().getUI_Field_Mapped_To());
		} catch (Exception e) {
			Activator.getDefault().getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "", e));
		}
		return "get"+accessorName+"()";
	}
	
	private String computeWidgetFieldAccessorName(){
		String accessorName = "";
		try {
			accessorName = GenmodelUtility.getInstance().
										getFeatureLongAccessorName(
												this.uiField.getMapping().getUI_Field_Mapped_To());
		} catch (Exception e) {
			Activator.getDefault().getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "", e));
		}
		return GenmodelUtility.getInstance().getPackageAccessorName()+".eINSTANCE.get"+accessorName+"()";
	}
	
	private List<String> computeSematicImports(){
		ArrayList<String> result = new ArrayList<>();
		String packageImport = GenmodelUtility.getInstance().getPackageImport();
		if (packageImport != null)
		{
			result.add(packageImport);
		}
		
		String sematicEClassImport = GenmodelUtility.getInstance().
											getSemanticEClassImport(
													this.uiField.getMapping().getUI_Field_Mapped_To());
		if (sematicEClassImport != null)
		{
			result.add(sematicEClassImport);
		}
		
		return result;
	}
	
	private String computeWidgetLabel(){
		String label = this.uiField.getLabel();
		return (label != null && label.trim().length() > 0 ? label : widgetName);
	}
	
	private String computeWidgetName(){
		String widgetNameTmp = this.uiField.getName();
		if (widgetNameTmp == null || widgetNameTmp.trim().length() == 0) {
			widgetNameTmp = this.uiField.getMapping().getUI_Field_Mapped_To()
									.getName() + "__" + this.uiField.getType().toString();
		}
		
		char first = Character.toUpperCase(widgetNameTmp.charAt(0));
		widgetNameTmp = first + widgetNameTmp.substring(1);
		
		return widgetNameTmp;
	}
	
	private String computeWidgetClassName(){
		switch (this.uiField.getType()) {
			case TEXT:
				return "TextValueGroup";
			case TEXTAREA:
				return "TextAreaValueGroup";
			case RICHTEXT:
				return "MDERichTextWidget";
			case CHECKBOX:
				String checkboxName = this.uiField.getName()+"_semanticCheckboxGroup";
				char checkboxFirst = Character.toUpperCase(checkboxName.charAt(0));
				checkboxName = checkboxFirst + checkboxName.substring(1);
				return checkboxName;
			case RADIOBOX:
				String radioboxName = this.uiField.getName()+"_semanticKindGroup";
				char radioboxFirst = Character.toUpperCase(radioboxName.charAt(0));
				radioboxName = radioboxFirst + radioboxName.substring(1);
				return radioboxName;
			case SIMPLE_CHOICE_LIST:
				return "SimpleSemanticField";
			case MULTIPLE_CHOICE_LIST:
				return "MultipleSemanticField";
		}
		return null;
	}
	
}
