/**
 */
package org.polarsys.capella.cdoxml.ta.genchain.connectorextension.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.polarsys.capella.cdoxml.ta.genchain.connectorextension.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ConnectorExtensionFactoryImpl extends EFactoryImpl implements ConnectorExtensionFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ConnectorExtensionFactory init() {
		try {
			ConnectorExtensionFactory theConnectorExtensionFactory = (ConnectorExtensionFactory)EPackage.Registry.INSTANCE.getEFactory(ConnectorExtensionPackage.eNS_URI);
			if (theConnectorExtensionFactory != null) {
				return theConnectorExtensionFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ConnectorExtensionFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectorExtensionFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ConnectorExtensionPackage.CONNECTOR_GENERATION: return createConnectorGeneration();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ConnectorGeneration createConnectorGeneration() {
		ConnectorGenerationImpl connectorGeneration = new ConnectorGenerationImpl();
		return connectorGeneration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ConnectorExtensionPackage getConnectorExtensionPackage() {
		return (ConnectorExtensionPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ConnectorExtensionPackage getPackage() {
		return ConnectorExtensionPackage.eINSTANCE;
	}

} //ConnectorExtensionFactoryImpl
