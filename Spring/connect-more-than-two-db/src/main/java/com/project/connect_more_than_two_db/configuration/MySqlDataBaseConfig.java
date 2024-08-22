package com.project.connect_more_than_two_db.configuration;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class MySqlDataBaseConfig {

    @ConfigurationProperties(prefix = "spring.datasource.mysql")
    @Bean
    public DataSourceProperties mysqlDataSourceProperties(){
        return new DataSourceProperties();
    }


    @Primary
    @Bean
    public DataSource mysqlDataSource(){
//        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
//        driverManagerDataSource.setUrl(dataSourceProperties().getUrl());
//        driverManagerDataSource.setPassword(dataSourceProperties().getPassword());
//        driverManagerDataSource.setUsername(dataSourceProperties().getUsername());
//        driverManagerDataSource.setDriverClassName(dataSourceProperties().getDriverClassName());
        return mysqlDataSourceProperties().initializeDataSourceBuilder().build();
    }
}
