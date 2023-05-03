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

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.polarsys.capella.diffmerge.bridge.examples.apa.ABehavior;
import org.polarsys.capella.diffmerge.bridge.examples.apa.AExchange;
import org.polarsys.capella.diffmerge.bridge.examples.apa.AFunction;
import org.polarsys.capella.diffmerge.bridge.examples.apa.ApaPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>AFunction</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.capella.diffmerge.bridge.examples.apa.impl.AFunctionImpl#getOwningBehavior <em>Owning Behavior</em>}</li>
 *   <li>{@link org.polarsys.capella.diffmerge.bridge.examples.apa.impl.AFunctionImpl#getIncoming <em>Incoming</em>}</li>
 *   <li>{@link org.polarsys.capella.diffmerge.bridge.examples.apa.impl.AFunctionImpl#getOutgoing <em>Outgoing</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AFunctionImpl extends ANamedElementImpl implements AFunction {
	/**
   * The cached value of the '{@link #getIncoming() <em>Incoming</em>}' reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getIncoming()
   * @generated
   * @ordered
   */
	protected EList<AExchange> incoming;

	/**
   * The cached value of the '{@link #getOutgoing() <em>Outgoing</em>}' reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getOutgoing()
   * @generated
   * @ordered
   */
	protected EList<AExchange> outgoing;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected AFunctionImpl() {
    super();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	protected EClass eStaticClass() {
    return ApaPackage.Literals.AFUNCTION;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public ABehavior getOwningBehavior() {
    if (eContainerFeatureID() != ApaPackage.AFUNCTION__OWNING_BEHAVIOR) return null;
    return (ABehavior)eInternalContainer();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public NotificationChain basicSetOwningBehavior(ABehavior newOwningBehavior, NotificationChain msgs) {
    msgs = eBasicSetContainer((InternalEObject)newOwningBehavior, ApaPackage.AFUNCTION__OWNING_BEHAVIOR, msgs);
    return msgs;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setOwningBehavior(ABehavior newOwningBehavior) {
    if (newOwningBehavior != eInternalContainer() || (eContainerFeatureID() != ApaPackage.AFUNCTION__OWNING_BEHAVIOR && newOwningBehavior != null)) {
      if (EcoreUtil.isAncestor(this, newOwningBehavior))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newOwningBehavior != null)
        msgs = ((InternalEObject)newOwningBehavior).eInverseAdd(this, ApaPackage.ABEHAVIOR__FUNCTIONS, ABehavior.class, msgs);
      msgs = basicSetOwningBehavior(newOwningBehavior, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ApaPackage.AFUNCTION__OWNING_BEHAVIOR, newOwningBehavior, newOwningBehavior));
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EList<AExchange> getIncoming() {
    if (incoming == null) {
      incoming = new EObjectWithInverseResolvingEList<AExchange>(AExchange.class, this, ApaPackage.AFUNCTION__INCOMING, ApaPackage.AEXCHANGE__TARGET);
    }
    return incoming;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EList<AExchange> getOutgoing() {
    if (outgoing == null) {
      outgoing = new EObjectWithInverseResolvingEList<AExchange>(AExchange.class, this, ApaPackage.AFUNCTION__OUTGOING, ApaPackage.AEXCHANGE__SOURCE);
    }
    return outgoing;
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
      case ApaPackage.AFUNCTION__OWNING_BEHAVIOR:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return basicSetOwningBehavior((ABehavior)otherEnd, msgs);
      case ApaPackage.AFUNCTION__INCOMING:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getIncoming()).basicAdd(otherEnd, msgs);
      case ApaPackage.AFUNCTION__OUTGOING:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutgoing()).basicAdd(otherEnd, msgs);
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
      case ApaPackage.AFUNCTION__OWNING_BEHAVIOR:
        return basicSetOwningBehavior(null, msgs);
      case ApaPackage.AFUNCTION__INCOMING:
        return ((InternalEList<?>)getIncoming()).basicRemove(otherEnd, msgs);
      case ApaPackage.AFUNCTION__OUTGOING:
        return ((InternalEList<?>)getOutgoing()).basicRemove(otherEnd, msgs);
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
      case ApaPackage.AFUNCTION__OWNING_BEHAVIOR:
        return eInternalContainer().eInverseRemove(this, ApaPackage.ABEHAVIOR__FUNCTIONS, ABehavior.class, msgs);
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
      case ApaPackage.AFUNCTION__OWNING_BEHAVIOR:
        return getOwningBehavior();
      case ApaPackage.AFUNCTION__INCOMING:
        return getIncoming();
      case ApaPackage.AFUNCTION__OUTGOING:
        return getOutgoing();
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
      case ApaPackage.AFUNCTION__OWNING_BEHAVIOR:
        setOwningBehavior((ABehavior)newValue);
        return;
      case ApaPackage.AFUNCTION__INCOMING:
        getIncoming().clear();
        getIncoming().addAll((Collection<? extends AExchange>)newValue);
        return;
      case ApaPackage.AFUNCTION__OUTGOING:
        getOutgoing().clear();
        getOutgoing().addAll((Collection<? extends AExchange>)newValue);
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
      case ApaPackage.AFUNCTION__OWNING_BEHAVIOR:
        setOwningBehavior((ABehavior)null);
        return;
      case ApaPackage.AFUNCTION__INCOMING:
        getIncoming().clear();
        return;
      case ApaPackage.AFUNCTION__OUTGOING:
        getOutgoing().clear();
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
      case ApaPackage.AFUNCTION__OWNING_BEHAVIOR:
        return getOwningBehavior() != null;
      case ApaPackage.AFUNCTION__INCOMING:
        return incoming != null && !incoming.isEmpty();
      case ApaPackage.AFUNCTION__OUTGOING:
        return outgoing != null && !outgoing.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //AFunctionImpl
