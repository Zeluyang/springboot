package com.bjsxt.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;



/**
 * @author zhaoyangyang
 * 
 * 此listener由web容器创建
 *
 */
@WebListener
public class MyFirstListener implements ServletContextListener {
	//监听ServletContext
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		String p = sce.getServletContext().getInitParameter("test1");
		
		System.out.println("init parameter p1 = " + p);
		
		System.out.println("first listener initialized ...");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {	
		
	}

}
