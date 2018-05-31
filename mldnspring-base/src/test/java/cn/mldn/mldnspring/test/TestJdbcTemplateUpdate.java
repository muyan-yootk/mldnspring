package cn.mldn.mldnspring.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ParameterizedPreparedStatementSetter;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.mldn.mldnspring.vo.News;

@ContextConfiguration(locations= {"classpath:spring/spring-base.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestJdbcTemplateUpdate {
	@Autowired
	private JdbcTemplate jdbcTemplate ;	// 直接注入的是数据源
	
	@Test
	public void testBatch() throws Exception {
		String sql = "INSERT INTO news(title,note,pubdate,price,readcount) VALUES (?,?,?,?,?)" ;
		List<News> allNews = new ArrayList<News>() ;
		for (int x = 0; x < 10; x++) {
			News vo = new News() ;
			vo.setTitle("mldn - " + x);
			vo.setNote("睡觉吧 - " + x);
			vo.setPrice(1.1 * x);
			vo.setReadcount(x);
			vo.setPubdate(new Date());
			allNews.add(vo) ;
		}
		int[][] result = this.jdbcTemplate.batchUpdate(sql, allNews, allNews.size(), new ParameterizedPreparedStatementSetter<News>() {
			@Override
			public void setValues(PreparedStatement ps, News vo) throws SQLException {
				ps.setString(1, vo.getTitle());
				ps.setString(2, vo.getNote());
				ps.setDate(3, new java.sql.Date(vo.getPubdate().getTime()));
				ps.setDouble(4, vo.getPrice());
				ps.setInt(5, vo.getReadcount());
			} 
		});
		System.out.println(Arrays.toString(result));
	}
	
	@Test
	public void testDelete() throws Exception {
		String sql = "DELETE FROM news WHERE nid=?" ;
		long nid = 1 ;
		int len = this.jdbcTemplate.update(sql, nid) ; 
		System.out.println("更新行数：" + len);
	} 
	
	@Test
	public void testUpdate() throws Exception {
		String sql = "UPDATE news SET title=?,note=?,pubdate=?,price=?,readcount=? WHERE nid=?" ;
		long nid = 3 ;
		String title = "周末休息" ;
		String note = "是真的" ;
		Date pubdate = new Date() ;
		double price = 9.9 ;
		int readCount = 10000 ;
		int len = this.jdbcTemplate.update(sql, title,note,pubdate,price,readCount,nid) ; 
		System.out.println("更新行数：" + len);
	}
	@Test
	public void testKeyHolder() throws Exception {
		KeyHolder key = new GeneratedKeyHolder() ;	// 获取自动增长的key
		String sql = "INSERT INTO news(title,note,pubdate,price,readcount) VALUES (?,?,?,?,?)" ;
		String title = "周末来临啦，欢呼吧！" ;
		String note = "周末是不休息要上课。" ;
		Date pubdate = new Date() ;
		double price = 0.0 ;
		int readCount = 100 ;
		int len = this.jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement(sql) ;
				pstmt.setString(1, title);
				pstmt.setString(2, note);
				pstmt.setDate(3, new java.sql.Date(pubdate.getTime()));
				pstmt.setDouble(4, price);
				pstmt.setInt(5, readCount);
				return pstmt;
			}
		}, key) ;
		System.out.println("更新行数：" + len + "、增长后的ID：" + key.getKey());
	} 
	@Test
	public void testAdd() throws Exception {
		String sql = "INSERT INTO news(title,note,pubdate,price,readcount) VALUES (?,?,?,?,?)" ;
		String title = "周末来临啦，欢呼吧！" ;
		String note = "周末是不休息要上课。" ;
		Date pubdate = new Date() ;
		double price = 0.0 ;
		int readCount = 100 ;
		int len = this.jdbcTemplate.update(sql, title,note,pubdate,price,readCount) ;
		System.out.println("更新行数：" + len);
	}
}
