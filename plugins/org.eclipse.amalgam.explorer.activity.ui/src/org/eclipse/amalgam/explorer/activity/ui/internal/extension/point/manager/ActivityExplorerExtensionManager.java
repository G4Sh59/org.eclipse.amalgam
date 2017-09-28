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
package org.eclipse.amalgam.explorer.activity.ui.internal.extension.point.manager;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import java.util.regex.Pattern;

import javax.activity.InvalidActivityException;

import org.eclipse.amalgam.explorer.activity.ui.ActivityExplorerActivator;
import org.eclipse.amalgam.explorer.activity.ui.IImageKeys;
import org.eclipse.amalgam.explorer.activity.ui.api.configuration.ActivityConfiguration;
import org.eclipse.amalgam.explorer.activity.ui.api.configuration.ActivityExplorerPageConfiguration;
import org.eclipse.amalgam.explorer.activity.ui.api.configuration.BasicSessionActivityExplorerPageConfiguration;
import org.eclipse.amalgam.explorer.activity.ui.api.configuration.CommonActivityExplorerPageConfiguration;
import org.eclipse.amalgam.explorer.activity.ui.api.configuration.SectionConfiguration;
import org.eclipse.amalgam.explorer.activity.ui.api.editor.activities.ExplorerActivity;
import org.eclipse.amalgam.explorer.activity.ui.api.editor.pages.CommonActivityExplorerPage;
import org.eclipse.amalgam.explorer.activity.ui.api.editor.pages.helper.HTMLHelper;
import org.eclipse.amalgam.explorer.activity.ui.api.editor.predicates.IPredicate;
import org.eclipse.amalgam.explorer.activity.ui.internal.ActivityExplorerConstants;
import org.eclipse.amalgam.explorer.activity.ui.internal.exceptions.InvalidActivityExplorerIndexException;
import org.eclipse.amalgam.explorer.activity.ui.internal.util.ActivityExplorerLoggerService;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IContributor;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.forms.events.IHyperlinkListener;
import org.osgi.framework.Bundle;

public class ActivityExplorerExtensionManager {
    /**
     * Extension point declaration
     */
    public static final String PROVIDER_PAGES_EXT = "org.eclipse.amalgam.explorer.activity.ui.pagesProvider"; //$NON-NLS-1$

    public static final String PROVIDER_SECTIONS_EXT = "org.eclipse.amalgam.explorer.activity.ui.sectionsProvider"; //$NON-NLS-1$

    public static final String PROVIDER_ACTIVITIES_EXT = "org.eclipse.amalgam.explorer.activity.ui.activitiesProvider"; //$NON-NLS-1$

    /**
     * Page Attributes
     */
    public static final String PAGE = "Page"; //$NON-NLS-1$

    public static final String ATT_CLASS = "class"; //$NON-NLS-1$

    public static final String ATT_TAB_NAME = "tabName"; //$NON-NLS-1$

    public static final String ATT_TITLE = "title"; //$NON-NLS-1$

    public static final String ATT_IMAGE = "image"; //$NON-NLS-1$

    public static final String ATT_IMAGE_OFF = "imageOff"; //$NON-NLS-1$

    public static final String ATT_IMAGE_ON = "imageOn"; //$NON-NLS-1$

    public static final String ATT_ID = "id"; //$NON-NLS-1$

    public static final String ATT_NAME = "name"; //$NON-NLS-1$

    public static final String DESCRIPTION = "Description"; //$NON-NLS-1$

    public static final String ATT_INDEX = "index"; //$NON-NLS-1$

    public static final String ATT_VIEWER = "viewer"; //$NON-NLS-1$

    public static final String OVERVIEW = "Overview"; //$NON-NLS-1$

    public static final String ATT_OVERVIEW_IMG_ON = "imageOn"; //$NON-NLS-1$

    public static final String ATT_OVERVIEW_IMG_OFF = "imageOff"; //$NON-NLS-1$

    /**
     * Section Attributes
     */
    public static final String SECTION = "Section"; //$NON-NLS-1$

    public static final String ATT_EXPANDED = "expanded"; //$NON-NLS-1$

    public static final String ATT_FILTERING = "filtering"; //$NON-NLS-1$

