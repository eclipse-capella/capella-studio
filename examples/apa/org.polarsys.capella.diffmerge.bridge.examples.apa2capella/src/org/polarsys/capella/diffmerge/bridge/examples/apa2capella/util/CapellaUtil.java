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
package org.polarsys.capella.diffmerge.bridge.examples.apa2capella.util;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.polarsys.capella.core.data.capellamodeller.ModelRoot;
import org.polarsys.capella.core.data.capellamodeller.Project;
import org.polarsys.capella.core.data.capellamodeller.SystemEngineering;
import org.polarsys.capella.core.data.fa.FunctionPkg;
import org.polarsys.capella.core.data.pa.PhysicalArchitecture;
import org.polarsys.capella.core.data.pa.PhysicalComponent;
import org.polarsys.capella.core.data.pa.PhysicalFunction;
import org.polarsys.capella.core.data.pa.PhysicalFunctionPkg;
import org.polarsys.capella.core.model.handler.command.CapellaResourceHelper;

/**
 * A utility helper to retrieve parts of a Capella model
 * 
 * @author Amine Lajmi
 *
 */
public class CapellaUtil {

  /**
   * Returns the root physical component of the Capella physical architecture given a semantic object
   * 
   * @param source_p
   *          a (non-null) Capella semantic object
   * @return the (possibly null) physical system root
   */
  public static PhysicalComponent getPhysicalSystemRoot(EObject source_p) {
    ResourceSet resourceSet = source_p.eResource().getResourceSet();
    URI semanticResourceURI = source_p.eResource().getURI().trimFileExtension()
        .appendFileExtension(CapellaResourceHelper.CAPELLA_MODEL_FILE_EXTENSION);
    Resource semanticResource = resourceSet.getResource(semanticResourceURI, false);
    if (semanticResource != null) {
      EObject root = semanticResource.getContents().get(0);
      if (root instanceof Project) {
        EList<ModelRoot> ownedModelRoots = ((Project) root)
            .getOwnedModelRoots();
        for (ModelRoot modelRoot : ownedModelRoots) {
          if (modelRoot instanceof SystemEngineering) {
            EList<PhysicalArchitecture> containedPhysicalArchitectures = ((SystemEngineering) modelRoot)
                .getContainedPhysicalArchitectures();
            for (PhysicalArchitecture arch : containedPhysicalArchitectures) {
              return (PhysicalComponent)arch.getSystem();
            }
          }
        }
      }
    }
    return null;
  }

  /**
   * Returns the root physical component of the Capella physical architecture
   * 
   * @param resource_p
   *          (non-null) Capella semantic resource
   * @return the physical system root given a resource.
   */
  public static PhysicalComponent getPhysicalSystemRoot(Resource resource_p) {
    return getPhysicalSystemRoot(resource_p.getContents().get(0));
  }

  /**
   * Returns the physical function package of a Capella model
   * 
   * @param source_p
   *          a (non-null) Capella semantic object
   * @return the physical function package.
   */
  public static PhysicalFunctionPkg getPhysicalFunctionPackage(EObject source_p) {
    ResourceSet resourceSet = source_p.eResource().getResourceSet();
    URI semanticResourceURI = source_p.eResource().getURI().trimFileExtension()
        .appendFileExtension(CapellaResourceHelper.CAPELLA_MODEL_FILE_EXTENSION);
    Resource semanticResource = resourceSet.getResource(semanticResourceURI, false);
    PhysicalFunctionPkg physicalFunctionPkgTmp = null;
    if (semanticResource != null) {
      EObject root = semanticResource.getContents().get(0);
      if (root instanceof Project) {
        EList<ModelRoot> ownedModelRoots = ((Project) root).getOwnedModelRoots();
        for (ModelRoot modelRoot : ownedModelRoots) {
          if (modelRoot instanceof SystemEngineering) {
            EList<PhysicalArchitecture> containedPhysicalArchitectures = ((SystemEngineering) modelRoot)
                .getContainedPhysicalArchitectures();
            for (PhysicalArchitecture arch : containedPhysicalArchitectures) {
              FunctionPkg ownedFunctionPkg = arch.getOwnedFunctionPkg();
              if (ownedFunctionPkg instanceof PhysicalFunctionPkg) {
                physicalFunctionPkgTmp = (PhysicalFunctionPkg) ownedFunctionPkg;
                break;
              }
            }
          }
        }
      }
    }
    return physicalFunctionPkgTmp;
  }

  /**
   * Returns the physical function root of a Capella model
   * 
   * @param source_p
   *          a (non-null) Capella semantic object
   * @return the physical function root given an eObject.
   */
  public static PhysicalFunction getPhysicalFunctionRoot(EObject source_p) {
    PhysicalFunctionPkg functionPackage = getPhysicalFunctionPackage(source_p);
    return functionPackage.getOwnedPhysicalFunctions().get(0);
  }

  /**
   * Returns the physical function root of a Capella model
   * 
   * @param resource_p the (non-null) semantic resource
   * @return the physical function root given a resource.
   */
  public static PhysicalFunction getPhysicalFunctionRoot(Resource resource_p) {
    PhysicalFunctionPkg functionPackage = getPhysicalFunctionPackage(resource_p.getContents().get(0));
    return functionPackage.getOwnedPhysicalFunctions().get(0);
  }
}
