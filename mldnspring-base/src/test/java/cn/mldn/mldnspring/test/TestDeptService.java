package cn.mldn.mldnspring.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.mldn.mldnspring.service.IDeptService;
import cn.mldn.mldnspring.vo.Dept;

@ContextConfiguration(locations= {"classpath:spring/spring-base.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestDeptService {
	@Autowired
	private IDeptService deptService ;
	@Test
	public void testAdd() {
		System.out.println(this.deptService.add(new Dept()));
	}
}
