/**
 * 
 */
package com.bjsxt.schedule;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.bjsxt.service.UserService;

/**
 * @author zhaoyangyang
 * 这是第一种写定时任务的方法，还可以使用Quarz组件编写定时任务
 * 该类在spring容器启动时，通过扫描注解的方式实例化，并开始执行定时任务。
 * 该实力对象由spring容器管理
 */
/*
 * @Component 首先关闭注解，项目（spring）启动时，扫描不到@Component注解，
 * 就不会自动注入ScheduledTask的实例对象，定时任务不会被启动
 * 如果要启动该定时任务，请添加@Component注解，让spring容器找到该类，并由容器实例化该类对象
*/
//@Component
public class ScheduledTask {
	
	//这里可能是定义每隔一秒执行一次，线程沉睡两秒，所以console上每隔三秒输出显示一次，
	@Scheduled(cron = "* * * * * ?")
	public void excutorSheduledTask() {
		System.out.println(Thread.currentThread().getName() + " cron=* * * * * ? --- " + new Date());
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
