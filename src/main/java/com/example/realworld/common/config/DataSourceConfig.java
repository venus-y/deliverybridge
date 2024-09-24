//package com.example.realworld.config;
//
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//
//import javax.sql.DataSource;
//
//@Configuration
//public class DataSourceConfig {
//    @Bean(name = "masterDataSource")
//    @Primary
//    @ConfigurationProperties(prefix = "spring.datasource.master")
//    public DataSource masterDataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean(name = "slaveDataSource")
//    @ConfigurationProperties(prefix = "spring.datasource.slave")
//    public DataSource slaveDataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean(name = "slave2DataSource")
//    @ConfigurationProperties(prefix = "spring.datasource.slave2")
//    public DataSource slave2DataSource() {
//        return DataSourceBuilder.create().build();
//    }
//}