    /**
     * Activity Attributes
     */
    public static final String ACTIVITY = "Activity"; //$NON-NLS-1$

    public static final String ATT_SECTION_PAGE_ID = "pageId"; //$NON-NLS-1$

    public static final String ATT_ACTIVITY_SECTION_ID = "sectionId"; //$NON-NLS-1$

    /**
     * Predicate
     */
    public static final String PREDICATE = "Predicate"; //$NON-NLS-1$

    private static final Pattern P_PATTERN = Pattern.compile("<p>.*</p>"); //$NON-NLS-1$

    /**
     * get all Page Providers
     *
     * @return
     */
    public static IConfigurationElement[] getAllProviderExtensions() {
        return ActivityExplorerExtensionManager.getExtensionElt(ActivityExplorerExtensionManager.PROVIDER_PAGES_EXT);
    }

    private static IConfigurationElement[] getExtensionElt(String id) {
        IExtensionPoint point = ActivityExplorerExtensionManager.getExtensionPoint(id);
        IExtension[] extensions = point.getExtensions();
        ArrayList<IConfigurationElement> configElements = new ArrayList<>();

        for (IExtension extension : extensions) {
            configElements.addAll(Arrays.asList(extension.getConfigurationElements()));
        }

        return configElements.toArray(new IConfigurationElement[] {});
    }

    public static IExtensionPoint getExtensionPoint(String id) {
        return Platform.getExtensionRegistry().getExtensionPoint(id);
    }

    private static CommonActivityExplorerPage getPage(IConfigurationElement element) throws CoreException, InvalidActivityExplorerIndexException {
        CommonActivityExplorerPage page = null;

        if (element != null) {
            CommonActivityExplorerPage.setID(ActivityExplorerExtensionManager.getId(element));
            if (element.getAttribute(ActivityExplorerExtensionManager.ATT_CLASS) != null) {
                page = (CommonActivityExplorerPage) element.createExecutableExtension(ActivityExplorerExtensionManager.ATT_CLASS);
            } else {
                page = new CommonActivityExplorerPage();
                ((IExecutableExtension) page).setInitializationData(element, ActivityExplorerExtensionManager.ATT_CLASS, null);
            }
        }

        return ActivityExplorerExtensionManager.accept(page, element);
    }

    /**
     * check if the page is valid
     *
     * @param page
     * @return the page, otherways, launch an exception
     * @throws InvalidActivityException
     */
    private static CommonActivityExplorerPage accept(CommonActivityExplorerPage page, IConfigurationElement element) throws InvalidActivityExplorerIndexException {
        // Never accept null page
        if (page == null) {
            String id = ActivityExplorerExtensionManager.getId(element);
            throw new NullPointerException(String.format("ActivityExplorerExtensionManager.accept(...) _ An error occured while instantianting the class of contribution %s", id));
        }
        // Never accept negative index for pages
        if (page.getPosition() < 0) {
            String message = String.format("ActivityExplorerExtensionManager.accept(...) _ The page %s has negative index. Only pages with an index upper or equal to zero are allowed.", page.getId()); //$NON-NLS-1$
            throw new InvalidActivityExplorerIndexException(message);
        }
        return page;
    }

    public static List<CommonActivityExplorerPage> getAllPages() {
        List<CommonActivityExplorerPage> providers = new ArrayList<>();
        List<IConfigurationElement> extensions = Arrays.asList(ActivityExplorerExtensionManager.getExtensionElt(ActivityExplorerExtensionManager.PROVIDER_PAGES_EXT));
        CommonActivityExplorerPage page;
        for (IConfigurationElement extension : extensions) {
            page = null;
            try {
                page = ActivityExplorerExtensionManager.getPage(extension);
                providers.add(page);
            } catch (CoreException e) {
                ActivityExplorerLoggerService.getInstance().log(IStatus.ERROR, Messages.ActivityExplorerExtensionManager_0, e);
            } catch (InvalidActivityExplorerIndexException e) {
                ActivityExplorerActivator.getDefault().getLog().log(new Status(IStatus.WARNING, ActivityExplorerActivator.ID, e.getMessage()));
            } catch (NumberFormatException e) {
                String message = "ActivityExplorerExtensionManager.getAllPages(...) _ The contribution %s has wrong index format (%d). Only 0 or positive integers are valid"; //$NON-NLS-1$
                ActivityExplorerLoggerService.getInstance().log(IStatus.ERROR, String.format(message, ActivityExplorerExtensionManager.getId(extension), ActivityExplorerExtensionManager.getIndex(extension)), e);
            } catch (NullPointerException e) {
                ActivityExplorerLoggerService.getInstance().log(IStatus.ERROR, e.getMessage(), null);
            } catch (Throwable e) {
                // Unknown error from contribution
                String message = "ActivityExplorerExtensionManager.getAllPages(...) _ Unknown error occurred from contribution %s. See the exception stack for more details"; //$NON-NLS-1$
                ActivityExplorerLoggerService.getInstance().log(IStatus.ERROR, String.format(message, ActivityExplorerExtensionManager.getId(extension)), e);
            }
        }
        return providers;
    }

