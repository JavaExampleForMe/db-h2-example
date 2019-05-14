package com.example;

import com.example.repository.EntityManagerRepository;
import com.example.repository.EntityManagerRepositoryImpl;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan("com.example.Entities")
@EnableJpaRepositories(basePackages = "com.example.repository")
public class EntityManagerConfig {
    @Bean
    EntityManagerRepository getProgramJdbcRepository(){
        return new EntityManagerRepositoryImpl();
    }
}
