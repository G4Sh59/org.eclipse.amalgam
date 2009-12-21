/**
 * 
 *   Copyright (c)  2009 Obeo.
 *   All rights reserved. This program and the accompanying materials
 *   are made available under the terms of the Eclipse Public License v1.0
 *   which accompanies this distribution, and is available at
 *   http://www.eclipse.org/legal/epl-v10.html
 *   
 *   Contributors:
 *       Obeo - initial API and implementation
 *  
 *
 * $Id: DiscoveryPackage.java,v 1.1 2009/12/21 12:35:54 cbrun Exp $
 */
package org.eclipse.amalgam.discovery;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.amalgam.discovery.DiscoveryFactory
 * @model kind="package"
 * @generated
 */
public interface DiscoveryPackage extends EPackage {
    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "discovery";

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "http://www.eclipse.org/amalgamation/discovery/1.0";

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "discovery";

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    DiscoveryPackage eINSTANCE = org.eclipse.amalgam.discovery.impl.DiscoveryPackageImpl.init();

    /**
     * The meta object id for the '{@link org.eclipse.amalgam.discovery.impl.InstallableComponentImpl <em>Installable Component</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.amalgam.discovery.impl.InstallableComponentImpl
     * @see org.eclipse.amalgam.discovery.impl.DiscoveryPackageImpl#getInstallableComponent()
     * @generated
     */
    int INSTALLABLE_COMPONENT = 0;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INSTALLABLE_COMPONENT__NAME = 0;

    /**
     * The feature id for the '<em><b>Provider</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INSTALLABLE_COMPONENT__PROVIDER = 1;

    /**
     * The feature id for the '<em><b>Site URL</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INSTALLABLE_COMPONENT__SITE_URL = 2;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INSTALLABLE_COMPONENT__DESCRIPTION = 3;

    /**
     * The feature id for the '<em><b>Overview</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INSTALLABLE_COMPONENT__OVERVIEW = 4;

    /**
     * The feature id for the '<em><b>Image</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INSTALLABLE_COMPONENT__IMAGE = 5;

    /**
     * The feature id for the '<em><b>Category</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INSTALLABLE_COMPONENT__CATEGORY = 6;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INSTALLABLE_COMPONENT__ID = 7;

    /**
     * The feature id for the '<em><b>License</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INSTALLABLE_COMPONENT__LICENSE = 8;

    /**
     * The feature id for the '<em><b>Selected</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INSTALLABLE_COMPONENT__SELECTED = 9;

    /**
     * The feature id for the '<em><b>Available</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INSTALLABLE_COMPONENT__AVAILABLE = 10;

    /**
     * The feature id for the '<em><b>Installed</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INSTALLABLE_COMPONENT__INSTALLED = 11;

    /**
     * The feature id for the '<em><b>Groups</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INSTALLABLE_COMPONENT__GROUPS = 12;

    /**
     * The number of structural features of the '<em>Installable Component</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INSTALLABLE_COMPONENT_FEATURE_COUNT = 13;

    /**
     * The meta object id for the '{@link org.eclipse.amalgam.discovery.impl.OverviewImpl <em>Overview</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.amalgam.discovery.impl.OverviewImpl
     * @see org.eclipse.amalgam.discovery.impl.DiscoveryPackageImpl#getOverview()
     * @generated
     */
    int OVERVIEW = 1;

    /**
     * The feature id for the '<em><b>Summary</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OVERVIEW__SUMMARY = 0;

    /**
     * The feature id for the '<em><b>Screenshot</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OVERVIEW__SCREENSHOT = 1;

    /**
     * The feature id for the '<em><b>Url</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OVERVIEW__URL = 2;

    /**
     * The number of structural features of the '<em>Overview</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OVERVIEW_FEATURE_COUNT = 3;

    /**
     * The meta object id for the '{@link org.eclipse.amalgam.discovery.impl.ImageDefImpl <em>Image Def</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.amalgam.discovery.impl.ImageDefImpl
     * @see org.eclipse.amalgam.discovery.impl.DiscoveryPackageImpl#getImageDef()
     * @generated
     */
    int IMAGE_DEF = 2;

    /**
     * The feature id for the '<em><b>Image32</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IMAGE_DEF__IMAGE32 = 0;

    /**
     * The feature id for the '<em><b>Image48</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IMAGE_DEF__IMAGE48 = 1;

    /**
     * The number of structural features of the '<em>Image Def</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IMAGE_DEF_FEATURE_COUNT = 2;

    /**
     * The meta object id for the '{@link org.eclipse.amalgam.discovery.impl.CategoryImpl <em>Category</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.amalgam.discovery.impl.CategoryImpl
     * @see org.eclipse.amalgam.discovery.impl.DiscoveryPackageImpl#getCategory()
     * @generated
     */
    int CATEGORY = 3;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CATEGORY__NAME = 0;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CATEGORY__DESCRIPTION = 1;

