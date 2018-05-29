package cn.mldn.mldnspring.task;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyTask {

	public void runTask() {  
		System.out.println("【当前的日期时间】" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date()));
	}

}
