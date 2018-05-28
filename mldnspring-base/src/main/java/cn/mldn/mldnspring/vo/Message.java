package cn.mldn.mldnspring.vo;

public class Message {
	public void createChannel() {	// 自定义一个新的方法
		System.out.println("【Message】创建一个发送消息的通道。");
	}
	public void closeChannel() {
		System.out.println("【Message】关闭消息的发送通道。");
	}
	public void send(String msg) {
		System.out.println("【Message】消息发送，内容为：" + msg);
	}
}
