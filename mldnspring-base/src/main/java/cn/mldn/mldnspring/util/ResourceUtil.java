package cn.mldn.mldnspring.util;

import org.springframework.core.io.Resource;

public class ResourceUtil {
	private Resource[] resources ; 	// 一组资源的注入
	// setter、getter略

	public void setResources(Resource[] resources) {
		this.resources = resources;
	}
	public Resource[] getResources() {
		return resources;
	}	 
	
}
