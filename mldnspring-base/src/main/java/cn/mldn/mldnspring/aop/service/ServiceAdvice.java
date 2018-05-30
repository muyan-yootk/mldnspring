package cn.mldn.mldnspring.aop.service;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
@Component
@Aspect	// 表示现在要进行的是一个AOP的配置处理类
public class ServiceAdvice {
	@Around("execution(public * cn.mldn..service..*.*(..))")
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
	@Before(value="execution(public * cn.mldn..service..*.*(..)) and args(vo)",argNames="vo")
	public void handleBefore(Object arg) {
		System.err.println("【ServiceAdvice-Before】业务调用执行之前。" + arg);
	}
	@AfterReturning(value="execution(public * cn.mldn..service..*.*(..))",returning="val",argNames="val")
	public void handleReturn(Object result) {	// 后置返回通知，方法执行完毕返回结果
		System.err.println("【ServiceAdvice-Return】方法返回，返回结果：" + result);
	}
	@AfterThrowing(value="execution(public * cn.mldn..service..*.*(..))",throwing="e",argNames="e")
	public void handleThrow(Exception exp) {
		System.err.println("【ServiceAdvice-Throw】方法执行抛出异常：" + exp);
	} 
	@After("execution(public * cn.mldn..service..*.*(..))")
	public void handleAfter() {	// 后置最终通知
		System.err.println("【ServiceAdvice-After】业务调用执行之后。");
	}
}
