package com.projectjavasem4.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = { "com.projectjavasem4.repository" })
@EnableTransactionManagement
public class JPAConfig {

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());

		em.setPersistenceUnitName("persistence-data");
		
		
		
		// em.setPackagesToScan("com.projectjavasem4.entities");
		//em.setPackagesToScan(new String[]{"com.projectjavasem4.entities"});
		//Trong trường hợp quét dựa trên Spring, không cần thiết phải có Persence.xml; 
		//tất cả những gì bạn cần làm là chỉ định các gói cơ sở
		
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		em.setJpaProperties(additionalProperties());
		return em;
	}

	@Bean
	JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory);
		return transactionManager;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

	@Bean
	public DataSource dataSource() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/dbprojectjavasem4springmvc");
		dataSource.setUsername("root");
		dataSource.setPassword("1234$");

		/*
		 * dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver")
		 * ; dataSource.setUrl(
		 * "jdbc:sqlserver://localhost:1433;databaseName=dbprojectjavasem4springmvc");
		 * dataSource.setUsername("sa"); dataSource.setPassword("1234$");
		 */

		return dataSource;

	}

	Properties additionalProperties() {
		Properties properties = new Properties();
		

		//properties.setProperty("hibernate.hbm2ddl.auto", "create");
		
		 //properties.setProperty("hibernate.hbm2ddl.auto", "update");
		// //org.hibernate.dialect.MySQL5Dialect
		 properties.setProperty("hibernate.hbm2ddl.auto", "none");
		// //org.hibernate.dialect.H2Dialect
		// khi chuyển qua sql server phaiar thêm dòng này ->>
		// properties.setProperty("hibernate.dialect",
		// "org.hibernate.dialect.SQLServer2008Dialect");
		// //org.hibernate.dialect.SQLServer2008Dialect
		properties.setProperty("hibernate.enable_lazy_load_no_trans", "true");
		return properties;
	}
}
