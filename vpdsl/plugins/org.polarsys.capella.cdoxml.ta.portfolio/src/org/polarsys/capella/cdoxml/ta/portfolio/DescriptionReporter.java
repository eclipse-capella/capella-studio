/*******************************************************************************
 * Copyright (c) 2021 Thales Global Services.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 *  
 * Contributors:
 *   Thales Global Services - initial API and implementation
 *******************************************************************************/
package org.polarsys.capella.cdoxml.ta.portfolio;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.egf.model.pattern.PatternContext;
import org.eclipse.egf.model.pattern.PatternExecutionReporter;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource;


/**
 * @author Matthieu Helleboid
 */
public class DescriptionReporter implements PatternExecutionReporter {

	private static Collection<IFile> generatedFiles = new ArrayList<IFile>();
	
	public void executionFinished(String output, PatternContext context) {
		generatedFiles.clear();
	}

	public void loopFinished(String output, String outputWithCallBack, PatternContext context, Map<String, Object> parameterValues) {
		EClass eClass = (EClass) parameterValues.get("eClass");
		Resource eResource = eClass.eResource();
		String projectName = new Path(eResource.getURI().toPlatformString(false)).segment(0) + ".connector";
		
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
		try {
			if (!project.exists()) {
				project.create(new NullProgressMonitor());
			}
			if (!project.isOpen()) {
				project.open(new NullProgressMonitor());
			}
		} catch (CoreException e) {
			throw new IllegalStateException("Unable to find project " + projectName, e);
		}
		
		IFile file = project.getFile((String) context.getValue("fileName"));
		try {
			boolean append = generatedFiles.contains(file);
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file.getRawLocation().toFile(), append));
			bufferedWriter.append(output);
			bufferedWriter.close();
			generatedFiles.add(file);
		} catch (IOException e) {
			throw new IllegalStateException("Unable to find file " + file, e);
		}
		
		try {
			project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
		} catch (CoreException e) {
			throw new IllegalStateException("Unable to refresh project " + projectName, e);
		}
	}

}
