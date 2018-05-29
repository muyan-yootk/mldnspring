package cn.mldn.mldnspring.task;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
@Component	// 所有的类一定要在Spring进行注册配置
public class MyTask {
	@Scheduled(cron="* * * * * ?")
	public void runTask() {  
		System.out.println("【当前的日期时间】" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date()));
	}

}
