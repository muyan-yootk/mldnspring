package cn.mldn.mldnspring.service;

import javax.jws.WebService;

@WebService 
public interface IMessageService {
	public String echo(String msg) ;
} 
