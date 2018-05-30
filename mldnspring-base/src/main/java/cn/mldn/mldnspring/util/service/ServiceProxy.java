package cn.mldn.mldnspring.util.service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ServiceProxy implements InvocationHandler {
	private Object target ;
	public Object bind(Object target) {
		this.target = target ;
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this) ;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object result = null ;
		try {
			// 1、打开数据库的连接
			if (this.isBeginTransaction(method.getName())) {
				// 2、关闭数据库的自动提交操作；
			}
			// 3、调用真实业务主题
			result = method.invoke(this.target, args) ;
			if (this.isBeginTransaction(method.getName())) {
				// 4、如果没有任何的问题，则进行事务的提交（commit()）
			}
		} catch (Exception e) {
			if (this.isBeginTransaction(method.getName())) {
				// 5、代码出现有错误则进行事务的回滚（rollback()）；
			}
		} finally {
			// 6、一定要关闭数据库连接
		}
		return result;
	}
	public boolean isBeginTransaction(String methodName) {
		return methodName.startsWith("add") ;
	}
}
