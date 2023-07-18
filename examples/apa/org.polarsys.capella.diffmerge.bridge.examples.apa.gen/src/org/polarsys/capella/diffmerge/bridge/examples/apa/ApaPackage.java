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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.polarsys.capella.diffmerge.bridge.examples.apa.ApaFactory
 * @model kind="package"
 * @generated
 */
public interface ApaPackage extends EPackage {
	/**
   * The package name.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	String eNAME = "apa";

	/**
   * The package namespace URI.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	String eNS_URI = "http://www.eclipse.org/emf/diffmerge/bridge/apa/1.0.0";

	/**
   * The package namespace name.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	String eNS_PREFIX = "org.polarsys.capella.diffmerge.bridge.examples.apa.gen";

	/**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	ApaPackage eINSTANCE = org.polarsys.capella.diffmerge.bridge.examples.apa.impl.ApaPackageImpl.init();

	/**
   * The meta object id for the '{@link org.polarsys.capella.diffmerge.bridge.examples.apa.impl.ANamedElementImpl <em>ANamed Element</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.polarsys.capella.diffmerge.bridge.examples.apa.impl.ANamedElementImpl
   * @see org.polarsys.capella.diffmerge.bridge.examples.apa.impl.ApaPackageImpl#getANamedElement()
   * @generated
   */
	int ANAMED_ELEMENT = 0;

	/**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ANAMED_ELEMENT__ID = 0;

	/**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ANAMED_ELEMENT__NAME = 1;

	/**
   * The number of structural features of the '<em>ANamed Element</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ANAMED_ELEMENT_FEATURE_COUNT = 2;

	/**
   * The number of operations of the '<em>ANamed Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANAMED_ELEMENT_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link org.polarsys.capella.diffmerge.bridge.examples.apa.impl.AScopeImpl <em>AScope</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.polarsys.capella.diffmerge.bridge.examples.apa.impl.AScopeImpl
   * @see org.polarsys.capella.diffmerge.bridge.examples.apa.impl.ApaPackageImpl#getAScope()
   * @generated
   */
	int ASCOPE = 1;

	/**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ASCOPE__ID = ANAMED_ELEMENT__ID;

	/**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ASCOPE__NAME = ANAMED_ELEMENT__NAME;

	/**
   * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ASCOPE__NODES = ANAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
   * The feature id for the '<em><b>Exchanges</b></em>' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ASCOPE__EXCHANGES = ANAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
   * The number of structural features of the '<em>AScope</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ASCOPE_FEATURE_COUNT = ANAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
   * The number of operations of the '<em>AScope</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASCOPE_OPERATION_COUNT = ANAMED_ELEMENT_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link org.polarsys.capella.diffmerge.bridge.examples.apa.impl.ANodeImpl <em>ANode</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.polarsys.capella.diffmerge.bridge.examples.apa.impl.ANodeImpl
   * @see org.polarsys.capella.diffmerge.bridge.examples.apa.impl.ApaPackageImpl#getANode()
   * @generated
   */
	int ANODE = 2;

	/**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ANODE__ID = ANAMED_ELEMENT__ID;

	/**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ANODE__NAME = ANAMED_ELEMENT__NAME;

	/**
   * The feature id for the '<em><b>Owning Scope</b></em>' container reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ANODE__OWNING_SCOPE = ANAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
   * The feature id for the '<em><b>Behaviors</b></em>' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ANODE__BEHAVIORS = ANAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
   * The number of structural features of the '<em>ANode</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ANODE_FEATURE_COUNT = ANAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
   * The number of operations of the '<em>ANode</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANODE_OPERATION_COUNT = ANAMED_ELEMENT_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link org.polarsys.capella.diffmerge.bridge.examples.apa.impl.ABehaviorImpl <em>ABehavior</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.polarsys.capella.diffmerge.bridge.examples.apa.impl.ABehaviorImpl
   * @see org.polarsys.capella.diffmerge.bridge.examples.apa.impl.ApaPackageImpl#getABehavior()
   * @generated
   */
	int ABEHAVIOR = 3;

