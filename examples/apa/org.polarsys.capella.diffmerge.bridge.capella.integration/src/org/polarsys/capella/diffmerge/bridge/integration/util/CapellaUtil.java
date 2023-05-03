/*********************************************************************
 * Copyright (c) 2016-2019 Thales Global Services S.A.S.
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *    Thales Global Services S.A.S. - initial API and implementation
 **********************************************************************/
package org.polarsys.capella.diffmerge.bridge.integration.util;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.polarsys.capella.core.data.capellamodeller.ModelRoot;
import org.polarsys.capella.core.data.capellamodeller.Project;
import org.polarsys.capella.core.data.capellamodeller.SystemEngineering;
import org.polarsys.capella.core.data.fa.FunctionPkg;
import org.polarsys.capella.core.data.la.LogicalArchitecture;
import org.polarsys.capella.core.data.la.LogicalComponent;
import org.polarsys.capella.core.data.la.LogicalFunction;
import org.polarsys.capella.core.data.la.LogicalFunctionPkg;
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
	 * The Capella model file extension
	 */
	public static final String CAPELLA_MODEL_FILE_EXTENSION = "melodymodeller"; //$NON-NLS-1$

	/**
	 * The Aird file extension
	 */
	public static final String AIRD_FILE_EXTENSION = "aird"; //$NON-NLS-1$

	/**
	 * Returns the root physical component of the Capella physical architecture
	 * given a semantic object
	 * 
	 * @param source_p
	 *            a (non-null) Capella semantic object
	 * @return the (possibly null) physical system root
	 */
	public static PhysicalComponent getPhysicalSystemRoot(EObject source_p) {
		ResourceSet resourceSet = source_p.eResource().getResourceSet();
		URI semanticResourceURI = source_p
				.eResource()
				.getURI()
				.trimFileExtension()
				.appendFileExtension(
						CapellaResourceHelper.CAPELLA_MODEL_FILE_EXTENSION);
		Resource semanticResource = resourceSet.getResource(
				semanticResourceURI, false);
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
	 *            (non-null) Capella semantic resource
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
	    List<PhysicalFunction> subFunctions = functionPackage.getOwnedPhysicalFunctions();
	    return subFunctions.isEmpty()? null: subFunctions.get(0);
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

	/**
	 * Returns the logical component system root given a semantic object
	 * 
	 * @param source_p
	 *            the semantic object
	 * @return the logical component root
	 */
	public static LogicalComponent getLogicalSystemRoot(EObject source_p) {
		ResourceSet resourceSet = source_p.eResource().getResourceSet();
		URI semanticResourceURI = source_p.eResource().getURI()
				.trimFileExtension()
				.appendFileExtension(CAPELLA_MODEL_FILE_EXTENSION);
		Resource semanticResource = resourceSet.getResource(
				semanticResourceURI, false);
		if (semanticResource != null) {
			EObject root = semanticResource.getContents().get(0);
			if (root instanceof Project) {
				EList<ModelRoot> ownedModelRoots = ((Project) root)
						.getOwnedModelRoots();
				for (ModelRoot modelRoot : ownedModelRoots) {
					if (modelRoot instanceof SystemEngineering) {
						EList<LogicalArchitecture> containedLogicalArchitecture = ((SystemEngineering) modelRoot)
								.getContainedLogicalArchitectures();
						for (LogicalArchitecture arch : containedLogicalArchitecture) {
							return (LogicalComponent)arch.getSystem();
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
	 *            (non-null) Capella semantic resource
	 * @return the physical system root given a resource.
	 */
	public static LogicalComponent getLogicalSystemRoot(Resource resource_p) {
		return getLogicalSystemRoot(resource_p.getContents().get(0));
	}

	/**
	 * Returns the physical function package of a Capella model
	 * 
	 * @param source_p
	 *            a (non-null) Capella semantic object
	 * @return the physical function package.
	 */
	public static LogicalFunctionPkg getLogicalFunctionPackage(EObject source_p) {
		ResourceSet resourceSet = source_p.eResource().getResourceSet();
		URI semanticResourceURI = source_p.eResource().getURI()
				.trimFileExtension()
				.appendFileExtension(CAPELLA_MODEL_FILE_EXTENSION);
		Resource semanticResource = resourceSet.getResource(
				semanticResourceURI, false);
		LogicalFunctionPkg logicalFunctionPkgTmp = null;
		if (semanticResource != null) {
			EObject root = semanticResource.getContents().get(0);
			if (root instanceof Project) {
				EList<ModelRoot> ownedModelRoots = ((Project) root)
						.getOwnedModelRoots();
				for (ModelRoot modelRoot : ownedModelRoots) {
					if (modelRoot instanceof SystemEngineering) {
						EList<LogicalArchitecture> containedPhysicalArchitectures = ((SystemEngineering) modelRoot)
								.getContainedLogicalArchitectures();
						for (LogicalArchitecture arch : containedPhysicalArchitectures) {
							FunctionPkg ownedFunctionPkg = arch
									.getOwnedFunctionPkg();
							if (ownedFunctionPkg instanceof LogicalFunctionPkg) {
								logicalFunctionPkgTmp = (LogicalFunctionPkg) ownedFunctionPkg;
								break;
							}
						}
					}
				}
			}
		}
		return logicalFunctionPkgTmp;
	}

	/**
	 * Returns the logical function root of a Capella model
	 * 
	 * @param source_p
	 *            a (non-null) Capella semantic object
	 * @return the logical function root given an eObject.
	 */
	public static LogicalFunction getLogicalFunctionRoot(EObject source_p) {
		LogicalFunctionPkg functionPackage = getLogicalFunctionPackage(source_p);
		return functionPackage.getOwnedLogicalFunctions().get(0);
	}

	/**
	 * Returns the logical function root of a Capella model
	 * 
	 * @param resource_p
	 *            the (non-null) semantic resource
	 * @return the logical function root given a resource.
	 */
	public static LogicalFunction getLogicalFunctionRoot(Resource resource_p) {
		LogicalFunctionPkg functionPackage = getLogicalFunctionPackage(resource_p
				.getContents().get(0));
		return functionPackage.getOwnedLogicalFunctions().get(0);
	}

	/**
	 * Returns the system engineering root from the Capella project
	 * 
	 * @param project_p
	 *            a Capella project
	 * @return the system engineering root
	 */
	public static SystemEngineering getSystemEngineering(Project project_p) {
		if (project_p != null) {
			for (ModelRoot root : project_p.getOwnedModelRoots()) {
				if (root instanceof SystemEngineering) {
					return (SystemEngineering) root;
				}
			}
		}
		return null;
	}
}
