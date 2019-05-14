package com.example.jdbc.repository.ms;

import com.example.jdbc.repository.JdbcRepository;
import com.example.jdbc.repository.entities.Program;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/jdbc")
public class ProgramController {
    @Autowired
    JdbcRepository jdbcRepository;


    //http://localhost:8080//jdbc/program/KUKU'%20OR ''='
    @RequestMapping(value="/program/{name}", method= RequestMethod.DELETE)
    public void deleteProgram(@PathVariable String name) {
        jdbcRepository.delete(name);
    }


    // POST http://localhost:8080/jdbc/program/'%3bDELETE%20PROGRAM%20WHERE%20''='
//    {
//        "name": "The program",
//    }
    @PostMapping(path = "/program/{name}")
    public void setActivateProgram(@PathVariable String name, @RequestBody Program program) {
        jdbcRepository.activate(name);
    }
}