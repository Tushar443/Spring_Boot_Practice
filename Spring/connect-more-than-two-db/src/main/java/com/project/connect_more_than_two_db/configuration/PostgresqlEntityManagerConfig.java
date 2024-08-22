package com.project.connect_more_than_two_db.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Objects;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "postgresEntityManagerFactoryBean",
        basePackages = "com.project.connect_more_than_two_db.repository.orderRepo",
        transactionManagerRef = "postgresqlTransactionManager"
)
public class PostgresqlEntityManagerConfig {

    EntityManagerFactoryBuilder entityManagerFactoryBuilder;

    @Autowired
    public PostgresqlEntityManagerConfig(EntityManagerFactoryBuilder entityManagerFactoryBuilder) {
        this.entityManagerFactoryBuilder = entityManagerFactoryBuilder;
    }


    @Bean
    public LocalContainerEntityManagerFactoryBean postgresEntityManagerFactoryBean(@Qualifier("postgreSqlDataSource") DataSource dataSource){
        return entityManagerFactoryBuilder
                .dataSource(dataSource)
                .packages("com.project.connect_more_than_two_db.entity.orderEntity")
                .build();
    }

    @Bean
    public PlatformTransactionManager postgresqlTransactionManager(@Qualifier("postgresEntityManagerFactoryBean") LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean){
        return new JpaTransactionManager(Objects.requireNonNull(localContainerEntityManagerFactoryBean.getObject()));
    }
}
