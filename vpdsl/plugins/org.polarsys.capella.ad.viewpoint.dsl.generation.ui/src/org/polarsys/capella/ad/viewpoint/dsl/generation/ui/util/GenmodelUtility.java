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

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenEnum;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.AbstractAssociation;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.AbstractFeature;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.Attribute;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.Class;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.NamedElement;

import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.provider.exception.ViewpointResourceException;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.provider.resourceimpl.ViewpointResourceProviderRegistry;

/**
 * @author Boubekeur Zendagui
 */
public class GenmodelUtility {

	private static GenmodelUtility INSTANCE = null;
	
	private GenPackage genPackage;
	private EPackage   generatedEPackage;
	
	
	public static GenmodelUtility getInstance(){
		if (INSTANCE == null){
			INSTANCE = new GenmodelUtility();
		}
		return INSTANCE;
	}
	
	public void load() throws ViewpointResourceException {
		generatedEPackage = ViewpointResourceProviderRegistry.getInstance().getEcoreProvider().getEPackage();
		genPackage = ViewpointResourceProviderRegistry.getInstance().getGenmodelProvider().getGenPackage();
	}
	
	public void load(EPackage ePackage, GenPackage genPackage) {
		generatedEPackage = ePackage;
		this.genPackage = genPackage;
	}
	
	public void unload(){
		genPackage = null;
		generatedEPackage = null;
	}
	
	public String getModelPluginID(){
		return genPackage.getGenModel().getModelPluginID();
	}
	
	public String getPackageAccessorName(){
		return genPackage.getPackageInterfaceName();
	}
	
	public String getPackageImport(){
		return genPackage.getQualifiedPackageInterfaceName();
	}
	
	public GenEnum getGenEnum(String name){
		for (GenEnum iGenEnum : genPackage.getGenEnums()) {
			if (iGenEnum.getName().equalsIgnoreCase(name)) {
				return iGenEnum;
			}
		}
		return null;
	}
	
	public String getSemanticEClassImport(NamedElement feature){
		if (! ((feature instanceof Attribute) || 
				  (feature instanceof AbstractAssociation))){
			return null;
		}
		
		Class clazz = (Class)feature.eContainer();
		
		return getSemanticEClassImport(clazz);
	}
	
	public String getSemanticEClassImport(Class clazz){
		// Get the generated EClass from the VPDesc clazz Class
		EClass eClass = getEquivalent(clazz);
		// Get the equivalent genClass from genModel
		GenClass genClass = getEquivalent(eClass);
		return genClass.getQualifiedInterfaceName();
	}
	
	public String getFeatureContainerAccessorName(AbstractFeature feature) {
		if (feature == null) {
			throw new IllegalStateException();
		}
		
		// Get the generated GenClass 
		GenClass genClass = getFeatureContainerGenClass(feature);
		return (genClass != null ? genClass.getClassifierAccessorName() : null);
	}
	
	public String getFeatureContainerLiteral(AbstractFeature feature) {
		if (feature == null) {
			throw new IllegalStateException();
		}
		
		// Get the generated GenClass 
		GenClass genClass = getFeatureContainerGenClass(feature);
		
		return (genClass != null ? genPackage.getPackageInterfaceName()
									+".Literals."
									+genPackage.getClassifierID(genClass)  
								 : null);
	}
	
	private GenClass getFeatureContainerGenClass(AbstractFeature feature) {
		if (feature == null) {
			throw new IllegalStateException();
		}
		
		Class clazz = (Class)feature.eContainer();
		// Get the generated EClass from the VPDesc clazz Class
		EClass eClass = getEquivalent(clazz);
		// Get the generated GenClass 
		return getEquivalent(eClass);
	}
	
	public String getFeatureShortAccessorName(AbstractFeature feature) {
		if (feature == null) {
			throw new IllegalStateException();
		}
		String featureName = feature.getName();
		Class clazz = (Class)feature.eContainer();
		// Get the generated EClass from the VPDesc clazz Class
		EClass eClass = getEquivalent(clazz);
		// Get the generated GenFeature 
		GenFeature genFeature = getEquivalent(eClass.getEStructuralFeature(featureName));
		return (genFeature != null ? genFeature.getAccessorName() : null);
	}
	
	public String getFeatureLongAccessorName(NamedElement feature) {
		if (! ((feature instanceof Attribute) || 
				  (feature instanceof AbstractAssociation))) {
			throw new IllegalStateException();
		}
		String featureName = feature.getName();
		Class clazz = (Class)feature.eContainer();
		// Get the generated EClass from the VPDesc clazz Class
		EClass eClass = getEquivalent(clazz);
		// Get the generated GenFeature 
		GenFeature genFeature = getEquivalent(eClass.getEStructuralFeature(featureName));
		return (genFeature != null ? genFeature.getFeatureAccessorName() : null);
	}
	
