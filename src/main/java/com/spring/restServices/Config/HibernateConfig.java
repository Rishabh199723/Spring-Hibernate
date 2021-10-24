package com.spring.restServices.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
public class HibernateConfig {

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean bean = new LocalSessionFactoryBean();
        bean.setDataSource(dataSource());
        bean.setHibernateProperties(hibernateProperties());
        bean.setPackagesToScan(new String[]{"com.spring.restServices.entity"});
        bean.setAnnotatedClasses(new Class[]{com.spring.restServices.entity.Question.class, com.spring.restServices.entity.Answer.class, com.spring.restServices.entity.Laptop.class, com.spring.restServices.entity.User.class});
        return bean;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource source = new DriverManagerDataSource();
        source.setDriverClassName("oracle.jdbc.OracleDriver");
        source.setUrl("jdbc:oracle:thin:@localhost:1521/orcl");
        source.setUsername("todo_db");
        source.setPassword("todo_db");
        return source;
    }

    private Properties hibernateProperties() {
        Properties prop = new Properties();
        prop.put("hibernate.dialect", "org.hibernate.dialect.Oracle12cDialect");
        prop.put("hibernate.show_sql", true);
//        prop.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
        prop.put("hibernate.hbm2ddl.auto", "update");
        prop.put("hibernate.cache.use_second_level_cache",true);
        prop.put("hibernate.cache.region.factory_class","org.hibernate.cache.ehcache.EhCacheRegionFactory");
        return prop;
    }

    @Bean
    public HibernateTemplate hibernateTemplate() {
        HibernateTemplate template = new HibernateTemplate();
        template.setSessionFactory(sessionFactory().getObject());
        return template;
    }

    @Bean
    public HibernateTransactionManager transactionManager() {
        HibernateTransactionManager manager = new HibernateTransactionManager();
        manager.setSessionFactory(sessionFactory().getObject());
        return manager;
    }

}
