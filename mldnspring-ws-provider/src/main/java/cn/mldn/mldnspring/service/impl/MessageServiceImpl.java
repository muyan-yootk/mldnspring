package cn.mldn.mldnspring.service.impl;

import javax.jws.WebService;

import cn.mldn.mldnspring.service.IMessageService;

@WebService(		// 进行WebService服务注册
		serviceName = "messageService", 	// 服务名称
		endpointInterface = "cn.mldn.mldnspring.service.IMessageService")	// 服务对应的远程接口
public class MessageServiceImpl implements IMessageService {

	@Override 
	public String echo(String msg) {
		if (msg == null) {
			throw new RuntimeException("空的消息，无法进行处理！") ;
		}
		return "【ECHO】msg = " + msg;
	}

}
