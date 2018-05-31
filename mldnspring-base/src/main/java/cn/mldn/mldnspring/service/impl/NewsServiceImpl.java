package cn.mldn.mldnspring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.mldn.mldnspring.dao.INewsDAO;
import cn.mldn.mldnspring.service.INewsService;

@Service
public class NewsServiceImpl implements INewsService {
	@Autowired
	private INewsDAO newsDAO ;
	@Override
	public boolean remove(long nid) {
		return this.newsDAO.doRemove(nid) ;
	}

}
