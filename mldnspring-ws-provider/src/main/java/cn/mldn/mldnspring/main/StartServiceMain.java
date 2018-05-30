package cn.mldn.mldnspring.main;


import javax.xml.ws.Endpoint;

import cn.mldn.mldnspring.service.IMessageService;
import cn.mldn.mldnspring.service.impl.MessageServiceImpl;

public class StartServiceMain {
	public static void main(String[] args) {
		IMessageService service = new MessageServiceImpl();
		Endpoint.publish("http://192.168.28.87:7777/message", service) ;
	}
}
