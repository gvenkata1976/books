package com.actiweb.web.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionFilter implements Filter {

  public void destroy() {
  }

  public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
      throws IOException, ServletException {

    HttpServletRequest request = (HttpServletRequest) req;
    HttpServletResponse response = (HttpServletResponse) res;
    HttpSession session = request.getSession(false);
    String loginURI = request.getContextPath() + "/user/login.htm";

    boolean loggedIn = session != null && session.getAttribute("User") != null;
    boolean loginRequest = request.getRequestURI().equals(loginURI);

    if (loggedIn || loginRequest) {
      chain.doFilter(request, response);
    } else {
      response.sendRedirect(loginURI);
    }

  }

  public void init(FilterConfig config) throws ServletException {

  }
}