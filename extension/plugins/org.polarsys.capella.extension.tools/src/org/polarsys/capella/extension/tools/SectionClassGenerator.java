/*******************************************************************************
 * Copyright (c) 2015, 2020 Thales Global Services S.A.S.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 *  
 * Contributors:
 *   Thales Global Services S.A.S - initial API and implementation
 *******************************************************************************/
package org.polarsys.capella.extension.tools;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.polarsys.capella.core.data.capellacore.CapellacorePackage;
import org.polarsys.capella.extension.tools.HelperClassGenerator.HelperInfo;
import org.w3c.dom.Document;
import org.w3c.dom.Element;


/**
 * @author Thomas Guiu
 * 
 */
public final class SectionClassGenerator {

	public static boolean needSection(GenClass model) {
		for (EClass parent : model.getEcoreClass().getESuperTypes()) {
			if (CapellacorePackage.eINSTANCE.getNsURI().equals(parent.getEPackage().getNsURI()) && CapellacorePackage.eINSTANCE.getNamedElement().getName().equals(parent.getName())) {
				return true;
			}
		}
		return false;
	}

	public static String getClassname(GenClass model) {
		return model.getInterfaceName() + "Section";
	}

	public static String getFilterTest(GenClass model) {
		GenPackage genPackage = model.getGenPackage();
		return "obj != null && obj.eClass().equals(" + genPackage.getInterfacePackageName() + '.' + genPackage.getBasicPackageName() + ".eINSTANCE.get" + model.getEcoreClass().getName() + "())";
	}

	public static String getPackagename(GenClass model) {
		return model.getGenPackage().getProviderPackageName() + ".sections";
	}

	public static String getFullClassname(GenClass model) {
		return model.getGenPackage().getQualifiedPackageName() + '.' + model.getEcoreClass().getName();
	}

	public static String getFullSectionClassname(GenClass model) {
		return getPackagename(model) + '.' + model.getEcoreClass().getName() + "Section";
	}

	public static void declareSections(Element root, GenModel genModel) {
		Document doc = root.getOwnerDocument();
		Element extension = createExtensionNode(root, doc);

		Element itemContribution = doc.createElement("propertySections");
		itemContribution.setAttribute("contributorId", "org.polarsys.capella.core.data.capellamodeller.properties");
		itemContribution.appendChild(doc.createTextNode("\n"));
		TreeIterator<EObject> eAllContents = genModel.eAllContents();
		while (eAllContents.hasNext()) {
			EObject obj = eAllContents.next();
			if (obj instanceof GenClass) {
				GenClass genClass = (GenClass) obj;
				HelperInfo info = HelperClassGenerator.getInfo(genClass.getEcoreClass());
				if (info == null || info.getSectionClass() == null) {
					continue;
				}
				Element subItemContribution = doc.createElement("propertySection");
				subItemContribution.setAttribute("class", info.getSectionClass());
				subItemContribution.setAttribute("filter", SectionClassGenerator.getFullSectionClassname(genClass));
				subItemContribution.setAttribute("id", MenuContributorClassGenerator.getFullClassname(genClass) + ".section");
				subItemContribution.setAttribute("tab", "BaseCapella");
				itemContribution.appendChild(doc.createTextNode("        "));
				itemContribution.appendChild(subItemContribution);
				itemContribution.appendChild(doc.createTextNode("\n"));
				Element input = doc.createElement("input");
				GenPackage genPackage = genClass.getGenPackage();
				input.setAttribute("type", genPackage.getInterfacePackageName() + "." + genClass.getName());
				subItemContribution.appendChild(doc.createTextNode("\n"));
				subItemContribution.appendChild(doc.createTextNode("            "));
				subItemContribution.appendChild(input);
				subItemContribution.appendChild(doc.createTextNode("\n"));
				subItemContribution.appendChild(doc.createTextNode("        "));
			}
		}
		extension.appendChild(itemContribution);
		extension.appendChild(doc.createTextNode("\n"));
		extension.appendChild(doc.createTextNode("    "));

		extension = createExtensionNode(root, doc);
		itemContribution = doc.createElement("propertySections");
		itemContribution.setAttribute("contributorId", "org.eclipse.sirius.diagram.ui");
		itemContribution.appendChild(doc.createTextNode("\n"));
		eAllContents = genModel.eAllContents();
		while (eAllContents.hasNext()) {
			EObject obj = eAllContents.next();
			if (obj instanceof GenClass) {
				GenClass genClass = (GenClass) obj;
				HelperInfo info = HelperClassGenerator.getInfo(genClass.getEcoreClass());
				if (info == null || info.getSectionClass() == null) {
					continue;
				}
				boolean needSection = SectionClassGenerator.needSection(genClass);
				Element subItemContribution = doc.createElement("propertySection");
				subItemContribution.setAttribute("class", needSection ? SectionClassGenerator.getFullSectionClassname(genClass) : info.getSectionClass());
				subItemContribution.setAttribute("filter", SectionClassGenerator.getFullSectionClassname(genClass));
				subItemContribution.setAttribute("id", SectionClassGenerator.getFullSectionClassname(genClass) + ".section");
				subItemContribution.setAttribute("tab", "BaseSiriusDiagram");
				itemContribution.appendChild(doc.createTextNode("        "));
				itemContribution.appendChild(subItemContribution);
				itemContribution.appendChild(doc.createTextNode("\n"));
				subItemContribution.appendChild(doc.createTextNode("\n"));
				subItemContribution.appendChild(doc.createTextNode("        "));
			}
		}
		extension.appendChild(itemContribution);
		extension.appendChild(doc.createTextNode("\n"));
		extension.appendChild(doc.createTextNode("    "));
	}

	private static Element createExtensionNode(Element root, Document doc) {
		root.appendChild(doc.createTextNode("\n"));
		root.appendChild(doc.createComment("@generated"));
		root.appendChild(doc.createTextNode("\n  "));

		Element extension = doc.createElement("extension");
		extension.setAttribute("point", "org.eclipse.ui.views.properties.tabbed.propertySections");
		extension.appendChild(doc.createTextNode("\n"));
		extension.appendChild(doc.createTextNode("    "));
		root.appendChild(extension);
		root.appendChild(doc.createTextNode("\n"));
		return extension;
	}

	private SectionClassGenerator() {
		super();
	}

}
