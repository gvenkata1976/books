package com.actiweb.xml;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.actiweb.common.utils.Constants;
import com.actiweb.jaxb.nav.bean.Action;
import com.actiweb.jaxb.nav.bean.Organization;
import com.actiweb.jaxb.nav.bean.Tab;
import com.actiweb.jaxb.nav.bean.Toolbar;

public class ViewConfigurationReader implements Constants {
  static final String XML_PATH = "/config/navigation.xml";
  static Organization config = null;
  static {
    try {
      initialize();
    } catch (IOException | JAXBException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  /**
   * @throws IOException
   * @throws JAXBException
   */
  public static void initialize() throws IOException, JAXBException {
    InputStream is = ViewConfigurationReader.class.getResourceAsStream(XML_PATH);
    JAXBContext jaxbContext = JAXBContext.newInstance(Organization.class);
    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
    config = (Organization) jaxbUnmarshaller.unmarshal(is);
  }

  /**
   * @return
   */
  public static List<Tab> getMainTabs() {
    return getTabs(null);
  }

  /**
   * @param parent
   * @return
   */
  public static List<Tab> getTabs(String parent) {
    List<Tab> tabs = new ArrayList<>();
    for (Tab tab : config.getTabs().getTab()) {
      if (tab.getParent() == parent || tab.getParent().equals(parent)) {
        tabs.add(tab);
      }
    }
    return tabs;
  }

  /**
   * @return
   */
  public static Toolbar getToolbar() {
    return config.getTabs().getToolbar();
  }

  /**
   * @return
   */
  public static List<Action> getActions() {
    return config.getTabs().getToolbar().getActions().getAction();
  }

  public static void main(String[] args) {
    try {
      initialize();
      for (Tab tab : getMainTabs()) {
        System.out.println(tab.getName());
      }
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (JAXBException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}