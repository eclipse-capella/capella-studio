/**
 * Copyright (c) 2015, 2018 Thales Global Services S.A.S.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 *   
 * Contributors:
 *   Thales Global Services S.A.S - initial API and implementation
 * 
 *
 * $Id$
 */

package org.polarsys.capella.extension.genchain.capellaextension;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.polarsys.kitalpha.emde.genchain.extension.model.ExtensionPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.polarsys.capella.extension.genchain.capellaextension.CapellaExtensionFactory
 * @model kind="package"
 * @generated
 */
public interface CapellaExtensionPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "capellaextension";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.polarsys.org/capella/extension/genchain/0.8.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "CapellaExtension";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CapellaExtensionPackage eINSTANCE = org.polarsys.capella.extension.genchain.capellaextension.impl.CapellaExtensionPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.polarsys.capella.extension.genchain.capellaextension.impl.CapellaEmfGenerationImpl <em>Capella Emf Generation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.capella.extension.genchain.capellaextension.impl.CapellaEmfGenerationImpl
	 * @see org.polarsys.capella.extension.genchain.capellaextension.impl.CapellaExtensionPackageImpl#getCapellaEmfGeneration()
	 * @generated
	 */
	int CAPELLA_EMF_GENERATION = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPELLA_EMF_GENERATION__NAME = ExtensionPackage.EMDE_GENERATION__NAME;

	/**
	 * The feature id for the '<em><b>Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPELLA_EMF_GENERATION__CONTAINER = ExtensionPackage.EMDE_GENERATION__CONTAINER;

	/**
	 * The feature id for the '<em><b>Model Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPELLA_EMF_GENERATION__MODEL_PATH = ExtensionPackage.EMDE_GENERATION__MODEL_PATH;

	/**
	 * The feature id for the '<em><b>Generate Model</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPELLA_EMF_GENERATION__GENERATE_MODEL = ExtensionPackage.EMDE_GENERATION__GENERATE_MODEL;

	/**
	 * The feature id for the '<em><b>Generate Edit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPELLA_EMF_GENERATION__GENERATE_EDIT = ExtensionPackage.EMDE_GENERATION__GENERATE_EDIT;

	/**
	 * The feature id for the '<em><b>Generate Editor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPELLA_EMF_GENERATION__GENERATE_EDITOR = ExtensionPackage.EMDE_GENERATION__GENERATE_EDITOR;

	/**
	 * The feature id for the '<em><b>Generate Test</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPELLA_EMF_GENERATION__GENERATE_TEST = ExtensionPackage.EMDE_GENERATION__GENERATE_TEST;

	/**
	 * The feature id for the '<em><b>Generate Javadoc</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPELLA_EMF_GENERATION__GENERATE_JAVADOC = ExtensionPackage.EMDE_GENERATION__GENERATE_JAVADOC;

	/**
	 * The feature id for the '<em><b>Plugin Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPELLA_EMF_GENERATION__PLUGIN_NAME = ExtensionPackage.EMDE_GENERATION__PLUGIN_NAME;

	/**
	 * The feature id for the '<em><b>Base Package</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPELLA_EMF_GENERATION__BASE_PACKAGE = ExtensionPackage.EMDE_GENERATION__BASE_PACKAGE;

	/**
	 * The number of structural features of the '<em>Capella Emf Generation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPELLA_EMF_GENERATION_FEATURE_COUNT = ExtensionPackage.EMDE_GENERATION_FEATURE_COUNT + 0;


	/**
	 * The meta object id for the '{@link org.polarsys.capella.extension.genchain.capellaextension.impl.CapellaCdoEmfGenerationImpl <em>Capella Cdo Emf Generation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.capella.extension.genchain.capellaextension.impl.CapellaCdoEmfGenerationImpl
	 * @see org.polarsys.capella.extension.genchain.capellaextension.impl.CapellaExtensionPackageImpl#getCapellaCdoEmfGeneration()
	 * @generated
	 */
	int CAPELLA_CDO_EMF_GENERATION = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPELLA_CDO_EMF_GENERATION__NAME = ExtensionPackage.EMDE_CDO_GENERATION__NAME;

	/**
	 * The feature id for the '<em><b>Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPELLA_CDO_EMF_GENERATION__CONTAINER = ExtensionPackage.EMDE_CDO_GENERATION__CONTAINER;

	/**
	 * The feature id for the '<em><b>Model Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPELLA_CDO_EMF_GENERATION__MODEL_PATH = ExtensionPackage.EMDE_CDO_GENERATION__MODEL_PATH;

	/**
	 * The feature id for the '<em><b>Cdo Suffix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPELLA_CDO_EMF_GENERATION__CDO_SUFFIX = ExtensionPackage.EMDE_CDO_GENERATION__CDO_SUFFIX;

	/**
	 * The feature id for the '<em><b>Feature Delegation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPELLA_CDO_EMF_GENERATION__FEATURE_DELEGATION = ExtensionPackage.EMDE_CDO_GENERATION__FEATURE_DELEGATION;

	/**
	 * The number of structural features of the '<em>Capella Cdo Emf Generation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPELLA_CDO_EMF_GENERATION_FEATURE_COUNT = ExtensionPackage.EMDE_CDO_GENERATION_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.polarsys.capella.extension.genchain.capellaextension.CapellaEmfGeneration <em>Capella Emf Generation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Capella Emf Generation</em>'.
	 * @see org.polarsys.capella.extension.genchain.capellaextension.CapellaEmfGeneration
	 * @generated
	 */
	EClass getCapellaEmfGeneration();

	/**
	 * Returns the meta object for class '{@link org.polarsys.capella.extension.genchain.capellaextension.CapellaCdoEmfGeneration <em>Capella Cdo Emf Generation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Capella Cdo Emf Generation</em>'.
	 * @see org.polarsys.capella.extension.genchain.capellaextension.CapellaCdoEmfGeneration
	 * @generated
	 */
	EClass getCapellaCdoEmfGeneration();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CapellaExtensionFactory getCapellaExtensionFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.polarsys.capella.extension.genchain.capellaextension.impl.CapellaEmfGenerationImpl <em>Capella Emf Generation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.capella.extension.genchain.capellaextension.impl.CapellaEmfGenerationImpl
		 * @see org.polarsys.capella.extension.genchain.capellaextension.impl.CapellaExtensionPackageImpl#getCapellaEmfGeneration()
		 * @generated
		 */
		EClass CAPELLA_EMF_GENERATION = eINSTANCE.getCapellaEmfGeneration();
		/**
		 * The meta object literal for the '{@link org.polarsys.capella.extension.genchain.capellaextension.impl.CapellaCdoEmfGenerationImpl <em>Capella Cdo Emf Generation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.capella.extension.genchain.capellaextension.impl.CapellaCdoEmfGenerationImpl
		 * @see org.polarsys.capella.extension.genchain.capellaextension.impl.CapellaExtensionPackageImpl#getCapellaCdoEmfGeneration()
		 * @generated
		 */
		EClass CAPELLA_CDO_EMF_GENERATION = eINSTANCE.getCapellaCdoEmfGeneration();

	}

} //CapellaExtensionPackage
