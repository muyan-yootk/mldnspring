package cn.mldn.mldnspring.aop.service;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;

public class ServiceAdvice {
	public Object handleAround(ProceedingJoinPoint point) throws Throwable {
		System.out.println("1、***** 〖环绕通知-BEFORE〗方法调用之前，参数：" + Arrays.toString(point.getArgs()));
		Object result = null ; // 保存返回结果
		try {
			result = point.proceed(point.getArgs()) ;// 调用真实业务主题
		} catch (Exception e) {
			System.out.println("2、***** 〖环绕通知-THROW〗调用产生异常：" + e);
			throw e ; // 将异常抛给调用处
		}
		System.out.println("3、***** 〖环绕通知-AFTER〗调用完毕");
		System.out.println("4、***** 〖环绕通知-RETURN〗返回调用结果：" + result); 
		return result ;
	}
	
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
