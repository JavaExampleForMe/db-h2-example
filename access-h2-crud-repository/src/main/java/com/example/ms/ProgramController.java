package com.example.ms;

import com.example.Entities.Program;
import com.example.crud.repository.ProgramCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/crud")
public class ProgramController {
    @Autowired
    ProgramCrudRepository programCrudRepository;


    //http://localhost:8080//crud/program/2
    @RequestMapping(value="/program/{id}", method= RequestMethod.DELETE)
    public void deleteProgram(@PathVariable long id) {
        programCrudRepository.deleteById(id);
    }


    // POST http://localhost:8080/jdbc/program
//    {
//        "name": "The program",
//    }
    @PostMapping(path = "/program")
    public void setActivateProgram(@RequestBody Program program) {
        programCrudRepository.save(program);
    }
}