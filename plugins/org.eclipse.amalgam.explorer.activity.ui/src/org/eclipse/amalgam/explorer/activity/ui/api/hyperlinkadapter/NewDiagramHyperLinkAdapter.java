/*******************************************************************************
 * Copyright (c)  2006, 2015 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Thales - initial API and implementation
 *******************************************************************************/
package org.eclipse.amalgam.explorer.activity.ui.api.hyperlinkadapter;

import org.eclipse.amalgam.explorer.activity.ui.api.manager.ActivityExplorerManager;

public class NewDiagramHyperLinkAdapter extends AbstractNewDiagramHyperlinkAdapter {

	protected String name;

	public NewDiagramHyperLinkAdapter() {
		super(ActivityExplorerManager.INSTANCE.getRootSemanticModel());
	}

	@Override
	public String getRepresentationName() {
		return name;
	}

}
