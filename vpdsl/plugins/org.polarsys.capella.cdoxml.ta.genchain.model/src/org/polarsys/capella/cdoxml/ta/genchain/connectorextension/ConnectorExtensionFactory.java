/**
 */
package org.polarsys.capella.cdoxml.ta.genchain.connectorextension;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.polarsys.capella.cdoxml.ta.genchain.connectorextension.ConnectorExtensionPackage
 * @generated
 */
public interface ConnectorExtensionFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ConnectorExtensionFactory eINSTANCE = org.polarsys.capella.cdoxml.ta.genchain.connectorextension.impl.ConnectorExtensionFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Connector Generation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Connector Generation</em>'.
	 * @generated
	 */
	ConnectorGeneration createConnectorGeneration();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ConnectorExtensionPackage getConnectorExtensionPackage();

} //ConnectorExtensionFactory
