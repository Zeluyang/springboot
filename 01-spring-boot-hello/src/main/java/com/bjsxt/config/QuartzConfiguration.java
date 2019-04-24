/**
 * 
 */
package com.bjsxt.config;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.Executor;

import javax.sql.DataSource;

import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import com.bjsxt.quartz.SpringBootQuartzJobDemo;

/**
 * @author Administrator
 *
 */
@Configuration
public class QuartzConfiguration {
	@Autowired
	private DataSource dataSource;

	/**
	 * 创建调度器（可以省略）
	 * 
	 * @return scheduler（调度器）
	 * @throws Exception
	 */
	@Bean
	public Scheduler scheduler() throws Exception {
		Scheduler scheduler = schedulerFactoryBean().getScheduler();
		scheduler.start();
		return scheduler;
	}

	@Bean
	public SchedulerFactoryBean schedulerFactoryBean() throws Exception {
		SchedulerFactoryBean factory = new SchedulerFactoryBean();
		factory.setSchedulerName("Cluster_Scheduler");
		factory.setDataSource(dataSource);
		factory.setApplicationContextSchedulerContextKey("applicationContext");
		factory.setTaskExecutor(schedulerThreadPool());
		factory.setTriggers(triggers().getObject());
		factory.setQuartzProperties(quartzProperties());
		return factory;
	}

	/**
	 * 读取quartz.properties配置文件的方法。
	 * 
	 * @return
	 * @throws IOException
	 */
	@Bean
	public Properties quartzProperties() throws IOException {
		PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
		propertiesFactoryBean.setLocation(new ClassPathResource("/quartz.properties"));
		// 在quartz.properties中的属性被读取并注入后再初始化对象
		propertiesFactoryBean.afterPropertiesSet();
		return propertiesFactoryBean.getObject();
	}

	@Bean
	public CronTriggerFactoryBean triggers() {
		CronTriggerFactoryBean cronTriggerFactoryBean = new CronTriggerFactoryBean();
		cronTriggerFactoryBean.setJobDetail(job().getObject());
		cronTriggerFactoryBean.setCronExpression("0/2 * * * * ?");
		return cronTriggerFactoryBean;
	}

	/**
	 * 创建Job对象的方法。
	 * 
	 * @return
	 */
	@Bean
	public JobDetailFactoryBean job() {
		JobDetailFactoryBean jobDetailFactoryBean = new JobDetailFactoryBean();
		jobDetailFactoryBean.setJobClass(SpringBootQuartzJobDemo.class);
		// 是否持久化job内容
		jobDetailFactoryBean.setDurability(true);
		// 设置是否多次请求尝试任务。
		jobDetailFactoryBean.setRequestsRecovery(true);
		return jobDetailFactoryBean;
	}

	@Bean
	public Executor schedulerThreadPool() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(15);
		executor.setMaxPoolSize(25);
		executor.setQueueCapacity(100);
		return executor;
	}

}