    public static List<IConfigurationElement> getAllPagesElt() {
        List<IConfigurationElement> extensions = Arrays.asList(ActivityExplorerExtensionManager.getExtensionElt(ActivityExplorerExtensionManager.PROVIDER_PAGES_EXT));
        return extensions;
    }

    public static List<IConfigurationElement> getAllSectionsExtensions() {
        List<IConfigurationElement> extensions = Arrays.asList(ActivityExplorerExtensionManager.getExtensionElt(ActivityExplorerExtensionManager.PROVIDER_SECTIONS_EXT));
        return extensions;
    }

    public static List<IConfigurationElement> getAllSectionsExtensionForPageId(String id) {
        List<IConfigurationElement> list = new ArrayList<>();
        for (IConfigurationElement elt : ActivityExplorerExtensionManager.getAllSectionsExtensions()) {
            if (ActivityExplorerExtensionManager.getPageId(elt).equals(id)) {
                list.add(elt);
            }
        }
        return list;
    }

    public static List<IConfigurationElement> getAllActivitiesExtensionForSectionId(String id) {
        List<IConfigurationElement> list = new ArrayList<>();
        for (IConfigurationElement elt : ActivityExplorerExtensionManager.getAllActivitiesExtensions()) {
            if (ActivityExplorerExtensionManager.getSectionId(elt).equals(id)) {
                list.add(elt);
            }
        }
        return list;
    }

    public static List<IConfigurationElement> getAllActivitiesExtensions() {
        List<IConfigurationElement> extensions = Arrays.asList(ActivityExplorerExtensionManager.getExtensionElt(ActivityExplorerExtensionManager.PROVIDER_ACTIVITIES_EXT));
        return extensions;
    }

    public static CommonActivityExplorerPage getPageById(String id) {
        CommonActivityExplorerPage result = null;
        for (IConfigurationElement page : Arrays.asList(ActivityExplorerExtensionManager.getExtensionElt(ActivityExplorerExtensionManager.PROVIDER_PAGES_EXT))) {
            if (ActivityExplorerExtensionManager.getId(page).equals(id)) {
                try {
                    result = ActivityExplorerExtensionManager.getPage(page);
                } catch (CoreException e) {
                    StringBuilder loggerMessage = new StringBuilder("ActivityExplorerExtensionManager.getPageById(..) _ "); //$NON-NLS-1$
                    loggerMessage.append(e.getMessage());
                    ActivityExplorerLoggerService.getInstance().log(IStatus.ERROR, loggerMessage.toString(), e);
                } catch (InvalidActivityExplorerIndexException e) {
                    ActivityExplorerLoggerService.getInstance().log(IStatus.WARNING, e.toString(), e);
                } catch (NumberFormatException e) {
                    String message = "ActivityExplorerExtensionManager.getAllPages(...) _ The contribution %s has wrong index format (%d). Only 0 or positive integers are valid"; //$NON-NLS-1$
                    ActivityExplorerLoggerService.getInstance().log(IStatus.ERROR, String.format(message, ActivityExplorerExtensionManager.getId(page), ActivityExplorerExtensionManager.getIndex(page)), e);
                } catch (NullPointerException e) {
                    ActivityExplorerLoggerService.getInstance().log(IStatus.WARNING, e.getMessage(), e);
                } catch (Throwable e) {
                    // Unknown error from contributions
                    String message = "ActivityExplorerExtensionManager.getAllPages(...) _ Unknown error occurred from contribution %s. See the exception stack for more details"; //$NON-NLS-1$
                    ActivityExplorerLoggerService.getInstance().log(IStatus.WARNING, String.format(message, ActivityExplorerExtensionManager.getId(page)), e);
                }
            }
        }
        return result;
    }

