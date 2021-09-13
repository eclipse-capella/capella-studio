/**
 */
package org.polarsys.capella.cdoxml.ta.genchain.connectorextension;

import org.eclipse.egf.portfolio.genchain.generationChain.GenerationChainPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

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
 * @see org.polarsys.capella.cdoxml.ta.genchain.connectorextension.ConnectorExtensionFactory
 * @model kind="package"
 * @generated
 */
public interface ConnectorExtensionPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "connectorextension";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.polarsys.org/capella/cdoxml/genchain/extension/connector/1.0.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "connectorextension";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ConnectorExtensionPackage eINSTANCE = org.polarsys.capella.cdoxml.ta.genchain.connectorextension.impl.ConnectorExtensionPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.polarsys.capella.cdoxml.ta.genchain.connectorextension.impl.ConnectorGenerationImpl <em>Connector Generation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.capella.cdoxml.ta.genchain.connectorextension.impl.ConnectorGenerationImpl
	 * @see org.polarsys.capella.cdoxml.ta.genchain.connectorextension.impl.ConnectorExtensionPackageImpl#getConnectorGeneration()
	 * @generated
	 */
	int CONNECTOR_GENERATION = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_GENERATION__NAME = GenerationChainPackage.ECORE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_GENERATION__CONTAINER = GenerationChainPackage.ECORE_ELEMENT__CONTAINER;

	/**
	 * The feature id for the '<em><b>Model Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_GENERATION__MODEL_PATH = GenerationChainPackage.ECORE_ELEMENT__MODEL_PATH;

	/**
	 * The feature id for the '<em><b>Add Connector EAnnotations</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_GENERATION__ADD_CONNECTOR_EANNOTATIONS = GenerationChainPackage.ECORE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Connector Generation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_GENERATION_FEATURE_COUNT = GenerationChainPackage.ECORE_ELEMENT_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link org.polarsys.capella.cdoxml.ta.genchain.connectorextension.ConnectorGeneration <em>Connector Generation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connector Generation</em>'.
	 * @see org.polarsys.capella.cdoxml.ta.genchain.connectorextension.ConnectorGeneration
	 * @generated
	 */
	EClass getConnectorGeneration();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.capella.cdoxml.ta.genchain.connectorextension.ConnectorGeneration#isAddConnectorEAnnotations <em>Add Connector EAnnotations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Add Connector EAnnotations</em>'.
	 * @see org.polarsys.capella.cdoxml.ta.genchain.connectorextension.ConnectorGeneration#isAddConnectorEAnnotations()
	 * @see #getConnectorGeneration()
	 * @generated
	 */
	EAttribute getConnectorGeneration_AddConnectorEAnnotations();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ConnectorExtensionFactory getConnectorExtensionFactory();

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
		 * The meta object literal for the '{@link org.polarsys.capella.cdoxml.ta.genchain.connectorextension.impl.ConnectorGenerationImpl <em>Connector Generation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.capella.cdoxml.ta.genchain.connectorextension.impl.ConnectorGenerationImpl
		 * @see org.polarsys.capella.cdoxml.ta.genchain.connectorextension.impl.ConnectorExtensionPackageImpl#getConnectorGeneration()
		 * @generated
		 */
		EClass CONNECTOR_GENERATION = eINSTANCE.getConnectorGeneration();

		/**
		 * The meta object literal for the '<em><b>Add Connector EAnnotations</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTOR_GENERATION__ADD_CONNECTOR_EANNOTATIONS = eINSTANCE.getConnectorGeneration_AddConnectorEAnnotations();

	}

} //ConnectorExtensionPackage
