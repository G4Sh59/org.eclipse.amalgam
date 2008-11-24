/**
 * <copyright>
 * </copyright>
 *
 * $Id: MapElement.java,v 1.1 2008/11/14 17:33:36 rgronback Exp $
 */
package org.eclipse.amalgam.examples.mindmap;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Map Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.amalgam.examples.mindmap.MapElement#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.amalgam.examples.mindmap.MindmapPackage#getMapElement()
 * @model abstract="true"
 * @generated
 */
public interface MapElement extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * The default value is <code>"Element"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.amalgam.examples.mindmap.MindmapPackage#getMapElement_Name()
	 * @model default="Element"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.amalgam.examples.mindmap.MapElement#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // MapElement