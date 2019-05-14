package com.example.jdbc.repository.ms;

import com.example.jdbc.repository.JdbcConfig;
import com.example.jdbc.repository.JdbcRepository;
import com.example.jdbc.repository.entities.Program;
import lombok.extern.slf4j.Slf4j;
import org.fluttercode.datafactory.impl.DataFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

@EnableAutoConfiguration
@Slf4j
@Import({JdbcConfig.class})
public class JdbcApplication implements CommandLineRunner {
    @Autowired
    JdbcRepository jdbcRepository;

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(JdbcApplication.class, args);
    }

    @Override
    public void run(String... args) {
        DataFactory df = new DataFactory();
        for (int i = 1; i < 21; i++) {
            Program program = new Program(i, df.getName());
            jdbcRepository.insert(program);
        }
    }

}
