package cn.mldn.mldnspring.util;

import java.util.List;

import org.springframework.core.io.Resource;

public class ResourceUtil {
	private List<Resource> resources ; 	// 一组资源的注入
	// setter、getter略

	public List<Resource> getResources() {
		return resources;
	}

	public void setResources(List<Resource> resources) {
		this.resources = resources;
	}
	
}
