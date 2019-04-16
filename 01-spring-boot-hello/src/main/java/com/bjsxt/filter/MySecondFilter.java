/**
 * 
 */
package com.bjsxt.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author Administrator
 * 
 * MySecondFilter class 将在FilterConfiguration.java完成自动配置，并注入spring容器中由spring容器管理。
 * MyFirstFilter class 没有注入spring容器，所以由web容器管理，使用时需要注意spring的一些特性不能在MyFirstFilter使用
 * 在web技术中 过滤链 中存在着 java的 责任链设计模式
 */
public class MySecondFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("second filter run...");
		chain.doFilter(request, response);
		System.out.println("second filter end...");
	}

	@Override
	public void destroy() {

	}

}
