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

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.eclipse.amalgam.explorer.activity.ui.api.editor.pages.CommonActivityExplorerPage;
import org.eclipse.amalgam.explorer.activity.ui.api.editor.pages.OverviewActivityExplorerPage;
import org.eclipse.amalgam.explorer.activity.ui.internal.extension.point.manager.ActivityExplorerExtensionManager;
import org.eclipse.sirius.ui.editor.SessionEditor;
import org.eclipse.sirius.ui.editor.api.pages.AbstractSessionEditorPage;
import org.eclipse.sirius.ui.editor.api.pages.PageProvider;

/**
 * Provides a unique "Overview" index page followed by one page for each
 * Activity Explorer page into the Sirius session editor.
 * 
 * @author pcdavid
 */
public class ActivityExplorerPagesProvider extends PageProvider {
    /**
     * All the pages registered in the Activity Explorer using the extension
     * point.
     */
    private List<CommonActivityExplorerPage> allPages = ActivityExplorerExtensionManager.getAllPages();

    /**
     * For each page, returns the ID of the page that should be to its left.
     */
    private Map<CommonActivityExplorerPage, String> predecessors = computePredecessors(allPages);

    @Override
    public boolean provides(String pageId) {
        return OverviewPage.SIRIUS_ACTIVITIES_OVERVIEW.equals(pageId) || allPages.stream().anyMatch(p -> p.getId().equals(pageId));
    }

    @Override
    public Map<String, Supplier<AbstractSessionEditorPage>> getPages(SessionEditor editor) {
        Map<String, Supplier<AbstractSessionEditorPage>> result = new HashMap<>();
        result.put(OverviewPage.SIRIUS_ACTIVITIES_OVERVIEW, () -> new OverviewPage(allPages));
        allPages.forEach(page -> {
            if (!(page instanceof OverviewActivityExplorerPage)) {
                result.put(page.getId(), () -> new ActivityPage(page, predecessors.get(page)));
            }
        });
        return result;
    }

    private Map<CommonActivityExplorerPage, String> computePredecessors(List<CommonActivityExplorerPage> pages) {
        List<CommonActivityExplorerPage> sortedPages = pages.stream().filter(p -> !(p instanceof OverviewActivityExplorerPage)).sorted().collect(Collectors.toList());
        Map<CommonActivityExplorerPage, String> predecessors = new HashMap<>();
        if (!sortedPages.isEmpty()) {
            predecessors.put(sortedPages.get(0), OverviewPage.SIRIUS_ACTIVITIES_OVERVIEW);
        }
        for (int i = 1; i < sortedPages.size(); i++) {
            predecessors.put(sortedPages.get(i), sortedPages.get(i - 1).getId());
        }
        return predecessors;
    }
}
