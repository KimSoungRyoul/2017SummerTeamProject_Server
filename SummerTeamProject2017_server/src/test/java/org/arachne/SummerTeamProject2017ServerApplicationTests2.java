package org.arachne;

import static org.junit.Assert.assertNotNull;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
@ActiveProfiles("product")
@SpringBootTest
public class SummerTeamProject2017ServerApplicationTests2 {

	
	@Autowired
	SqlSessionFactory sessionFactory;
	
	
	
	
	@Test
	public void contextLoads() {
		
		
		
		
		assertNotNull(sessionFactory);
		
	}

}
