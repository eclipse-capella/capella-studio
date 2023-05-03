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
package org.polarsys.capella.diffmerge.bridge.examples.apa2capella.messages;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	
	private static final String BUNDLE_NAME = "org.eclipse.emf.diffmerge.bridge.examples.apa2capella.messages.messages"; //$NON-NLS-1$
	
	public static String Apa2CapellaBridgeCommandHandler_BridgeDialogTitle;
	public static String Apa2CapellaBridgeCommandHandler_ExecutionContextNotFound;
	public static String Apa2CapellaBridgeCommandHandler_TargetResourceNotFound;
	public static String Apa2CapellaBridgeJob_JobLabel;
	 
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
