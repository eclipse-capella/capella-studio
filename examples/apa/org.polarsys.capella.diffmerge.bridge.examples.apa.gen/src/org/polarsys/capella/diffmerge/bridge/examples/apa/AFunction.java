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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>AFunction</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.capella.diffmerge.bridge.examples.apa.AFunction#getOwningBehavior <em>Owning Behavior</em>}</li>
 *   <li>{@link org.polarsys.capella.diffmerge.bridge.examples.apa.AFunction#getIncoming <em>Incoming</em>}</li>
 *   <li>{@link org.polarsys.capella.diffmerge.bridge.examples.apa.AFunction#getOutgoing <em>Outgoing</em>}</li>
 * </ul>
 *
 * @see org.polarsys.capella.diffmerge.bridge.examples.apa.ApaPackage#getAFunction()
 * @model
 * @generated
 */
public interface AFunction extends ANamedElement {
	/**
   * Returns the value of the '<em><b>Owning Behavior</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.polarsys.capella.diffmerge.bridge.examples.apa.ABehavior#getFunctions <em>Functions</em>}'.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Behavior</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Owning Behavior</em>' container reference.
   * @see #setOwningBehavior(ABehavior)
   * @see org.polarsys.capella.diffmerge.bridge.examples.apa.ApaPackage#getAFunction_OwningBehavior()
   * @see org.polarsys.capella.diffmerge.bridge.examples.apa.ABehavior#getFunctions
   * @model opposite="functions" required="true" transient="false"
   * @generated
   */
	ABehavior getOwningBehavior();

	/**
   * Sets the value of the '{@link org.polarsys.capella.diffmerge.bridge.examples.apa.AFunction#getOwningBehavior <em>Owning Behavior</em>}' container reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Owning Behavior</em>' container reference.
   * @see #getOwningBehavior()
   * @generated
   */
	void setOwningBehavior(ABehavior value);

	/**
   * Returns the value of the '<em><b>Incoming</b></em>' reference list.
   * The list contents are of type {@link org.polarsys.capella.diffmerge.bridge.examples.apa.AExchange}.
   * It is bidirectional and its opposite is '{@link org.polarsys.capella.diffmerge.bridge.examples.apa.AExchange#getTarget <em>Target</em>}'.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incoming</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Incoming</em>' reference list.
   * @see org.polarsys.capella.diffmerge.bridge.examples.apa.ApaPackage#getAFunction_Incoming()
   * @see org.polarsys.capella.diffmerge.bridge.examples.apa.AExchange#getTarget
   * @model opposite="target"
   * @generated
   */
	EList<AExchange> getIncoming();

	/**
   * Returns the value of the '<em><b>Outgoing</b></em>' reference list.
   * The list contents are of type {@link org.polarsys.capella.diffmerge.bridge.examples.apa.AExchange}.
   * It is bidirectional and its opposite is '{@link org.polarsys.capella.diffmerge.bridge.examples.apa.AExchange#getSource <em>Source</em>}'.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outgoing</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Outgoing</em>' reference list.
   * @see org.polarsys.capella.diffmerge.bridge.examples.apa.ApaPackage#getAFunction_Outgoing()
   * @see org.polarsys.capella.diffmerge.bridge.examples.apa.AExchange#getSource
   * @model opposite="source"
   * @generated
   */
	EList<AExchange> getOutgoing();

} // AFunction