	public String getFeatureETypeName(NamedElement feature) {
		if (! (feature instanceof AbstractAssociation)){
			return null;
		}
		
		String featureName = feature.getName();
		Class clazz = (Class)feature.eContainer();
		// Get the generated EClass from the VPDesc clazz Class
		EClass eClass = getEquivalent(clazz);
		// Get the EStructuralFeature generated from feature
		EStructuralFeature eStructuralFeature = eClass.getEStructuralFeature(featureName);
		return (eStructuralFeature instanceof EReference? eStructuralFeature.getEType().getName() : null);
	}
	
	public String getFeatureETypeEPackageImport(NamedElement feature) {
		if (! (feature instanceof AbstractAssociation)){
			return null;
		}
		
		String featureName = feature.getName();
		Class clazz = (Class)feature.eContainer();
		// Get the generated EClass from the VPDesc clazz Class
		EClass eClass = getEquivalent(clazz);
		// Get the EType of the EReference
		EClass eType = (EClass)eClass.getEStructuralFeature(featureName).getEType();
		
		GenPackage eTypeGenPackage = null;
		
		String eTypePackageNsURI = eType.getEPackage().getNsURI();
		if (! eClass.getEPackage().getNsURI().equals(eTypePackageNsURI)){
			// We deal here with an external EClass (a target application EClass)
			// We search this eClass in the referenced GenPackages in the GenModel
			for (GenPackage iGenPackage : genPackage.getGenModel().getAllUsedGenPackagesWithClassifiers()) {
				if (iGenPackage.getEcorePackage().getNsURI().equals(eTypePackageNsURI)){
					eTypeGenPackage = iGenPackage;
					break;
				}
			}
		}else{
			eTypeGenPackage = genPackage;
		}
		
		return (eTypeGenPackage != null ? eTypeGenPackage.getInterfacePackageName()
											+"."
											+eTypeGenPackage.getPackageInterfaceName()
									  : null);
	}
	
	public String getFeatureETypeLiteral(NamedElement feature){
		if (! (feature instanceof AbstractAssociation)){
			return null;
		}
		
		String featureName = feature.getName();
		Class clazz = (Class)feature.eContainer();
		// Get the generated EClass from the VPDesc clazz Class
		EClass eClass = getEquivalent(clazz);
		// Get the EType of the EReference
		EClass eType = (EClass)eClass.getEStructuralFeature(featureName).getEType();
		
		GenClass eTypeGenClass = null;
		GenPackage eTypeGenPackage = null;
		
		String eTypePackageNsURI = eType.getEPackage().getNsURI();
		if (! eClass.getEPackage().getNsURI().equals(eTypePackageNsURI)){
			// We deal here with an external EClass (a target application EClass)
			// We search this eClass in the referenced GenPackages in the GenModel
			for (GenPackage iGenPackage : genPackage.getGenModel().getAllUsedGenPackagesWithClassifiers()) {
				if (iGenPackage.getEcorePackage().getNsURI().equals(eTypePackageNsURI)){
					for (GenClass genClass : iGenPackage.getGenClasses()) {
						EClass clazzz = genClass.getEcoreClass();
						if (clazzz.getName().equals(eType.getName())){
							eTypeGenClass = genClass;
							eTypeGenPackage = iGenPackage;
							break;
						}
					}
				}
			}
		}else{
			eTypeGenClass = getEquivalent(eType);
			eTypeGenPackage = genPackage;
		}
		
		return (eTypeGenClass != null ? eTypeGenPackage.getPackageInterfaceName()
										+".Literals."
										+eTypeGenPackage.getClassifierID(eTypeGenClass) 
									  : null);
	}
	
	public GenFeature getEquivalent(EStructuralFeature eStructuralFeature){
		GenClass genClass = getEquivalent(((EClass)eStructuralFeature.eContainer()));
		
		String eSFName = eStructuralFeature.getName();
		
		for (GenFeature genFeature : genClass.getGenFeatures()) {
			EStructuralFeature structuralFeature = genFeature.getEcoreFeature();
			if (structuralFeature.getName().equals(eSFName)) {
				return genFeature;
			}
		}
		return null;
	}
	
	public EClass getEquivalent(Class clazz){
		String className = clazz.getName();
		return (EClass)generatedEPackage.getEClassifier(className);
	}

	public GenClass getEquivalent(EClass eClass){
		String eClassPackageNsURI = eClass.getEPackage().getNsURI();
		String className = eClass.getName();
		for (GenClass genClass : genPackage.getGenClasses()) 
		{
			EClass clazz = genClass.getEcoreClass();
			if (clazz.getName().equals(className) && clazz.getEPackage().getNsURI().equals(eClassPackageNsURI)) {
				return genClass;
			}
		}
		return null;
	}
}
