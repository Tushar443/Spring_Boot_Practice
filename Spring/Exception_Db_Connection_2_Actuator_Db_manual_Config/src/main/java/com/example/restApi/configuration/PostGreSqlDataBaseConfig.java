package com.example.restApi.configuration;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class PostGreSqlDataBaseConfig {

    @ConfigurationProperties(prefix = "spring.datasource.pg")
    @Bean
    public DataSourceProperties postgreSqlDataSourceProperties(){
        return new DataSourceProperties();
    }

    @Bean
    public DataSource postgreSqlDataSource(){
        return postgreSqlDataSourceProperties().initializeDataSourceBuilder().build();
    }
}
