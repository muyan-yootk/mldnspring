package cn.mldn.mldnspring.main;


import javax.xml.ws.Endpoint;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.mldn.mldnspring.service.IMessageService;
import cn.mldn.mldnspring.service.impl.MessageServiceImpl;

public class StartServiceMain {
	public static void main(String[] args) {
		new ClassPathXmlApplicationContext("spring/spring-*.xml") ;
	}
} 
