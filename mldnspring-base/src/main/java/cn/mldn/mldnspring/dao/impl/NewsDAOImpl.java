package cn.mldn.mldnspring.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import cn.mldn.mldnspring.dao.INewsDAO;
@Service
public class NewsDAOImpl implements INewsDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate ;
	@Override
	public boolean doRemove(Long nid) {
		String sql = "DELETE FROM news WHERE nid=?" ;
		return this.jdbcTemplate.update(sql, nid) > 0 ; 
	}

}
