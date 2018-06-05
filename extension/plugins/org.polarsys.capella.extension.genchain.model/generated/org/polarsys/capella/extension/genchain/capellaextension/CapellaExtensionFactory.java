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

package org.polarsys.capella.extension.genchain.capellaextension;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.polarsys.capella.extension.genchain.capellaextension.CapellaExtensionPackage
 * @generated
 */
public interface CapellaExtensionFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CapellaExtensionFactory eINSTANCE = org.polarsys.capella.extension.genchain.capellaextension.impl.CapellaExtensionFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Capella Emf Generation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Capella Emf Generation</em>'.
	 * @generated
	 */
	CapellaEmfGeneration createCapellaEmfGeneration();

	/**
	 * Returns a new object of class '<em>Capella Cdo Emf Generation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Capella Cdo Emf Generation</em>'.
	 * @generated
	 */
	CapellaCdoEmfGeneration createCapellaCdoEmfGeneration();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	CapellaExtensionPackage getCapellaExtensionPackage();

} //CapellaExtensionFactory