    /**
     * The feature id for the '<em><b>Components</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CATEGORY__COMPONENTS = 2;

    /**
     * The feature id for the '<em><b>Relevance</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CATEGORY__RELEVANCE = 3;

    /**
     * The feature id for the '<em><b>Image</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CATEGORY__IMAGE = 4;

    /**
     * The feature id for the '<em><b>Overview</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CATEGORY__OVERVIEW = 5;

    /**
     * The number of structural features of the '<em>Category</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CATEGORY_FEATURE_COUNT = 6;

    /**
     * The meta object id for the '{@link org.eclipse.amalgam.discovery.impl.DiscoveryDefinitionImpl <em>Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.amalgam.discovery.impl.DiscoveryDefinitionImpl
     * @see org.eclipse.amalgam.discovery.impl.DiscoveryPackageImpl#getDiscoveryDefinition()
     * @generated
     */
    int DISCOVERY_DEFINITION = 4;

    /**
     * The feature id for the '<em><b>Categories</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DISCOVERY_DEFINITION__CATEGORIES = 0;

    /**
     * The feature id for the '<em><b>Filters</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DISCOVERY_DEFINITION__FILTERS = 1;

    /**
     * The number of structural features of the '<em>Definition</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DISCOVERY_DEFINITION_FEATURE_COUNT = 2;

    /**
     * The meta object id for the '{@link org.eclipse.amalgam.discovery.impl.GroupImpl <em>Group</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.amalgam.discovery.impl.GroupImpl
     * @see org.eclipse.amalgam.discovery.impl.DiscoveryPackageImpl#getGroup()
     * @generated
     */
    int GROUP = 5;


    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GROUP__NAME = 0;

    /**
     * The number of structural features of the '<em>Group</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GROUP_FEATURE_COUNT = 1;


    /**
     * Returns the meta object for class '{@link org.eclipse.amalgam.discovery.InstallableComponent <em>Installable Component</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Installable Component</em>'.
     * @see org.eclipse.amalgam.discovery.InstallableComponent
     * @generated
     */
    EClass getInstallableComponent();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.amalgam.discovery.InstallableComponent#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see org.eclipse.amalgam.discovery.InstallableComponent#getName()
     * @see #getInstallableComponent()
     * @generated
     */
    EAttribute getInstallableComponent_Name();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.amalgam.discovery.InstallableComponent#getProvider <em>Provider</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Provider</em>'.
     * @see org.eclipse.amalgam.discovery.InstallableComponent#getProvider()
     * @see #getInstallableComponent()
     * @generated
     */
    EAttribute getInstallableComponent_Provider();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.amalgam.discovery.InstallableComponent#getSiteURL <em>Site URL</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Site URL</em>'.
     * @see org.eclipse.amalgam.discovery.InstallableComponent#getSiteURL()
     * @see #getInstallableComponent()
     * @generated
     */
    EAttribute getInstallableComponent_SiteURL();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.amalgam.discovery.InstallableComponent#getDescription <em>Description</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Description</em>'.
     * @see org.eclipse.amalgam.discovery.InstallableComponent#getDescription()
     * @see #getInstallableComponent()
     * @generated
     */
    EAttribute getInstallableComponent_Description();

    /**
     * Returns the meta object for the reference list '{@link org.eclipse.amalgam.discovery.InstallableComponent#getGroups <em>Groups</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Groups</em>'.
     * @see org.eclipse.amalgam.discovery.InstallableComponent#getGroups()
     * @see #getInstallableComponent()
     * @generated
     */
    EReference getInstallableComponent_Groups();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.amalgam.discovery.InstallableComponent#getOverview <em>Overview</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Overview</em>'.
     * @see org.eclipse.amalgam.discovery.InstallableComponent#getOverview()
     * @see #getInstallableComponent()
     * @generated
     */
    EReference getInstallableComponent_Overview();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.amalgam.discovery.InstallableComponent#getImage <em>Image</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Image</em>'.
     * @see org.eclipse.amalgam.discovery.InstallableComponent#getImage()
     * @see #getInstallableComponent()
     * @generated
     */
    EReference getInstallableComponent_Image();

