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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.polarsys.capella.core.data.capellacore.CapellaElement;
import org.polarsys.capella.core.data.fa.FaPackage;
import org.polarsys.capella.core.data.pa.PaPackage;
import org.polarsys.kitalpha.transposer.transformation.emf.TransposerEMFPlugin;
import org.polarsys.kitalpha.transposer.transformation.emf.util.EmfDomainHelper;


/**
 * A domain helper dedicated to the Capella2Apa bridge.
 * @author Olivier Constant
 */
public class CapellaDomainHelper extends EmfDomainHelper {
  
  /** The file extension for Capella models */
  public static final String CAPELLA_FILE_EXT = "melodymodeller"; //$NON-NLS-1$
  
  /**
   * @see org.polarsys.kitalpha.transposer.transformation.emf.util.EmfDomainHelper#isDomainFor(java.lang.Object)
   */
  @Override
  public boolean isDomainFor(Object object_p) {
    boolean isDomain = false ; 
    if (object_p instanceof IFile) {
      IFile file = (IFile) object_p;
      isDomain = CAPELLA_FILE_EXT.equals(file.getFileExtension());
    }
    
    if(object_p instanceof CapellaElement){
      isDomain = true;
    }
    return isDomain;
  }
  
  /**
   * @see org.polarsys.kitalpha.transposer.transformation.emf.util.EmfDomainHelper#getEPackages()
   */
  @Override
  protected Set<EPackage> getEPackages() {
    Set<EPackage> eAllPackages = new LinkedHashSet<EPackage>();
    eAllPackages.add(PaPackage.eINSTANCE);
    eAllPackages.add(FaPackage.eINSTANCE);
    return eAllPackages;
  }
  
  /**
   * @see org.polarsys.kitalpha.transposer.transformation.emf.util.EmfDomainHelper#isHotSpot(java.lang.Object)
   */
  @Override
  public boolean isHotSpot(Object object_p) {
    return object_p instanceof CapellaElement;
  }
  
  /**
   * @see org.polarsys.kitalpha.transposer.transformation.emf.util.EmfDomainHelper#getAnalysisSources(java.util.Collection)
   */
  @Override
  public Collection<Object> getAnalysisSources(Collection<?> selection_p) {
    Collection<Object> sources = new ArrayList<Object>();
    for (Object sel : selection_p) {
      if (sel instanceof CapellaElement) {
        Iterator<EObject> it = ((CapellaElement) sel).eAllContents();
        while (it.hasNext())
          sources.add(it.next());
      }

    }
    return sources;
  }
  
  /**
   * @see org.polarsys.kitalpha.transposer.transformation.emf.util.EmfDomainHelper#getDomainMetaclass(java.lang.String)
   */
  @Override
  public java.lang.Class<?> getDomainMetaclass(String name_p) {
    try {
      return java.lang.Class.forName(name_p);
    } catch (ClassNotFoundException e) {
      TransposerEMFPlugin.getDefault().getLog().log(
          new Status(IStatus.ERROR, TransposerEMFPlugin.PLUGIN_ID,
              "No Domain Class called : " + name_p, e)); //$NON-NLS-1$
    }
    return null;
  }
  
}
