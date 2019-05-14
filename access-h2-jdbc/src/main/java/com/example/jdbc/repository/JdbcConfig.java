package com.example.jdbc.repository;

import com.example.jdbc.repository.ms.ProgramController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JdbcConfig {
    @Bean
    JdbcRepository getProgramJdbcRepository(){
        return new JdbcRepository();
    }

    @Bean
    ProgramController getProgramController(){
        return new ProgramController();
    }
}
