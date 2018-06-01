package cn.mldn.util.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

public class ValidationInterceptor implements HandlerInterceptor {
	private Logger logger = LoggerFactory.getLogger(ValidationInterceptor.class) ;	// 日志对象
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if (handler instanceof HandlerMethod) {	// 判断对象是否为指定类的实例
			HandlerMethod handlerMethod = (HandlerMethod) handler ; // 对象向下转型
			this.logger.info("Action对象：" + handlerMethod.getBean());
			this.logger.info("Action类：" + handlerMethod.getBeanType());
			this.logger.info("Action方法：" + handlerMethod.getMethod());
		} 
		return true ;	// 如果返回true则表示继续向后执行后续的Action，如果是false表示不执行Action
	}
}
