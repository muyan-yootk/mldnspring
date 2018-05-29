package cn.mldn.mldnspring.test;

import java.util.Iterator;
import java.util.Scanner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.mldn.mldnspring.util.ResourceUtil;

@ContextConfiguration(locations= {"classpath:spring/spring-base.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestResourceUtil {
	@Autowired
	private ResourceUtil resourceUtil ;
	@Test
	public void testOut() throws Exception {
		Iterator<Resource> iter = this.resourceUtil.getResources().iterator() ;
		while (iter.hasNext()) {
			this.outputResource(iter.next());
		}
	}
	
	private void outputResource(Resource resource) throws Exception {
		Scanner scan = new Scanner(resource.getInputStream()) ; // 获取输入流
		scan.useDelimiter("\n") ; 
		while (scan.hasNext()) {
			System.out.println(scan.next());
		}
	}
}
