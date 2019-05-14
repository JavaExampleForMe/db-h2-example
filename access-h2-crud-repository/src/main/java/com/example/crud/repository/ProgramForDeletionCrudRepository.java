package com.example.crud.repository;


import com.example.Entities.ProgramForDeletion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramForDeletionCrudRepository extends CrudRepository<ProgramForDeletion, Long> {

}
