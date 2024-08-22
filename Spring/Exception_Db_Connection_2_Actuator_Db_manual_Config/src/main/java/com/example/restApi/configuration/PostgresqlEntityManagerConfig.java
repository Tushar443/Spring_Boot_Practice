package com.example.restApi.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(
        entityManagerFactoryRef = "postgresEntityManagerFactoryBean",
        basePackages = "com.example.restApi.repository.orderRepo"
)
public class PostgresqlEntityManagerConfig {

    EntityManagerFactoryBuilder entityManagerFactoryBuilder;

    public PostgresqlEntityManagerConfig(EntityManagerFactoryBuilder entityManagerFactoryBuilder) {
        this.entityManagerFactoryBuilder = entityManagerFactoryBuilder;
    }


    @Bean
    public LocalContainerEntityManagerFactoryBean postgresEntityManagerFactoryBean(@Qualifier("postgreSqlDataSource") DataSource dataSource){
        return entityManagerFactoryBuilder
                .dataSource(dataSource)
                .packages("com.example.restApi.entity.orderEntity")
                .build();
    }

}
