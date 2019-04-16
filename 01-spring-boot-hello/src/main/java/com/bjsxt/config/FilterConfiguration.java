/**
 * 
 */
package com.bjsxt.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bjsxt.filter.MySecondFilter;



/**
 * @author Administrator
 *
 */
@Configuration
public class FilterConfiguration {
	@Bean
	public FilterRegistrationBean getFilterRegistrationBean(){
		//com.bjsxt.filter包下MySecondFilter类注入spring容器
		FilterRegistrationBean bean = new FilterRegistrationBean(new MySecondFilter());
		List<String> urlPatterns = new ArrayList<String>();
		urlPatterns.add("/*");
		bean.setUrlPatterns(urlPatterns);
		return bean;
		
	}
	
	@Bean
	public FilterRegistrationBean getFilterNewRegistrationBean(){
		//com.bjsxt.filter包下MySecondFilter类注入spring容器
		FilterRegistrationBean bean = new FilterRegistrationBean(new MySecondFilter());
		List<String> urlPatterns = new ArrayList<String>();
		urlPatterns.add("/*");
		bean.setUrlPatterns(urlPatterns);
		return bean;
		
	}

}
