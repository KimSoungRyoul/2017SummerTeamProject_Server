package org.arachne;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.annotation.Resource;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
@ActiveProfiles("unitTest")
@SpringBootTest
public class SummerTeamProject2017ServerApplicationTests {

	
	
	
	
	/*@Autowired
	SqlSessionFactoryBean sqlSessionFactory;
	
	
	@Test
	public void sqlSessionIsNull(){
		
		
		assertNotNull(sqlSessionFactory);
		
	}
	*/
	
	@Test
	public void contextLoads() {
		
		
		
	}

}
