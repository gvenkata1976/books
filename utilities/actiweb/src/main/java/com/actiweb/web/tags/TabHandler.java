package com.actiweb.web.tags;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.actiweb.jaxb.nav.bean.Action;
import com.actiweb.jaxb.nav.bean.Tab;
import com.actiweb.xml.ViewConfigurationReader;

public class TabHandler extends TagSupport {
  private String userRole = null;
  private String activeTab = "Home";
  /**
   * 
   */
  private static final long serialVersionUID = -6395789747839663438L;

  @Override
  public int doStartTag() throws JspException {
    // tabs display

    if (pageContext.getSession() != null) {
      String tabs = showTabs();
      String actions = showActions();
      JspWriter out = null;
      try {
        // Get the writer object for output.
        out = pageContext.getOut();
        out.print(tabs);
        out.print(actions);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return SKIP_BODY;
  }

  /**
   * @return
   */
  private String showTabs() {
    List<Tab> tabList = ViewConfigurationReader.getMainTabs();
    if (activeTab == null || activeTab.trim().length() == 0) {
      activeTab = "Home";
    }
    StringBuffer tabs = new StringBuffer();
    tabs.append("\n<div id='cssmenu' class='menubar'>\n").append("<ul>\n");
    String activeClass = "class='active'";
    for (Iterator<Tab> iterator = tabList.iterator(); iterator.hasNext();) {
      Tab tab = (Tab) iterator.next();
      tabs.append("<li ");
      if (activeTab.equalsIgnoreCase((tab.getValue()))) {
        tabs.append(activeClass);
      }
      String url = pageContext.getServletContext().getContextPath();
      tabs.append("><a href='").append(url).append("/").append(tab.getName()).append("/list.htm").append("'>")
          .append(tab.getValue()).append("</a></li>\n");
    }

    tabs.append("</ul>").append("</div>\n");
    return tabs.toString();
  }

  /**
   * @return
   */
  private String showActions() {

    List<Action> tabList = ViewConfigurationReader.getToolbar().getActions().getAction();
    if (activeTab == null || activeTab.trim().length() == 0) {
      activeTab = "Home";
    }

    StringBuffer actions = new StringBuffer();
    actions.append("<form method=\"post\" id=").append(activeTab).append(">");
    actions.append("\n<div class='toolbar'>\n").append("<table class=\"actions\"><tr>\n");

    for (Iterator<Action> iterator = tabList.iterator(); iterator.hasNext();) {
      Action action = (Action) iterator.next();
      actions.append("<td>").append("<input type=\"submit\" name=\"action\" id=\"action\" value=\"&nbsp;");
      actions.append(action.getValue()).append("&nbsp;\" onclick=\"javascript:").append(action.getName())
          .append(activeTab).append("('0')\">&nbsp;</td>\n");
    }
    actions.append("</tr></table></div>\n");
    actions.append("</form>");
    return actions.toString();
  }

  public String getUserRole() {
    return userRole;
  }

  public void setUserRole(String userRole) {
    this.userRole = userRole;
  }

  public String getActiveTab() {
    return activeTab;
  }

  public void setActiveTab(String activeTab) {
    this.activeTab = activeTab;
  }
}
