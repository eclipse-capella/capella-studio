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

/**
 * Generation internal structure for a business annotation.
 *
 * Copied from main capella repo: \releng\plugins\org.polarsys.capella.core.egf\src\org\polarsys\capella\core\egf
 */
public class BusinessAnnotation {
  private String _namingAttribute;
  private String _idAttribute;
  
  /**
   * 
   */
  public BusinessAnnotation() {
  }

  /**
   * @return the namingAttribute
   */
  public String getNamingAttribute() {
    return _namingAttribute;
  }

  /**
   * @param namingAttribute_p the namingAttribute to set
   */
  public void setNamingAttribute(String namingAttribute_p) {
    _namingAttribute = namingAttribute_p;
  }

  /**
   * @return the idAttribute
   */
  public String getIdAttribute() {
    return _idAttribute;
  }

  /**
   * @param idAttribute_p the idAttribute to set
   */
  public void setIdAttribute(String idAttribute_p) {
    _idAttribute = idAttribute_p;
  }
  
  
  

}
