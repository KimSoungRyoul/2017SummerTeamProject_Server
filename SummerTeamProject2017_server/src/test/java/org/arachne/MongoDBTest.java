package org.arachne;

import org.arachne.domain.testvo.Domain;
import org.arachne.infrastructure.repository.mongodb.DomainRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringRunner.class)
@ActiveProfiles("mongoTest")
@SpringBootTest
@Log4j
public class MongoDBTest{

  
	@Autowired
	DomainRepository domainRepository;
	
	
	@Test
	public void testMongo()throws Exception{
		
		
		Domain domain=new Domain();
		
		domain.setDisplayAds(true);
		domain.setDomain("samsoungGallexy4S");
		domain.setId(4L);
		
		domainRepository.save(domain);
		
		
		Domain domain2= domainRepository.findCustomByDomain("samsoungGallexy4S");
		
		log.info("TEST: ~~~~~~~~::   "+ domain2.toString());
		
		
		
	}
	
	

}