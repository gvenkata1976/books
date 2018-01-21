package com.actiweb.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomePageController {
  @RequestMapping("/")
  public ModelAndView welcome() {
    ModelAndView mv = new ModelAndView();
    mv.setViewName("redirect:/user/login.htm");
    return mv;
  }
}
