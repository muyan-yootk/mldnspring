package cn.mldn.mldnspring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.mldn.mldnspring.service.IMessage;

public class TestMessage {
	public static void main(String[] args) {
		// 利用ApplicationContext同时指定有一个配置文件的加载路径，通过此配置文件启动Spring容器
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-base.xml");
		// 容器启动之后会自动进行类的实例化，就可以利用ApplicationContext获取实例化对象
		IMessage msg = context.getBean("messageImpl",IMessage.class) ;
		System.out.println(msg.echo("www.mldn.cn"));
				
	}
}
