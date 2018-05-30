package cn.mldn.mldnspring.service.impl;

import org.springframework.stereotype.Service;

import cn.mldn.mldnspring.service.IDeptService;
import cn.mldn.mldnspring.vo.Dept;
@Service
public class DeptServiceImpl implements IDeptService {

	@Override
	public boolean add(Dept vo) {
		System.out.println("【DeptService】实现部门数据增加。");
		return false;
	}

}
