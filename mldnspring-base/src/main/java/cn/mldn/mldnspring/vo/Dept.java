package cn.mldn.mldnspring.vo;

import java.io.Serializable;
import java.util.Set;

@SuppressWarnings("serial")
public class Dept implements Serializable {
	private Long deptno ;
	private String dname ;
	private Set<Emp> emps ;
	public void setEmps(Set<Emp> emps) {
		this.emps = emps;
	}
	public Set<Emp> getEmps() {
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