    public static String getPageId(IConfigurationElement element) {
        return element.getAttribute(ActivityExplorerExtensionManager.ATT_SECTION_PAGE_ID);
    }

    public static String getSectionId(IConfigurationElement element) {
        return element.getAttribute(ActivityExplorerExtensionManager.ATT_ACTIVITY_SECTION_ID);
    }

    public static List<IConfigurationElement> getSectionsFromPageId(String id) {
        List<IConfigurationElement> sections = new ArrayList<>();
        for (IConfigurationElement page : Arrays.asList(ActivityExplorerExtensionManager.getExtensionElt(ActivityExplorerExtensionManager.PROVIDER_PAGES_EXT))) {
            if (ActivityExplorerExtensionManager.getId(page).equals(id)) {
                sections.addAll(ActivityExplorerExtensionManager.getSections(page));
            }
        }
        return sections;
    }

    public static List<IConfigurationElement> getActivitiesFromPageId(String id) {
        List<IConfigurationElement> sections = new ArrayList<>();
        for (IConfigurationElement page : Arrays.asList(ActivityExplorerExtensionManager.getExtensionElt(ActivityExplorerExtensionManager.PROVIDER_PAGES_EXT))) {
            if (ActivityExplorerExtensionManager.getId(page).equals(id)) {
                sections.addAll(ActivityExplorerExtensionManager.getSections(page));
            }
        }
        return sections;
    }

    public static String getId(IConfigurationElement element) {
        return element.getAttribute(ActivityExplorerExtensionManager.ATT_ID);
    }

    public static String getName(IConfigurationElement element) {
        String att = ActivityExplorerExtensionManager.ATT_NAME;
        if (element.getName().equals(ActivityExplorerExtensionManager.PAGE)) {
            att = ActivityExplorerExtensionManager.ATT_TITLE;
        }
        String name = element.getAttribute(att);
        return name == null ? ActivityExplorerConstants.NO_NAME : name;
    }

    private static String getTitle(IConfigurationElement element) {
        String title = element.getAttribute(ActivityExplorerExtensionManager.ATT_TITLE);
        return title == null ? ActivityExplorerConstants.NO_TITLE : title;
    }

    private static String getTabName(IConfigurationElement element) {
        return element.getAttribute(ActivityExplorerExtensionManager.ATT_TAB_NAME);
    }

    public static String getIndex(IConfigurationElement element) {
        return element.getAttribute(ActivityExplorerExtensionManager.ATT_INDEX);
    }

    private static Image getImage(IConfigurationElement element) {
        Image image = null;
        String img = element.getAttribute(ActivityExplorerExtensionManager.ATT_IMAGE);
        if (img != null) {
            String pluginId = ActivityExplorerExtensionManager.getPluginId(element);
            image = ActivityExplorerActivator.getDefault().getImage(pluginId, img);
        }
        return image;
    }

    private static Image getImageOff(IConfigurationElement element) {
        Image image = null;
        String img = element.getAttribute(ActivityExplorerExtensionManager.ATT_IMAGE_OFF);
        if (img != null) {
            String pluginId = ActivityExplorerExtensionManager.getPluginId(element);
            image = ActivityExplorerActivator.getDefault().getImage(pluginId, img);
        }
        return image;
    }

    private static Image getImageOn(IConfigurationElement element) {
        Image image = null;
        String img = element.getAttribute(ActivityExplorerExtensionManager.ATT_IMAGE_ON);
        if (img != null) {
            String pluginId = ActivityExplorerExtensionManager.getPluginId(element);
            image = ActivityExplorerActivator.getDefault().getImage(pluginId, img);
        }
        return image;
    }

