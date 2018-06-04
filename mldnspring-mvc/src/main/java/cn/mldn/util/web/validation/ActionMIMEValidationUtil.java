package cn.mldn.util.web.validation;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.MessageSource;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

public class ActionMIMEValidationUtil {
	private MultipartHttpServletRequest request ;
	private MessageSource messageSource ; 
	private String rule ; 
	private Map<String,String> errors = new HashMap<String,String>() ;
	// 保存规则的定义
	private Map<String,String> ruleMap = new HashMap<String,String>() ;

	public ActionMIMEValidationUtil(HttpServletRequest request, MessageSource messageSource, String rule) {
		if (request instanceof DefaultMultipartHttpServletRequest) {// 有上传
			this.rule = rule ; // 接收规则
			this.messageSource = messageSource ;	// 接收资源读取类
			this.request = (MultipartHttpServletRequest) request ;
			this.ruleHandle(); 
			this.handleValidator(); 
		}
	}
	private void ruleHandle() {
		if (this.rule.contains("|") || this.rule.contains(":")) {
			String ruleResult [] = this.rule.split("\\|") ; // 拆分规则
			for (int x = 0 ; x < ruleResult.length ; x ++) {	// 针对于规则进行
				String temp [] = ruleResult[x].split(":") ;
				this.ruleMap.put(temp[0], temp[1]) ;
			}
		}
	}
	/**
	 * 进行规则验证
	 * @param mime 要验证的规则
	 * @param mimeRule 规则的列表
	 * @return 验证通过返回true
	 */
	private boolean isMime(String mime,String mimeRule) {
		if (mime == null || "".equals(mime)) {
			return false ;
		}
		String result [] = mimeRule.split(";") ;
		for (int x = 0 ; x < result.length ; x ++) {
			if (mime.equalsIgnoreCase(result[x])) {
				return true ;
			}
		}
		return false ;
	}
	/**
	 * 进行上传文件的验证处理，验证失败后的信息保存在Map集合之中
	 */
	private void handleValidator() {

		Map<String, MultipartFile> fileMap = this.request.getFileMap(); // 获取全部的上传文件
		if (fileMap.size() > 0) { // 现在有上传文件存在
			Iterator<Entry<String, MultipartFile>> iter = fileMap.entrySet().iterator();
			while (iter.hasNext()) { // 进行迭代处理
				try { // 进行每一个规则的验证
					Entry<String, MultipartFile> entry = iter.next();
					if (entry.getValue().getSize() > 0) { // 有指定的上传内容
						boolean mimeFlag = false;
						if (this.ruleMap.containsKey(entry.getKey())) { // 指定内容存在有规则
							mimeFlag = this.isMime(entry.getValue().getContentType(), this.ruleMap.get(entry.getKey()));
						} else { // 没有进行单独规则，使用公共规则
							mimeFlag = this.isMime(entry.getValue().getContentType(), this.rule);
						}
						if (mimeFlag == false) { // 验证失败
							this.errors.put(entry.getKey(),
									this.messageSource.getMessage("mime.validate.error.msg", null, null));
						}
					}
				} catch (Exception e) {
				}
			}
		}
		if (this.errors.size() > 0) {
			this.request.setAttribute("errors", this.errors);
		}
	}
	public Map<String, String> getErrors() { 
		return errors;
	}
}
 