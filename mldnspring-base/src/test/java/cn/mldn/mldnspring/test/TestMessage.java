package cn.mldn.mldnspring.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.mldn.mldnspring.vo.Message;

public class TestMessage {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-base.xml");
		Message msg = (Message) context.getBean("message", Message.class);
		msg.send("www.mldn.cn");
		context.registerShutdownHook();  // 调用销毁处理操作
	}
}
