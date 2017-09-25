/*******************************************************************************
 * Copyright (c) 2006, 2017 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *    Thales - initial API and implementation
 *******************************************************************************/
package org.polarsys.capella.extension.tools.annotation;

import java.util.List;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;

/**
 * Helper for generation of business relative interests
 *
 * Copied from main capella repo: \releng\plugins\org.polarsys.capella.core.egf\src\org\polarsys\capella\core\egf
 */
public class BusinessGenHelper {
  /**
   * Return the naming feature if found in all genfeatures of a genClass
   * @param genModel_p
   * @param genClass_p
   * @return
   */
  public static GenFeature getNamingAttribute(GenModel genModel_p, GenClass genClass_p) {
    GenFeature result = null;
    List<GenFeature> genFeatures = genClass_p.getAllGenFeatures();
    for (GenFeature genFeature : genFeatures) {
      BusinessAnnotation businessAnnotation = BusinessAnnotationHelper.getBusinessAnnotation(genModel_p, genFeature);
      if (businessAnnotation != null && businessAnnotation.getNamingAttribute() != null) {
        result = genFeature;
      }
    }
    return result;
  }

  /**
   * Return the id feature if found in all genfeatures of a genClass
   * @param genModel_p
   * @param genClass_p
   * @return
   */
  public static GenFeature getIdAttribute(GenModel genModel_p, GenClass genClass_p) {
    GenFeature result = null;
    List<GenFeature> genFeatures = genClass_p.getAllGenFeatures();
    for (GenFeature genFeature : genFeatures) {
      BusinessAnnotation businessAnnotation = BusinessAnnotationHelper.getBusinessAnnotation(genModel_p, genFeature);
      if (businessAnnotation != null && businessAnnotation.getIdAttribute() != null) {
        result = genFeature;
      }
    }
    return result;
  }
}
