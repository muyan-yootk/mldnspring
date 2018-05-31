package cn.mldn.mldnspring.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Dept implements Serializable{
	private Long deptno ;
	private String dname ;
	@Override
	public String toString() {
		return "【Dept】deptno = " + this.deptno + "、dname = " + this.dname;
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
	
}
