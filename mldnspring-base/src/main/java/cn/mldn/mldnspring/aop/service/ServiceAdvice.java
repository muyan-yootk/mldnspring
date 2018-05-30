package cn.mldn.mldnspring.aop.service;

public class ServiceAdvice {
	public void handleBefore(Object arg) {
		System.err.println("【ServiceAdvice-Before】业务调用执行之前。" + arg);
	}
	public void handleAfter() {
		System.err.println("【ServiceAdvice-After】业务调用执行之后。");
	}
}
