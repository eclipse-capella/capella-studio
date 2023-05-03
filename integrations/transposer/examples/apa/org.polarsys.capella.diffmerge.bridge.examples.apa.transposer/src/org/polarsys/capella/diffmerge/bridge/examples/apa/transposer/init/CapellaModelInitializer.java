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
package org.polarsys.capella.diffmerge.bridge.examples.apa.transposer.init;

import java.util.Collection;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.polarsys.capella.common.platform.sirius.ted.SemanticEditingDomainFactory;
import org.polarsys.capella.diffmerge.bridge.examples.apa.transposer.TransposerApaPlugin;
import org.polarsys.kitalpha.cadence.core.api.parameter.ActivityParameters;
import org.polarsys.kitalpha.transposer.emf.toolbox.activities.ModelInitializer;
import org.polarsys.kitalpha.transposer.emf.toolbox.api.TransposerUtil;
import org.polarsys.kitalpha.transposer.rules.handler.rules.api.IContext;
import org.polarsys.kitalpha.transposer.transformation.emf.resource.ResourceUtil;


/**
 * A ModelInitializer activity that can handle Capella models.
 */
public class CapellaModelInitializer extends ModelInitializer {
  
  /**
   * Create and return a resource set for loading the given file
   * @param file_p a non-null file
   * @return a non-null resource set
   */
  protected ResourceSet createSourceResourceSet(IFile file_p) {
    ResourceSet result;
    if (isCapellaFile(file_p))
      result = new SemanticEditingDomainFactory().createEditingDomain().getResourceSet();
    else
      result = new ResourceSetImpl();
    return result;
  }
  
  /**
   * Return whether the given selection refers to a Capella model
   * @param file_p a potentially null object
   */
  protected boolean isCapellaFile(IFile file_p) {
    return CapellaDomainHelper.CAPELLA_FILE_EXT.equals(file_p.getFileExtension());
  }
  
  /**
   * Copied from ModelInitializer.
   * @see ModelInitializer#run(ActivityParameters)
   * @see org.polarsys.kitalpha.transposer.emf.toolbox.activities.ModelInitializer#run(org.polarsys.kitalpha.cadence.core.api.parameter.ActivityParameters)
   */
  @Override
  @SuppressWarnings("unchecked")
  public IStatus run(ActivityParameters activityParams_p) {
    // Selection
    Collection<Object> selection = (Collection<Object>) activityParams_p.getParameter(TRANSPOSER_SELECTION).getValue();
    if (selection == null || selection.isEmpty()) { 
      return new Status(IStatus.ERROR, TransposerApaPlugin.getDefault().getPluginId(),
          "the selection is empty or null");//$NON-NLS-1$
    }
    Object selectedElement = selection.iterator().next();
    // Source model
    if (selectedElement instanceof IFile) {
      IFile file = (IFile)selectedElement;
      URI fileURI = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
      ResourceSet sourceRS = createSourceResourceSet(file);
      Resource resource = sourceRS.getResource(fileURI, true);
      if (resource.getContents() != null && !resource.getContents().isEmpty()) {
        EObject project = (EObject) resource.getContents().get(0); // get the root container
        selectedElement = project;
        selection.clear();
        selection.add(project);
      }
    }
    // Target root element
    final String nsUri = (String) activityParams_p.getParameter(NSURI).getValue();
    final String rootS = (String) activityParams_p.getParameter(ROOT_ELEMENT).getValue();
    final EObject root = TransposerUtil.createObject(nsUri, rootS);
    IContext context = (IContext) activityParams_p.getParameter(TRANSPOSER_CONTEXT).getValue();
    // Target resource
    String modelPath = new String();
    if (selectedElement instanceof EObject && ((EObject) selectedElement).eResource() != null) {
      Resource res = ((EObject) selectedElement).eResource();
      String path = res.getURI().toPlatformString(true);
      final String extension = root.eClass().getEPackage().getName().toLowerCase();
      modelPath = res.getURI().toPlatformString(true).
          substring(0,path.length() - res.getURI().fileExtension().length())
          + extension;
    }
    final ResourceSet resourceSet = new ResourceSetImpl();
    ResourceUtil.createResource(resourceSet, modelPath, null, false);
    resourceSet.getResources().get(0).setTrackingModification(true);
    context.put(ResourceUtil.TRANSPOSER_RESOURCE_SET, resourceSet);
    return Status.OK_STATUS;
  }
  
}
