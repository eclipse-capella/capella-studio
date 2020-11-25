/*******************************************************************************
* Copyright (c) 2006, 2019 THALES GLOBAL SERVICES.
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

import java.io.ByteArrayInputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.jdt.core.ToolFactory;
import org.eclipse.jdt.core.formatter.CodeFormatter;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;
import org.eclipse.text.edits.MalformedTreeException;
import org.eclipse.text.edits.TextEdit;
import org.polarsys.capella.ad.viewpoint.dsl.generation.ui.Activator;

/**
 * @author Boubekeur Zendagui
 */
public final class JDTUtility {
	
	public static IFolder packageToFolder(IProject project, String packageName){
		String folder = JDTUtility.getValidPackageName("src."+packageName);
		folder = folder.replaceAll("\\.", "/");
		return project.getFolder(new Path(folder));
	}
	
	public static String formatJavaCode(String javaCode){
		CodeFormatter cf = ToolFactory.createCodeFormatter(null);

        TextEdit te = cf.format(CodeFormatter.K_UNKNOWN, javaCode, 0,javaCode.length(),0,null);
        IDocument dc = new Document(javaCode);
        String formatedCode = javaCode;
        try {
                te.apply(dc);
                formatedCode = dc.get();
        } catch (MalformedTreeException|BadLocationException e) {
        	Activator.getDefault().getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "", e));
        }

		return formatedCode;
	}
	
	public static void writeJavaContent(IFile javaFile, String javaCode){
		String formatedOutput = formatJavaCode(javaCode);
		ByteArrayInputStream outputContent = new ByteArrayInputStream(formatedOutput.getBytes());
		try {
			if (javaFile.exists()) {
				javaFile.setContents(outputContent, true, false, null);
			} else {
				javaFile.create(outputContent, true, null);
			}

		} catch (CoreException e) {
			Activator.getDefault().getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "", e));
		}
	}
	
	public static String getValidPackageName(String name){
		return name.replaceAll("[^a-zA-Z0-9_.]","").toLowerCase();
	}
	
	public static String getValidClassName(String name){
		String cName = name.replaceAll("[^a-zA-Z0-9_]","");
		return cName.substring(0,1).toUpperCase() + cName.substring(1);
	}
	
	public static void createPackage(String projectName, String packageName){
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
		IFolder src = project.getFolder("src");
		if (! src.exists()){
			try {
				src.create(true, true, null);
			} catch (CoreException e) {
				Activator.getDefault().getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "", e));
			}
		}
		Path packageFolderPath = new Path(packageName.replace('.', '/'));
		if (src.getFolder(packageFolderPath).exists()) {
			return;
		}
		
		IFolder parent = src;
		for (int i = 0; i < packageFolderPath.segmentCount(); i++) {
			IFolder curFolder = parent.getFolder(packageFolderPath.segment(i));
			if (! curFolder.exists()){
				try {
					curFolder.create(true, true, null);
				} catch (CoreException e) {
					Activator.getDefault().getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "", e));
				}
			}
			parent = curFolder;
		}
		
	}

	private JDTUtility() {
		super();
	}
	
}
