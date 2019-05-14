package com.example.crud.repository;

import com.example.Entities.Program;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ProgramCrudRepository extends CrudRepository<Program, Long> {

    public List<Program> findByNameLike(String name);

    public List<Program> findByCreationDateGreaterThan(LocalDate date);

    @Query("SELECT a FROM Program a WHERE a.name=:name ")
    List<Program> fetchPrograms(@Param("name") String name);
}
