//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.09.22 at 11:03:30 PM IST 
//

package com.actiweb.jaxb.nav.bean;

import javax.xml.bind.annotation.XmlRegistry;

/**
 * This object contains factory methods for each Java content interface and Java
 * element interface generated in the com.actiweb.jaxb.nav.bean package.
 * <p>
 * An ObjectFactory allows you to programatically construct new instances of the
 * Java representation for XML content. The Java representation of XML content
 * can consist of schema derived interfaces and classes representing the binding
 * of schema type definitions, element declarations and model groups. Factory
 * methods for each of these are provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

  /**
   * Create a new ObjectFactory that can be used to create new instances of
   * schema derived classes for package: com.actiweb.jaxb.nav.bean
   * 
   */
  public ObjectFactory() {
  }

  /**
   * Create an instance of {@link Organization }
   * 
   */
  public Organization createOrganization() {
    return new Organization();
  }

  /**
   * Create an instance of {@link Tabs }
   * 
   */
  public Tabs createTabs() {
    return new Tabs();
  }

  /**
   * Create an instance of {@link Toolbar }
   * 
   */
  public Toolbar createToolbar() {
    return new Toolbar();
  }

  /**
   * Create an instance of {@link Tab }
   * 
   */
  public Tab createTab() {
    return new Tab();
  }

  /**
   * Create an instance of {@link Actions }
   * 
   */
  public Actions createActions() {
    return new Actions();
  }

  /**
   * Create an instance of {@link Action }
   * 
   */
  public Action createAction() {
    return new Action();
  }

}