    /**
     * Returns the meta object for the container reference '{@link org.eclipse.amalgam.discovery.InstallableComponent#getCategory <em>Category</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Category</em>'.
     * @see org.eclipse.amalgam.discovery.InstallableComponent#getCategory()
     * @see #getInstallableComponent()
     * @generated
     */
    EReference getInstallableComponent_Category();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.amalgam.discovery.InstallableComponent#getId <em>Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Id</em>'.
     * @see org.eclipse.amalgam.discovery.InstallableComponent#getId()
     * @see #getInstallableComponent()
     * @generated
     */
    EAttribute getInstallableComponent_Id();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.amalgam.discovery.InstallableComponent#getLicense <em>License</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>License</em>'.
     * @see org.eclipse.amalgam.discovery.InstallableComponent#getLicense()
     * @see #getInstallableComponent()
     * @generated
     */
    EAttribute getInstallableComponent_License();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.amalgam.discovery.InstallableComponent#isSelected <em>Selected</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Selected</em>'.
     * @see org.eclipse.amalgam.discovery.InstallableComponent#isSelected()
     * @see #getInstallableComponent()
     * @generated
     */
    EAttribute getInstallableComponent_Selected();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.amalgam.discovery.InstallableComponent#isAvailable <em>Available</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Available</em>'.
     * @see org.eclipse.amalgam.discovery.InstallableComponent#isAvailable()
     * @see #getInstallableComponent()
     * @generated
     */
    EAttribute getInstallableComponent_Available();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.amalgam.discovery.InstallableComponent#isInstalled <em>Installed</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Installed</em>'.
     * @see org.eclipse.amalgam.discovery.InstallableComponent#isInstalled()
     * @see #getInstallableComponent()
     * @generated
     */
    EAttribute getInstallableComponent_Installed();

    /**
     * Returns the meta object for class '{@link org.eclipse.amalgam.discovery.Overview <em>Overview</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Overview</em>'.
     * @see org.eclipse.amalgam.discovery.Overview
     * @generated
     */
    EClass getOverview();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.amalgam.discovery.Overview#getSummary <em>Summary</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Summary</em>'.
     * @see org.eclipse.amalgam.discovery.Overview#getSummary()
     * @see #getOverview()
     * @generated
     */
    EAttribute getOverview_Summary();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.amalgam.discovery.Overview#getScreenshot <em>Screenshot</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Screenshot</em>'.
     * @see org.eclipse.amalgam.discovery.Overview#getScreenshot()
     * @see #getOverview()
     * @generated
     */
    EAttribute getOverview_Screenshot();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.amalgam.discovery.Overview#getUrl <em>Url</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Url</em>'.
     * @see org.eclipse.amalgam.discovery.Overview#getUrl()
     * @see #getOverview()
     * @generated
     */
    EAttribute getOverview_Url();

    /**
     * Returns the meta object for class '{@link org.eclipse.amalgam.discovery.ImageDef <em>Image Def</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Image Def</em>'.
     * @see org.eclipse.amalgam.discovery.ImageDef
     * @generated
     */
    EClass getImageDef();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.amalgam.discovery.ImageDef#getImage32 <em>Image32</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Image32</em>'.
     * @see org.eclipse.amalgam.discovery.ImageDef#getImage32()
     * @see #getImageDef()
     * @generated
     */
    EAttribute getImageDef_Image32();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.amalgam.discovery.ImageDef#getImage48 <em>Image48</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Image48</em>'.
     * @see org.eclipse.amalgam.discovery.ImageDef#getImage48()
     * @see #getImageDef()
     * @generated
     */
    EAttribute getImageDef_Image48();

    /**
     * Returns the meta object for class '{@link org.eclipse.amalgam.discovery.Category <em>Category</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Category</em>'.
     * @see org.eclipse.amalgam.discovery.Category
     * @generated
     */
    EClass getCategory();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.amalgam.discovery.Category#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see org.eclipse.amalgam.discovery.Category#getName()
     * @see #getCategory()
     * @generated
     */
    EAttribute getCategory_Name();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.amalgam.discovery.Category#getDescription <em>Description</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Description</em>'.
     * @see org.eclipse.amalgam.discovery.Category#getDescription()
     * @see #getCategory()
     * @generated
     */
    EAttribute getCategory_Description();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.amalgam.discovery.Category#getComponents <em>Components</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Components</em>'.
     * @see org.eclipse.amalgam.discovery.Category#getComponents()
     * @see #getCategory()
     * @generated
     */
    EReference getCategory_Components();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.amalgam.discovery.Category#getRelevance <em>Relevance</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Relevance</em>'.
     * @see org.eclipse.amalgam.discovery.Category#getRelevance()
     * @see #getCategory()
     * @generated
     */
    EAttribute getCategory_Relevance();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.amalgam.discovery.Category#getImage <em>Image</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Image</em>'.
     * @see org.eclipse.amalgam.discovery.Category#getImage()
     * @see #getCategory()
     * @generated
     */
    EReference getCategory_Image();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.amalgam.discovery.Category#getOverview <em>Overview</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Overview</em>'.
     * @see org.eclipse.amalgam.discovery.Category#getOverview()
     * @see #getCategory()
     * @generated
     */
    EReference getCategory_Overview();

