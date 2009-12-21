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
 * $Id: DiscoveryFactoryImpl.java,v 1.1 2009/12/21 12:35:54 cbrun Exp $
 */
package org.eclipse.amalgam.discovery.impl;

import org.eclipse.amalgam.discovery.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DiscoveryFactoryImpl extends EFactoryImpl implements DiscoveryFactory {
    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static DiscoveryFactory init() {
        try {
            DiscoveryFactory theDiscoveryFactory = (DiscoveryFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/amalgamation/discovery/1.0"); 
            if (theDiscoveryFactory != null) {
                return theDiscoveryFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new DiscoveryFactoryImpl();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DiscoveryFactoryImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EObject create(EClass eClass) {
        switch (eClass.getClassifierID()) {
            case DiscoveryPackage.INSTALLABLE_COMPONENT: return createInstallableComponent();
            case DiscoveryPackage.OVERVIEW: return createOverview();
            case DiscoveryPackage.IMAGE_DEF: return createImageDef();
            case DiscoveryPackage.CATEGORY: return createCategory();
            case DiscoveryPackage.DISCOVERY_DEFINITION: return createDiscoveryDefinition();
            case DiscoveryPackage.GROUP: return createGroup();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public InstallableComponent createInstallableComponent() {
        InstallableComponentImpl installableComponent = new InstallableComponentImpl();
        return installableComponent;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Overview createOverview() {
        OverviewImpl overview = new OverviewImpl();
        return overview;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ImageDef createImageDef() {
        ImageDefImpl imageDef = new ImageDefImpl();
        return imageDef;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Category createCategory() {
        CategoryImpl category = new CategoryImpl();
        return category;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DiscoveryDefinition createDiscoveryDefinition() {
        DiscoveryDefinitionImpl discoveryDefinition = new DiscoveryDefinitionImpl();
        return discoveryDefinition;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Group createGroup() {
        GroupImpl group = new GroupImpl();
        return group;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DiscoveryPackage getDiscoveryPackage() {
        return (DiscoveryPackage)getEPackage();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static DiscoveryPackage getPackage() {
        return DiscoveryPackage.eINSTANCE;
    }

} //DiscoveryFactoryImpl