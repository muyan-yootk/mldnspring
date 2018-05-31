package cn.mldn.mldnspring.test;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations= {"classpath:spring/spring-base.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestDataSource {
	@Autowired
	private DataSource dataSource ;	// 直接注入的是数据源
	@Test
	public void testJDBC() throws Exception {
		System.out.println(dataSource.getConnection());
	}
}
