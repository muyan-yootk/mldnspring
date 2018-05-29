package cn.mldn.mldnspring.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class TimerDemo {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-base.xml") ;
	}
}



