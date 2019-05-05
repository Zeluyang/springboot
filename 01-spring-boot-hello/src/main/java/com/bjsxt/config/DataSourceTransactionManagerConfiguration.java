/**
 * 
 */
package com.bjsxt.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

/**
 * @author Administrator
 */
@Configuration
public class DataSourceTransactionManagerConfiguration {

	@Autowired
	private DataSource dataSource;
	
	@Bean
	public DataSourceTransactionManager transactionManager() {
		//dataSource()
		return new DataSourceTransactionManager(dataSource);
	}
}
