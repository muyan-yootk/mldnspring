package cn.mldn.mldnspring.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.mldn.mldnspring.vo.Emp;

@ContextConfiguration(locations= {"classpath:spring/spring-base.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestEmp {
	@Resource
	private Emp emp ;
	@Test
	public void testValue() {
		System.out.println(this.emp); 
		System.out.println(this.emp.getDept());
	}
}
