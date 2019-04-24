package com.bjsxt.quartz;

import java.util.Date;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * 使用Spring提供的Quartz相关Job类型实现Job的定义。
 * 父类型QuartzJobBean中，提供了分布式环境中任务的配置定义。
 * 保证分布式环境中的任务是有效的。
 */
@PersistJobDataAfterExecution // 当job执行结束，持久化job信息到数据库
@DisallowConcurrentExecution // 保证job的唯一性
public class SpringBootQuartzJobDemo extends QuartzJobBean {

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		System.out.println("SpringBootQuartzJobDemo : " + new Date());
	}

}
