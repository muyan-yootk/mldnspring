package cn.mldn.util.action;

import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public abstract class AbstractAction {
	@Autowired
	private MessageSource messageSource ;
	/**
	 * 实现资源文件内容的读取
	 * @param key 要读取的资源KEY
	 * @param args 设置的占位符参数
	 * @return 资源的内容
	 */
	public String getMessage(String key,String ... args) {
		try {
			return this.messageSource.getMessage(key, args, Locale.getDefault()) ;
		} catch (Exception e) {
			return null ; 
		}
	} 
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd") ;
		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(sdf, true));	
	}
	public HttpServletResponse getResponse() { 
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse() ;
	} 
	
	public HttpServletRequest getRequest() {
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest() ;
	}
}
 