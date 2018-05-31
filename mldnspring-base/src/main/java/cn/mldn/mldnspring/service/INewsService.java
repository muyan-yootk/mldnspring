package cn.mldn.mldnspring.service;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public interface INewsService {
	public boolean remove(long nid) ;
}
 