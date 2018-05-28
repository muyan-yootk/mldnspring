package cn.mldn.mldnspring.vo;

import java.beans.ConstructorProperties;
import java.io.Serializable;
import java.util.Properties;

@SuppressWarnings("serial")
public class Dept implements Serializable {
	private Long deptno ;
	private String dname ;
	@ConstructorProperties(value= {"pdeptno","pdname"})
	public Dept(Long deptno,String dname) {
		this.deptno = deptno ;
		this.dname = dname ;
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
		return "deptno = " + this.deptno + "、dname = " + this.dname;
	}
}
