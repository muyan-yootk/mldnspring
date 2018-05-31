package cn.mldn.mldnspring.test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.mldn.mldnspring.vo.News;

@ContextConfiguration(locations= {"classpath:spring/spring-base.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestJdbcTemplateQuery {
	@Autowired
	private JdbcTemplate jdbcTemplate ;	// 直接注入的是数据源
	@Test 
	public void testCount() {
		String keyWord = "mldn" ;
		String sql = "SELECT COUNT(*) FROM news WHERE title LIKE ?" ;
		Long count = this.jdbcTemplate.queryForObject(sql, new Object[] {"%"+keyWord+"%"}, Long.class) ;
		System.out.println(count);
	}
	
	@Test
	public void testFindLike() {
		String keyWord = "mldn" ;
		long currentPage = 1 ; 
		int lineSize = 3 ;
		String sql = "SELECT nid,title,note,pubdate,price,readCount FROM news WHERE title LIKE ? LIMIT ?,?" ;
		List<News> all = this.jdbcTemplate.query(sql, 
			new Object[] { "%"+keyWord+"%",(currentPage - 1) * lineSize , lineSize }, 
			new RowMapper<News>() { 
			@Override
			public News mapRow(ResultSet rs, int rowNum) throws SQLException {
				News vo = new News() ;
				vo.setNid(rs.getLong(1));
				vo.setTitle(rs.getString(2));
				vo.setNote(rs.getString(3));
				vo.setPubdate(rs.getDate(4));
				vo.setPrice(rs.getDouble(5));
				vo.setReadcount(rs.getInt(6)); 
				return vo;
			}}) ;
		all.forEach((news)->{
			System.out.println(news.getTitle() + " - " + news.getNote());
		});
	}
	
	@Test
	public void testFindById() {
		String sql = "SELECT nid,title,note,pubdate,price,readCount FROM news WHERE nid=?" ;
		News news = this.jdbcTemplate.queryForObject(sql, new Object[] { 3 }, new RowMapper<News>() {
			@Override
			public News mapRow(ResultSet rs, int rowNum) throws SQLException {
				News vo = new News() ;
				vo.setNid(rs.getLong(1));
				vo.setTitle(rs.getString(2));
				vo.setNote(rs.getString(3));
				vo.setPubdate(rs.getDate(4));
				vo.setPrice(rs.getDouble(5));
				vo.setReadcount(rs.getInt(6)); 
				return vo;
			}}) ;
		System.out.println(news.getTitle() + " - " + news.getNote());
	}
}
