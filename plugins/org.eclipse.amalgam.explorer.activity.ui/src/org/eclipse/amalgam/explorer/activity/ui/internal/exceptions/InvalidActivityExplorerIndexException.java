/*******************************************************************************
 * Copyright (c)  2006, 2016 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Thales - initial API and implementation
 *******************************************************************************/
package org.eclipse.amalgam.explorer.activity.ui.internal.exceptions;

public class InvalidActivityExplorerIndexException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public InvalidActivityExplorerIndexException() {
		super();
	}
	
	public InvalidActivityExplorerIndexException(String message){
		super(message);
	}
}
