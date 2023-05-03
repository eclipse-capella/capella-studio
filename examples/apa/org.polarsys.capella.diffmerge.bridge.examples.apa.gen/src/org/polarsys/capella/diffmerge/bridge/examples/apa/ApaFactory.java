/*********************************************************************
 * Copyright (c) 2015-2019 Thales Global Services S.A.S.
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *    Thales Global Services S.A.S. - initial API and implementation
 **********************************************************************/
package org.polarsys.capella.diffmerge.bridge.examples.apa;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.polarsys.capella.diffmerge.bridge.examples.apa.ApaPackage
 * @generated
 */
public interface ApaFactory extends EFactory {
	/**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	ApaFactory eINSTANCE = org.polarsys.capella.diffmerge.bridge.examples.apa.impl.ApaFactoryImpl.init();

	/**
   * Returns a new object of class '<em>AScope</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>AScope</em>'.
   * @generated
   */
	AScope createAScope();

	/**
   * Returns a new object of class '<em>ANode</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>ANode</em>'.
   * @generated
   */
	ANode createANode();

	/**
   * Returns a new object of class '<em>ABehavior</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>ABehavior</em>'.
   * @generated
   */
	ABehavior createABehavior();

	/**
   * Returns a new object of class '<em>AFunction</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>AFunction</em>'.
   * @generated
   */
	AFunction createAFunction();

	/**
   * Returns a new object of class '<em>AExchange</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>AExchange</em>'.
   * @generated
   */
	AExchange createAExchange();

	/**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
	ApaPackage getApaPackage();

} //ApaFactory
