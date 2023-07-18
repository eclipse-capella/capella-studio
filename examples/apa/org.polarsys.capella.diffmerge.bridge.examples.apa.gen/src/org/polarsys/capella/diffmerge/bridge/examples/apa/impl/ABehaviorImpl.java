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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.polarsys.capella.diffmerge.bridge.examples.apa.ABehavior;
import org.polarsys.capella.diffmerge.bridge.examples.apa.AFunction;
import org.polarsys.capella.diffmerge.bridge.examples.apa.ANode;
import org.polarsys.capella.diffmerge.bridge.examples.apa.ApaPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>ABehavior</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.capella.diffmerge.bridge.examples.apa.impl.ABehaviorImpl#getOwningNode <em>Owning Node</em>}</li>
 *   <li>{@link org.polarsys.capella.diffmerge.bridge.examples.apa.impl.ABehaviorImpl#getFunctions <em>Functions</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ABehaviorImpl extends ANamedElementImpl implements ABehavior {
	/**
   * The cached value of the '{@link #getFunctions() <em>Functions</em>}' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getFunctions()
   * @generated
   * @ordered
   */
	protected EList<AFunction> functions;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected ABehaviorImpl() {
    super();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	protected EClass eStaticClass() {
    return ApaPackage.Literals.ABEHAVIOR;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public ANode getOwningNode() {
    if (eContainerFeatureID() != ApaPackage.ABEHAVIOR__OWNING_NODE) return null;
    return (ANode)eInternalContainer();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public NotificationChain basicSetOwningNode(ANode newOwningNode, NotificationChain msgs) {
    msgs = eBasicSetContainer((InternalEObject)newOwningNode, ApaPackage.ABEHAVIOR__OWNING_NODE, msgs);
    return msgs;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setOwningNode(ANode newOwningNode) {
    if (newOwningNode != eInternalContainer() || (eContainerFeatureID() != ApaPackage.ABEHAVIOR__OWNING_NODE && newOwningNode != null)) {
      if (EcoreUtil.isAncestor(this, newOwningNode))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newOwningNode != null)
        msgs = ((InternalEObject)newOwningNode).eInverseAdd(this, ApaPackage.ANODE__BEHAVIORS, ANode.class, msgs);
      msgs = basicSetOwningNode(newOwningNode, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ApaPackage.ABEHAVIOR__OWNING_NODE, newOwningNode, newOwningNode));
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EList<AFunction> getFunctions() {
    if (functions == null) {
      functions = new EObjectContainmentWithInverseEList<AFunction>(AFunction.class, this, ApaPackage.ABEHAVIOR__FUNCTIONS, ApaPackage.AFUNCTION__OWNING_BEHAVIOR);
    }
    return functions;
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
      case ApaPackage.ABEHAVIOR__OWNING_NODE:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return basicSetOwningNode((ANode)otherEnd, msgs);
      case ApaPackage.ABEHAVIOR__FUNCTIONS:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getFunctions()).basicAdd(otherEnd, msgs);
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
      case ApaPackage.ABEHAVIOR__OWNING_NODE:
        return basicSetOwningNode(null, msgs);
      case ApaPackage.ABEHAVIOR__FUNCTIONS:
        return ((InternalEList<?>)getFunctions()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
    switch (eContainerFeatureID()) {
      case ApaPackage.ABEHAVIOR__OWNING_NODE:
        return eInternalContainer().eInverseRemove(this, ApaPackage.ANODE__BEHAVIORS, ANode.class, msgs);
    }
    return super.eBasicRemoveFromContainerFeature(msgs);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case ApaPackage.ABEHAVIOR__OWNING_NODE:
        return getOwningNode();
      case ApaPackage.ABEHAVIOR__FUNCTIONS:
        return getFunctions();
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
      case ApaPackage.ABEHAVIOR__OWNING_NODE:
        setOwningNode((ANode)newValue);
        return;
      case ApaPackage.ABEHAVIOR__FUNCTIONS:
        getFunctions().clear();
        getFunctions().addAll((Collection<? extends AFunction>)newValue);
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
      case ApaPackage.ABEHAVIOR__OWNING_NODE:
        setOwningNode((ANode)null);
        return;
      case ApaPackage.ABEHAVIOR__FUNCTIONS:
        getFunctions().clear();
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
      case ApaPackage.ABEHAVIOR__OWNING_NODE:
        return getOwningNode() != null;
      case ApaPackage.ABEHAVIOR__FUNCTIONS:
        return functions != null && !functions.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ABehaviorImpl