	/**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ABEHAVIOR__ID = ANAMED_ELEMENT__ID;

	/**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ABEHAVIOR__NAME = ANAMED_ELEMENT__NAME;

	/**
   * The feature id for the '<em><b>Owning Node</b></em>' container reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ABEHAVIOR__OWNING_NODE = ANAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
   * The feature id for the '<em><b>Functions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ABEHAVIOR__FUNCTIONS = ANAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
   * The number of structural features of the '<em>ABehavior</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ABEHAVIOR_FEATURE_COUNT = ANAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
   * The number of operations of the '<em>ABehavior</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABEHAVIOR_OPERATION_COUNT = ANAMED_ELEMENT_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link org.polarsys.capella.diffmerge.bridge.examples.apa.impl.AFunctionImpl <em>AFunction</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.polarsys.capella.diffmerge.bridge.examples.apa.impl.AFunctionImpl
   * @see org.polarsys.capella.diffmerge.bridge.examples.apa.impl.ApaPackageImpl#getAFunction()
   * @generated
   */
	int AFUNCTION = 4;

	/**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int AFUNCTION__ID = ANAMED_ELEMENT__ID;

	/**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int AFUNCTION__NAME = ANAMED_ELEMENT__NAME;

	/**
   * The feature id for the '<em><b>Owning Behavior</b></em>' container reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int AFUNCTION__OWNING_BEHAVIOR = ANAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
   * The feature id for the '<em><b>Incoming</b></em>' reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int AFUNCTION__INCOMING = ANAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
   * The feature id for the '<em><b>Outgoing</b></em>' reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int AFUNCTION__OUTGOING = ANAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
   * The number of structural features of the '<em>AFunction</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int AFUNCTION_FEATURE_COUNT = ANAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
   * The number of operations of the '<em>AFunction</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AFUNCTION_OPERATION_COUNT = ANAMED_ELEMENT_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link org.polarsys.capella.diffmerge.bridge.examples.apa.impl.AExchangeImpl <em>AExchange</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.polarsys.capella.diffmerge.bridge.examples.apa.impl.AExchangeImpl
   * @see org.polarsys.capella.diffmerge.bridge.examples.apa.impl.ApaPackageImpl#getAExchange()
   * @generated
   */
	int AEXCHANGE = 5;

	/**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int AEXCHANGE__ID = ANAMED_ELEMENT__ID;

	/**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int AEXCHANGE__NAME = ANAMED_ELEMENT__NAME;

	/**
   * The feature id for the '<em><b>Owning Scope</b></em>' container reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int AEXCHANGE__OWNING_SCOPE = ANAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
   * The feature id for the '<em><b>Source</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int AEXCHANGE__SOURCE = ANAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
   * The feature id for the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int AEXCHANGE__TARGET = ANAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
   * The number of structural features of the '<em>AExchange</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int AEXCHANGE_FEATURE_COUNT = ANAMED_ELEMENT_FEATURE_COUNT + 3;


	/**
   * The number of operations of the '<em>AExchange</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AEXCHANGE_OPERATION_COUNT = ANAMED_ELEMENT_OPERATION_COUNT + 0;


  /**
   * Returns the meta object for class '{@link org.polarsys.capella.diffmerge.bridge.examples.apa.ANamedElement <em>ANamed Element</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>ANamed Element</em>'.
   * @see org.polarsys.capella.diffmerge.bridge.examples.apa.ANamedElement
   * @generated
   */
	EClass getANamedElement();

	/**
   * Returns the meta object for the attribute '{@link org.polarsys.capella.diffmerge.bridge.examples.apa.ANamedElement#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Id</em>'.
   * @see org.polarsys.capella.diffmerge.bridge.examples.apa.ANamedElement#getId()
   * @see #getANamedElement()
   * @generated
   */
	EAttribute getANamedElement_Id();

