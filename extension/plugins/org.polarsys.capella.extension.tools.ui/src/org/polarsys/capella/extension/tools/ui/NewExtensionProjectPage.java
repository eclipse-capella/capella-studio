/*******************************************************************************
 * Copyright (c) 2015 Thales Global Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *   Thales Global Services S.A.S - initial API and implementation
 *******************************************************************************/
package org.polarsys.capella.extension.tools.ui;

import java.util.Iterator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.presentation.EcoreActionBarContributor.ExtendedLoadResourceAction.ExtendedLoadResourceDialog;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.dialogs.IDialogPage;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;

/**
 * @author Thomas Guiu
 * 
 */
public class NewExtensionProjectPage extends WizardPage {
	private static final String SPACE = " ";

	private static final String ECORE_EXTENSION = "ecore";

	private Text fileText;

	private ISelection selection;

	private Text ecoreText;

	private final String defaultProjectName;

	/**
	 * Constructor for SampleNewWizardPage.
	 * 
	 * @param pageName
	 */
	public NewExtensionProjectPage(ISelection selection, String defaultProjectName) {
		super("wizardPage");
		setTitle("Capella extension wizard");
		setDescription("This wizard creates a Capella metamodel extension.");
		setImageDescriptor(Activator.getImageDescriptor(Activator.WIZARD_IMG));
		this.selection = selection;
		this.defaultProjectName = defaultProjectName;
	}

	/**
	 * @see IDialogPage#createControl(Composite)
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);

		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 3;
		layout.verticalSpacing = 9;

		createFirstLine(container);
		createSecondLine(container);
		dialogChanged();
		setControl(container);

	}

	@Override
	public void setVisible(boolean visible) {
		super.setVisible(visible);
		initialize();
	}

	private void createSecondLine(Composite container) {
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		Label label = new Label(container, SWT.NULL);
		label.setText("&Extension model:");
		ecoreText = new Text(container, SWT.BORDER | SWT.SINGLE);
		ecoreText.setLayoutData(gd);
		// ecoreText.set
		ecoreText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				ecoreDialogChanged();
			}
		});
		Button button = new Button(container, SWT.PUSH);
		button.setText("Load ...");
		button.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				String text = ecoreText.getText();
				String result = loadEcoreResource(text);
				ecoreText.setText(result);
			}

		});
	}

	private String loadEcoreResource(String string) {
		MyExtendedLoadResourceDialog loadResourceDialog = new MyExtendedLoadResourceDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), null);
		loadResourceDialog.create();
		if (string != null) {
			loadResourceDialog.setText(string);
		}
		loadResourceDialog.open();
		return loadResourceDialog.getURIText();

	}

	private static class MyExtendedLoadResourceDialog extends ExtendedLoadResourceDialog {

		public MyExtendedLoadResourceDialog(Shell arg0, EditingDomain arg1) {
			super(arg0, arg1);
		}

		public void setText(String text) {
			uriField.setText(text);
		}

	}

	private void createFirstLine(Composite container) {
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		Label label = new Label(container, SWT.NULL);
		label.setText("&Project name:");

		fileText = new Text(container, SWT.BORDER | SWT.SINGLE);
		fileText.setLayoutData(gd);
		fileText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				dialogChanged();
			}
		});

		label = new Label(container, SWT.NULL);
		label.setText("");
	}

	/**
	 * Tests if the current workbench selection is a suitable container to use.
	 */

	@SuppressWarnings("unchecked")
	private void initialize() {
		fileText.setText(defaultProjectName);
		if (selection != null && selection.isEmpty() == false && selection instanceof IStructuredSelection) {
			IStructuredSelection ssel = (IStructuredSelection) selection;
			Iterator<Object> iterator = ssel.iterator();
			StringBuilder builder = new StringBuilder();
			while (iterator.hasNext()) {
				Object next = iterator.next();
				if (next instanceof IFile) {
					IFile file = (IFile) next;
					if (file.getFileExtension().equals(ECORE_EXTENSION)) {
						URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), false);
						builder.append(uri.toString());
						builder.append(SPACE);
					}
				}
			}
			ecoreText.setText(builder.toString());
			return;
		}
	}

	/**
	 * Ensures that both text fields are set.
	 */

	private void dialogChanged() {

		String fileName = getFileName();

		if (fileName.length() == 0) {
			updateStatus("Extension name must be specified");
			return;
		}
		if (fileName.replace('\\', '/').indexOf('/', 1) > 0) {
			updateStatus("Extension name must be valid");
			return;
		}
		if (fileName.contains(SPACE)) {
			updateStatus("Extension name must be valid");
			return;
		}
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(fileName);
		if (project != null && project.exists()) {
			updateStatus("Project is already existing.");
			return;
		}
		updateStatus(null);
	}

	private void ecoreDialogChanged() {

	}

	private void updateStatus(String message) {
		setErrorMessage(message);
		setPageComplete(message == null);
	}

	public String getFileName() {
		return fileText.getText();
	}

	public String getEcoreModelPath() {
		return ecoreText.getText();
	}
}
