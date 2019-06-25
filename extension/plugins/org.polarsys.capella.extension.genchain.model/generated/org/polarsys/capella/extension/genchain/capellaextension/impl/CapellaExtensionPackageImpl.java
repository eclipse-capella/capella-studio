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

import org.eclipse.egf.portfolio.genchain.cdo.cdoExtension.CdoExtensionPackage;
import org.eclipse.egf.portfolio.genchain.generationChain.GenerationChainPackage;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.polarsys.capella.extension.genchain.capellaextension.CapellaCdoEmfGeneration;
import org.polarsys.capella.extension.genchain.capellaextension.CapellaEmfGeneration;
import org.polarsys.capella.extension.genchain.capellaextension.CapellaExtensionFactory;
import org.polarsys.capella.extension.genchain.capellaextension.CapellaExtensionPackage;

import org.polarsys.kitalpha.emde.genchain.extension.model.ExtensionPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CapellaExtensionPackageImpl extends EPackageImpl implements CapellaExtensionPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass capellaEmfGenerationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass capellaCdoEmfGenerationEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.polarsys.capella.extension.genchain.capellaextension.CapellaExtensionPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private CapellaExtensionPackageImpl() {
		super(eNS_URI, CapellaExtensionFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link CapellaExtensionPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static CapellaExtensionPackage init() {
		if (isInited) return (CapellaExtensionPackage)EPackage.Registry.INSTANCE.getEPackage(CapellaExtensionPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredCapellaExtensionPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		CapellaExtensionPackageImpl theCapellaExtensionPackage = registeredCapellaExtensionPackage instanceof CapellaExtensionPackageImpl ? (CapellaExtensionPackageImpl)registeredCapellaExtensionPackage : new CapellaExtensionPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		ExtensionPackage.eINSTANCE.eClass();
		GenerationChainPackage.eINSTANCE.eClass();
		CdoExtensionPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theCapellaExtensionPackage.createPackageContents();

		// Initialize created meta-data
		theCapellaExtensionPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theCapellaExtensionPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(CapellaExtensionPackage.eNS_URI, theCapellaExtensionPackage);
		return theCapellaExtensionPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCapellaEmfGeneration() {
		return capellaEmfGenerationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCapellaCdoEmfGeneration() {
		return capellaCdoEmfGenerationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CapellaExtensionFactory getCapellaExtensionFactory() {
		return (CapellaExtensionFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		capellaEmfGenerationEClass = createEClass(CAPELLA_EMF_GENERATION);

		capellaCdoEmfGenerationEClass = createEClass(CAPELLA_CDO_EMF_GENERATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		ExtensionPackage theExtensionPackage = (ExtensionPackage)EPackage.Registry.INSTANCE.getEPackage(ExtensionPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		capellaEmfGenerationEClass.getESuperTypes().add(theExtensionPackage.getEmdeGeneration());
		capellaCdoEmfGenerationEClass.getESuperTypes().add(theExtensionPackage.getEmdeCdoGeneration());

		// Initialize classes and features; add operations and parameters
		initEClass(capellaEmfGenerationEClass, CapellaEmfGeneration.class, "CapellaEmfGeneration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(capellaCdoEmfGenerationEClass, CapellaCdoEmfGeneration.class, "CapellaCdoEmfGeneration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //CapellaExtensionPackageImpl