	/**
   * Returns the meta object for the attribute '{@link org.polarsys.capella.diffmerge.bridge.examples.apa.ANamedElement#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.polarsys.capella.diffmerge.bridge.examples.apa.ANamedElement#getName()
   * @see #getANamedElement()
   * @generated
   */
	EAttribute getANamedElement_Name();

	/**
   * Returns the meta object for class '{@link org.polarsys.capella.diffmerge.bridge.examples.apa.AScope <em>AScope</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>AScope</em>'.
   * @see org.polarsys.capella.diffmerge.bridge.examples.apa.AScope
   * @generated
   */
	EClass getAScope();

	/**
   * Returns the meta object for the containment reference list '{@link org.polarsys.capella.diffmerge.bridge.examples.apa.AScope#getNodes <em>Nodes</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Nodes</em>'.
   * @see org.polarsys.capella.diffmerge.bridge.examples.apa.AScope#getNodes()
   * @see #getAScope()
   * @generated
   */
	EReference getAScope_Nodes();

	/**
   * Returns the meta object for the containment reference list '{@link org.polarsys.capella.diffmerge.bridge.examples.apa.AScope#getExchanges <em>Exchanges</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Exchanges</em>'.
   * @see org.polarsys.capella.diffmerge.bridge.examples.apa.AScope#getExchanges()
   * @see #getAScope()
   * @generated
   */
	EReference getAScope_Exchanges();

	/**
   * Returns the meta object for class '{@link org.polarsys.capella.diffmerge.bridge.examples.apa.ANode <em>ANode</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>ANode</em>'.
   * @see org.polarsys.capella.diffmerge.bridge.examples.apa.ANode
   * @generated
   */
	EClass getANode();

	/**
   * Returns the meta object for the container reference '{@link org.polarsys.capella.diffmerge.bridge.examples.apa.ANode#getOwningScope <em>Owning Scope</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Owning Scope</em>'.
   * @see org.polarsys.capella.diffmerge.bridge.examples.apa.ANode#getOwningScope()
   * @see #getANode()
   * @generated
   */
	EReference getANode_OwningScope();

	/**
   * Returns the meta object for the containment reference list '{@link org.polarsys.capella.diffmerge.bridge.examples.apa.ANode#getBehaviors <em>Behaviors</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Behaviors</em>'.
   * @see org.polarsys.capella.diffmerge.bridge.examples.apa.ANode#getBehaviors()
   * @see #getANode()
   * @generated
   */
	EReference getANode_Behaviors();

	/**
   * Returns the meta object for class '{@link org.polarsys.capella.diffmerge.bridge.examples.apa.ABehavior <em>ABehavior</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>ABehavior</em>'.
   * @see org.polarsys.capella.diffmerge.bridge.examples.apa.ABehavior
   * @generated
   */
	EClass getABehavior();

	/**
   * Returns the meta object for the container reference '{@link org.polarsys.capella.diffmerge.bridge.examples.apa.ABehavior#getOwningNode <em>Owning Node</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Owning Node</em>'.
   * @see org.polarsys.capella.diffmerge.bridge.examples.apa.ABehavior#getOwningNode()
   * @see #getABehavior()
   * @generated
   */
	EReference getABehavior_OwningNode();

	/**
   * Returns the meta object for the containment reference list '{@link org.polarsys.capella.diffmerge.bridge.examples.apa.ABehavior#getFunctions <em>Functions</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Functions</em>'.
   * @see org.polarsys.capella.diffmerge.bridge.examples.apa.ABehavior#getFunctions()
   * @see #getABehavior()
   * @generated
   */
	EReference getABehavior_Functions();

	/**
   * Returns the meta object for class '{@link org.polarsys.capella.diffmerge.bridge.examples.apa.AFunction <em>AFunction</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>AFunction</em>'.
   * @see org.polarsys.capella.diffmerge.bridge.examples.apa.AFunction
   * @generated
   */
	EClass getAFunction();

