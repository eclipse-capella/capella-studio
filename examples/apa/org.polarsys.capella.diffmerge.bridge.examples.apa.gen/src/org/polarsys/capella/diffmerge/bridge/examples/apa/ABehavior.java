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
 * A representation of the model object '<em><b>ABehavior</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.capella.diffmerge.bridge.examples.apa.ABehavior#getOwningNode <em>Owning Node</em>}</li>
 *   <li>{@link org.polarsys.capella.diffmerge.bridge.examples.apa.ABehavior#getFunctions <em>Functions</em>}</li>
 * </ul>
 *
 * @see org.polarsys.capella.diffmerge.bridge.examples.apa.ApaPackage#getABehavior()
 * @model
 * @generated
 */
public interface ABehavior extends ANamedElement {
	/**
   * Returns the value of the '<em><b>Owning Node</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.polarsys.capella.diffmerge.bridge.examples.apa.ANode#getBehaviors <em>Behaviors</em>}'.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Node</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Owning Node</em>' container reference.
   * @see #setOwningNode(ANode)
   * @see org.polarsys.capella.diffmerge.bridge.examples.apa.ApaPackage#getABehavior_OwningNode()
   * @see org.polarsys.capella.diffmerge.bridge.examples.apa.ANode#getBehaviors
   * @model opposite="behaviors" required="true" transient="false"
   * @generated
   */
	ANode getOwningNode();

	/**
   * Sets the value of the '{@link org.polarsys.capella.diffmerge.bridge.examples.apa.ABehavior#getOwningNode <em>Owning Node</em>}' container reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Owning Node</em>' container reference.
   * @see #getOwningNode()
   * @generated
   */
	void setOwningNode(ANode value);

	/**
   * Returns the value of the '<em><b>Functions</b></em>' containment reference list.
   * The list contents are of type {@link org.polarsys.capella.diffmerge.bridge.examples.apa.AFunction}.
   * It is bidirectional and its opposite is '{@link org.polarsys.capella.diffmerge.bridge.examples.apa.AFunction#getOwningBehavior <em>Owning Behavior</em>}'.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Functions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Functions</em>' containment reference list.
   * @see org.polarsys.capella.diffmerge.bridge.examples.apa.ApaPackage#getABehavior_Functions()
   * @see org.polarsys.capella.diffmerge.bridge.examples.apa.AFunction#getOwningBehavior
   * @model opposite="owningBehavior" containment="true"
   * @generated
   */
	EList<AFunction> getFunctions();

} // ABehavior
