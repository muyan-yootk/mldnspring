package cn.mldn.mldnspring.service.proxy;

import cn.mldn.mldnspring.service.IDeptService;
import cn.mldn.mldnspring.vo.Dept;

public class DeptServiceProxy implements IDeptService {
	private IDeptService deptService ;
	public DeptServiceProxy(IDeptService deptService) {
		this.deptService = deptService ;
	}
	@Override
	public boolean add(Dept vo) {
		try {
			// 1、打开数据库的连接
			// 2、关闭数据库的自动提交操作；
			// 3、调用真实业务主题
			this.deptService.add(vo) ;
			// 4、如果没有任何的问题，则进行事务的提交（commit()）
		} catch (Exception e) {
			// 5、代码出现有错误则进行事务的回滚（rollback()）；
		} finally {
			// 6、一定要关闭数据库连接
		}
		return false;
	}

}
