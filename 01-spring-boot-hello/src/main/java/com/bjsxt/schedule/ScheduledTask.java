/**
 * 
 */
package com.bjsxt.schedule;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author zhaoyangyang
 * 这是第一种写定时任务的方法，还可以使用Quarz组件编写定时任务
 */
@Component
public class ScheduledTask {

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
