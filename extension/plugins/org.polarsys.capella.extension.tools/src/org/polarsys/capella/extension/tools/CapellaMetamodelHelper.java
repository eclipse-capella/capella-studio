/*******************************************************************************
 * Copyright (c) 2015, 2018 Thales Global Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *   Thales Global Services S.A.S - initial API and implementation
 *******************************************************************************/
package org.polarsys.capella.extension.tools;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.polarsys.capella.common.data.modellingcore.ModellingcorePackage;

/**
 * @author Thomas Guiu
 * 
 */

public class CapellaMetamodelHelper {

	public static boolean hasCapellaGenClasses(GenPackage genPackage) {
		for (GenClass genClass : genPackage.getGenClasses()) {
			if (isCapellaGenClass(genClass))
				return true;
		}
		return false;
	}

	public static boolean hasCapellaGenClasses(GenModel genModel) {
		for (GenPackage genPackage : genModel.getAllGenPackagesWithClassifiers()) {
			if (hasCapellaGenClasses(genPackage))
				return true;
		}

		return false;
	}

	public static boolean isCapellaGenClass(GenClass genClass) {
		EClass ecoreClass = genClass.getEcoreClass();
		EClass modelElement = ModellingcorePackage.eINSTANCE.getModelElement();
		return contains(ecoreClass.getEAllSuperTypes(), modelElement);
	}

	public static List<GenClass> getCapellaGenClasses(EList<GenClass> allGenClasses) {
		List<GenClass> result = new ArrayList<>(allGenClasses.size());
		for (GenClass gen : allGenClasses) {
			if (isCapellaGenClass(gen))
				result.add(gen);
		}
		return result;
	}

	private static boolean contains(List<EClass> classes, EClass source) {
		String name = source.getName();
		String nsURI = source.getEPackage().getNsURI();
		for (EClass cls : classes) {
			if (cls.getName().equals(name) && nsURI.equals(cls.getEPackage().getNsURI()))
				return true;
		}
		return false;
	}

	private CapellaMetamodelHelper() {
		super();
	}
	
}