    private static boolean getIsDisplayViewerInPage(IConfigurationElement element) {
        String bool = element.getAttribute(ActivityExplorerExtensionManager.ATT_VIEWER);
        return Boolean.parseBoolean(bool);
    }

    private static IConfigurationElement getOverviewElement(IConfigurationElement element) {
        return ActivityExplorerExtensionManager.getChild(element, ActivityExplorerExtensionManager.OVERVIEW);
    }

    private static IConfigurationElement getChild(IConfigurationElement element, String name) {
        IConfigurationElement child = null;
        IConfigurationElement[] children = element.getChildren(name);
        if (children.length > 0) {
            child = children[0];
        }
        return child;
    }

    private static String getOverviewImageOn(IConfigurationElement element) {
        IConfigurationElement overview = ActivityExplorerExtensionManager.getOverviewElement(element);
        String img = overview.getAttribute(ActivityExplorerExtensionManager.ATT_OVERVIEW_IMG_ON);
        return img == null ? IImageKeys.IMAGE_DEFAULT_OVERVIEW_ON : img;
    }

    private static String getOverviewImageOff(IConfigurationElement element) {
        IConfigurationElement overview = ActivityExplorerExtensionManager.getOverviewElement(element);
        String img = overview.getAttribute(ActivityExplorerExtensionManager.ATT_OVERVIEW_IMG_OFF);
        return img == null ? IImageKeys.IMAGE_DEFAULT_OVERVIEW_OFF : img;
    }

    private static String getOverviewDescription(IConfigurationElement element) {
        IConfigurationElement overview = ActivityExplorerExtensionManager.getOverviewElement(element);
        return ActivityExplorerExtensionManager.getDescription(overview);
    }

    public static String getDescription(IConfigurationElement element) {
        String description = null;
        if (null != element) {
            IConfigurationElement desc = ActivityExplorerExtensionManager.getChild(element, ActivityExplorerExtensionManager.DESCRIPTION);
            if (null != desc) {
                description = desc.getValue();
            }
        }
        return description;
    }

    public static List<IConfigurationElement> getSections(IConfigurationElement element) {
        List<IConfigurationElement> result = new ArrayList<>();
        String id = ActivityExplorerExtensionManager.getId(element);
        result.addAll(Arrays.asList(element.getChildren(ActivityExplorerExtensionManager.SECTION)));
        result.addAll(ActivityExplorerExtensionManager.getAllSectionsExtensionForPageId(id));
        return result;
    }

    private static String getPluginId(IConfigurationElement element) {
        IContributor contributor = element.getContributor();
        Bundle bundle = Platform.getBundle(contributor.getName());
        String id = bundle.getSymbolicName();
        return id;
    }

    private static boolean getIsExpanded(IConfigurationElement element) {
        String bool = element.getAttribute(ActivityExplorerExtensionManager.ATT_EXPANDED);
        boolean result = Boolean.parseBoolean(bool);
        return result;
    }

    private static boolean getIsFiltering(IConfigurationElement element) {
        String bool = element.getAttribute(ActivityExplorerExtensionManager.ATT_FILTERING);
        boolean result = Boolean.parseBoolean(bool);
        return result;
    }

    public static List<IConfigurationElement> getActivities(IConfigurationElement element) {
        List<IConfigurationElement> result = new ArrayList<>();
        String id = ActivityExplorerExtensionManager.getId(element);
        result.addAll(Arrays.asList(element.getChildren(ActivityExplorerExtensionManager.ACTIVITY)));
        result.addAll(ActivityExplorerExtensionManager.getAllActivitiesExtensionForSectionId(id));
        return result;
    }

    private static IHyperlinkListener getActivityAdapter(IConfigurationElement element) {
        IHyperlinkListener listener = null;

        String type = element.getName();
        String id = ActivityExplorerExtensionManager.getId(element);

        try {
            String c = element.getAttribute(ActivityExplorerExtensionManager.ATT_CLASS);
            if (c != null) {
                listener = (IHyperlinkListener) element.createExecutableExtension(ActivityExplorerExtensionManager.ATT_CLASS);
            }
        } catch (CoreException e) {
            StringBuilder message = new StringBuilder();
            message.append(Messages.ActivityExplorerExtensionManager_1);
            message.append(type);
            message.append(Messages.ActivityExplorerExtensionManager_2);
            message.append(id);
            message.append(Messages.ActivityExplorerExtensionManager_3);
            ActivityExplorerLoggerService.getInstance().log(IStatus.WARNING, message.toString(), e);
        }
        return listener;
    }

