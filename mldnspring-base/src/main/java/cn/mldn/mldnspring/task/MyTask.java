package cn.mldn.mldnspring.task;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class MyTask extends QuartzJobBean {

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		System.out.println("【当前的日期时间】" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date()));
	}

}
