/*******************************************************************************
 * Copyright (c) 2007, 2009 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     THALES GLOBAL SERVICES 
 *******************************************************************************/
package org.polarsys.capella.studio.product;



import org.eclipse.core.runtime.IBundleGroup;
import org.eclipse.core.runtime.IBundleGroupProvider;
import org.eclipse.core.runtime.IProduct;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.StringConverter;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.branding.IProductConstants;
import org.eclipse.ui.splash.BasicSplashHandler;
import org.osgi.framework.Version;

public class CapellaStudioSplashHandler extends BasicSplashHandler {
	/**
	 * Copied from EclipseSplashHandler
	 */
	public void init(Shell splash) {
		super.init(splash);
		String progressRectString = null;
		String messageRectString = null;
		String foregroundColorString = null;
		IProduct product = Platform.getProduct();
		if (product != null) {
			progressRectString = product.getProperty(IProductConstants.STARTUP_PROGRESS_RECT);
			messageRectString = product.getProperty(IProductConstants.STARTUP_MESSAGE_RECT);
			foregroundColorString = product.getProperty(IProductConstants.STARTUP_FOREGROUND_COLOR);
		}
		Rectangle progressRect = StringConverter.asRectangle(progressRectString, new Rectangle(1, 10, 452, 15));
		setProgressRect(progressRect);

		Rectangle messageRect = StringConverter.asRectangle(messageRectString, new Rectangle(10, 35, 300, 25));
		setMessageRect(messageRect);

		int foregroundColorInteger;
		try {
			foregroundColorInteger = Integer.parseInt(foregroundColorString, 16);
		} catch (Exception ex) {
			foregroundColorInteger = 0x726ba6; // off white
		}

		setForeground(new RGB((foregroundColorInteger & 0xFF0000) >> 16, (foregroundColorInteger & 0xFF00) >> 8, foregroundColorInteger & 0xFF));

		// Custom
		Version studioVersion = product.getDefiningBundle().getVersion();
		String capellaVersion = "n/a";
		String kitalphaVersion = "n/a";
		for (IBundleGroupProvider bundleGroupProvider : Platform.getBundleGroupProviders())
		{
			for (IBundleGroup bundleGroups : bundleGroupProvider.getBundleGroups())
			{
				if ("org.polarsys.capella.core.advance.feature".equals(bundleGroups.getIdentifier()))
					capellaVersion = bundleGroups.getVersion();
				else if ("org.polarsys.kitalpha.sdk.feature".equals(bundleGroups.getIdentifier()))
					kitalphaVersion = bundleGroups.getVersion();
			}
		}
		StringBuilder builder = new StringBuilder();
		builder.append(studioVersion.getMajor()).append('.');
		builder.append(studioVersion.getMinor()).append('.');
		builder.append(studioVersion.getMicro()).append('.');
		builder.append(studioVersion.getQualifier());
		final String text = builder.toString();
		final String fCapellaVersion = "Capella\t"+capellaVersion;
		final String fKitalphaVersion = "Kitalpha\t"+kitalphaVersion;

		getContent().addPaintListener(new PaintListener() {

			public void paintControl(PaintEvent e) {

				e.gc.setForeground(new Color(getSplash().getShell().getDisplay(), new RGB(38, 32, 87)));
				Font newFont = computeFont(e, 11);
				e.gc.setFont(newFont);
				e.gc.drawText(text, 325, 185, true);
				
				e.gc.setForeground(getForeground());
				newFont = computeFont(e, 9);
				e.gc.setFont(newFont);
				e.gc.drawText(fCapellaVersion, 10, 255, true);
				e.gc.drawText(fKitalphaVersion, 10, 275, true);
				newFont.dispose();
			}

			private Font computeFont(PaintEvent e, int height) {
				FontData[] fontData = e.gc.getFont().getFontData();
				for (int i = 0; i < fontData.length; ++i)
					fontData[i].setHeight(height);
				final Font newFont = new Font(e.display, fontData);
				return newFont;
			}
		});
	}

}
