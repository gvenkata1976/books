package com.actiweb.web.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.actiweb.entities.User;
import com.actiweb.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController extends BaseMultiActionController {

  @Autowired
  private IUserService service;

  public IUserService getService() {
    return service;
  }

  public void setService(IUserService service) {
    this.service = service;
  }

  /**
   * @param request
   * @param response
   * @return
   * @throws Exception
   */
  @RequestMapping("/validate.htm")
  public ModelAndView validate(HttpServletRequest request, HttpServletResponse response, Object command)
      throws Exception {
    ModelAndView mv = new ModelAndView();

    User user = getUser(request);
    try {
      service.isValidUser(user);
      HttpSession session = request.getSession(true);

      session.setAttribute("User", user);
      request.setAttribute("activeTab", "Home");
      mv.setViewName("redirect:/employee/list.htm");

    } catch (Exception e1) {
      log.error("ERR_ACW_DPT_06", e1);
      mv.addObject("msg", "Login failed. ");
      user = new User();
      mv.addObject("user", user);
      mv.setViewName("login");
    }
    return mv;

  }

  /**
   * @param request
   * @param response
   * @return
   * @throws Exception
   */
  @RequestMapping("/login.htm")
  public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception {
    ModelAndView mv = new ModelAndView();
    User user = new User();
    mv.addObject("user", user);
    mv.setViewName("login");
    return mv;
  }

  private User getUser(HttpServletRequest request) {
    User user = new User();
    user.setUserName(request.getParameter("userName"));
    user.setPassword(request.getParameter("password"));
    return user;
  }

  @RequestMapping("/edit.htm")
  public ModelAndView edit(HttpServletRequest request, HttpServletResponse response, Object command) throws Exception {
    // TODO Auto-generated method stub
    return null;
  }

  @RequestMapping("/list.htm")
  public ModelAndView list(HttpServletRequest request, HttpServletResponse response, Object command) throws Exception {
    // TODO Auto-generated method stub
    return null;
  }

  @RequestMapping("/update.htm")
  public ModelAndView update(HttpServletRequest request, HttpServletResponse response, Object command)
      throws Exception {
    // TODO Auto-generated method stub
    return null;
  }

  @RequestMapping("/add.htm")
  public ModelAndView add(HttpServletRequest request, HttpServletResponse response, Object command) throws Exception {
    // TODO Auto-generated method stub
    return null;
  }

  @RequestMapping("/delete.htm")
  public ModelAndView delete(HttpServletRequest request, HttpServletResponse response, Object command)
      throws Exception {
    // TODO Auto-generated method stub
    return null;
  }

  @RequestMapping("/logout.htm")
  public ModelAndView logout(HttpServletRequest request, HttpServletResponse response, Object command)
      throws Exception {
    // TODO Auto-generated method stub
    return null;
  }

}
