package com.example.ms;

import com.example.CrudConfig;
import com.example.Entities.Program;
import lombok.extern.slf4j.Slf4j;
import org.fluttercode.datafactory.impl.DataFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import com.example.crud.repository.ProgramCrudRepository;

@EnableAutoConfiguration
@Slf4j
@Import({CrudConfig.class})
public class CrudApplication implements CommandLineRunner {
    @Autowired
    private ProgramCrudRepository programCrudRepository;

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(CrudApplication.class, args);
    }

    @Override
    public void run(String... args) {
        DataFactory df = new DataFactory();
        for (int i = 1; i < 21; i++) {
            Program program = new Program(i, df.getName());
            programCrudRepository.save(program);
        }
    }

}
