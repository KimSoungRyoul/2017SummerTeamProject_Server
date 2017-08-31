package org.arachne.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
@MapperScan(value = {"org.arachne.infrastructure.mapper"})
public class MybatisSpringConfig {

	
	 /**
     * SqlSessionFactory 설정
     */
    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource)throws Exception{
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
            sessionFactory.setDataSource(dataSource);
            
            
            Resource[] res = new PathMatchingResourcePatternResolver().getResources("classpath:mappers/*_mapper.xml");
            
            sessionFactory.setMapperLocations(res);
            sessionFactory.setTypeAliasesPackage("org.arachne.domain");

            return sessionFactory.getObject();
            
            
            
            
    }


}