    private static IPredicate getPredicate(IConfigurationElement elem) {
        IPredicate predicate = null;
        IConfigurationElement element = ActivityExplorerExtensionManager.getChild(elem, ActivityExplorerExtensionManager.PREDICATE);
        if (element != null) {
            String type = element.getName();
            try {
                String c = elem.getAttribute(ActivityExplorerExtensionManager.ATT_CLASS);
                if (c != null) {
                    predicate = (IPredicate) element.createExecutableExtension(ActivityExplorerExtensionManager.ATT_CLASS);
                }
            } catch (CoreException e) {
                StringBuilder message = new StringBuilder();
                message.append(Messages.ActivityExplorerExtensionManager_1);
                message.append(type);
                message.append(Messages.ActivityExplorerExtensionManager_2);
                message.append(Messages.ActivityExplorerExtensionManager_3);
                ActivityExplorerLoggerService.getInstance().log(IStatus.WARNING, message.toString(), e);
            }
        }
        return predicate;
    }

    /**
     * Test if the id is a ActivityExplorerPage
     *
     * @param id
     * @return boolean
     */
    public static boolean isPage(String id) {
        return null != ActivityExplorerExtensionManager.getPageById(id);
    }

    /**
     * Test if the id is a ActivityExplorerSection
     *
     * @param pageId
     * @param sectionId
     * @return
     */
    public static boolean isSection(String pageId, String sectionId) {
        boolean result = false;
        for (IConfigurationElement element : ActivityExplorerExtensionManager.getSectionsFromPageId(pageId)) {
            result |= ActivityExplorerExtensionManager.getId(element).equals(sectionId);
        }
        return result;
    }

    public static boolean isActivity(String pageId, String sectionId, String activityId) {
        boolean result = false;
        for (IConfigurationElement element : ActivityExplorerExtensionManager.getSectionsFromPageId(pageId)) {
            if (ActivityExplorerExtensionManager.getId(element).equals(sectionId)) {
                for (IConfigurationElement element2 : ActivityExplorerExtensionManager.getActivities(element)) {
                    result |= ActivityExplorerExtensionManager.getId(element2).equals(activityId);
                }
            }
        }
        return result;
    }

    public static ActivityConfiguration parseActivityConfiguration(IConfigurationElement element_p) {
        ActivityConfiguration config = new ActivityConfiguration();
        config.setName(ActivityExplorerExtensionManager.getName(element_p));
        config.setDescription(ActivityExplorerExtensionManager.getDescription(element_p));
        config.setIndex(Integer.parseInt(ActivityExplorerExtensionManager.getIndex(element_p)));
        config.setListener(ActivityExplorerExtensionManager.getActivityAdapter(element_p));
        config.setImage(ActivityExplorerExtensionManager.getImage(element_p));
        config.setId(ActivityExplorerExtensionManager.getId(element_p));
        config.setPredicate(ActivityExplorerExtensionManager.getPredicate(element_p));
        return config;
    }

    public static SectionConfiguration parseSectionConfiguration(IConfigurationElement contributor) {
        SectionConfiguration sectionDescription = new SectionConfiguration();
        sectionDescription.setId(ActivityExplorerExtensionManager.getId(contributor));
        sectionDescription.setName(ActivityExplorerExtensionManager.getName(contributor));
        sectionDescription.setExpanded(ActivityExplorerExtensionManager.getIsExpanded(contributor));
        String desc = ActivityExplorerExtensionManager.getDescription(contributor);
        if (null != desc) {
            boolean isInParagraph = ActivityExplorerExtensionManager.P_PATTERN.matcher(desc).find();
            sectionDescription.setDescription(isInParagraph ? HTMLHelper.formWrapper2(desc) : HTMLHelper.formWrapper(desc));
        }
        String indice = ActivityExplorerExtensionManager.getIndex(contributor);
        try {
            sectionDescription.setIndex(Integer.parseInt(indice));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(MessageFormat.format("Attribute ''{0}'' of section {1} must be an int, but was ''{2}''", ActivityExplorerExtensionManager.ATT_INDEX,
                    ActivityExplorerExtensionManager.getId(contributor), indice));
        }
        sectionDescription.setFiltering(ActivityExplorerExtensionManager.getIsFiltering(contributor));
        ActivityExplorerExtensionManager.createActivities(contributor, sectionDescription);
        return sectionDescription;
    }

