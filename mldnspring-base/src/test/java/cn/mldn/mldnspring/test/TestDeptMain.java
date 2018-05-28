package cn.mldn.mldnspring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.mldn.mldnspring.vo.Dept;

public class TestDeptMain {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-base.xml");
		for (int x = 0; x < 10; x++) {
			new Thread(() -> {
				Dept deptA = context.getBean("dept", Dept.class);
				System.out.println("【"+Thread.currentThread().getName()+" - MAIN方法】获取dept、" + deptA);
			}).start();
		}
	}
}
