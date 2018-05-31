package cn.mldn.mldnspring.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.mldn.mldnspring.service.INewsService;


@ContextConfiguration(locations= {"classpath:spring/spring-base.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestTransaction {
	@Autowired
	private INewsService newsService ;
	@Test
	public void test() throws Exception {
		System.out.println(this.newsService.remove(19));
	}  
}