	/**
   * Returns the meta object for the container reference '{@link org.polarsys.capella.diffmerge.bridge.examples.apa.AFunction#getOwningBehavior <em>Owning Behavior</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Owning Behavior</em>'.
   * @see org.polarsys.capella.diffmerge.bridge.examples.apa.AFunction#getOwningBehavior()
   * @see #getAFunction()
   * @generated
   */
	EReference getAFunction_OwningBehavior();

	/**
   * Returns the meta object for the reference list '{@link org.polarsys.capella.diffmerge.bridge.examples.apa.AFunction#getIncoming <em>Incoming</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Incoming</em>'.
   * @see org.polarsys.capella.diffmerge.bridge.examples.apa.AFunction#getIncoming()
   * @see #getAFunction()
   * @generated
   */
	EReference getAFunction_Incoming();

	/**
   * Returns the meta object for the reference list '{@link org.polarsys.capella.diffmerge.bridge.examples.apa.AFunction#getOutgoing <em>Outgoing</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Outgoing</em>'.
   * @see org.polarsys.capella.diffmerge.bridge.examples.apa.AFunction#getOutgoing()
   * @see #getAFunction()
   * @generated
   */
	EReference getAFunction_Outgoing();

	/**
   * Returns the meta object for class '{@link org.polarsys.capella.diffmerge.bridge.examples.apa.AExchange <em>AExchange</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>AExchange</em>'.
   * @see org.polarsys.capella.diffmerge.bridge.examples.apa.AExchange
   * @generated
   */
	EClass getAExchange();

	/**
   * Returns the meta object for the container reference '{@link org.polarsys.capella.diffmerge.bridge.examples.apa.AExchange#getOwningScope <em>Owning Scope</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Owning Scope</em>'.
   * @see org.polarsys.capella.diffmerge.bridge.examples.apa.AExchange#getOwningScope()
   * @see #getAExchange()
   * @generated
   */
	EReference getAExchange_OwningScope();

	/**
   * Returns the meta object for the reference '{@link org.polarsys.capella.diffmerge.bridge.examples.apa.AExchange#getSource <em>Source</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Source</em>'.
   * @see org.polarsys.capella.diffmerge.bridge.examples.apa.AExchange#getSource()
   * @see #getAExchange()
   * @generated
   */
	EReference getAExchange_Source();

	/**
   * Returns the meta object for the reference '{@link org.polarsys.capella.diffmerge.bridge.examples.apa.AExchange#getTarget <em>Target</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Target</em>'.
   * @see org.polarsys.capella.diffmerge.bridge.examples.apa.AExchange#getTarget()
   * @see #getAExchange()
   * @generated
   */
	EReference getAExchange_Target();

	/**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
	ApaFactory getApaFactory();

	/**
   * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
   * @generated
   */
	interface Literals {
		/**
     * The meta object literal for the '{@link org.polarsys.capella.diffmerge.bridge.examples.apa.impl.ANamedElementImpl <em>ANamed Element</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.polarsys.capella.diffmerge.bridge.examples.apa.impl.ANamedElementImpl
     * @see org.polarsys.capella.diffmerge.bridge.examples.apa.impl.ApaPackageImpl#getANamedElement()
     * @generated
     */
		EClass ANAMED_ELEMENT = eINSTANCE.getANamedElement();

		/**
     * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EAttribute ANAMED_ELEMENT__ID = eINSTANCE.getANamedElement_Id();

		/**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EAttribute ANAMED_ELEMENT__NAME = eINSTANCE.getANamedElement_Name();

		/**
     * The meta object literal for the '{@link org.polarsys.capella.diffmerge.bridge.examples.apa.impl.AScopeImpl <em>AScope</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.polarsys.capella.diffmerge.bridge.examples.apa.impl.AScopeImpl
     * @see org.polarsys.capella.diffmerge.bridge.examples.apa.impl.ApaPackageImpl#getAScope()
     * @generated
     */
		EClass ASCOPE = eINSTANCE.getAScope();

