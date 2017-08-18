/*******************************************************************************
 * Copyright (c) 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.amalgam.explorer.activity.sirius;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.eclipse.amalgam.explorer.activity.ui.api.editor.pages.CommonActivityExplorerPage;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.sirius.ui.editor.SessionEditorPlugin;
import org.eclipse.sirius.ui.editor.api.pages.AbstractSessionEditorPage;
import org.eclipse.sirius.ui.editor.api.pages.PageProviderRegistry.PositioningKind;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;

/**
 * Provides an index-like page which gives access to all the individual activity
 * pages.
 * 
 * @author pcdavid
 */
public class OverviewPage extends AbstractSessionEditorPage {
    /**
     * The unique identifier for the overview page.
     */
    public static final String SIRIUS_ACTIVITIES_OVERVIEW = "sirius.activitiesOverview";

    /**
     * All the activity pages this overview should display and give access to.
     */
    private final List<CommonActivityExplorerPage> activityPages;

    public OverviewPage(List<CommonActivityExplorerPage> activityPages) {
        super(SIRIUS_ACTIVITIES_OVERVIEW, "Workflow");
        this.activityPages = new ArrayList<>(activityPages);
    }

    @Override
    protected void createFormContent(IManagedForm managedForm) {
        super.createFormContent(managedForm);
        FormToolkit toolkit = managedForm.getToolkit();
        final ScrolledForm scrolledForm = managedForm.getForm();
        scrolledForm.setText("Workflow of " + this.getEditor().getTitle().replaceAll("\\.aird$", ""));
        toolkit.decorateFormHeading(scrolledForm.getForm());

        Composite body = managedForm.getForm().getBody();
        body.setLayout(GridLayoutFactory.swtDefaults().create());

        Composite subBody = toolkit.createComposite(body);
        subBody.setLayout(GridLayoutFactory.swtDefaults().numColumns(2).equalWidth(false).create());
        subBody.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

        Text pagesLists = new Text(subBody, SWT.MULTI);
        StringBuilder sb = new StringBuilder("Known activity pages:\n");
        activityPages.forEach(p -> {
            sb.append(" - ").append(p.getId()).append(": ").append(p.getTitle()).append("\n");
        });
        pagesLists.setText(sb.toString());
    }

    @Override
    public Optional<String> getLocationId() {
        return Optional.of(SessionEditorPlugin.DEFAULT_PAGE_ID);
    }

    @Override
    public Optional<PositioningKind> getPositioning() {
        return Optional.of(PositioningKind.AFTER);
    }
}
