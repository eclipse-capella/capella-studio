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
import org.polarsys.capella.diffmerge.bridge.examples.apa.ANode;
import org.polarsys.capella.diffmerge.bridge.examples.apa.AScope;
import org.polarsys.capella.diffmerge.bridge.examples.apa.ApaPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>ANode</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.capella.diffmerge.bridge.examples.apa.impl.ANodeImpl#getOwningScope <em>Owning Scope</em>}</li>
 *   <li>{@link org.polarsys.capella.diffmerge.bridge.examples.apa.impl.ANodeImpl#getBehaviors <em>Behaviors</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ANodeImpl extends ANamedElementImpl implements ANode {
	/**
   * The cached value of the '{@link #getBehaviors() <em>Behaviors</em>}' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getBehaviors()
   * @generated
   * @ordered
   */
	protected EList<ABehavior> behaviors;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected ANodeImpl() {
    super();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	protected EClass eStaticClass() {
    return ApaPackage.Literals.ANODE;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public AScope getOwningScope() {
    if (eContainerFeatureID() != ApaPackage.ANODE__OWNING_SCOPE) return null;
    return (AScope)eInternalContainer();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public NotificationChain basicSetOwningScope(AScope newOwningScope, NotificationChain msgs) {
    msgs = eBasicSetContainer((InternalEObject)newOwningScope, ApaPackage.ANODE__OWNING_SCOPE, msgs);
    return msgs;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setOwningScope(AScope newOwningScope) {
    if (newOwningScope != eInternalContainer() || (eContainerFeatureID() != ApaPackage.ANODE__OWNING_SCOPE && newOwningScope != null)) {
      if (EcoreUtil.isAncestor(this, newOwningScope))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newOwningScope != null)
        msgs = ((InternalEObject)newOwningScope).eInverseAdd(this, ApaPackage.ASCOPE__NODES, AScope.class, msgs);
      msgs = basicSetOwningScope(newOwningScope, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ApaPackage.ANODE__OWNING_SCOPE, newOwningScope, newOwningScope));
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EList<ABehavior> getBehaviors() {
    if (behaviors == null) {
      behaviors = new EObjectContainmentWithInverseEList<ABehavior>(ABehavior.class, this, ApaPackage.ANODE__BEHAVIORS, ApaPackage.ABEHAVIOR__OWNING_NODE);
    }
    return behaviors;
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
      case ApaPackage.ANODE__OWNING_SCOPE:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return basicSetOwningScope((AScope)otherEnd, msgs);
      case ApaPackage.ANODE__BEHAVIORS:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getBehaviors()).basicAdd(otherEnd, msgs);
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
      case ApaPackage.ANODE__OWNING_SCOPE:
        return basicSetOwningScope(null, msgs);
      case ApaPackage.ANODE__BEHAVIORS:
        return ((InternalEList<?>)getBehaviors()).basicRemove(otherEnd, msgs);
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
      case ApaPackage.ANODE__OWNING_SCOPE:
        return eInternalContainer().eInverseRemove(this, ApaPackage.ASCOPE__NODES, AScope.class, msgs);
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
      case ApaPackage.ANODE__OWNING_SCOPE:
        return getOwningScope();
      case ApaPackage.ANODE__BEHAVIORS:
        return getBehaviors();
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
      case ApaPackage.ANODE__OWNING_SCOPE:
        setOwningScope((AScope)newValue);
        return;
      case ApaPackage.ANODE__BEHAVIORS:
        getBehaviors().clear();
        getBehaviors().addAll((Collection<? extends ABehavior>)newValue);
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
      case ApaPackage.ANODE__OWNING_SCOPE:
        setOwningScope((AScope)null);
        return;
      case ApaPackage.ANODE__BEHAVIORS:
        getBehaviors().clear();
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
      case ApaPackage.ANODE__OWNING_SCOPE:
        return getOwningScope() != null;
      case ApaPackage.ANODE__BEHAVIORS:
        return behaviors != null && !behaviors.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ANodeImpl
