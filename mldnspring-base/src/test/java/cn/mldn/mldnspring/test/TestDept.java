package cn.mldn.mldnspring.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.mldn.mldnspring.vo.Dept;

@ContextConfiguration(locations= {"classpath:spring/spring-base.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestDept {
	@Autowired
	private Dept dept ;
	@Test
	public void testOut() throws Exception {
		System.out.println(this.dept.getDeptno());
		System.out.println(this.dept.getDname());
		System.out.println(this.dept.getLoc());
	}
}
