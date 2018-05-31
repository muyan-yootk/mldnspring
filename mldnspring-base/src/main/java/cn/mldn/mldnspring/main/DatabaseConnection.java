package cn.mldn.mldnspring.main;

import java.sql.Connection;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class DatabaseConnection {
	public static final String DRIVER = "org.gjt.mm.mysql.Driver" ;
	public static final String URL = "jdbc:mysql://localhost:3306/mldn" ;
	public static final String USERNAME = "root" ;
	public static final String PASSWORD = "mysqladmin" ;
	public static void main(String[] args) throws Exception {
		DriverManagerDataSource dataSource = new DriverManagerDataSource() ;
		dataSource.setDriverClassName(DRIVER);
		dataSource.setUrl(URL);
		dataSource.setUsername(USERNAME) ;
		dataSource.setPassword(PASSWORD); 
		Connection conn = dataSource.getConnection() ;
		System.out.println(conn);
		conn.close(); 
	}
}
