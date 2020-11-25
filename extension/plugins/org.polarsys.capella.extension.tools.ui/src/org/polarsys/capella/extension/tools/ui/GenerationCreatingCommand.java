/*******************************************************************************
 * Copyright (c) 2015, 2018 Thales Global Services S.A.S.
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

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.egf.portfolio.genchain.extension.ExtensionHelper;
import org.eclipse.egf.portfolio.genchain.extension.ExtensionProperties;
import org.eclipse.egf.portfolio.genchain.generationChain.EcoreElement;
import org.eclipse.egf.portfolio.genchain.generationChain.GenerationChain;
import org.eclipse.egf.portfolio.genchain.generationChain.GenerationElement;
import org.eclipse.egf.portfolio.genchain.tools.ui.Messages;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

/**
 * @author Thomas Guiu
 * 
 */
public class GenerationCreatingCommand extends RecordingCommand implements ExtensionProperties {
	private GenerationChain gc;
	private List<URI> uriList;
	private final ExtensionHelper extensionHelper;

	public GenerationCreatingCommand(TransactionalEditingDomain domain, GenerationChain gc, List<URI> uriList, ExtensionHelper extensionHelper) {
		super(domain);
		this.gc = gc;
		this.uriList = uriList;
		this.extensionHelper = extensionHelper;
	}

	@Override
	protected void doExecute() {
		if (uriList != null && !uriList.isEmpty()) {
			String project = gc.eResource().getURI().segment(1);
			for (URI uri : uriList) {
				GenerationElement feature1 = createNewElement(uri, project);
				gc.getElements().add(feature1);
			}
		} else {
			throw new IllegalStateException("no uri provided");
		}
	}

	public String getPath(URI uri) {
		if (uri.isPlatform()) {
			return uri.toPlatformString(false);
		} else if (uri.isFile()) {
			return uri.toFileString();
		}
		return "";
	}

	public GenerationElement createNewElement(URI uri, String project) {
		ExtensionHelper extension = getExtension();
		Map<String, String> context = new HashMap<String, String>();
		Map<String, String> properties = new HashMap<String, String>();

		String name = uri.trimFileExtension().lastSegment();
		context.put(CONTEXT_CURRENT_PROJECT_NAME, project);
		context.put(CONTEXT_MODEL_NAME, name);

		Map<EAttribute, String> defaultProperties = extension.getDefaultProperties(context);
		for (Entry<EAttribute, String> entry : defaultProperties.entrySet()) {
			properties.put(entry.getKey().getName(), entry.getValue());
		}
		properties.put(MODEL_PATH, uri.toPlatformString(true));
		EcoreElement element = extension.createEcoreElement(properties);
		element.setName(Messages.bind(Messages.genchain_wizard_element_name_creation, extension.getLabel(), name));
		return element;
	}

	protected ExtensionHelper getExtension() {
		return extensionHelper;
	}
}