    public static void parseCommonActivityExplorerPageConfiguration(IConfigurationElement cfg, CommonActivityExplorerPageConfiguration target) {
        target.setTitle(ActivityExplorerExtensionManager.getTitle(cfg));
        target.setTabName(ActivityExplorerExtensionManager.getTabName(cfg));
        if (target.getTabName() == null) {
            target.setTabName(target.getTitle());
        }
        target.setOverview(ActivityExplorerExtensionManager.getOverviewElement(cfg) != null);
        target.setPluginId(ActivityExplorerExtensionManager.getPluginId(cfg));
        if (target.isOverview()) {
            target.setOverviewImageOffPath(ActivityExplorerExtensionManager.getOverviewImageOff(cfg));
            target.setOverviewImageOnPath(ActivityExplorerExtensionManager.getOverviewImageOn(cfg));
            target.setOverviewText(ActivityExplorerExtensionManager.getOverviewDescription(cfg));
        } else {
            target.setOverviewImageOffPath(IImageKeys.IMAGE_DEFAULT_OVERVIEW_OFF);
            target.setOverviewImageOnPath(IImageKeys.IMAGE_DEFAULT_OVERVIEW_ON);
        }
        target.setPredicate(ActivityExplorerExtensionManager.getPredicate(cfg));

        String indice = ActivityExplorerExtensionManager.getIndex(cfg);
        try {
            target.setIndex(Integer.parseInt(indice));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(MessageFormat.format("Attribute ''{0}'' of page {1} must be an int, but was ''{2}''", ActivityExplorerExtensionManager.ATT_INDEX,
                    ActivityExplorerExtensionManager.getId(cfg), indice));
        }
    }

    public static void parseActivityExplorerPageConfiguration(IConfigurationElement cfig, ActivityExplorerPageConfiguration target) {
        target.setHeaderTitle(ActivityExplorerExtensionManager.getTitle(cfig));
        Image image = ActivityExplorerExtensionManager.getImageOff(cfig);
        if (image != null) {
            target.setHeaderImageOff(image);
        }

        image = ActivityExplorerExtensionManager.getImageOn(cfig);
        if (image != null) {
            target.setHeaderImageOn(image);
        }

        String description = ActivityExplorerExtensionManager.getDescription(cfig);
        if (null != description) {
            target.setDescription(HTMLHelper.formWrapper(description));
        }
    }

    public static void parseBasicSessionActivityExplorerPageConfiguration(IConfigurationElement cfg, BasicSessionActivityExplorerPageConfiguration target) {
        target.setDisplayViewer(ActivityExplorerExtensionManager.getIsDisplayViewerInPage(cfg));
    }

    /**
     * Create theirs Activities.
     *
     * @param contributor
     */
    private static void createActivities(IConfigurationElement contributor, SectionConfiguration sectionDescription) {
        sectionDescription.activities = new TreeSet<>();
        List<IConfigurationElement> activities = ActivityExplorerExtensionManager.getActivities(contributor);
        for (IConfigurationElement element : activities) {
            try {
                ActivityConfiguration config = ActivityExplorerExtensionManager.parseActivityConfiguration(element);
                sectionDescription.activities.add(new ExplorerActivity(config));
            } catch (NumberFormatException e) {
                String message = "ActivityExplorerSection.createActivities(...) _ The Activity contribution %s has wrong index format (%d). Only integers are valid"; //$NON-NLS-1$
                ActivityExplorerLoggerService.getInstance().log(IStatus.ERROR, String.format(message, ActivityExplorerExtensionManager.getId(contributor), ActivityExplorerExtensionManager.getIndex(contributor)), e);
            }
        }
    }

}
