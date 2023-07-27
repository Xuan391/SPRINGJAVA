//package com.example.JAVASPRING1.config;
//
//import jakarta.persistence.EntityManagerFactory;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.autoconfigure.domain.EntityScan;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
//
//
//import javax.sql.DataSource;
//
//@Configuration
//@EnableJpaRepositories(basePackages = "com.example.JAVASPRING1.repositories",
//        entityManagerFactoryRef = "userEntityManagerFactory", transactionManagerRef = "userTransactionManager")
//@EntityScan("com.example.JAVASPRING1.entity")
//public class DataSourceConfig {
//    @Primary
//    @Bean(name = "userDataSourceProperties")
//    @ConfigurationProperties("spring.datasource.secondary")
//    public DataSourceProperties userDataSourceProperties() {
//        return new DataSourceProperties();
//    }
//
//    @Primary
//    @Bean(name = "userDataSource")
//    public DataSource userDataSource(@Qualifier("userDataSourceProperties") DataSourceProperties dataSourceProperties) {
//        return dataSourceProperties.initializeDataSourceBuilder().build();
//    }
//
//    @Primary
//    @Bean(name = "userEntityManagerFactory")
//    public LocalContainerEntityManagerFactoryBean userEntityManagerFactory(EntityManagerFactoryBuilder builder,
//                                                                           @Qualifier("userDataSource") DataSource userDataSource) {
//        return builder
//                .dataSource(userDataSource)
//                .packages("com.example.JAVASPRING1.entity")
//                .persistenceUnit("user")
//                .build();
//    }
//
//    @Primary
//    @Bean(name = "userTransactionManager")
//    public PlatformTransactionManager userTransactionManager(@Qualifier("userEntityManagerFactory") EntityManagerFactory userEntityManagerFactory) {
//        return new JpaTransactionManager(userEntityManagerFactory);
//    }
//}