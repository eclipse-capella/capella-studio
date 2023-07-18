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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.polarsys.capella.diffmerge.bridge.examples.apa.AExchange;
import org.polarsys.capella.diffmerge.bridge.examples.apa.AFunction;
import org.polarsys.capella.diffmerge.bridge.examples.apa.AScope;
import org.polarsys.capella.diffmerge.bridge.examples.apa.ApaPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>AExchange</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.capella.diffmerge.bridge.examples.apa.impl.AExchangeImpl#getOwningScope <em>Owning Scope</em>}</li>
 *   <li>{@link org.polarsys.capella.diffmerge.bridge.examples.apa.impl.AExchangeImpl#getSource <em>Source</em>}</li>
 *   <li>{@link org.polarsys.capella.diffmerge.bridge.examples.apa.impl.AExchangeImpl#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AExchangeImpl extends ANamedElementImpl implements AExchange {
	/**
   * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getSource()
   * @generated
   * @ordered
   */
	protected AFunction source;

	/**
   * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getTarget()
   * @generated
   * @ordered
   */
	protected AFunction target;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected AExchangeImpl() {
    super();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	protected EClass eStaticClass() {
    return ApaPackage.Literals.AEXCHANGE;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public AScope getOwningScope() {
    if (eContainerFeatureID() != ApaPackage.AEXCHANGE__OWNING_SCOPE) return null;
    return (AScope)eInternalContainer();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public NotificationChain basicSetOwningScope(AScope newOwningScope, NotificationChain msgs) {
    msgs = eBasicSetContainer((InternalEObject)newOwningScope, ApaPackage.AEXCHANGE__OWNING_SCOPE, msgs);
    return msgs;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setOwningScope(AScope newOwningScope) {
    if (newOwningScope != eInternalContainer() || (eContainerFeatureID() != ApaPackage.AEXCHANGE__OWNING_SCOPE && newOwningScope != null)) {
      if (EcoreUtil.isAncestor(this, newOwningScope))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newOwningScope != null)
        msgs = ((InternalEObject)newOwningScope).eInverseAdd(this, ApaPackage.ASCOPE__EXCHANGES, AScope.class, msgs);
      msgs = basicSetOwningScope(newOwningScope, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ApaPackage.AEXCHANGE__OWNING_SCOPE, newOwningScope, newOwningScope));
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public AFunction getSource() {
    if (source != null && source.eIsProxy()) {
      InternalEObject oldSource = (InternalEObject)source;
      source = (AFunction)eResolveProxy(oldSource);
      if (source != oldSource) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ApaPackage.AEXCHANGE__SOURCE, oldSource, source));
      }
    }
    return source;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public AFunction basicGetSource() {
    return source;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public NotificationChain basicSetSource(AFunction newSource, NotificationChain msgs) {
    AFunction oldSource = source;
    source = newSource;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ApaPackage.AEXCHANGE__SOURCE, oldSource, newSource);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setSource(AFunction newSource) {
    if (newSource != source) {
      NotificationChain msgs = null;
      if (source != null)
        msgs = ((InternalEObject)source).eInverseRemove(this, ApaPackage.AFUNCTION__OUTGOING, AFunction.class, msgs);
      if (newSource != null)
        msgs = ((InternalEObject)newSource).eInverseAdd(this, ApaPackage.AFUNCTION__OUTGOING, AFunction.class, msgs);
      msgs = basicSetSource(newSource, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ApaPackage.AEXCHANGE__SOURCE, newSource, newSource));
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public AFunction getTarget() {
    if (target != null && target.eIsProxy()) {
      InternalEObject oldTarget = (InternalEObject)target;
      target = (AFunction)eResolveProxy(oldTarget);
      if (target != oldTarget) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ApaPackage.AEXCHANGE__TARGET, oldTarget, target));
      }
    }
    return target;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public AFunction basicGetTarget() {
    return target;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public NotificationChain basicSetTarget(AFunction newTarget, NotificationChain msgs) {
    AFunction oldTarget = target;
    target = newTarget;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ApaPackage.AEXCHANGE__TARGET, oldTarget, newTarget);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setTarget(AFunction newTarget) {
    if (newTarget != target) {
      NotificationChain msgs = null;
      if (target != null)
        msgs = ((InternalEObject)target).eInverseRemove(this, ApaPackage.AFUNCTION__INCOMING, AFunction.class, msgs);
      if (newTarget != null)
        msgs = ((InternalEObject)newTarget).eInverseAdd(this, ApaPackage.AFUNCTION__INCOMING, AFunction.class, msgs);
      msgs = basicSetTarget(newTarget, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ApaPackage.AEXCHANGE__TARGET, newTarget, newTarget));
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case ApaPackage.AEXCHANGE__OWNING_SCOPE:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return basicSetOwningScope((AScope)otherEnd, msgs);
      case ApaPackage.AEXCHANGE__SOURCE:
        if (source != null)
          msgs = ((InternalEObject)source).eInverseRemove(this, ApaPackage.AFUNCTION__OUTGOING, AFunction.class, msgs);
        return basicSetSource((AFunction)otherEnd, msgs);
      case ApaPackage.AEXCHANGE__TARGET:
        if (target != null)
          msgs = ((InternalEObject)target).eInverseRemove(this, ApaPackage.AFUNCTION__INCOMING, AFunction.class, msgs);
        return basicSetTarget((AFunction)otherEnd, msgs);
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
      case ApaPackage.AEXCHANGE__OWNING_SCOPE:
        return basicSetOwningScope(null, msgs);
      case ApaPackage.AEXCHANGE__SOURCE:
        return basicSetSource(null, msgs);
      case ApaPackage.AEXCHANGE__TARGET:
        return basicSetTarget(null, msgs);
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
      case ApaPackage.AEXCHANGE__OWNING_SCOPE:
        return eInternalContainer().eInverseRemove(this, ApaPackage.ASCOPE__EXCHANGES, AScope.class, msgs);
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
      case ApaPackage.AEXCHANGE__OWNING_SCOPE:
        return getOwningScope();
      case ApaPackage.AEXCHANGE__SOURCE:
        if (resolve) return getSource();
        return basicGetSource();
      case ApaPackage.AEXCHANGE__TARGET:
        if (resolve) return getTarget();
        return basicGetTarget();
    }
    return super.eGet(featureID, resolve, coreType);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public void eSet(int featureID, Object newValue) {
    switch (featureID) {
      case ApaPackage.AEXCHANGE__OWNING_SCOPE:
        setOwningScope((AScope)newValue);
        return;
      case ApaPackage.AEXCHANGE__SOURCE:
        setSource((AFunction)newValue);
        return;
      case ApaPackage.AEXCHANGE__TARGET:
        setTarget((AFunction)newValue);
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
      case ApaPackage.AEXCHANGE__OWNING_SCOPE:
        setOwningScope((AScope)null);
        return;
      case ApaPackage.AEXCHANGE__SOURCE:
        setSource((AFunction)null);
        return;
      case ApaPackage.AEXCHANGE__TARGET:
        setTarget((AFunction)null);
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
      case ApaPackage.AEXCHANGE__OWNING_SCOPE:
        return getOwningScope() != null;
      case ApaPackage.AEXCHANGE__SOURCE:
        return source != null;
      case ApaPackage.AEXCHANGE__TARGET:
        return target != null;
    }
    return super.eIsSet(featureID);
  }

} //AExchangeImpl
