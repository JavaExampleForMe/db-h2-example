package com.example.repository;

import com.example.Entities.Program;

import javax.transaction.Transactional;
import javax.validation.constraints.NotBlank;

public interface EntityManagerRepository {

    @Transactional
    void delete(long id);

    Program save(@NotBlank Program program);

    @Transactional
    void innerSave(Program program);
}