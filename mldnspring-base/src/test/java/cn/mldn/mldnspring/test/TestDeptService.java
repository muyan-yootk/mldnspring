package cn.mldn.mldnspring.test;

import javax.annotation.Resource;

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
	private IDeptService deptService ;
	@Autowired
	public void setDeptService(IDeptService deptService) {
		this.deptService = deptService;
	}
	@Test
	public void testAdd() {
		Dept vo = new Dept() ;
		vo.setDeptno(99L);
		vo.setDname("开发部");
		System.out.println(this.deptService.add(vo));
	}
}
