/*******************************************************************************
 * Copyright (c) 2007, 2020 IBM Corporation and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     THALES GLOBAL SERVICES 
 *******************************************************************************/
package org.polarsys.capella.studio.product;

import org.eclipse.core.runtime.IProduct;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.StringConverter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.branding.IProductConstants;
import org.eclipse.ui.splash.BasicSplashHandler;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.Version;

public class CapellaStudioSplashHandler extends BasicSplashHandler {
	
	private static final String NOT_APPLICABLE = "n/a";
	private static final String FOREGROUND_COLOR_HTML = "262057";
	
	/**
	 * Copied from EclipseSplashHandler
	 */
	@Override
	public void init(Shell splash) {
		super.init(splash);
		String progressRectString = null;
		String messageRectString = null;
		IProduct product = Platform.getProduct();
		if (product != null) {
			progressRectString = product.getProperty(IProductConstants.STARTUP_PROGRESS_RECT);
			messageRectString = product.getProperty(IProductConstants.STARTUP_MESSAGE_RECT);
		}
		Rectangle progressRect = StringConverter.asRectangle(progressRectString, new Rectangle(1, 10, 452, 15));
		setProgressRect(progressRect);

		Rectangle messageRect = StringConverter.asRectangle(messageRectString, new Rectangle(10, 35, 300, 25));
		setMessageRect(messageRect);

		int foregroundColorInteger;
		try {
			foregroundColorInteger = Integer.parseInt(FOREGROUND_COLOR_HTML, 16);
		} catch (Exception ex) {
			foregroundColorInteger = 0x726ba6; // off white
		}

		setForeground(new RGB((foregroundColorInteger & 0xFF0000) >> 16, (foregroundColorInteger & 0xFF00) >> 8, foregroundColorInteger & 0xFF));

		// Custom
		Version studioVersion = null;
		if (product != null) {
			Bundle definingBundle = product.getDefiningBundle();
			if (definingBundle != null) {
				studioVersion = definingBundle.getVersion();
			}
		}
		String capellaVersion = NOT_APPLICABLE;
		String kitalphaVersion = NOT_APPLICABLE;
		
		Bundle kitalphaAdServicesBundle = FrameworkUtil.getBundle(org.polarsys.kitalpha.ad.services.ToolIntegrationHelper.class);
		if (kitalphaAdServicesBundle != null) {
			String kitalphaAdServicesBundleVersion = kitalphaAdServicesBundle.getVersion().toString();
			kitalphaVersion = trunkQualifier(kitalphaAdServicesBundleVersion);
		}
		
		Bundle capellaPerspectiveBundle = FrameworkUtil.getBundle(org.polarsys.capella.core.platform.sirius.ui.perspective.CapellaSplashHandler.class);
		if (capellaPerspectiveBundle != null) {
			String capellaPerspectiveBundleVersion = capellaPerspectiveBundle.getVersion().toString();
			capellaVersion = trunkQualifier(capellaPerspectiveBundleVersion);
		}
		
		StringBuilder builder = new StringBuilder();
		builder.append(studioVersion != null? studioVersion.getMajor() : NOT_APPLICABLE).append('.');
		builder.append(studioVersion != null? studioVersion.getMinor() : NOT_APPLICABLE).append('.');
		builder.append(studioVersion != null? studioVersion.getMicro() : NOT_APPLICABLE).append('.');
		builder.append(studioVersion != null? studioVersion.getQualifier() : NOT_APPLICABLE);
		final String fCapellaStudioVersion = "Version " + builder.toString();
		final String fCapellaVersion =  "Capella  "+ capellaVersion;
		final String fKitalphaVersion = "Kitalpha "+ kitalphaVersion;
		
		Font font = new Font(getContent().getDisplay(), new FontData("Arial", 11, SWT.BOLD));
		
		Label versionLabel = new Label(getContent(), SWT.RIGHT);
		versionLabel.setForeground(getForeground());
		versionLabel.setFont(font);
		versionLabel.setBounds(220, 250, 210, 20);
		versionLabel.setText(fCapellaStudioVersion);

		Label capellaVersionLabel = new Label(getContent(), SWT.LEFT);
		capellaVersionLabel.setForeground(getForeground());
		capellaVersionLabel.setFont(font);
		capellaVersionLabel.setBounds(20, 250, 100, 20);
		capellaVersionLabel.setText(fCapellaVersion);

		Label kitalphaVersionLabel = new Label(getContent(), SWT.LEFT);
		kitalphaVersionLabel.setForeground(getForeground());
		kitalphaVersionLabel.setFont(font);
		kitalphaVersionLabel.setBounds(20, 270, 100, 20);
		kitalphaVersionLabel.setText(fKitalphaVersion);
	}
	
	private String trunkQualifier(String version) {
		int index = version.lastIndexOf('.');
		if (index < 0) {
			return version;
		}
		return version.substring(0, index);
	}

}
