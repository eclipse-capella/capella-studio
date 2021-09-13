/**
 */
package org.polarsys.capella.cdoxml.ta.genchain.connectorextension.impl;

import org.eclipse.egf.portfolio.genchain.generationChain.GenerationChainPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.polarsys.capella.cdoxml.ta.genchain.connectorextension.ConnectorExtensionFactory;
import org.polarsys.capella.cdoxml.ta.genchain.connectorextension.ConnectorExtensionPackage;
import org.polarsys.capella.cdoxml.ta.genchain.connectorextension.ConnectorGeneration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ConnectorExtensionPackageImpl extends EPackageImpl implements ConnectorExtensionPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass connectorGenerationEClass = null;

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
	 * @see org.polarsys.capella.cdoxml.ta.genchain.connectorextension.ConnectorExtensionPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ConnectorExtensionPackageImpl() {
		super(eNS_URI, ConnectorExtensionFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ConnectorExtensionPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ConnectorExtensionPackage init() {
		if (isInited) return (ConnectorExtensionPackage)EPackage.Registry.INSTANCE.getEPackage(ConnectorExtensionPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredConnectorExtensionPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		ConnectorExtensionPackageImpl theConnectorExtensionPackage = registeredConnectorExtensionPackage instanceof ConnectorExtensionPackageImpl ? (ConnectorExtensionPackageImpl)registeredConnectorExtensionPackage : new ConnectorExtensionPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		GenerationChainPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theConnectorExtensionPackage.createPackageContents();

		// Initialize created meta-data
		theConnectorExtensionPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theConnectorExtensionPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ConnectorExtensionPackage.eNS_URI, theConnectorExtensionPackage);
		return theConnectorExtensionPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getConnectorGeneration() {
		return connectorGenerationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getConnectorGeneration_AddConnectorEAnnotations() {
		return (EAttribute)connectorGenerationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ConnectorExtensionFactory getConnectorExtensionFactory() {
		return (ConnectorExtensionFactory)getEFactoryInstance();
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
		connectorGenerationEClass = createEClass(CONNECTOR_GENERATION);
		createEAttribute(connectorGenerationEClass, CONNECTOR_GENERATION__ADD_CONNECTOR_EANNOTATIONS);
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

		// Obtain other dependent packages
		GenerationChainPackage theGenerationChainPackage = (GenerationChainPackage)EPackage.Registry.INSTANCE.getEPackage(GenerationChainPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		connectorGenerationEClass.getESuperTypes().add(theGenerationChainPackage.getEcoreElement());
		connectorGenerationEClass.getESuperTypes().add(theGenerationChainPackage.getPluginProvider());

		// Initialize classes and features; add operations and parameters
		initEClass(connectorGenerationEClass, ConnectorGeneration.class, "ConnectorGeneration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConnectorGeneration_AddConnectorEAnnotations(), ecorePackage.getEBoolean(), "addConnectorEAnnotations", "false", 0, 1, ConnectorGeneration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //ConnectorExtensionPackageImpl
