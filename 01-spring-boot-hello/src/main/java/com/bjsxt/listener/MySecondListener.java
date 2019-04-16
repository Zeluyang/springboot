/**
 * 
 */
package com.bjsxt.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author zhaoyangyang
 * MySecondListener由com.bjsxt.config.ListenerConfiguration类注入spring容器
 * 此listener由spring容器管理
 */

public class MySecondListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		String p = sce.getServletContext().getInitParameter("test2");

		System.out.println("init parameter p1 = " + p);

		System.out.println("second listener initialized ...");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {

	}

}
