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

import java.util.Optional;
import java.util.TreeSet;

import org.eclipse.amalgam.explorer.activity.ui.ActivityExplorerActivator;
import org.eclipse.amalgam.explorer.activity.ui.api.configuration.ActivityExplorerPageConfiguration;
import org.eclipse.amalgam.explorer.activity.ui.api.editor.pages.CommonActivityExplorerPage;
import org.eclipse.amalgam.explorer.activity.ui.api.editor.pages.helper.FormHelper.LayoutType;
import org.eclipse.amalgam.explorer.activity.ui.api.editor.sections.ActivityExplorerSection;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.sirius.ui.editor.api.pages.AbstractSessionEditorPage;
import org.eclipse.sirius.ui.editor.api.pages.PageProviderRegistry.PositioningKind;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;

/**
 * Displays activities organized in (collapsible) sections.
 * 
 * @author pcdavid
 */
public class ActivityPage extends AbstractSessionEditorPage {
    /**
     * The underlying page implementation from the Amalgam codebase.
     */
    private final CommonActivityExplorerPage delegatedPage;

    /**
     * 
     */
    private final String predecessorId;

    public ActivityPage(CommonActivityExplorerPage activityPage, String predecessorId) {
        super("sirius.activity." + activityPage.getId(), activityPage.getTitle());
        this.delegatedPage = activityPage;
        this.predecessorId = predecessorId;
    }

    @Override
    protected void createFormContent(IManagedForm managedForm) {
        super.createFormContent(managedForm);
        FormToolkit toolkit = managedForm.getToolkit();
        final ScrolledForm scrolledForm = managedForm.getForm();
        scrolledForm.setText(delegatedPage.getTitle());
        toolkit.decorateFormHeading(scrolledForm.getForm());

        Composite body = managedForm.getForm().getBody();
        body.setLayout(GridLayoutFactory.swtDefaults().create());

        Composite subBody = toolkit.createComposite(body);
        subBody.setLayout(GridLayoutFactory.swtDefaults().numColumns(2).equalWidth(false).create());
        subBody.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

        Composite sectionContainer = createSectionContainer(subBody, managedForm);

        TreeSet<ActivityExplorerSection> sections = ((ActivityExplorerPageConfiguration) delegatedPage.getConfiguration()).getSections();
        for (ActivityExplorerSection section : sections) {
            // Create a new "clone" section attached to this page.
            new ActivityExplorerSection(section.getConfiguration(), ActivityExplorerActivator.getDefault().getPreferenceStore()).initialize(sectionContainer, this, managedForm);
        }
    }

    protected Composite createSectionContainer(Composite parent, IManagedForm managedForm) {
        Composite container = org.eclipse.amalgam.explorer.activity.ui.api.editor.pages.helper.FormHelper.createCompositeWithLayoutType(managedForm.getToolkit(), parent, LayoutType.TABLEWRAP_LAYOUT,
                1, true);
        container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true));
        return container;
    }

    @Override
    public Optional<String> getLocationId() {
        if (OverviewPage.SIRIUS_ACTIVITIES_OVERVIEW.equals(predecessorId)) {
            return Optional.of(OverviewPage.SIRIUS_ACTIVITIES_OVERVIEW);
        } else {
            return Optional.of("sirius.activity." + predecessorId);
        }
    }

    @Override
    public Optional<PositioningKind> getPositioning() {
        return Optional.of(PositioningKind.AFTER);
    }
}
