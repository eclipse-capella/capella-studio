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
package org.polarsys.capella.diffmerge.bridge.examples.apa2capella;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.handlers.HandlerUtil;
import org.polarsys.capella.common.ef.ExecutionManager;
import org.polarsys.capella.common.ef.ExecutionManagerRegistry;
import org.polarsys.capella.core.model.handler.command.CapellaResourceHelper;
import org.polarsys.capella.diffmerge.bridge.examples.apa.AScope;
import org.polarsys.capella.diffmerge.bridge.examples.apa2capella.messages.Messages;

/**
 * The incremental bridge command handler. This command handler is invoked when
 * the user right clicks from the Project Explorer on an APA model and selects
 * APA-to-Capella Bridge from the contextual menu. An APA model is a resource
 * with the extension "apa".
 * 
 * @author Amine Lajmi
 * 
 */
public class Apa2CapellaBridgeHandler extends AbstractHandler {

	/**
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	public Object execute(ExecutionEvent event_p) throws ExecutionException {
		IFile file = unwrap(event_p, IFile.class);
		if (file != null) {
			IPath sourcePath = file.getFullPath();

			// load source resource		
			ExecutionManager manager = ExecutionManagerRegistry.getInstance().addNewManager();
			TransactionalEditingDomain domain = manager.getEditingDomain();
			ResourceSet resourceSet = domain.getResourceSet();
			URI sourceURI = URI.createPlatformResourceURI(sourcePath.toString(), false);
			Resource resource = resourceSet.getResource(sourceURI, true);

			AScope context = (AScope) resource.getContents().get(0);
			if (context != null) {
				IPath targetPath = sourcePath.removeFileExtension().addFileExtension(CapellaResourceHelper.CAPELLA_MODEL_FILE_EXTENSION);
				if (EcorePlugin.getWorkspaceRoot().exists(targetPath)) {
					IPath rootLocationPath = EcorePlugin.getWorkspaceRoot().getLocation();
					IPath workspaceRelativePath = targetPath.makeRelativeTo(rootLocationPath);
					URI targetURI = URI.createPlatformResourceURI(workspaceRelativePath.toString(), false);
					Apa2CapellaBridgeJob apa2CapellaBridgeJob = new Apa2CapellaBridgeJob(context, targetURI);
					apa2CapellaBridgeJob.schedule();	
				} else {
					Display display = Display.getCurrent();
					if (display!=null) {
						Shell shell = display.getActiveShell();
						MessageDialog.openError(shell, Messages.Apa2CapellaBridgeCommandHandler_BridgeDialogTitle, Messages.Apa2CapellaBridgeCommandHandler_TargetResourceNotFound);						
					}
				}
			} else {
				throw new ExecutionException(
						Messages.Apa2CapellaBridgeCommandHandler_ExecutionContextNotFound);
			}
		}
		return null;
	}

	/**
	 * Unwraps the object given the type given as input
	 * 
	 * @param <T> the return type
	 * @param object_p (non-null) the object to unwrap
	 * @param type_p (non-null) the type to cast
	 * @return the (possibly null) unwrapped object
	 */
	<T> T unwrap(Object object_p, Class<T> type_p) {
		Object current = object_p;
		if (current instanceof ExecutionEvent) {
			current = HandlerUtil.getCurrentSelection((ExecutionEvent) current);
		}
		if (current instanceof IStructuredSelection) {
			current = ((IStructuredSelection) current).getFirstElement();
		}
		if (current instanceof IAdaptable) {
			current = ((IAdaptable) current).getAdapter(type_p);
		}
		if (type_p.isInstance(current)) {
			return type_p.cast(current);
		}
		return null;
	}
}