package com.example.ms;

import com.example.Entities.Program;
import com.example.repository.EntityManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/entitymanager")
public class ProgramController {
    @Autowired
    EntityManagerRepository entityManagerRepository;


    //http://localhost:8080/entitymanager/program/KUKU'%20OR ''='
    @RequestMapping(value="/program/{name}", method= RequestMethod.DELETE)
    public void deleteProgram(@PathVariable int id) {
        entityManagerRepository.delete(id);
    }


    // POST http://localhost:8080/entitymanager/program
//    {
//        "name": "The program",
//    }
    @PostMapping(path = "/program")
    public void setActivateProgram(@RequestBody Program program) {
        entityManagerRepository.save(program);
    }
}