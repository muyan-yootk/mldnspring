package cn.mldn.mldnspring.vo;

import java.io.Serializable;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@SuppressWarnings("serial")
// <bean id="dept" class="cn.mldn.mldnspring.vo.Dept"/>
@Controller
public class Dept implements Serializable {
	private Long deptno ;
	private String dname ;
	public Dept() {
		System.out.println("*************** 实例化Dept类对象 ***************");
	}
	public Long getDeptno() {
		return deptno;
	}
	public void setDeptno(Long deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	@Override
	public String toString() {
		return "【" + super.toString() + "】deptno = " + this.deptno + "、dname = " + this.dname;
	}
}