    /**
     * Returns the meta object for class '{@link org.eclipse.amalgam.discovery.DiscoveryDefinition <em>Definition</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Definition</em>'.
     * @see org.eclipse.amalgam.discovery.DiscoveryDefinition
     * @generated
     */
    EClass getDiscoveryDefinition();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.amalgam.discovery.DiscoveryDefinition#getCategories <em>Categories</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Categories</em>'.
     * @see org.eclipse.amalgam.discovery.DiscoveryDefinition#getCategories()
     * @see #getDiscoveryDefinition()
     * @generated
     */
    EReference getDiscoveryDefinition_Categories();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.amalgam.discovery.DiscoveryDefinition#getFilters <em>Filters</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Filters</em>'.
     * @see org.eclipse.amalgam.discovery.DiscoveryDefinition#getFilters()
     * @see #getDiscoveryDefinition()
     * @generated
     */
    EReference getDiscoveryDefinition_Filters();

    /**
     * Returns the meta object for class '{@link org.eclipse.amalgam.discovery.Group <em>Group</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Group</em>'.
     * @see org.eclipse.amalgam.discovery.Group
     * @generated
     */
    EClass getGroup();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.amalgam.discovery.Group#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see org.eclipse.amalgam.discovery.Group#getName()
     * @see #getGroup()
     * @generated
     */
    EAttribute getGroup_Name();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    DiscoveryFactory getDiscoveryFactory();

    /**
     * <!-- begin-user-doc -->
     * Defines literals for the meta objects that represent
     * <ul>
     *   <li>each class,</li>
     *   <li>each feature of each class,</li>
     *   <li>each enum,</li>
     *   <li>and each data type</li>
     * </ul>
     * <!-- end-user-doc -->
     * @generated
     */
    interface Literals {
        /**
         * The meta object literal for the '{@link org.eclipse.amalgam.discovery.impl.InstallableComponentImpl <em>Installable Component</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.amalgam.discovery.impl.InstallableComponentImpl
         * @see org.eclipse.amalgam.discovery.impl.DiscoveryPackageImpl#getInstallableComponent()
         * @generated
         */
        EClass INSTALLABLE_COMPONENT = eINSTANCE.getInstallableComponent();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute INSTALLABLE_COMPONENT__NAME = eINSTANCE.getInstallableComponent_Name();

        /**
         * The meta object literal for the '<em><b>Provider</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute INSTALLABLE_COMPONENT__PROVIDER = eINSTANCE.getInstallableComponent_Provider();

        /**
         * The meta object literal for the '<em><b>Site URL</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute INSTALLABLE_COMPONENT__SITE_URL = eINSTANCE.getInstallableComponent_SiteURL();

        /**
         * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute INSTALLABLE_COMPONENT__DESCRIPTION = eINSTANCE.getInstallableComponent_Description();

        /**
         * The meta object literal for the '<em><b>Groups</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference INSTALLABLE_COMPONENT__GROUPS = eINSTANCE.getInstallableComponent_Groups();

        /**
         * The meta object literal for the '<em><b>Overview</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference INSTALLABLE_COMPONENT__OVERVIEW = eINSTANCE.getInstallableComponent_Overview();

        /**
         * The meta object literal for the '<em><b>Image</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference INSTALLABLE_COMPONENT__IMAGE = eINSTANCE.getInstallableComponent_Image();

        /**
         * The meta object literal for the '<em><b>Category</b></em>' container reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference INSTALLABLE_COMPONENT__CATEGORY = eINSTANCE.getInstallableComponent_Category();

        /**
         * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute INSTALLABLE_COMPONENT__ID = eINSTANCE.getInstallableComponent_Id();

        /**
         * The meta object literal for the '<em><b>License</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute INSTALLABLE_COMPONENT__LICENSE = eINSTANCE.getInstallableComponent_License();

        /**
         * The meta object literal for the '<em><b>Selected</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute INSTALLABLE_COMPONENT__SELECTED = eINSTANCE.getInstallableComponent_Selected();

        /**
         * The meta object literal for the '<em><b>Available</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute INSTALLABLE_COMPONENT__AVAILABLE = eINSTANCE.getInstallableComponent_Available();

        /**
         * The meta object literal for the '<em><b>Installed</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute INSTALLABLE_COMPONENT__INSTALLED = eINSTANCE.getInstallableComponent_Installed();

        /**
         * The meta object literal for the '{@link org.eclipse.amalgam.discovery.impl.OverviewImpl <em>Overview</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.amalgam.discovery.impl.OverviewImpl
         * @see org.eclipse.amalgam.discovery.impl.DiscoveryPackageImpl#getOverview()
         * @generated
         */
        EClass OVERVIEW = eINSTANCE.getOverview();

