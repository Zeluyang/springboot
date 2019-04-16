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
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * @author zhaoyangyang
 *
 */
@WebFilter(urlPatterns = "/*", initParams = { @WebInitParam(name = "test", value = "test init param value"),
		@WebInitParam(name = "test2", value = "test init param value2") })
public class MyFirstFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// 处理初始化参数？
		String initParamValue = filterConfig.getInitParameter("test");
		System.out.println("init param value : " + initParamValue);
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("first filter run...");
		chain.doFilter(request, response);
		System.out.println("first filter end...");
	}

	/**
	 * destroy方法运行唯一一次，在容器关闭的时候执行。
	 */
	@Override
	public void destroy() {

	}

}
