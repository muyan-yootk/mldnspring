package cn.mldn.util.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import cn.mldn.util.web.BasePathUtil;
import cn.mldn.util.web.validation.ActionValidationUtil;

public class ValidationInterceptor implements HandlerInterceptor {
	private static final String ERROR_PAGE = "error.page" ;
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
//				this.logger.info(validationRule);
				ActionValidationUtil avu = new ActionValidationUtil(request, this.messageSource, validationRule) ;
				if (avu.getErrors().size() > 0) {	// 此时出现了错误的信息，跳转到错误页
					String errorPageKey = validationKey + ".error.page" ;
					String errorPage = null ;	// 保存错误页的路径
					try {	// 获取每个Action执行方法具体的错误页
						errorPage = this.messageSource.getMessage(errorPageKey, null, null) ;
					} catch (Exception e) {	// 获取全局错误页
						errorPage = this.messageSource.getMessage(ERROR_PAGE, null, null) ;
					}
					if ("POST".equals(request.getMethod())) {	// 现在是一个POST请求
						response.sendRedirect(BasePathUtil.getBasePath() + errorPage);
					} else {
						request.getRequestDispatcher(errorPage).forward(request, response);
					}
					return false ; // 进行拦截处理
				}
			}
		} 
		return true ;	// 如果返回true则表示继续向后执行后续的Action，如果是false表示不执行Action
	}
}
