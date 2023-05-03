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
package org.polarsys.capella.diffmerge.bridge.examples.apa.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.polarsys.capella.diffmerge.bridge.examples.apa.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.polarsys.capella.diffmerge.bridge.examples.apa.ApaPackage
 * @generated
 */
public class ApaSwitch<T> extends Switch<T> {
	/**
   * The cached model package
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected static ApaPackage modelPackage;

	/**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public ApaSwitch() {
    if (modelPackage == null) {
      modelPackage = ApaPackage.eINSTANCE;
    }
  }

	/**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage) {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
	@Override
  protected T doSwitch(int classifierID, EObject theEObject) {
    switch (classifierID) {
      case ApaPackage.ANAMED_ELEMENT: {
        ANamedElement aNamedElement = (ANamedElement)theEObject;
        T result = caseANamedElement(aNamedElement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ApaPackage.ASCOPE: {
        AScope aScope = (AScope)theEObject;
        T result = caseAScope(aScope);
        if (result == null) result = caseANamedElement(aScope);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ApaPackage.ANODE: {
        ANode aNode = (ANode)theEObject;
        T result = caseANode(aNode);
        if (result == null) result = caseANamedElement(aNode);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ApaPackage.ABEHAVIOR: {
        ABehavior aBehavior = (ABehavior)theEObject;
        T result = caseABehavior(aBehavior);
        if (result == null) result = caseANamedElement(aBehavior);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ApaPackage.AFUNCTION: {
        AFunction aFunction = (AFunction)theEObject;
        T result = caseAFunction(aFunction);
        if (result == null) result = caseANamedElement(aFunction);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ApaPackage.AEXCHANGE: {
        AExchange aExchange = (AExchange)theEObject;
        T result = caseAExchange(aExchange);
        if (result == null) result = caseANamedElement(aExchange);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>ANamed Element</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>ANamed Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseANamedElement(ANamedElement object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>AScope</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>AScope</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseAScope(AScope object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>ANode</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>ANode</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseANode(ANode object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>ABehavior</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>ABehavior</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseABehavior(ABehavior object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>AFunction</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>AFunction</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseAFunction(AFunction object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>AExchange</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>AExchange</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseAExchange(AExchange object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
	@Override
  public T defaultCase(EObject object) {
    return null;
  }

} //ApaSwitch
