package cn.mldn.util.web.validation;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.MessageSource;

/**
 * 实现一个数据验证的工具类定义
 * @author mldn
 */
public class ActionValidationUtil {
	// 定义一个Map集合，在进行数据验证的时候如果出现有错误信息则要进行错误信息的保存，可以根据其是否有内容来判断是否有错误
	private Map<String,String> errors = new HashMap<String,String>() ;
	private String rule ; // 获取验证规则
	private MessageSource messageSource ; 	// 读取错误信息
	private HttpServletRequest request ; // Request对象，利用此对象可以根据参数名称获取内容
	public ActionValidationUtil(HttpServletRequest request,MessageSource messageSource,String rule) {
		this.messageSource = messageSource ;
		this.rule = rule ;
		this.request = request ; 
		this.handleValidator(); // 错误验证
	}
	public Map<String, String> getErrors() {	// 所有的错误信息
		return errors;
	}
	private String getMessage(String key) {
		try {
			return this.messageSource.getMessage(key, null, Locale.getDefault()) ;
		} catch (Exception e) {
			return "" ;
		}
	}
	/**
	 * 根据指定的验证规则进行数据的请求验证，在进行验证处理的时候所有验证失败的问题需要保存在Map集合
	 */
	private void handleValidator() {
		String ruleResult [] = this.rule.split("\\|") ; // 拆分验证规则
		for (int x = 0 ; x < ruleResult.length ; x ++) {	// 针对于每一个规则进行验证
			try {	// 如果此处出现有验证规则的问题，则不应该影响后续的规则处理
				String rule [] = ruleResult[x].split(":") ; // 获取每一个规则
				switch (rule[1]) {
				case "int" : {
					if (!this.isInt(rule[0])) {	// 没有通过验证
						this.errors.put(rule[0], this.getMessage("int.validate.error.msg")) ;
					}
					break ;
				}
				case "boolean" : {
					if (!this.isBoolean(rule[0])) {	// 没有通过验证
						this.errors.put(rule[0], this.getMessage("int.validate.error.msg")) ;
					}
					break ;
				}
				case "long" : {
					if (!this.isLong(rule[0])) {	// 没有通过验证
						this.errors.put(rule[0], this.getMessage("long.validate.error.msg")) ;
					}
					break ;
				}
				case "string" : {
					if (!this.isString(rule[0])) {	// 没有通过验证
						this.errors.put(rule[0], this.getMessage("string.validate.error.msg")) ;
					}
					break ;
				}
				case "double" : {
					if (!this.isDouble(rule[0])) {	// 没有通过验证
						this.errors.put(rule[0], this.getMessage("double.validate.error.msg")) ;
					}
					break ;
				}
				case "date" : {
					if (!this.isDate(rule[0])) {	// 没有通过验证
						this.errors.put(rule[0], this.getMessage("date.validate.error.msg")) ;
					}
					break ;
				}
				case "datetime" : {
					if (!this.isDatetime(rule[0])) {	// 没有通过验证
						this.errors.put(rule[0], this.getMessage("datetime.validate.error.msg")) ;
					}
					break ;
				}
				case "rand" : {
					if (!this.isRand(rule[0])) {	// 没有通过验证
						this.errors.put(rule[0], this.getMessage("rand.validate.error.msg")) ;
					}
					break ;
				}
				case "int[]" : {
					if (!this.isIntArray(rule[0])) {	// 没有通过验证
						this.errors.put(rule[0], this.getMessage("int[].validate.error.msg")) ;
					}
					break ;
				}
				case "long[]" : {
					if (!this.isLongArray(rule[0])) {	// 没有通过验证
						this.errors.put(rule[0], this.getMessage("long[].validate.error.msg")) ;
					}
					break ;
				}
				case "string[]" : {
					if (!this.isStringArray(rule[0])) {	// 没有通过验证
						this.errors.put(rule[0], this.getMessage("string[].validate.error.msg")) ;
					}
					break ;
				}
				}
			} catch (Exception e) {}
		}
		if (this.errors.size() > 0) {	// 有错误了
			this.request.setAttribute("errors", errors); // 保存错误信息 
		}
	}
	/**
	 * 进行字符串是否为空的验证 
	 * @param str 要验证的字符串
	 * @return 如果为空返回false，如果有内容返回true
	 */
	public boolean isString(String paramName) {	// 进行字符串的验证处理
		String paramValue = this.request.getParameter(paramName) ;
		if (paramValue == null || "".equals(paramValue)) {
			return false ;
		} 
		return true ;
	}
	/**
	 * 进行字符串的数据验证
	 * @param paramName 参数名称
	 * @return 不为空返回true
	 */
	public boolean isStringArray(String paramName) {
		String paramValue[] = this.request.getParameterValues(paramName) ;
		if (paramValue == null) {
			return false ;
		}
		for (int x = 0 ; x < paramValue.length ; x ++) {
			if (paramValue[x] == null || "".equals(paramValue[x])) {
				return false ; 
			}
		}
		return true ;
	}
	/**
	 * 验证是否为空以及是否为整数
	 * @param paramName 参数名称
	 * @return 整数返回true
	 */
	public boolean isInt(String paramName) {
		String paramValue = this.request.getParameter(paramName) ;
		if (this.isString(paramValue)) {	// 通过了字符串不为空的验证
			return paramValue.matches("\\d+") ;
		} 
		return false ;
	}
	/**
	 * 验证是否为空以及是否为整数
	 * @param paramName 参数名称
	 * @return 整数返回true
	 */
	public boolean isIntArray(String paramName) {
		String [] paramValue = this.request.getParameterValues(paramName) ;
		if (paramValue == null) {
			return false ;
		}
		for (int x = 0 ; x < paramValue.length ; x ++) {
			if (!paramValue[x].matches("\\d+")) {
				return false ;
			}
		}
		return true ;
	}
	/**
	 * 验证是否为空以及是否为整数
	 * @param paramName 参数名称
	 * @return 整数返回true
	 */
	public boolean isLong(String paramName) {
		if (isString(paramName)) {	// 通过了字符串不为空的验证
			String paramValue = this.request.getParameter(paramName) ;
			return paramValue.matches("\\d+") ;
		}
		return false ;
	}
	/**
	 * 验证是否为空以及是否为整数
	 * @param paramName 参数名称
	 * @return 整数返回true
	 */
	public boolean isLongArray(String paramName) {
		String paramValue[] = this.request.getParameterValues(paramName) ;
		if (paramValue == null) {
			return false ;
		}
		for (int x = 0 ; x < paramValue.length ; x ++) {
			if (!paramValue[x].matches("\\d+")) {
				return false ;
			}
		}
		return true ;
	}
	/**
	 * 验证是否为空以及是否为整数
	 * @param paramName 参数名称
	 * @return 整数返回true
	 */
	public boolean isDouble(String paramName) {
		if (this.isString(paramName)) {	// 通过了字符串不为空的验证
			String paramValue = this.request.getParameter(paramName) ;
			return paramValue.matches("\\d+(\\.\\d+)?") ;
		}
		return false ;
	}
	/**
	 * 验证是否为空以及是否为整数
	 * @param paramName 参数名称
	 * @return 整数返回true
	 */
	public boolean isDate(String paramName) {
		if (this.isString(paramName)) {	// 通过了字符串不为空的验证
			String paramValue = this.request.getParameter(paramName) ;
			return paramValue.matches("\\d{4}-\\d{2}-\\d{2}") ;
		}
		return false ;
	}
	/**
	 * 验证码数据
	 * @param paramName 参数名称
	 * @return 整数返回true
	 */
	public boolean isRand(String paramName) {
		if (this.isString(paramName)) {	// 通过了字符串不为空的验证
			String paramValue = this.request.getParameter(paramName) ;
			String rand = (String) this.request.getSession().getAttribute("rand") ;
			if (rand == null || "".equals(rand)) {
				return false ; 
			}
			return rand.equalsIgnoreCase(paramValue) ;
		}
		return false ;
	}
	/**
	 * 验证是否为空以及是否为整数
	 * @param paramName 参数名称
	 * @return 整数返回true
	 */
	public boolean isDatetime(String paramName) {
		if (this.isString(paramName)) {	// 通过了字符串不为空的验证
			String paramValue = this.request.getParameter(paramName) ;
			return paramValue.matches("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}") ;
		}
		return false ;
	}
	/**
	 * 验证是否为空以及是否为整数
	 * @param paramName 参数名称
	 * @return 整数返回true
	 */
	public boolean isBoolean(String paramName) {
		if (this.isString(paramName)) {	// 通过了字符串不为空的验证
			String paramValue = this.request.getParameter(paramName) ;
			return "true".equals(paramValue) || "false".equals(paramValue);
		}
		return false ;
	}
}
