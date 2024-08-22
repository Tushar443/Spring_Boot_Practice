package com.project.connect_more_than_two_db.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
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
        entityManagerFactoryRef = "mysqlEntityManagerFactoryBean",
        basePackages = "com.project.connect_more_than_two_db.repository.productRepo",
        transactionManagerRef = "mySqlTransactionManager"
)
public class MySQLEntityManagerConfig {

    EntityManagerFactoryBuilder entityManagerFactoryBuilder;

    @Autowired
    public MySQLEntityManagerConfig(EntityManagerFactoryBuilder entityManagerFactoryBuilder) {
        this.entityManagerFactoryBuilder = entityManagerFactoryBuilder;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean mysqlEntityManagerFactoryBean(@Qualifier("mysqlDataSource") DataSource dataSource){
       return entityManagerFactoryBuilder
               .dataSource(dataSource)
               .packages("com.project.connect_more_than_two_db.entity.productEntity")
               .build();
    }

    @Bean
    public PlatformTransactionManager mySqlTransactionManager(@Qualifier("mysqlEntityManagerFactoryBean") LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean){
        return new JpaTransactionManager(Objects.requireNonNull(localContainerEntityManagerFactoryBean.getObject()));
    }
}
