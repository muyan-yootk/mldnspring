package cn.mldn.mldnspring.util;

import org.springframework.core.io.Resource;

public class ResourceUtil {
	private Resource fileResource ; 	// 读取文件
	private Resource classPathResource ; // CLASSPATH读取
	private Resource urlResource ; // 网络资源读取
	// setter、getter略
	public Resource getFileResource() {
		return fileResource;
	}
	public void setFileResource(Resource fileResource) {
		this.fileResource = fileResource;
	}
	public Resource getClassPathResource() {
		return classPathResource;
	}
	public void setClassPathResource(Resource classPathResource) {
		this.classPathResource = classPathResource;
	}
	public Resource getUrlResource() {
		return urlResource;
	}
	public void setUrlResource(Resource urlResource) {
		this.urlResource = urlResource;
	}
	
}
