package cn.mldn.mldnspring.main;

import java.util.Scanner;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

public class ResourceDemo {
	public static void main(String[] args) throws Exception {
		ResourceLoader loader = new DefaultResourceLoader() ;
		Resource resource = loader.getResource("classpath:spring/spring-base.xml") ;
		Scanner scan = new Scanner(resource.getInputStream()) ; // 获取输入流
		scan.useDelimiter("\n") ; 
		while (scan.hasNext()) {
			System.out.println(scan.next());
		}
	}
}
