/**
 * 
 */
package com.bjsxt.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Configuration;

/**
 * @author Administrator
 *
 */
@Configuration
public class ServletContextInitConfiguration implements ServletContextInitializer {


	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		servletContext.setInitParameter("test1", "p1");
		servletContext.setInitParameter("test2", "p2");
		System.out.println("init parameter ServletContextInit ....");
	}

}
