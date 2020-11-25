/*******************************************************************************
* Copyright (c) 2006, 2018 THALES GLOBAL SERVICES.
* This program and the accompanying materials are made available under the
* terms of the Eclipse Public License 2.0 which is available at
* http://www.eclipse.org/legal/epl-2.0
*
* SPDX-License-Identifier: EPL-2.0
*
* Contributors:
*    Thales - initial API and implementation
*******************************************************************************/
package org.polarsys.capella.ad.viewpoint.dsl.generation.ui.util;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;

/**
 * @author Boubekeur Zendagui
 */
public class UIProjectManager {
	
	public static final UIProjectManager INSTANCE = new UIProjectManager();
	
	private IProject uiProject = null;
	
	public void init(){
		uiProject = null;
	}
	
	public void registerUIProject(IProject projects){
		uiProject = projects;
	}
	
	public void registerUIProject(String name) {
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(name);
		if (project == null ) {
                  	throw new IllegalStateException();
                }
		uiProject = project;
	}

	public IProject getUiProject() {
		return uiProject;
	}

}
