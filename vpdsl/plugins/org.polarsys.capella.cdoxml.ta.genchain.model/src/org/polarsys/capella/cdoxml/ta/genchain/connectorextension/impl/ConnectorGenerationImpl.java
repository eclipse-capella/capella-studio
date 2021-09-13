/**
 */
package org.polarsys.capella.cdoxml.ta.genchain.connectorextension.impl;

import org.eclipse.egf.portfolio.genchain.generationChain.impl.EcoreElementImpl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.polarsys.capella.cdoxml.ta.genchain.connectorextension.ConnectorExtensionPackage;
import org.polarsys.capella.cdoxml.ta.genchain.connectorextension.ConnectorGeneration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Connector Generation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.capella.cdoxml.ta.genchain.connectorextension.impl.ConnectorGenerationImpl#isAddConnectorEAnnotations <em>Add Connector EAnnotations</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConnectorGenerationImpl extends EcoreElementImpl implements ConnectorGeneration {
	/**
	 * The default value of the '{@link #isAddConnectorEAnnotations() <em>Add Connector EAnnotations</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAddConnectorEAnnotations()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ADD_CONNECTOR_EANNOTATIONS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAddConnectorEAnnotations() <em>Add Connector EAnnotations</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAddConnectorEAnnotations()
	 * @generated
	 * @ordered
	 */
	protected boolean addConnectorEAnnotations = ADD_CONNECTOR_EANNOTATIONS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConnectorGenerationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConnectorExtensionPackage.Literals.CONNECTOR_GENERATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isAddConnectorEAnnotations() {
		return addConnectorEAnnotations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAddConnectorEAnnotations(boolean newAddConnectorEAnnotations) {
		boolean oldAddConnectorEAnnotations = addConnectorEAnnotations;
		addConnectorEAnnotations = newAddConnectorEAnnotations;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConnectorExtensionPackage.CONNECTOR_GENERATION__ADD_CONNECTOR_EANNOTATIONS, oldAddConnectorEAnnotations, addConnectorEAnnotations));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<String> getPluginNames(EList<EObject> domains) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConnectorExtensionPackage.CONNECTOR_GENERATION__ADD_CONNECTOR_EANNOTATIONS:
				return isAddConnectorEAnnotations();
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
			case ConnectorExtensionPackage.CONNECTOR_GENERATION__ADD_CONNECTOR_EANNOTATIONS:
				setAddConnectorEAnnotations((Boolean)newValue);
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
			case ConnectorExtensionPackage.CONNECTOR_GENERATION__ADD_CONNECTOR_EANNOTATIONS:
				setAddConnectorEAnnotations(ADD_CONNECTOR_EANNOTATIONS_EDEFAULT);
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
			case ConnectorExtensionPackage.CONNECTOR_GENERATION__ADD_CONNECTOR_EANNOTATIONS:
				return addConnectorEAnnotations != ADD_CONNECTOR_EANNOTATIONS_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (addConnectorEAnnotations: ");
		result.append(addConnectorEAnnotations);
		result.append(')');
		return result.toString();
	}

} //ConnectorGenerationImpl
