/**
 * Copyright (c) 2015, 2020 Thales Global Services S.A.S.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 *   
 * Contributors:
 *   Thales Global Services S.A.S - initial API and implementation
 * 
 *
 * $Id$
 */

package org.polarsys.capella.extension.genchain.capellaextension.util;

import org.eclipse.egf.portfolio.genchain.cdo.cdoExtension.CdoGeneration;
import org.eclipse.egf.portfolio.genchain.generationChain.EcoreElement;
import org.eclipse.egf.portfolio.genchain.generationChain.EmfGeneration;
import org.eclipse.egf.portfolio.genchain.generationChain.GenerationElement;
import org.eclipse.egf.portfolio.genchain.generationChain.PluginProvider;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.polarsys.capella.extension.genchain.capellaextension.*;

import org.polarsys.kitalpha.emde.genchain.extension.model.EmdeCdoGeneration;
import org.polarsys.kitalpha.emde.genchain.extension.model.EmdeGeneration;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.polarsys.capella.extension.genchain.capellaextension.CapellaExtensionPackage
 * @generated
 */
public class CapellaExtensionAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static CapellaExtensionPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CapellaExtensionAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = CapellaExtensionPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CapellaExtensionSwitch<Adapter> modelSwitch =
		new CapellaExtensionSwitch<Adapter>() {
			@Override
			public Adapter caseCapellaEmfGeneration(CapellaEmfGeneration object) {
				return createCapellaEmfGenerationAdapter();
			}
			@Override
			public Adapter caseCapellaCdoEmfGeneration(CapellaCdoEmfGeneration object) {
				return createCapellaCdoEmfGenerationAdapter();
			}
			@Override
			public Adapter caseGenerationElement(GenerationElement object) {
				return createGenerationElementAdapter();
			}
			@Override
			public Adapter caseEcoreElement(EcoreElement object) {
				return createEcoreElementAdapter();
			}
			@Override
			public Adapter casePluginProvider(PluginProvider object) {
				return createPluginProviderAdapter();
			}
			@Override
			public Adapter caseEmfGeneration(EmfGeneration object) {
				return createEmfGenerationAdapter();
			}
			@Override
			public Adapter caseEmdeGeneration(EmdeGeneration object) {
				return createEmdeGenerationAdapter();
			}
			@Override
			public Adapter caseCdoGeneration(CdoGeneration object) {
				return createCdoGenerationAdapter();
			}
			@Override
			public Adapter caseEmdeCdoGeneration(EmdeCdoGeneration object) {
				return createEmdeCdoGenerationAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.capella.extension.genchain.capellaextension.CapellaEmfGeneration <em>Capella Emf Generation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.capella.extension.genchain.capellaextension.CapellaEmfGeneration
	 * @generated
	 */
	public Adapter createCapellaEmfGenerationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.capella.extension.genchain.capellaextension.CapellaCdoEmfGeneration <em>Capella Cdo Emf Generation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.capella.extension.genchain.capellaextension.CapellaCdoEmfGeneration
	 * @generated
	 */
	public Adapter createCapellaCdoEmfGenerationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.egf.portfolio.genchain.generationChain.GenerationElement <em>Generation Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.egf.portfolio.genchain.generationChain.GenerationElement
	 * @generated
	 */
	public Adapter createGenerationElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.egf.portfolio.genchain.generationChain.EcoreElement <em>Ecore Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.egf.portfolio.genchain.generationChain.EcoreElement
	 * @generated
	 */
	public Adapter createEcoreElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.egf.portfolio.genchain.generationChain.PluginProvider <em>Plugin Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.egf.portfolio.genchain.generationChain.PluginProvider
	 * @generated
	 */
	public Adapter createPluginProviderAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.egf.portfolio.genchain.generationChain.EmfGeneration <em>Emf Generation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.egf.portfolio.genchain.generationChain.EmfGeneration
	 * @generated
	 */
	public Adapter createEmfGenerationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.kitalpha.emde.genchain.extension.model.EmdeGeneration <em>Emde Generation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.kitalpha.emde.genchain.extension.model.EmdeGeneration
	 * @generated
	 */
	public Adapter createEmdeGenerationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.egf.portfolio.genchain.cdo.cdoExtension.CdoGeneration <em>Cdo Generation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.egf.portfolio.genchain.cdo.cdoExtension.CdoGeneration
	 * @generated
	 */
	public Adapter createCdoGenerationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.kitalpha.emde.genchain.extension.model.EmdeCdoGeneration <em>Emde Cdo Generation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.kitalpha.emde.genchain.extension.model.EmdeCdoGeneration
	 * @generated
	 */
	public Adapter createEmdeCdoGenerationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //CapellaExtensionAdapterFactory
