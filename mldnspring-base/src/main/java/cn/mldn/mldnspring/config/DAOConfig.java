package cn.mldn.mldnspring.config;	// 必须放在扫描包的子包下

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import cn.mldn.mldnspring.dao.IDeptDAO;
import cn.mldn.mldnspring.dao.impl.DeptDAOImpl;

@Configuration		// 表示此类是一个配置类
public class DAOConfig {	// 名称可以任意编写
	@Scope("prototype") 
	@Bean(value="deptDAO") 
	public IDeptDAO getDeptDAOInstance() {	// 方法名称可以随意编写
		return new DeptDAOImpl() ; 
	}
}
