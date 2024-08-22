package com.example.restApi.configuration;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

//@Configuration  //commenting for other connection
public class Manual_DB_Config {

    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;


    @Bean
    public DataSource dataSource(){
        // Connection Pooling
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setPassword(password);
        comboPooledDataSource.setUser(username);
        comboPooledDataSource.setJdbcUrl(url);
        return comboPooledDataSource;
    }

//    @Bean
//    public DataSource dataSource(){
//        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
//        driverManagerDataSource.setPassword(password);
//        driverManagerDataSource.setUsername(username);
//        driverManagerDataSource.setUrl(url);
//        return driverManagerDataSource;
//    }

    @Bean
    public JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(dataSource());
    }
}
