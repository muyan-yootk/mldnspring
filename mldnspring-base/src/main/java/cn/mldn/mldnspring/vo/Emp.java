package cn.mldn.mldnspring.vo;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Emp implements Serializable {
	private Long empno ; 
	private String ename ;
	private Dept dept ;
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	public Dept getDept() {
		return dept;
	}
	public void setEmpno(Long empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public Long getEmpno() {
		return empno;
	}

	@Override
	public String toString() {
		return "empno = " + this.empno + "、ename = " + this.ename ;
	}
}
