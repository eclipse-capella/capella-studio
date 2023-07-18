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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>AExchange</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.capella.diffmerge.bridge.examples.apa.AExchange#getOwningScope <em>Owning Scope</em>}</li>
 *   <li>{@link org.polarsys.capella.diffmerge.bridge.examples.apa.AExchange#getSource <em>Source</em>}</li>
 *   <li>{@link org.polarsys.capella.diffmerge.bridge.examples.apa.AExchange#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @see org.polarsys.capella.diffmerge.bridge.examples.apa.ApaPackage#getAExchange()
 * @model
 * @generated
 */
public interface AExchange extends ANamedElement {
	/**
   * Returns the value of the '<em><b>Owning Scope</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.polarsys.capella.diffmerge.bridge.examples.apa.AScope#getExchanges <em>Exchanges</em>}'.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Scope</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Owning Scope</em>' container reference.
   * @see #setOwningScope(AScope)
   * @see org.polarsys.capella.diffmerge.bridge.examples.apa.ApaPackage#getAExchange_OwningScope()
   * @see org.polarsys.capella.diffmerge.bridge.examples.apa.AScope#getExchanges
   * @model opposite="exchanges" required="true" transient="false"
   * @generated
   */
	AScope getOwningScope();

	/**
   * Sets the value of the '{@link org.polarsys.capella.diffmerge.bridge.examples.apa.AExchange#getOwningScope <em>Owning Scope</em>}' container reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Owning Scope</em>' container reference.
   * @see #getOwningScope()
   * @generated
   */
	void setOwningScope(AScope value);

	/**
   * Returns the value of the '<em><b>Source</b></em>' reference.
   * It is bidirectional and its opposite is '{@link org.polarsys.capella.diffmerge.bridge.examples.apa.AFunction#getOutgoing <em>Outgoing</em>}'.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Source</em>' reference.
   * @see #setSource(AFunction)
   * @see org.polarsys.capella.diffmerge.bridge.examples.apa.ApaPackage#getAExchange_Source()
   * @see org.polarsys.capella.diffmerge.bridge.examples.apa.AFunction#getOutgoing
   * @model opposite="outgoing" required="true"
   * @generated
   */
	AFunction getSource();

	/**
   * Sets the value of the '{@link org.polarsys.capella.diffmerge.bridge.examples.apa.AExchange#getSource <em>Source</em>}' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Source</em>' reference.
   * @see #getSource()
   * @generated
   */
	void setSource(AFunction value);

	/**
   * Returns the value of the '<em><b>Target</b></em>' reference.
   * It is bidirectional and its opposite is '{@link org.polarsys.capella.diffmerge.bridge.examples.apa.AFunction#getIncoming <em>Incoming</em>}'.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Target</em>' reference.
   * @see #setTarget(AFunction)
   * @see org.polarsys.capella.diffmerge.bridge.examples.apa.ApaPackage#getAExchange_Target()
   * @see org.polarsys.capella.diffmerge.bridge.examples.apa.AFunction#getIncoming
   * @model opposite="incoming" required="true"
   * @generated
   */
	AFunction getTarget();

	/**
   * Sets the value of the '{@link org.polarsys.capella.diffmerge.bridge.examples.apa.AExchange#getTarget <em>Target</em>}' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Target</em>' reference.
   * @see #getTarget()
   * @generated
   */
	void setTarget(AFunction value);

} // AExchange
