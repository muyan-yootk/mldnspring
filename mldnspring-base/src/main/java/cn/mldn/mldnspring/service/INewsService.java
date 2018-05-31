package cn.mldn.mldnspring.service;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public interface INewsService {
//	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,readOnly=true)
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
	public boolean remove(long nid) ;
}
