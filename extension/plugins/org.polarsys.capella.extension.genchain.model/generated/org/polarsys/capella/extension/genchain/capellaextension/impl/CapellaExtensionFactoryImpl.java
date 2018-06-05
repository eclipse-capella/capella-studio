/**
 * Copyright (c) 2015, 2018 Thales Global Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *   Thales Global Services S.A.S - initial API and implementation
 * 
 *
 * $Id$
 */

package org.polarsys.capella.extension.genchain.capellaextension.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.polarsys.capella.extension.genchain.capellaextension.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CapellaExtensionFactoryImpl extends EFactoryImpl implements CapellaExtensionFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CapellaExtensionFactory init() {
		try {
			CapellaExtensionFactory theCapellaExtensionFactory = (CapellaExtensionFactory)EPackage.Registry.INSTANCE.getEFactory(CapellaExtensionPackage.eNS_URI);
			if (theCapellaExtensionFactory != null) {
				return theCapellaExtensionFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new CapellaExtensionFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CapellaExtensionFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case CapellaExtensionPackage.CAPELLA_EMF_GENERATION: return createCapellaEmfGeneration();
			case CapellaExtensionPackage.CAPELLA_CDO_EMF_GENERATION: return createCapellaCdoEmfGeneration();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CapellaEmfGeneration createCapellaEmfGeneration() {
		CapellaEmfGenerationImpl capellaEmfGeneration = new CapellaEmfGenerationImpl();
		return capellaEmfGeneration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CapellaCdoEmfGeneration createCapellaCdoEmfGeneration() {
		CapellaCdoEmfGenerationImpl capellaCdoEmfGeneration = new CapellaCdoEmfGenerationImpl();
		return capellaCdoEmfGeneration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CapellaExtensionPackage getCapellaExtensionPackage() {
		return (CapellaExtensionPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static CapellaExtensionPackage getPackage() {
		return CapellaExtensionPackage.eINSTANCE;
	}

} //CapellaExtensionFactoryImpl
