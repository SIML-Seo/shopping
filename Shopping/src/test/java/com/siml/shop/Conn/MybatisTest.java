package com.siml.shop.Conn;

import java.sql.Connection;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@WebAppConfiguration
public class MybatisTest {
	private static final Logger logger = LoggerFactory.getLogger(MybatisTest.class);
	
	@Inject
	private DataSource ds;
	@Inject
	private SqlSessionFactory sqlFactory;
	
	@Test
	public void testConnection() {
		try {
			Connection conn = ds.getConnection();
			System.out.println("asd");
			logger.info("Connecting Success");
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
	
    @Test
    public void testFactory(){
    	logger.info("sqlFatory : " + sqlFactory);
    }
    
    @Test
    public void testSession() {
    	SqlSession sqlSession = sqlFactory.openSession();
    	logger.info("sqlSession : " + sqlSession);
    }
}
