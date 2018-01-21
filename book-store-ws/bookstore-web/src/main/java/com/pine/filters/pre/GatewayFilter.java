package com.pine.filters.pre;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class GatewayFilter extends ZuulFilter {

  private static Logger log = LoggerFactory.getLogger(GatewayFilter.class);

  @Override
  public String filterType() {
    return "pre";
  }

  @Override
  public int filterOrder() {
    return 1;
  }

  @Override
  public boolean shouldFilter() {
    return true;
  }

  @Override
  public Object run() {
    RequestContext ctx = RequestContext.getCurrentContext();
    HttpServletRequest request = ctx.getRequest(); 
    log.info(String.format("%s request to %s ", request.getMethod(), request.getRequestURL().toString()));
    addHeadersInfo(request,ctx);
    return null;
  }
  private  void addHeadersInfo(HttpServletRequest request,RequestContext ctx) { 
    Enumeration<String> headerNames = request.getHeaderNames(); 
    while (headerNames.hasMoreElements()) {
        String key = (String) headerNames.nextElement();
        String value = request.getHeader(key); 
        log.info(key+"-"+value);
    }
    String[] clientHeaders = {"Content-Type","Authorization","Accept"};
    for (int i = 0; i < clientHeaders.length; i++) {
      ctx.addZuulRequestHeader(clientHeaders[i], request.getHeader(clientHeaders[i]));
    } 
}

}