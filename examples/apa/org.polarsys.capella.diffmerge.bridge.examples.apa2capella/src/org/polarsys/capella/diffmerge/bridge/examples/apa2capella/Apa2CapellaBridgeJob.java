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
package org.polarsys.capella.diffmerge.bridge.examples.apa2capella;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.diffmerge.api.scopes.IEditableModelScope;
import org.eclipse.emf.diffmerge.bridge.mapping.api.IMappingBridge;
import org.polarsys.capella.diffmerge.bridge.examples.apa.AScope;
import org.polarsys.capella.diffmerge.bridge.examples.apa2capella.messages.Messages;
import org.polarsys.capella.diffmerge.bridge.integration.CapellaBridgeJob;

/**
 * A specialized bridge job for the APA to Capella incremental transformation.
 * 
 * @author Amine Lajmi
 *
 */
public class Apa2CapellaBridgeJob extends CapellaBridgeJob<AScope> {
  
  /**
   * Constructor with explicit target uri
   *
   * @param context_p the (non-null) source model scope
   * @param targetURI_p the (non-null) target uri
   */
  public Apa2CapellaBridgeJob(AScope context_p, URI targetURI_p) {
    super(Messages.Apa2CapellaBridgeJob_JobLabel, context_p, targetURI_p);
  }
  
  /**
   * @see org.polarsys.capella.diffmerge.bridge.integration.CapellaBridgeJob#createMappingBridge()
   */
  @Override
  protected IMappingBridge<AScope, IEditableModelScope> createMappingBridge() {
    return new Apa2CapellaBridge();
  }
}