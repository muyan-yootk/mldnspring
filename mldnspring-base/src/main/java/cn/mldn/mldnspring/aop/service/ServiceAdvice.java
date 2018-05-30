package cn.mldn.mldnspring.aop.service;

public class ServiceAdvice {
	public void handleBefore() {
		System.err.println("【ServiceAdvice-Before】业务调用执行之前。");
	}
	public void handleAfter() {
		System.err.println("【ServiceAdvice-After】业务调用执行之后。");
	}
}
