package cn.mldn.mldnspring.aop.service;

public class ServiceAdvice {
	public void handleBefore(Object arg) {
		System.err.println("【ServiceAdvice-Before】业务调用执行之前。" + arg);
	}
	public void handleReturn(Object result) {	// 后置返回通知，方法执行完毕返回结果
		System.err.println("【ServiceAdvice-Return】方法返回，返回结果：" + result);
	}
	public void handleThrow(Exception exp) {
		System.err.println("【ServiceAdvice-Throw】方法执行抛出异常：" + exp);
	} 
	public void handleAfter() {	// 后置最终通知
		System.err.println("【ServiceAdvice-After】业务调用执行之后。");
	}
}
