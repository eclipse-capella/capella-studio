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
 * A representation of the model object '<em><b>AScope</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.capella.diffmerge.bridge.examples.apa.AScope#getNodes <em>Nodes</em>}</li>
 *   <li>{@link org.polarsys.capella.diffmerge.bridge.examples.apa.AScope#getExchanges <em>Exchanges</em>}</li>
 * </ul>
 *
 * @see org.polarsys.capella.diffmerge.bridge.examples.apa.ApaPackage#getAScope()
 * @model
 * @generated
 */
public interface AScope extends ANamedElement {
	/**
   * Returns the value of the '<em><b>Nodes</b></em>' containment reference list.
   * The list contents are of type {@link org.polarsys.capella.diffmerge.bridge.examples.apa.ANode}.
   * It is bidirectional and its opposite is '{@link org.polarsys.capella.diffmerge.bridge.examples.apa.ANode#getOwningScope <em>Owning Scope</em>}'.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nodes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Nodes</em>' containment reference list.
   * @see org.polarsys.capella.diffmerge.bridge.examples.apa.ApaPackage#getAScope_Nodes()
   * @see org.polarsys.capella.diffmerge.bridge.examples.apa.ANode#getOwningScope
   * @model opposite="owningScope" containment="true"
   * @generated
   */
	EList<ANode> getNodes();

	/**
   * Returns the value of the '<em><b>Exchanges</b></em>' containment reference list.
   * The list contents are of type {@link org.polarsys.capella.diffmerge.bridge.examples.apa.AExchange}.
   * It is bidirectional and its opposite is '{@link org.polarsys.capella.diffmerge.bridge.examples.apa.AExchange#getOwningScope <em>Owning Scope</em>}'.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exchanges</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Exchanges</em>' containment reference list.
   * @see org.polarsys.capella.diffmerge.bridge.examples.apa.ApaPackage#getAScope_Exchanges()
   * @see org.polarsys.capella.diffmerge.bridge.examples.apa.AExchange#getOwningScope
   * @model opposite="owningScope" containment="true"
   * @generated
   */
	EList<AExchange> getExchanges();

} // AScope
