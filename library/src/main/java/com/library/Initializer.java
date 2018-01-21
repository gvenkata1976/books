package com.library;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.library.user.UserService;

@Configuration
@ComponentScan
public class Initializer extends SpringBootServletInitializer {
	@Autowired
	UserService service;

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		service.initAdminUser();
		super.onStartup(servletContext);
	}
}
