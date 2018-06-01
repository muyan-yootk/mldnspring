package cn.mldn.util.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class ValidationInterceptor implements HandlerInterceptor {
	private Logger logger = LoggerFactory.getLogger(ValidationInterceptor.class) ;	// 日志对象
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		this.logger.info("1、preHandle()方法执行，" + handler.getClass());
		return false ;	// 如果返回true则表示继续向后执行后续的Action，如果是false表示不执行Action
	}
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		this.logger.info("2、postHandler()方法执行，handler = " + handler.getClass() + "、ModelAndView = " + modelAndView);
	}
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception { 
		this.logger.info("3、afterCompletion()方法执行、" + handler.getClass());
	}
	
}
