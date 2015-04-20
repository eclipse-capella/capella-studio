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


import org.eclipse.core.runtime.IProduct;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.StringConverter;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Point;
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

		Rectangle messageRect = StringConverter.asRectangle(messageRectString, new Rectangle(10, 35, 300, 15));
		setMessageRect(messageRect);

		int foregroundColorInteger;
		try {
			foregroundColorInteger = Integer.parseInt(foregroundColorString, 16);
		} catch (Exception ex) {
			foregroundColorInteger = 0x726ba6; // off white
		}

		setForeground(new RGB((foregroundColorInteger & 0xFF0000) >> 16, (foregroundColorInteger & 0xFF00) >> 8, foregroundColorInteger & 0xFF));

		// Custom
		Version version2 = product.getDefiningBundle().getVersion();

		StringBuilder builder = new StringBuilder();
		builder.append("Version : ");
		builder.append(version2.getMajor()).append('.');
		builder.append(version2.getMinor()).append('.');
		builder.append(version2.getMicro()).append("");
		builder.append("\n");
		builder.append("Build id : ");
		builder.append(version2.getQualifier());
		final String text = builder.toString();

		final Point buildIdPoint = new Point(240, 205);
		getContent().addPaintListener(new PaintListener() {

			public void paintControl(PaintEvent e) {
				e.gc.setForeground(getForeground());

				FontData[] fontData = e.gc.getFont().getFontData();
				for (int i = 0; i < fontData.length; ++i)
					fontData[i].setHeight(12);
				final Font newFont = new Font(e.display, fontData);
				e.gc.setFont(newFont);

				e.gc.drawText(text, buildIdPoint.x, buildIdPoint.y, true);
			}
		});
	}

}