		/**
     * The meta object literal for the '<em><b>Nodes</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference ASCOPE__NODES = eINSTANCE.getAScope_Nodes();

		/**
     * The meta object literal for the '<em><b>Exchanges</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference ASCOPE__EXCHANGES = eINSTANCE.getAScope_Exchanges();

		/**
     * The meta object literal for the '{@link org.polarsys.capella.diffmerge.bridge.examples.apa.impl.ANodeImpl <em>ANode</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.polarsys.capella.diffmerge.bridge.examples.apa.impl.ANodeImpl
     * @see org.polarsys.capella.diffmerge.bridge.examples.apa.impl.ApaPackageImpl#getANode()
     * @generated
     */
		EClass ANODE = eINSTANCE.getANode();

		/**
     * The meta object literal for the '<em><b>Owning Scope</b></em>' container reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference ANODE__OWNING_SCOPE = eINSTANCE.getANode_OwningScope();

		/**
     * The meta object literal for the '<em><b>Behaviors</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference ANODE__BEHAVIORS = eINSTANCE.getANode_Behaviors();

		/**
     * The meta object literal for the '{@link org.polarsys.capella.diffmerge.bridge.examples.apa.impl.ABehaviorImpl <em>ABehavior</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.polarsys.capella.diffmerge.bridge.examples.apa.impl.ABehaviorImpl
     * @see org.polarsys.capella.diffmerge.bridge.examples.apa.impl.ApaPackageImpl#getABehavior()
     * @generated
     */
		EClass ABEHAVIOR = eINSTANCE.getABehavior();

		/**
     * The meta object literal for the '<em><b>Owning Node</b></em>' container reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference ABEHAVIOR__OWNING_NODE = eINSTANCE.getABehavior_OwningNode();

		/**
     * The meta object literal for the '<em><b>Functions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference ABEHAVIOR__FUNCTIONS = eINSTANCE.getABehavior_Functions();

		/**
     * The meta object literal for the '{@link org.polarsys.capella.diffmerge.bridge.examples.apa.impl.AFunctionImpl <em>AFunction</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.polarsys.capella.diffmerge.bridge.examples.apa.impl.AFunctionImpl
     * @see org.polarsys.capella.diffmerge.bridge.examples.apa.impl.ApaPackageImpl#getAFunction()
     * @generated
     */
		EClass AFUNCTION = eINSTANCE.getAFunction();

		/**
     * The meta object literal for the '<em><b>Owning Behavior</b></em>' container reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference AFUNCTION__OWNING_BEHAVIOR = eINSTANCE.getAFunction_OwningBehavior();

		/**
     * The meta object literal for the '<em><b>Incoming</b></em>' reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference AFUNCTION__INCOMING = eINSTANCE.getAFunction_Incoming();

		/**
     * The meta object literal for the '<em><b>Outgoing</b></em>' reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference AFUNCTION__OUTGOING = eINSTANCE.getAFunction_Outgoing();

		/**
     * The meta object literal for the '{@link org.polarsys.capella.diffmerge.bridge.examples.apa.impl.AExchangeImpl <em>AExchange</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.polarsys.capella.diffmerge.bridge.examples.apa.impl.AExchangeImpl
     * @see org.polarsys.capella.diffmerge.bridge.examples.apa.impl.ApaPackageImpl#getAExchange()
     * @generated
     */
		EClass AEXCHANGE = eINSTANCE.getAExchange();

		/**
     * The meta object literal for the '<em><b>Owning Scope</b></em>' container reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference AEXCHANGE__OWNING_SCOPE = eINSTANCE.getAExchange_OwningScope();

		/**
     * The meta object literal for the '<em><b>Source</b></em>' reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference AEXCHANGE__SOURCE = eINSTANCE.getAExchange_Source();

		/**
     * The meta object literal for the '<em><b>Target</b></em>' reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference AEXCHANGE__TARGET = eINSTANCE.getAExchange_Target();

	}

} //ApaPackage
