package cn.mldn.mldnspring.dao.impl;

import org.springframework.stereotype.Repository;

import cn.mldn.mldnspring.dao.IDeptDAO;
import cn.mldn.mldnspring.vo.Dept;
@Repository 
public class DeptDAOImpl implements IDeptDAO { 

	@Override
	public boolean doCreate(Dept vo) {
		System.err.println("【数据层】" + vo);
		return true;
	}

}
