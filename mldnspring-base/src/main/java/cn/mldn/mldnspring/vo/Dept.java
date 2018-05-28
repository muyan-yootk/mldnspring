package cn.mldn.mldnspring.vo;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;

@SuppressWarnings("serial")
public class Dept implements Serializable {
	private Long deptno ;
	private String dname ;
	private Map<String,Emp> emps ;
	public void setEmps(Map<String, Emp> emps) {
		this.emps = emps;
	}
	public Map<String, Emp> getEmps() {
		return emps;
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
