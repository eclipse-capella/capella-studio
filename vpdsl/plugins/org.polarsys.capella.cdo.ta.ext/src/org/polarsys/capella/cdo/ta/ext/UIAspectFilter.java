/*******************************************************************************
 * Copyright (c) 2016, 2019 Thales Global Services.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *   Thales - initial API and implementation
 *******************************************************************************/
package org.polarsys.capella.cdo.ta.ext;

import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.core.extension.AbstractAspectExtensionFilter;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.Aspect;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpui.UIDescription;
/**
 * @author Thomas Guiu
 */
public class UIAspectFilter extends AbstractAspectExtensionFilter {

	@Override
	public boolean acceptAspect(Aspect aspect) {
		return aspect instanceof UIDescription;
	}

}
