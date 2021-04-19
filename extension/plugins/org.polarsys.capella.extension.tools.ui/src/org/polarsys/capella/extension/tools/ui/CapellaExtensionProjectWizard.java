/*******************************************************************************
 * Copyright (c) 2015, 2020 Thales Global Services S.A.S.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 *  
 * Contributors:
 *   Thales Global Services S.A.S - initial API and implementation
 *******************************************************************************/
package org.polarsys.capella.extension.tools.ui;

import java.util.List;

import org.eclipse.egf.portfolio.genchain.generationChain.GenerationChain;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.util.URI;
import org.polarsys.capella.extension.genchain.CapellaGenerationExtension;


/**
 * @author Thomas Guiu
 * 
 */
public class CapellaExtensionProjectWizard extends NewExtensionProjectWizard {
	/**
	 * Adding the page to the wizard.
	 */
	@Override
	public void addPages() {
		page = new NewExtensionProjectPage(selection, "org.polarsys.capella.viewpoint");
		addPage(page);

	}

	protected void addGenerationCommands(final GenerationChain chain, List<URI> uriList, CompoundCommand command) {
		GenerationCreatingCommand command1 = new GenerationCreatingCommand(editingDomain, chain, uriList, new CapellaGenerationExtension());
		command.append(command1);

	}

}
