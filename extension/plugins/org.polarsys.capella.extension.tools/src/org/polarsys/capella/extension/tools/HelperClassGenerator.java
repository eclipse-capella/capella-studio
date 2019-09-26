/*******************************************************************************
 * Copyright (c) 2015, 2019 Thales Global Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *   Thales Global Services S.A.S - initial API and implementation
 *******************************************************************************/
package org.polarsys.capella.extension.tools;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.core.dom.Modifier;

/**
 * 
 * @author Thomas Guiu
 * 
 */
public final class HelperClassGenerator {

	public static final List<String> SUPPORTED_TYPES = new ArrayList<>();

	private HelperClassGenerator() {
	}

	public static String getHelperClassname(GenPackage model) {
		String packageName = model.getPackageName();
		return Character.toUpperCase(packageName.charAt(0)) + packageName.substring(1) + "PackageHelper";
	}

	public static String getHelperClassname(GenClass model) {
		String className = model.getInterfaceName();
		return Character.toUpperCase(className.charAt(0)) + className.substring(1) + "Helper";
	}

	public static String getHelperPackagename(GenPackage model) {
		return model.getGenModel().getModelPluginID() + ".helpers";
	}

	public static String getHelperFullClassname(GenPackage model) {
		return getHelperPackagename(model) + "." + getHelperClassname(model);
	}

	public static void registerHelperAndSection(EClass eclass, Class helperClass, Class sectionClass) {
		registerHelper(eclass, helperClass, null, sectionClass);
	}

	public static void registerHelperAndSection(EClass eclass, Class helperClass, Class menuContributorBaseClass, Class sectionClass) {
		registerHelper(eclass, helperClass, menuContributorBaseClass, sectionClass);
	}

	public static void registerHelper(EClass eclass, Class helperClass) {
		registerHelper(eclass, helperClass, null, null);
	}

	public static void registerHelper(EClass eclass, Class helperClass, Class menuContributorBaseClass) {
		registerHelper(eclass, helperClass, menuContributorBaseClass, null);
	}

	private static void registerHelper(EClass eclass, Class helperClass, Class menuContributorBaseClass, Class sectionClass) {
		HelperInfo info = null;
		String eclassStr = getEClassName(eclass);
		String menuContributorBaseClassStr = menuContributorBaseClass == null ? null : menuContributorBaseClass.getCanonicalName();
		String sectionClassStr = sectionClass == null || Modifier.isAbstract(sectionClass.getModifiers()) ? null : sectionClass.getCanonicalName();

		if (helperClass == null) {
			info = new HelperInfo(eclassStr, null, null, menuContributorBaseClassStr, sectionClassStr);
			infos.put(eclassStr, info);
			return;
		}

		for (Method method : helperClass.getDeclaredMethods()) {
			if ("doSwitch".equals(method.getName())) {
				Class<?>[] parameterTypes = method.getParameterTypes();
				if (parameterTypes.length == 2 && EStructuralFeature.class.equals(parameterTypes[1])) {
					String helperClassStr = helperClass.getCanonicalName();
					info = new HelperInfo(eclassStr, parameterTypes[0].getCanonicalName(), helperClassStr, menuContributorBaseClassStr, sectionClassStr);
					infos.put(eclassStr, info);
					return;
				}
			}
		}
		throw new IllegalStateException("cannot handle Eclass" + eclass);
	}

	private static String getEClassName(EClass eclass) {
		return eclass.getEPackage().getName() + "." + eclass.getName();
	}

	public static HelperInfo getInfo(EClass clazz) {
		HelperInfo result = doGetInfo(clazz);
		if (result != null)
		{
			return result;
		}
		for (EClass superECls : clazz.getESuperTypes()) {
			result = doGetInfo(superECls);
			if (result != null)
			{
				return result;
			}
		}
		for (EClass superECls : clazz.getESuperTypes()) {
			result = getInfo(superECls);
			if (result != null)
			{
				return result;
			}
		}
		return null;
	}

	private static HelperInfo doGetInfo(EClass clazz) {
		return infos.get(getEClassName(clazz));
	}

	public static List<HelperInfo> getInfos(EPackage pack) {
		Set<String> names = new HashSet<>();
		for (EClassifier classifier : pack.getEClassifiers()) {
			if (classifier instanceof EClass) {
				EClass eclass = (EClass) classifier;
				for (EClass superECls : eclass.getEAllSuperTypes()) {
					names.add(getEClassName(superECls));
				}
			}
		}
		List<HelperInfo> result = new ArrayList<>();
		for (Entry<String, HelperInfo> info: infos.entrySet()) {
			String name = info.getKey();
			if (names.contains(name)) {
				result.add(infos.get(name));
			}
		}

		return result;
	}

	public static class HelperInfo {

		public HelperInfo(String eClass, String fullClassname, String helperClass, String menuContributorBaseClass, String sectionClass) {
			super();
			this.eClass = eClass;
			this.fullClassname = fullClassname;
			this.helperClass = helperClass;
			this.menuContributorBaseClass = menuContributorBaseClass;
			this.sectionClass = sectionClass;
		}

		public HelperInfo(String eClass, String fullClassname, String helperClass) {
			this(eClass, fullClassname, helperClass, null, null);
		}

		private final String helperClass;
		private final String eClass;
		private final String fullClassname;
		private final String menuContributorBaseClass;
		private String sectionClass;

		public String getHelperClass() {
			return helperClass;
		}

		public String getEClass() {
			return eClass;
		}

		public String getFullClassname() {
			return fullClassname;
		}

		public String getMenuContributorBaseClass() {
			return menuContributorBaseClass;
		}

		public String getSectionClass() {
			return sectionClass;
		}

	}

	// We now care about order, Info objects are used to build a kind of emf
	// switch
	private static final Map<String, HelperInfo> infos = new LinkedHashMap<>();

}
