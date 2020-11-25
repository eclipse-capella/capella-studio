/*******************************************************************************
 * Copyright (c) 2015, 2019 Thales Global Services S.A.S.
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

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.pde.internal.core.ClasspathComputer;
import org.eclipse.pde.internal.core.natures.PDE;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

/**
 * @author Thomas Guiu
 * 
 */
public final class ResourceHelper {

	private static final String SUFFIX = ",\\";
	private static final String BUILD_PROPERTIES = "build.properties";
	private static final NullProgressMonitor NULL_PROGRESS_MONITOR = new NullProgressMonitor();
	private static final String SLASH = "/";
	private static final String PREFIX = "source.. =";
	private static final String NEW_LINE = "\n";

	// A helper method to check whether an IFolder exists. If it doesn't, then
	// create it.
	public static boolean checkResource(String path) {
		final String projectName = getProjectName(path);
		final IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
		if (!project.exists()) {
			PlatformUI.getWorkbench().getDisplay().syncExec(new Runnable() {
				public void run() {
					try {
						createProject(project, true);
					} catch (Exception e) {
						Activator.getDefault().getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "", e));
					}
				}
			});
		}

		final String outputPath = getOutputPath(projectName, path);
		if (outputPath.length() > 0) {
			final IFolder folder = project.getFolder(new Path(outputPath));
			if (!folder.exists()) {
				PlatformUI.getWorkbench().getDisplay().syncExec(new Runnable() {
					public void run() {
						try {
							createFolder(folder, NULL_PROGRESS_MONITOR);
						} catch (Exception e) {
							Activator.getDefault().getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "", e));
						}
					}
				});
			} else {
				return true;
			}
		}
		return false;
	}

	/*
	 * 
	 */
	private static IStatus makeFilesWritable(IFile[] files, Object display) {

		// Resulting shell.
		Shell shell = null;
		// Given display object must indeed be a display.
		if (display instanceof Display) {
			// Get shell from display.
			shell = ((Display) display).getActiveShell();
		}
		// If a shell is active, use it to make sure an end-user confirmation is
		// performed (as needed).
		// Try validate prompt behavior otherwise.
		Object context = (null == shell) ? IWorkspace.VALIDATE_PROMPT : shell;
		// Check given files.
		return ResourcesPlugin.getWorkspace().validateEdit(files, context);

	}

	@SuppressWarnings("restriction")
	public static IStatus makeFolderWritable(IFolder folder) {
		try {
			Collection<IFile> fileList = getFiles(folder);
			if (fileList != null) {
				int size = fileList.size();
				if (size > 0) {
					IFile[] files = new org.eclipse.core.internal.resources.File[size];
					Object[] fileArrays = fileList.toArray();
					for (int i = 0; i < size; i++) {
						files[i] = (IFile) fileArrays[i];
					}
					return makeFilesWritable(files, null);
				}
			}

		} catch (CoreException e) {
			Activator.getDefault().getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "", e));
		}
		return null;
	}

	private static Collection<IFile> getFiles(IFolder folder) throws CoreException {
		if (folder != null && folder.exists()) {
			Collection<IFile> list = new ArrayList<>();
			for (IResource resource : folder.members()) {
				if (resource instanceof IFolder) {
					list.addAll(getFiles((IFolder) resource));
				}

				if (resource instanceof IFile) {
					IFile file = (IFile) resource;
					list.add(file);
				}
			}
			return list;
		}
		return Collections.emptyList();

	}

	private static String getOutputPath(String projectName, String outputDirectoryPath) {
		StringBuilder builder = new StringBuilder();
		for (String s : outputDirectoryPath.split(SLASH)) {
			if (s != null && ! s.isEmpty() && !s.equals(projectName)) {
				builder.append(SLASH);
				builder.append(s);
			}
		}
		return builder.toString();
	}

	private static String getProjectName(String outputDirectoryPath) {
		String[] split = outputDirectoryPath.split(SLASH);
		for (String s : split) {
			if (s != null && s.length() > 0) {
				return s;
			}
		}
		return null;
	}

	private static void createFolder(IFolder folder, IProgressMonitor monitor) throws CoreException {
		Deque<IFolder> folderStack = getStack(folder);
		while (!folderStack.isEmpty()) {
			IFolder newFolder = folderStack.pop();
			newFolder.create(true, true, monitor);
		}
	}

	private static Deque<IFolder> getStack(IFolder folder) {
		Deque<IFolder> stack = new ArrayDeque<>();
		if (folder != null && !folder.exists()) {
			stack.push(folder);
			IContainer parent = folder.getParent();
			if (parent instanceof IFolder) {
				stack.addAll(getStack((IFolder) parent));
			}
		}

		return stack;
	}

	// Boris Bokowski's contribution
	// https://bugs.eclipse.org/bugs/show_bug.cgi?id=188795

	@SuppressWarnings("restriction")
	private static IProject createProject(IProject project, boolean pde) throws CoreException {
		project.create(null);
		project.open(null);
		if (pde) {
			addNatureToProject(project, PDE.PLUGIN_NATURE, null);
			setupJava(project, true);
			IFolder metaFolder = project.getFolder("META-INF");
			metaFolder.create(true, true, null);
			IFolder modelFolder = project.getFolder("model");
			modelFolder.create(true, true, null);
			createManifest(metaFolder, project.getName());
			createBuildProperties(project);
		} else {
			setupJava(project, false);
		}
		return project;
	}

	public static IProject createProject(String name) {
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(name);
		if (!project.exists()) {
			try {
				return createProject(project, true);
			} catch (CoreException e) {
				Activator.getDefault().getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "", e));
			}
		} else {
			return project;
		}
		return null;
	}

	private static void addNatureToProject(IProject proj, String natureId, IProgressMonitor monitor) throws CoreException {
		IProjectDescription description = proj.getDescription();
		String[] prevNatures = description.getNatureIds();
		String[] newNatures = new String[prevNatures.length + 1];
		System.arraycopy(prevNatures, 0, newNatures, 0, prevNatures.length);
		newNatures[prevNatures.length] = natureId;
		description.setNatureIds(newNatures);
		proj.setDescription(description, monitor);
	}

	@SuppressWarnings("restriction")
	private static void setupJava(IProject project, boolean pde) throws CoreException {
		addNatureToProject(project, JavaCore.NATURE_ID, null);
		IFolder srcFolder = project.getFolder("src");
		srcFolder.create(true, true, null);
		IFolder binFolder = project.getFolder("bin");
		if (!binFolder.exists()) {
			binFolder.create(true, true, null);
		}
		IJavaProject javaProject = JavaCore.create(project);
		javaProject.setOutputLocation(binFolder.getFullPath(), null);
		IClasspathEntry[] entries = new IClasspathEntry[pde ? 3 : 1];
		if (pde) {
			String executionEnvironment = "J2SE-1.5";
			ClasspathComputer.setComplianceOptions(javaProject, executionEnvironment);
			entries[0] = ClasspathComputer.createJREEntry(executionEnvironment);
			entries[1] = ClasspathComputer.createContainerEntry();
		}
		entries[entries.length - 1] = JavaCore.newSourceEntry(srcFolder.getFullPath());
		javaProject.setRawClasspath(entries, null);
	}

	private static void createManifest(IFolder metaFolder, String name) throws CoreException {
		IFile manifest = metaFolder.getFile("MANIFEST.MF");
		StringBuilder contents = new StringBuilder();
		contents.append("Manifest-Version: 1.0\n");
		contents.append("Bundle-ManifestVersion: 2\n");
		contents.append("Bundle-Name: " + name + "\n");
		contents.append("Bundle-SymbolicName: " + name + ";singleton:=true\n");
		contents.append("Bundle-Version: 1.0.0.qualifier\n");
		contents.append("Bundle-RequiredExecutionEnvironment: J2SE-1.5\n");
		contents.append("\n");
		manifest.create(new ByteArrayInputStream(contents.toString().getBytes(StandardCharsets.UTF_8)), false, null);
	}

	private static void createBuildProperties(IProject project) throws CoreException {
		IFile buildProperties = project.getFile(BUILD_PROPERTIES);
		StringBuilder contents = new StringBuilder();
		contents.append("source.. = src/\n");
		contents.append("output.. = bin/\n");
		contents.append("bin.includes = META-INF/,\\\n");
		contents.append("				.,\\\n");
		contents.append("				model/");
		buildProperties.create(new ByteArrayInputStream(contents.toString().getBytes(StandardCharsets.UTF_8)), false, null);
	}

	public static void addNewSourceFolder(IProject project, IFolder sourceFolder, IProgressMonitor monitor) throws CoreException, IOException {
		if (!sourceFolder.exists()) {
			sourceFolder.create(true, true, monitor);
		}

		IJavaProject javaProject = JavaCore.create(project);
		IClasspathEntry[] oldRawClasspath = javaProject.getRawClasspath();
		int oldLength = oldRawClasspath.length;
		IClasspathEntry[] newRawClasspath = new IClasspathEntry[oldLength + 1];
		IClasspathEntry newSourceEntry = JavaCore.newSourceEntry(sourceFolder.getFullPath());
		for (int i = 0; i < oldLength; i++) {
			IClasspathEntry entry = oldRawClasspath[i];
			if (entry.equals(newSourceEntry)) {
				return;
			}
			newRawClasspath[i] = entry;
		}
		newRawClasspath[oldLength] = newSourceEntry;
		javaProject.setRawClasspath(newRawClasspath, null);

		IFile file = project.getFile(BUILD_PROPERTIES);
		InputStream inputStream = file.getContents();
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		String line = reader.readLine();
		StringBuilder builder = new StringBuilder();
		while (line != null) {
			builder.append(line);
			if (line.startsWith(PREFIX)) {
				if (!line.endsWith(SUFFIX)) {
					builder.append(SUFFIX);
					builder.append(NEW_LINE);
					builder.append(sourceFolder.getName());
					builder.append(SLASH);
				} else {
					builder.append(NEW_LINE);
					builder.append(sourceFolder.getName());
					builder.append(SUFFIX);
				}
			}
			builder.append(NEW_LINE);
			line = reader.readLine();
		}
		reader.close();
		file.delete(true, monitor);
		file.create(new ByteArrayInputStream(builder.toString().getBytes()), true, monitor);

	}

	private ResourceHelper() {
		super();
	}

}