        /**
         * The meta object literal for the '<em><b>Summary</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute OVERVIEW__SUMMARY = eINSTANCE.getOverview_Summary();

        /**
         * The meta object literal for the '<em><b>Screenshot</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute OVERVIEW__SCREENSHOT = eINSTANCE.getOverview_Screenshot();

        /**
         * The meta object literal for the '<em><b>Url</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute OVERVIEW__URL = eINSTANCE.getOverview_Url();

        /**
         * The meta object literal for the '{@link org.eclipse.amalgam.discovery.impl.ImageDefImpl <em>Image Def</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.amalgam.discovery.impl.ImageDefImpl
         * @see org.eclipse.amalgam.discovery.impl.DiscoveryPackageImpl#getImageDef()
         * @generated
         */
        EClass IMAGE_DEF = eINSTANCE.getImageDef();

        /**
         * The meta object literal for the '<em><b>Image32</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute IMAGE_DEF__IMAGE32 = eINSTANCE.getImageDef_Image32();

        /**
         * The meta object literal for the '<em><b>Image48</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute IMAGE_DEF__IMAGE48 = eINSTANCE.getImageDef_Image48();

        /**
         * The meta object literal for the '{@link org.eclipse.amalgam.discovery.impl.CategoryImpl <em>Category</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.amalgam.discovery.impl.CategoryImpl
         * @see org.eclipse.amalgam.discovery.impl.DiscoveryPackageImpl#getCategory()
         * @generated
         */
        EClass CATEGORY = eINSTANCE.getCategory();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CATEGORY__NAME = eINSTANCE.getCategory_Name();

        /**
         * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CATEGORY__DESCRIPTION = eINSTANCE.getCategory_Description();

        /**
         * The meta object literal for the '<em><b>Components</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference CATEGORY__COMPONENTS = eINSTANCE.getCategory_Components();

        /**
         * The meta object literal for the '<em><b>Relevance</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CATEGORY__RELEVANCE = eINSTANCE.getCategory_Relevance();

        /**
         * The meta object literal for the '<em><b>Image</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference CATEGORY__IMAGE = eINSTANCE.getCategory_Image();

        /**
         * The meta object literal for the '<em><b>Overview</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference CATEGORY__OVERVIEW = eINSTANCE.getCategory_Overview();

        /**
         * The meta object literal for the '{@link org.eclipse.amalgam.discovery.impl.DiscoveryDefinitionImpl <em>Definition</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.amalgam.discovery.impl.DiscoveryDefinitionImpl
         * @see org.eclipse.amalgam.discovery.impl.DiscoveryPackageImpl#getDiscoveryDefinition()
         * @generated
         */
        EClass DISCOVERY_DEFINITION = eINSTANCE.getDiscoveryDefinition();

        /**
         * The meta object literal for the '<em><b>Categories</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference DISCOVERY_DEFINITION__CATEGORIES = eINSTANCE.getDiscoveryDefinition_Categories();

        /**
         * The meta object literal for the '<em><b>Filters</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference DISCOVERY_DEFINITION__FILTERS = eINSTANCE.getDiscoveryDefinition_Filters();

        /**
         * The meta object literal for the '{@link org.eclipse.amalgam.discovery.impl.GroupImpl <em>Group</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.amalgam.discovery.impl.GroupImpl
         * @see org.eclipse.amalgam.discovery.impl.DiscoveryPackageImpl#getGroup()
         * @generated
         */
        EClass GROUP = eINSTANCE.getGroup();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute GROUP__NAME = eINSTANCE.getGroup_Name();

    }

} //DiscoveryPackage