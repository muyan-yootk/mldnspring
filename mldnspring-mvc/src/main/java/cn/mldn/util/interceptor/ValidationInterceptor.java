package cn.mldn.util.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

public class ValidationInterceptor implements HandlerInterceptor {
	@Autowired
	private MessageSource messageSource ;	// 注入资源读取类对象
	private Logger logger = LoggerFactory.getLogger(ValidationInterceptor.class) ;	// 日志对象
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if (handler instanceof HandlerMethod) {	// 判断对象是否为指定类的实例
			HandlerMethod handlerMethod = (HandlerMethod) handler ; // 对象向下转型
			// 根据反射的信息获取资源对应的key的名称
			String validationKey = handlerMethod.getBeanType().getName() + "." + handlerMethod.getMethod().getName() ;
			String validationRule = null ; // 进行资源规则的获取
			try { // 如果资源不存在则会出现异常
				validationRule = this.messageSource.getMessage(validationKey, null, null) ;
			} catch (Exception e) {}
			if (validationRule != null) {	// 程序里面需要进行验证处理
				 this.logger.info(validationRule);
			}
		} 
		return true ;	// 如果返回true则表示继续向后执行后续的Action，如果是false表示不执行Action
	}
}
