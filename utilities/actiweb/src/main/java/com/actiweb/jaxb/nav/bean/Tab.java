//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.09.22 at 11:03:30 PM IST 
//

package com.actiweb.jaxb.nav.bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for anonymous complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="value" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="parent" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="default" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="toolbar" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class Tab {

  @XmlAttribute(name = "name")
  protected String name;
  @XmlAttribute(name = "value")
  protected String value;
  @XmlAttribute(name = "parent")
  protected String parent;
  @XmlAttribute(name = "default")
  protected Boolean _default;
  @XmlAttribute(name = "toolbar")
  protected Boolean toolbar;

  /**
   * Gets the value of the name property.
   * 
   * @return possible object is {@link String }
   * 
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the value of the name property.
   * 
   * @param value
   *          allowed object is {@link String }
   * 
   */
  public void setName(String value) {
    this.name = value;
  }

  /**
   * Gets the value of the value property.
   * 
   * @return possible object is {@link String }
   * 
   */
  public String getValue() {
    return value;
  }

  /**
   * Sets the value of the value property.
   * 
   * @param value
   *          allowed object is {@link String }
   * 
   */
  public void setValue(String value) {
    this.value = value;
  }

  /**
   * Gets the value of the parent property.
   * 
   * @return possible object is {@link String }
   * 
   */
  public String getParent() {
    return parent;
  }

  /**
   * Sets the value of the parent property.
   * 
   * @param value
   *          allowed object is {@link String }
   * 
   */
  public void setParent(String value) {
    this.parent = value;
  }

  /**
   * Gets the value of the default property.
   * 
   * @return possible object is {@link Boolean }
   * 
   */
  public Boolean isDefault() {
    return _default;
  }

  /**
   * Sets the value of the default property.
   * 
   * @param value
   *          allowed object is {@link Boolean }
   * 
   */
  public void setDefault(Boolean value) {
    this._default = value;
  }

  /**
   * Gets the value of the toolbar property.
   * 
   * @return possible object is {@link Boolean }
   * 
   */
  public Boolean isToolbar() {
    return toolbar;
  }

  /**
   * Sets the value of the toolbar property.
   * 
   * @param value
   *          allowed object is {@link Boolean }
   * 
   */
  public void setToolbar(Boolean value) {
    this.toolbar = value;
  }

}