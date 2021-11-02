package com.unimini.config;
/**
 * @package : com.unimini.config
 * @name : MybatisConfig.java
 * @date : 2021-10-06 오후 4:38
 * @author : jeongwon.song
 * @version : 1.0.0
 * @modifyed :
 **/
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@MapperScan(value= {"com.unimini.mapper"})
@EnableTransactionManagement
public class MybatisConfig {

    @Autowired
    ApplicationContext applicationContext;

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource)throws Exception{
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);

        Resource[] res = new PathMatchingResourcePatternResolver().getResources("classpath:mapper/**/*.xml");
        sessionFactory.setMapperLocations(res);

        sessionFactory.setConfigLocation(applicationContext.getResource("classpath:mybatis/mybatis-config.xml"));

        return sessionFactory.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) throws Exception {
        sqlSessionFactory.getConfiguration().setMapUnderscoreToCamelCase(true);
        SqlSessionTemplate sessionTemplate = new SqlSessionTemplate(sqlSessionFactory);

        return sessionTemplate;
    }
}
