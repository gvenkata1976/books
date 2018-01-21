package com.actiweb.dao;

import java.sql.SQLException;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import com.actiweb.common.utils.Constants;

import oracle.jdbc.pool.OracleDataSource;

@Configuration
@PropertySources(value = { @PropertySource(value = "file:${config.path}") })
public class DatabaseConfig implements Constants {

  private static final String PROPERTY_NAME_DATABASE_DRIVER = "jdbc.driver";
  private static final String PROPERTY_NAME_DATABASE_URL = "jdbc.url";
  private static final String PROPERTY_NAME_DATABASE_USERNAME = "jdbc.username";
  private static final String PROPERTY_NAME_DATABASE_PASSWORD = "jdbc.password";

  private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "hibernate.dialect";
  private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "hibernate.show_sql";
  private static final String PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN = "com.actiweb.entities";

  @Autowired
  private Environment env;

  @PostConstruct
  public void postConstruct() {
    log.info(">>>>>>PROPERTY_NAME_DATABASE_DRIVER  : " + env.getRequiredProperty(PROPERTY_NAME_DATABASE_DRIVER));
    log.info(">>>>>>PROPERTY_NAME_DATABASE_URL  : " + env.getRequiredProperty(PROPERTY_NAME_DATABASE_URL));
    log.info(">>>>>>PROPERTY_NAME_DATABASE_USERNAME  : " + env.getRequiredProperty(PROPERTY_NAME_DATABASE_USERNAME));
    log.info(">>>>>>PROPERTY_NAME_DATABASE_PASSWORD  : " + env.getRequiredProperty(PROPERTY_NAME_DATABASE_PASSWORD));
  }

  @Bean
  public DataSource dataSource() {
    OracleDataSource dataSource = null;
    try {
      dataSource = new OracleDataSource();

      dataSource.setDriverType(env.getRequiredProperty(PROPERTY_NAME_DATABASE_DRIVER));
      dataSource.setURL(env.getRequiredProperty(PROPERTY_NAME_DATABASE_URL));
      dataSource.setUser(env.getRequiredProperty(PROPERTY_NAME_DATABASE_USERNAME));
      dataSource.setPassword(env.getRequiredProperty(PROPERTY_NAME_DATABASE_PASSWORD));
    } catch (IllegalStateException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return dataSource;
  }

  @Bean
  public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
    LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
    entityManagerFactoryBean.setDataSource(dataSource());
    entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
    entityManagerFactoryBean.setPackagesToScan(PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN);

    entityManagerFactoryBean.setJpaProperties(hibProperties());

    return entityManagerFactoryBean;
  }

  private Properties hibProperties() {
    Properties properties = new Properties();
    properties.put(PROPERTY_NAME_HIBERNATE_DIALECT, env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_DIALECT));
    properties.put(PROPERTY_NAME_HIBERNATE_SHOW_SQL, env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_SHOW_SQL));
    return properties;
  }

  @Bean
  public JpaTransactionManager transactionManager() {
    JpaTransactionManager transactionManager = new JpaTransactionManager();
    transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
    return transactionManager;
  }

}