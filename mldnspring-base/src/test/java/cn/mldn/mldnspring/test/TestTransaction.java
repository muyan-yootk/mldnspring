package cn.mldn.mldnspring.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;


@ContextConfiguration(locations= {"classpath:spring/spring-base.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestTransaction {
	@Autowired	// 注入事务管理类
	private PlatformTransactionManager transactionManager ;
	@Autowired
	private JdbcTemplate jdbcTemplate ;
	@Test
	public void test() throws Exception {
		// 利用TransactionDefinition来定义事务的相关环境配置属性
		DefaultTransactionDefinition transactionDefinition = new DefaultTransactionDefinition() ;
		// 定义事务的传播属性，所有的操作都一定需要开启事务的支持
		transactionDefinition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		// 使用默认的隔离级别（数据库处理）作为事务的隔离级别
		transactionDefinition.setIsolationLevel(TransactionDefinition.ISOLATION_DEFAULT);
		// transactionDefinition.setReadOnly(true); // 只读事务
		// 利用PlatformTransactionManager和TransactionDefinition可以获取一个事务的状态
		TransactionStatus status = this.transactionManager.getTransaction(transactionDefinition) ;
		try {
			String sql = "DELETE FROM news WHERE nid=?" ;
			long nid = 19 ;
			int len = this.jdbcTemplate.update(sql, nid) ; 
			System.out.println("更新行数：" + len);
			this.transactionManager.commit(status);
		} catch (Exception e) {
			this.transactionManager.rollback(status);
		}
	} 
}
