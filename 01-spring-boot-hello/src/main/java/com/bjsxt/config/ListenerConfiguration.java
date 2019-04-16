package com.bjsxt.config;

import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bjsxt.listener.MySecondListener;


@Configuration
public class ListenerConfiguration {
	//向spring容器中注入MySecondListener类listener，此listener由spring容器管理
	@Bean
	public ServletListenerRegistrationBean<MySecondListener> getListenerRegistrationBean(){
		ServletListenerRegistrationBean<MySecondListener> bean = 
				new ServletListenerRegistrationBean<>(new MySecondListener());
		return bean;
	}
}
