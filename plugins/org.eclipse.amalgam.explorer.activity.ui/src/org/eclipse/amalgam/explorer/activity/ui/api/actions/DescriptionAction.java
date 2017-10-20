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
package org.eclipse.amalgam.explorer.activity.ui.api.actions;

import org.eclipse.swt.widgets.Shell;

/**
 * Concrete implements of AbstractDescriptionAction which takes a fixed string
 * as description.
 */
public class DescriptionAction extends AbstractDescriptionAction {
    private final String description;

    public DescriptionAction(Shell shell, String description) {
        super(shell);
        this.description = description;
        setEnabled(null != getDescriptionContent());
    }

    @Override
    protected String getDescriptionContent() {
        return description;
    }

}
