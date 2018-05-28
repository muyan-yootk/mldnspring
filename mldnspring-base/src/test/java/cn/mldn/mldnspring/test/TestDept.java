package cn.mldn.mldnspring.test;

import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.mldn.mldnspring.vo.Dept;
import cn.mldn.mldnspring.vo.Emp;

@ContextConfiguration(locations= {"classpath:spring/spring-base.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestDept {
	@Resource
	private Dept dept ;
	@Test
	public void testValue() {
		System.out.println(this.dept);
		System.out.println(this.dept.getInfos().getClass());
		System.out.println(this.dept.getInfos());
	}
}
