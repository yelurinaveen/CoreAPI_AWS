package com.adiye.happyhome.coreapi.utils;

import java.util.Properties;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by nyeluri on 11/17/16.
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("com.adiye.happyhome.coreapi")
public class DBConfiguration {

    @Value("${db.driver}")
    private String dbDriver;

    @Value("${db.url}")
    private String dbUrl;

    @Value("${db.username}")
    private String dbUsernme;

    @Value("${db.password}")
    private String dbPassword;


    @Bean(destroyMethod = "close")
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(dbDriver);
        dataSource.setUrl(dbUrl);
        dataSource.setUsername(dbUsernme);
        dataSource.setPassword(dbPassword);
        return dataSource;
    }

    @Value("${hibernate.dialect}")
    private String dialect;

    @Value("${hibernate.show_sql}")
    private String showSql;

    @Value("${hibernate.format_sql}")
    private String formatSql;

    private Properties hibProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect",dialect);
        properties.put("hibernate.show_sql",showSql);
        properties.put("hibernate.format_sql",formatSql);
        properties.put("hibernate.id.new_generator_mappings",false);
        return properties;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource){
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource);
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactoryBean.setJpaProperties(hibProperties());
        entityManagerFactoryBean.setPackagesToScan("com.adiye.happyhome.coreapi");
        return entityManagerFactoryBean;
    }

    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }
}
