/*******************************************************************************
* Copyright (c) 2006, 2015 THALES GLOBAL SERVICES.
* This program and the accompanying materials are made available under the
* terms of the Eclipse Public License 2.0 which is available at
* http://www.eclipse.org/legal/epl-2.0
*
* SPDX-License-Identifier: EPL-2.0
*
* Contributors:
*    Thales - initial API and implementation
*******************************************************************************/
package org.polarsys.capella.ad.viewpoint.dsl.generation.ui.extensions;

import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.Aspect;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpui.UIDescription;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.core.extension.AbstractAspectExtensionFilter;

/**
 * @author Boubekeur Zendagui
 */
public class UIAspectFilter extends AbstractAspectExtensionFilter {

	@Override
	public boolean acceptAspect(Aspect aspect) {
		return aspect instanceof UIDescription;
	}

}
