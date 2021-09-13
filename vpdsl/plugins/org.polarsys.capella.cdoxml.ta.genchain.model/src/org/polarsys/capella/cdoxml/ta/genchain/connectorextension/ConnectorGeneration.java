/**
 */
package org.polarsys.capella.cdoxml.ta.genchain.connectorextension;

import org.eclipse.egf.portfolio.genchain.generationChain.EcoreElement;
import org.eclipse.egf.portfolio.genchain.generationChain.PluginProvider;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Connector Generation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.capella.cdoxml.ta.genchain.connectorextension.ConnectorGeneration#isAddConnectorEAnnotations <em>Add Connector EAnnotations</em>}</li>
 * </ul>
 *
 * @see org.polarsys.capella.cdoxml.ta.genchain.connectorextension.ConnectorExtensionPackage#getConnectorGeneration()
 * @model
 * @generated
 */
public interface ConnectorGeneration extends EcoreElement, PluginProvider {
	/**
	 * Returns the value of the '<em><b>Add Connector EAnnotations</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Add Connector EAnnotations</em>' attribute.
	 * @see #setAddConnectorEAnnotations(boolean)
	 * @see org.polarsys.capella.cdoxml.ta.genchain.connectorextension.ConnectorExtensionPackage#getConnectorGeneration_AddConnectorEAnnotations()
	 * @model default="false"
	 * @generated
	 */
	boolean isAddConnectorEAnnotations();

	/**
	 * Sets the value of the '{@link org.polarsys.capella.cdoxml.ta.genchain.connectorextension.ConnectorGeneration#isAddConnectorEAnnotations <em>Add Connector EAnnotations</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Add Connector EAnnotations</em>' attribute.
	 * @see #isAddConnectorEAnnotations()
	 * @generated
	 */
	void setAddConnectorEAnnotations(boolean value);

} // ConnectorGeneration
