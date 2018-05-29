package cn.mldn.mldnspring.vo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Dept {
	@Value("#{item.createDate?.time}")
	private Long deptno ;
	@Value("#{item.title.toUpperCase()}")
	private String dname ;
	@Value("#{'中国北京'.substring(2,4)}")
	private String loc ;
	public Long getDeptno() {
		return deptno;
	}
	public String getDname() {
		return dname;
	}
	public String getLoc() {
		return loc;
	}
	
	
}

