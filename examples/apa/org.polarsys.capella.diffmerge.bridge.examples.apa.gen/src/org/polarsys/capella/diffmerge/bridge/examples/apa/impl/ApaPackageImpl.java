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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.polarsys.capella.diffmerge.bridge.examples.apa.ABehavior;
import org.polarsys.capella.diffmerge.bridge.examples.apa.AExchange;
import org.polarsys.capella.diffmerge.bridge.examples.apa.AFunction;
import org.polarsys.capella.diffmerge.bridge.examples.apa.ANamedElement;
import org.polarsys.capella.diffmerge.bridge.examples.apa.ANode;
import org.polarsys.capella.diffmerge.bridge.examples.apa.AScope;
import org.polarsys.capella.diffmerge.bridge.examples.apa.ApaFactory;
import org.polarsys.capella.diffmerge.bridge.examples.apa.ApaPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ApaPackageImpl extends EPackageImpl implements ApaPackage {
	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass aNamedElementEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass aScopeEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass aNodeEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass aBehaviorEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass aFunctionEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass aExchangeEClass = null;

	/**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see org.polarsys.capella.diffmerge.bridge.examples.apa.ApaPackage#eNS_URI
   * @see #init()
   * @generated
   */
	private ApaPackageImpl() {
    super(eNS_URI, ApaFactory.eINSTANCE);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private static boolean isInited = false;

	/**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   * 
   * <p>This method is used to initialize {@link ApaPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
	public static ApaPackage init() {
    if (isInited) return (ApaPackage)EPackage.Registry.INSTANCE.getEPackage(ApaPackage.eNS_URI);

    // Obtain or create and register package
    ApaPackageImpl theApaPackage = (ApaPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ApaPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ApaPackageImpl());

    isInited = true;

    // Create package meta-data objects
    theApaPackage.createPackageContents();

    // Initialize created meta-data
    theApaPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theApaPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(ApaPackage.eNS_URI, theApaPackage);
    return theApaPackage;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getANamedElement() {
    return aNamedElementEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EAttribute getANamedElement_Id() {
    return (EAttribute)aNamedElementEClass.getEStructuralFeatures().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EAttribute getANamedElement_Name() {
    return (EAttribute)aNamedElementEClass.getEStructuralFeatures().get(1);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getAScope() {
    return aScopeEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EReference getAScope_Nodes() {
    return (EReference)aScopeEClass.getEStructuralFeatures().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EReference getAScope_Exchanges() {
    return (EReference)aScopeEClass.getEStructuralFeatures().get(1);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getANode() {
    return aNodeEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EReference getANode_OwningScope() {
    return (EReference)aNodeEClass.getEStructuralFeatures().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EReference getANode_Behaviors() {
    return (EReference)aNodeEClass.getEStructuralFeatures().get(1);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getABehavior() {
    return aBehaviorEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EReference getABehavior_OwningNode() {
    return (EReference)aBehaviorEClass.getEStructuralFeatures().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EReference getABehavior_Functions() {
    return (EReference)aBehaviorEClass.getEStructuralFeatures().get(1);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getAFunction() {
    return aFunctionEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EReference getAFunction_OwningBehavior() {
    return (EReference)aFunctionEClass.getEStructuralFeatures().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EReference getAFunction_Incoming() {
    return (EReference)aFunctionEClass.getEStructuralFeatures().get(1);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EReference getAFunction_Outgoing() {
    return (EReference)aFunctionEClass.getEStructuralFeatures().get(2);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getAExchange() {
    return aExchangeEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EReference getAExchange_OwningScope() {
    return (EReference)aExchangeEClass.getEStructuralFeatures().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EReference getAExchange_Source() {
    return (EReference)aExchangeEClass.getEStructuralFeatures().get(1);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EReference getAExchange_Target() {
    return (EReference)aExchangeEClass.getEStructuralFeatures().get(2);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public ApaFactory getApaFactory() {
    return (ApaFactory)getEFactoryInstance();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private boolean isCreated = false;

	/**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void createPackageContents() {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    aNamedElementEClass = createEClass(ANAMED_ELEMENT);
    createEAttribute(aNamedElementEClass, ANAMED_ELEMENT__ID);
    createEAttribute(aNamedElementEClass, ANAMED_ELEMENT__NAME);

    aScopeEClass = createEClass(ASCOPE);
    createEReference(aScopeEClass, ASCOPE__NODES);
    createEReference(aScopeEClass, ASCOPE__EXCHANGES);

    aNodeEClass = createEClass(ANODE);
    createEReference(aNodeEClass, ANODE__OWNING_SCOPE);
    createEReference(aNodeEClass, ANODE__BEHAVIORS);

    aBehaviorEClass = createEClass(ABEHAVIOR);
    createEReference(aBehaviorEClass, ABEHAVIOR__OWNING_NODE);
    createEReference(aBehaviorEClass, ABEHAVIOR__FUNCTIONS);

    aFunctionEClass = createEClass(AFUNCTION);
    createEReference(aFunctionEClass, AFUNCTION__OWNING_BEHAVIOR);
    createEReference(aFunctionEClass, AFUNCTION__INCOMING);
    createEReference(aFunctionEClass, AFUNCTION__OUTGOING);

    aExchangeEClass = createEClass(AEXCHANGE);
    createEReference(aExchangeEClass, AEXCHANGE__OWNING_SCOPE);
    createEReference(aExchangeEClass, AEXCHANGE__SOURCE);
    createEReference(aExchangeEClass, AEXCHANGE__TARGET);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private boolean isInitialized = false;

	/**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void initializePackageContents() {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    aScopeEClass.getESuperTypes().add(this.getANamedElement());
    aNodeEClass.getESuperTypes().add(this.getANamedElement());
    aBehaviorEClass.getESuperTypes().add(this.getANamedElement());
    aFunctionEClass.getESuperTypes().add(this.getANamedElement());
    aExchangeEClass.getESuperTypes().add(this.getANamedElement());

    // Initialize classes, features, and operations; add parameters
    initEClass(aNamedElementEClass, ANamedElement.class, "ANamedElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getANamedElement_Id(), ecorePackage.getEString(), "id", null, 1, 1, ANamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getANamedElement_Name(), ecorePackage.getEString(), "name", null, 1, 1, ANamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(aScopeEClass, AScope.class, "AScope", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAScope_Nodes(), this.getANode(), this.getANode_OwningScope(), "nodes", null, 0, -1, AScope.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAScope_Exchanges(), this.getAExchange(), this.getAExchange_OwningScope(), "exchanges", null, 0, -1, AScope.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(aNodeEClass, ANode.class, "ANode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getANode_OwningScope(), this.getAScope(), this.getAScope_Nodes(), "owningScope", null, 1, 1, ANode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getANode_Behaviors(), this.getABehavior(), this.getABehavior_OwningNode(), "behaviors", null, 0, -1, ANode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(aBehaviorEClass, ABehavior.class, "ABehavior", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getABehavior_OwningNode(), this.getANode(), this.getANode_Behaviors(), "owningNode", null, 1, 1, ABehavior.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getABehavior_Functions(), this.getAFunction(), this.getAFunction_OwningBehavior(), "functions", null, 0, -1, ABehavior.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(aFunctionEClass, AFunction.class, "AFunction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAFunction_OwningBehavior(), this.getABehavior(), this.getABehavior_Functions(), "owningBehavior", null, 1, 1, AFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAFunction_Incoming(), this.getAExchange(), this.getAExchange_Target(), "incoming", null, 0, -1, AFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAFunction_Outgoing(), this.getAExchange(), this.getAExchange_Source(), "outgoing", null, 0, -1, AFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(aExchangeEClass, AExchange.class, "AExchange", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAExchange_OwningScope(), this.getAScope(), this.getAScope_Exchanges(), "owningScope", null, 1, 1, AExchange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAExchange_Source(), this.getAFunction(), this.getAFunction_Outgoing(), "source", null, 1, 1, AExchange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAExchange_Target(), this.getAFunction(), this.getAFunction_Incoming(), "target", null, 1, 1, AExchange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //ApaPackageImpl
