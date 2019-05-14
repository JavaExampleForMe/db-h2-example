package com.example.crud.repository;

import com.example.Entities.ProgramEscapes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramEscapesCrudRepository extends CrudRepository<ProgramEscapes, Long> {

}
