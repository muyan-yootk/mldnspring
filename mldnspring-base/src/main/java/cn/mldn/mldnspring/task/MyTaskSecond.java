package cn.mldn.mldnspring.task;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
@Component	// 所有的类一定要在Spring进行注册配置
public class MyTaskSecond {
	@Scheduled(cron="* * * * * ?")
	public void runTask() {  
		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("【Second - 当前的日期时间】" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date()));
	}

}
