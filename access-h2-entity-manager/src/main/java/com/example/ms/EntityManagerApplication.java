package com.example.ms;

import com.example.Entities.Program;
import com.example.EntityManagerConfig;
import com.example.repository.EntityManagerRepository;
import lombok.extern.slf4j.Slf4j;
import org.fluttercode.datafactory.impl.DataFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

import java.time.LocalDate;

@EnableAutoConfiguration
@Slf4j
@Import({EntityManagerConfig.class})
public class EntityManagerApplication implements CommandLineRunner {
    @Autowired
    EntityManagerRepository entityManagerRepository;

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(EntityManagerApplication.class, args);
    }

    @Override
    public void run(String... args) {
        DataFactory df = new DataFactory();
        for (int i = 1; i < 21; i++) {
            Program program = new Program();
            program.setName(df.getName());
            program.setLastActive(LocalDate.now());
            entityManagerRepository.save(program);
        }
    }

}
