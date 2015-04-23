/*******************************************************************************
* Copyright (c) 2006, 2015 THALES GLOBAL SERVICES.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
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
	
	public static UIProjectManager INSTANCE = new UIProjectManager();
	
	private IProject uiProject = null;
	
	public void init(){
		uiProject = null;
	}
	
	public void registerUIProject(IProject projects){
		uiProject = projects;
	}
	
	public void registerUIProject(String name) throws Exception{
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(name);
		if (project != null )
			uiProject = project;
		else
			// TODO: Create an appropriate exception
			throw new Exception();
	}

	public IProject getUiProject() {
		return uiProject;
	}

}
