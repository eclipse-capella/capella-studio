/*********************************************************************
 * Copyright (c) 2014-2019 Thales Global Services S.A.S.
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *    Thales Global Services S.A.S. - initial API and implementation
 **********************************************************************/
package org.polarsys.capella.diffmerge.bridge.examples.apa.transposer.integrated;

import org.eclipse.emf.diffmerge.api.scopes.IEditableModelScope;
import org.polarsys.capella.diffmerge.bridge.examples.apa.ApaPackage;
import org.polarsys.kitalpha.diffmerge.bridge.integration.transposer.TransposerBridge;
import org.eclipse.emf.diffmerge.bridge.interactive.BridgeJob;
import org.eclipse.emf.diffmerge.bridge.interactive.EMFInteractiveBridge;
import org.eclipse.emf.diffmerge.impl.policies.ConfigurableDiffPolicy;
import org.polarsys.capella.core.data.pa.PhysicalArchitecture;


/**
 * A variant of TransposerAPABridgeJob based on a Transposer mapping.
 * @author Olivier Constant
 */
public class TransposerAPABridgeJob extends BridgeJob<PhysicalArchitecture> {
  
	/**
	 * Constructor
	 * @param context_p a non-null physical architecture
	 */
	public TransposerAPABridgeJob(PhysicalArchitecture context_p) {
	  super("Capella2APA", context_p, //$NON-NLS-1$
	      context_p.eResource().getURI().trimFileExtension().appendFileExtension(ApaPackage.eNAME));
	}
	
	/**
	 * @see org.eclipse.emf.diffmerge.bridge.interactive.BridgeJob#getBridge()
	 */
	@Override
	protected EMFInteractiveBridge<PhysicalArchitecture, IEditableModelScope> getBridge() {
    final TransposerBridge<PhysicalArchitecture> mapping =
        new TransposerBridge<PhysicalArchitecture>(
            "org.eclipse.emf.diffmerge.bridge.examples.apa.transposer.purpose", //$NON-NLS-1$
            "org.eclipse.emf.diffmerge.bridge.examples.apa.transposer.mapping"); //$NON-NLS-1$
    ConfigurableDiffPolicy diffPolicy = new ConfigurableDiffPolicy();
    diffPolicy.setIgnoreOrders(true); // Ignore orders because of Transposer's non-determinism
    EMFInteractiveBridge<PhysicalArchitecture, IEditableModelScope> result = 
        new EMFInteractiveBridge<PhysicalArchitecture, IEditableModelScope>(
            mapping, diffPolicy, null, null);
    return result;
	}
	
}
