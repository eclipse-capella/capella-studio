/*********************************************************************
 * Copyright (c) 2014-2019 Thales Global Services S.A.S.
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *    Thales Global Services S.A.S. - initial API and implementation
 **********************************************************************/
package org.polarsys.capella.diffmerge.bridge.examples.apa.transposer.integrated;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.polarsys.capella.core.data.pa.PhysicalArchitecture;
import org.polarsys.capella.core.data.pa.PhysicalComponent;


/**
 * An action for running the Capella2Apa operation from the GUI.
 * @author O. CONSTANT
 */
public class TransposerAPABridgeAction implements IObjectActionDelegate {
  
  /** The current, potentially null selection */
  private IStructuredSelection _selection;
  
  /** The current, potentially null workbench part where the action is being used */
  private IWorkbenchPart _workbenchPart;
  
  
  /**
   * Constructor
   */
  public TransposerAPABridgeAction() {
    _selection = null;
    _workbenchPart = null;
  }
  
  /**
   * Return the context element for the current selection, if any.
   * The context element is the one on which the action is applicable.
   * @return a potentially null object
   */
  protected PhysicalArchitecture getContext() {
    PhysicalArchitecture result = null;
    if (_selection != null && !_selection.isEmpty()) {
      Object selected = _selection.getFirstElement();
      if (selected instanceof EditPart)
        selected = ((EditPart)selected).getModel();
      if (selected instanceof View)
        selected = ((View)selected).getElement();
      if (selected instanceof DSemanticDecorator)
        selected = ((DSemanticDecorator)selected).getTarget();
      if (selected instanceof PhysicalComponent)
        while (selected instanceof PhysicalComponent)
          selected = ((PhysicalComponent)selected).eContainer();
      if (selected instanceof PhysicalArchitecture)
        result = (PhysicalArchitecture)selected;
    }
    return result;
  }
  
  /**
   * Return whether the action is applicable given the current context
   */
  protected boolean isApplicable() {
    return _selection != null && !_selection.isEmpty() && _workbenchPart != null;
  }
  
  /**
   * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
   */
  public void run(IAction action_p) {
    PhysicalArchitecture context = getContext();
    if (context != null) {
      new TransposerAPABridgeJob(context).schedule();
    } else {
      MessageDialog.openError(
          _workbenchPart.getSite().getShell(),
          TransposerIntegrationApaPlugin.getDefault().getPluginId(),
          "APA Transposer Bridge Example"); //$NON-NLS-1$
    }
  }
  
  /**
   * @see org.eclipse.ui.IActionDelegate#selectionChanged(org.eclipse.jface.action.IAction, org.eclipse.jface.viewers.ISelection)
   */
  public void selectionChanged(IAction action_p, ISelection selection_p) {
    if (selection_p instanceof IStructuredSelection)
      _selection = (IStructuredSelection)selection_p;
    else
      _selection = null;
    action_p.setEnabled(isApplicable());
  }
  
  /**
   * @see org.eclipse.ui.IObjectActionDelegate#setActivePart(org.eclipse.jface.action.IAction, org.eclipse.ui.IWorkbenchPart)
   */
  public void setActivePart(IAction action_p, IWorkbenchPart targetPart_p) {
    _workbenchPart = targetPart_p;
  }
  
}
