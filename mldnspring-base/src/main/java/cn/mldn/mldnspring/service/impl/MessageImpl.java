package cn.mldn.mldnspring.service.impl;

import cn.mldn.mldnspring.service.IMessage;

public class MessageImpl implements IMessage {

	@Override
	public String echo(String val) {
		return "【ECHO】" + val ;
	}
 
}
