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
package org.polarsys.capella.diffmerge.bridge.examples.apa.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.polarsys.capella.diffmerge.bridge.examples.apa.AExchange;
import org.polarsys.capella.diffmerge.bridge.examples.apa.ANode;
import org.polarsys.capella.diffmerge.bridge.examples.apa.AScope;
import org.polarsys.capella.diffmerge.bridge.examples.apa.ApaPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>AScope</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.capella.diffmerge.bridge.examples.apa.impl.AScopeImpl#getNodes <em>Nodes</em>}</li>
 *   <li>{@link org.polarsys.capella.diffmerge.bridge.examples.apa.impl.AScopeImpl#getExchanges <em>Exchanges</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AScopeImpl extends ANamedElementImpl implements AScope {
	/**
   * The cached value of the '{@link #getNodes() <em>Nodes</em>}' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getNodes()
   * @generated
   * @ordered
   */
	protected EList<ANode> nodes;

	/**
   * The cached value of the '{@link #getExchanges() <em>Exchanges</em>}' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getExchanges()
   * @generated
   * @ordered
   */
	protected EList<AExchange> exchanges;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected AScopeImpl() {
    super();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	protected EClass eStaticClass() {
    return ApaPackage.Literals.ASCOPE;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EList<ANode> getNodes() {
    if (nodes == null) {
      nodes = new EObjectContainmentWithInverseEList<ANode>(ANode.class, this, ApaPackage.ASCOPE__NODES, ApaPackage.ANODE__OWNING_SCOPE);
    }
    return nodes;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EList<AExchange> getExchanges() {
    if (exchanges == null) {
      exchanges = new EObjectContainmentWithInverseEList<AExchange>(AExchange.class, this, ApaPackage.ASCOPE__EXCHANGES, ApaPackage.AEXCHANGE__OWNING_SCOPE);
    }
    return exchanges;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case ApaPackage.ASCOPE__NODES:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getNodes()).basicAdd(otherEnd, msgs);
      case ApaPackage.ASCOPE__EXCHANGES:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getExchanges()).basicAdd(otherEnd, msgs);
    }
    return super.eInverseAdd(otherEnd, featureID, msgs);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case ApaPackage.ASCOPE__NODES:
        return ((InternalEList<?>)getNodes()).basicRemove(otherEnd, msgs);
      case ApaPackage.ASCOPE__EXCHANGES:
        return ((InternalEList<?>)getExchanges()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case ApaPackage.ASCOPE__NODES:
        return getNodes();
      case ApaPackage.ASCOPE__EXCHANGES:
        return getExchanges();
    }
    return super.eGet(featureID, resolve, coreType);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
    switch (featureID) {
      case ApaPackage.ASCOPE__NODES:
        getNodes().clear();
        getNodes().addAll((Collection<? extends ANode>)newValue);
        return;
      case ApaPackage.ASCOPE__EXCHANGES:
        getExchanges().clear();
        getExchanges().addAll((Collection<? extends AExchange>)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public void eUnset(int featureID) {
    switch (featureID) {
      case ApaPackage.ASCOPE__NODES:
        getNodes().clear();
        return;
      case ApaPackage.ASCOPE__EXCHANGES:
        getExchanges().clear();
        return;
    }
    super.eUnset(featureID);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public boolean eIsSet(int featureID) {
    switch (featureID) {
      case ApaPackage.ASCOPE__NODES:
        return nodes != null && !nodes.isEmpty();
      case ApaPackage.ASCOPE__EXCHANGES:
        return exchanges != null && !exchanges.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //AScopeImpl
