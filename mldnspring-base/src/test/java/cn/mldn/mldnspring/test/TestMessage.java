package cn.mldn.mldnspring.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.mldn.mldnspring.service.IMessage;
// 由于Spring所有的Bean都受到容器管理，则在进行测试的时候就必须明确的设置Spring配置文件的路径
@ContextConfiguration(locations= {"classpath:spring/spring-base.xml"})
// 本次将采用Junit进行代码的测试，所以选择测试的运行操作为“SpringJUnit4ClassRunner”
@RunWith(SpringJUnit4ClassRunner.class)
public class TestMessage {
	// @Resource		// 该注解为JavaEE标准注解，提供的是资源注入处理
	@Autowired 
	private IMessage message ; // 接口对象
	@Test
	public void testEcho() {
		String echoMsg = this.message.echo("www.mldn.cn") ;
		System.out.println(echoMsg);
	}
}
