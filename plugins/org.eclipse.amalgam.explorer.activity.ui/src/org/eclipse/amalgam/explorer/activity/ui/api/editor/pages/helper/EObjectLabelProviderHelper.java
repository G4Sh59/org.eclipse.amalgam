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
package org.eclipse.amalgam.explorer.activity.ui.api.editor.pages.helper;

import java.util.MissingResourceException;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;

/**
 * Provide services to display EObject.
 * 
 */
public class EObjectLabelProviderHelper {
	/**
	 * Suffix used by EMF Edit when generating feature labels.
	 */
	private static final String FEATURE_GENERATED_KEY_SUFFIX = "_feature"; //$NON-NLS-1$
	/**
	 * Suffix used by EMF Edit when generating metaclasse labels.
	 */
	private static final String METACLASS_GENERATED_KEY_SUFFIX = "_type"; //$NON-NLS-1$
	/**
	 * Prefix used by EMF Edit when generating labels.
	 */
	private static final String GENERATED_KEY_PREFIX = "_UI_"; //$NON-NLS-1$
	/**
	 * Prefix used in label rendering if requested.
	 */
	private static final String METACLASS_DISPLAY_PREFIX = "["; //$NON-NLS-1$
	/**
	 * Suffix used in label rendering if requested.
	 */
	private static final String METACLASS_DISPLAY_SUFFIX = "] "; //$NON-NLS-1$

	/**
	 * Get the generated item provider for given object.
	 * 
	 * @param object_p
	 * @return<code>null</code> if one of parameters is <code>null</code> or if
	 *                          no provider is found.
	 */
	protected static IItemLabelProvider getItemLabelProvider(EObject object_p) {
		// Precondition.
		if (null == object_p) {
			return null;
		}
		AdapterFactoryEditingDomain editingDomain = (AdapterFactoryEditingDomain) AdapterFactoryEditingDomain
				.getEditingDomainFor(object_p);
		// Precondition.
		if (null == editingDomain) {
			return null;
		}
		return (IItemLabelProvider) editingDomain.getAdapterFactory().adapt(object_p, IItemLabelProvider.class);
	}

	/**
	 * Get the label for given object based on generated item provider.
	 * 
	 * @param object_p
	 * @return<code>null</code> if one of parameters is <code>null</code> or if
	 *                          no label is found.
	 */
	public static String getText(EObject object_p) {
		String label = ""; //$NON-NLS-1$

		IItemLabelProvider provider = getItemLabelProvider(object_p);
		if (null != provider) {
			label = provider.getText(object_p);
		}
		return label;
	}

	/**
	 * Get the image for given object based on generated item provider.
	 * 
	 * @param object_p
	 * @return<code>null</code> if one of parameters is <code>null</code> or if
	 *                          no image is found.
	 */
	public static Image getImage(EObject object_p) {
		Object image = null;

		IItemLabelProvider provider = getItemLabelProvider(object_p);
		if (null != provider) {
			image = provider.getImage(object_p);
		}
		return (null != image) ? getImageFromObject(image) : null;
	}

	/**
	 * Get the image descriptor for given object based on generated item
	 * provider.
	 * 
	 * @param object_p
	 * @return<code>null</code> if one of parameters is <code>null</code> or if
	 *                          no image descriptor is found.
	 */
	public static ImageDescriptor getImageDescriptor(EObject object_p) {
		Object image = null;

		IItemLabelProvider provider = getItemLabelProvider(object_p);
		if (null != provider) {
			image = provider.getImage(object_p);
		}
		return (null != image) ? getImageDescriptorFromObject(image) : null;
	}

	/**
	 * Get Image from a object representation of it.
	 * 
	 * @param image_p
	 * @return <code>null</code> if image creation fails.
	 */
	public static Image getImageFromObject(Object image_p) {
		return ExtendedImageRegistry.getInstance().getImage(image_p);
	}

	/**
	 * Get ImageDescriptor from a object representation of it.
	 * 
	 * @param image_p
	 * @return <code>null</code> if image descriptor creation fails.
	 */
	public static ImageDescriptor getImageDescriptorFromObject(Object image_p) {
		return ExtendedImageRegistry.getInstance().getImageDescriptor(image_p);
	}

	/**
	 * Get the metaclass label (emitted by EMF Edit generation) for given
	 * object.
	 * 
	 * @param object_p
	 * @param addBrackets_p
	 *            if <code>true</code> the returned label is surrounded by
	 *            brackets.
	 * @return <code>null</code> if one of parameters is <code>null</code> or if
	 *         no label is found.
	 */
	public static String getMetaclassLabel(EObject object_p, boolean addBrackets_p) {
		String label = null;
		// Precondition.
		if (null == object_p) {
			return label;
		}
		AdapterFactoryEditingDomain editingDomain = (AdapterFactoryEditingDomain) AdapterFactoryEditingDomain
				.getEditingDomainFor(object_p);
		// Precondition.
		if (null == editingDomain) {
			return label;
		}
		// Adaptation to ItemProviderAdapter returns null due to EMF Edit
		// generated ItemProviderAdapterFactory that do not support this type.
		// So, we adapt to IItemLabelProvider and then we cast...
		IItemLabelProvider provider = (IItemLabelProvider) editingDomain.getAdapterFactory().adapt(object_p,
				IItemLabelProvider.class);
		if (provider instanceof ItemProviderAdapter) {
			label = getMetaclassLabel(object_p.eClass(), (ItemProviderAdapter) provider);
		}
		if (addBrackets_p) {
			label = METACLASS_DISPLAY_PREFIX + label + METACLASS_DISPLAY_SUFFIX;
		}
		return label;
	}

	/**
	 * Get the metaclass label (emitted by EMF Edit generation) for given object
	 * according given editing domain.
	 * 
	 * @param object_p
	 * @param provider_p
	 * @return <code>null</code> if one of parameters is <code>null</code> or if
	 *         no label is found.
	 */
	public static String getMetaclassLabel(EClass class_p, ItemProviderAdapter provider_p) {
		String label = null;
		// Preconditions.
		if ((null == class_p) || (null == provider_p)) {
			return label;
		}
		try {
			label = provider_p.getString(GENERATED_KEY_PREFIX + class_p.getName() + METACLASS_GENERATED_KEY_SUFFIX);
		} catch (MissingResourceException e) {
			label = "<<MissingResourceException>> [" + class_p.getName() + "]"; //$NON-NLS-1$ //$NON-NLS-2$
		}
		return label;
	}

	/**
	 * Get the metaclass label (emitted by EMF Edit generation) for given object
	 * according given editing domain.
	 * 
	 * @param object_p
	 * @param provider_p
	 * @return <code>null</code> if one of parameters is <code>null</code> or if
	 *         no label is found.
	 */
	public static String getFeatureLabel(EStructuralFeature feature_p, ItemProviderAdapter provider_p) {
		String label = null;
		// Preconditions.
		if ((null == feature_p) || (null == provider_p)) {
			return label;
		}
		String featureKey = feature_p.getEContainingClass().getName() + "_" + feature_p.getName(); //$NON-NLS-1$
		label = provider_p.getString(GENERATED_KEY_PREFIX + featureKey + FEATURE_GENERATED_KEY_SUFFIX);
		return label;
	}
}