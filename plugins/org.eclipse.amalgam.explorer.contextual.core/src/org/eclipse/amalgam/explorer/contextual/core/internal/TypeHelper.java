/******************************************************************************
 * Copyright (c) 2006, 2015 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *    Thales - initial API and implementation
 *****************************************************************************/
package org.eclipse.amalgam.explorer.contextual.core.internal;

/**
 * 
 */
public class TypeHelper {
	/**
	 * Singleton.
	 */
	protected static TypeHelper typeHelper = null;

	/**
	 * Constructor.
	 */
	private TypeHelper() {
	}

	public static TypeHelper getInstance() {
		if (typeHelper == null) {
			typeHelper = new TypeHelper();
		}
		return typeHelper;
	}

	/**
	 * 
	 * @param element
	 * @param type
	 * @return
	 */
	public boolean isInstanceOf(Object element, String type) {
		// null isn't an instance of of anything.
		if (element == null)
			return false;
		return isSubtype(element.getClass(), type);
	}

	/**
	 * 
	 * @param clazz
	 * @param type
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	private boolean isSubtype(Class clazz, String type) {
		if (clazz.getName().equals(type))
			return true;
		Class superClass = clazz.getSuperclass();
		if (superClass != null && isSubtype(superClass, type))
			return true;
		Class[] interfaces = clazz.getInterfaces();
		for (int i = 0; i < interfaces.length; i++) {
			if (isSubtype(interfaces[i], type))
				return true;
		}
		return false;
	}
}
