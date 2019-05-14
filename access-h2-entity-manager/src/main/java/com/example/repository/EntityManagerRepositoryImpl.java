package com.example.repository;

import com.example.Entities.*;
import org.fluttercode.datafactory.impl.DataFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

@Component
public class EntityManagerRepositoryImpl implements EntityManagerRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    EntityManagerRepository EntityManagerRepositoryImpl;

    @Override
    @Transactional
    public void delete(long id) {
        Program persistProgram = entityManager.find(Program.class, id);
        entityManager.remove(persistProgram);
    }

    @Override
    @Transactional
    public Program save(@NotBlank Program program) {
        @NotBlank Program persistProgram = entityManager.merge(program);
        //innerSave(persistProgram);
        EntityManagerRepositoryImpl.innerSave(persistProgram);
        return persistProgram;
    }

    @Override
    @Transactional(value = Transactional.TxType.REQUIRES_NEW)
    public void innerSave(Program program) {
        DataFactory df = new DataFactory();
        ProgramForDeletion programForDeletion = getProgramForDeletion(df, program);
        ProgramForDeletion persistProgramForDeletion = entityManager.merge(programForDeletion);
        ArrayList<ProgramEscapes> programEscapes = getProgramEscapes(df, persistProgramForDeletion);
        for (ProgramEscapes programEscape : programEscapes) {
            entityManager.merge(programEscape);
        }
    }
    public ProgramForDeletion getProgramForDeletion(DataFactory df, Program program) {
        ProgramForDeletion programForDeletion = new ProgramForDeletion();
        programForDeletion.setProgramId(program.getId());
        DeletionReason deletionReason = df.getItem(DeletionReason.values(), 80, DeletionReason.values()[0]);
        programForDeletion.setPotentialDeletionReason(deletionReason);
        Date plannedExecutionDate = df.getDateBetween(DateUtils.asDate(program.getLastActive()), DateUtils.asDate(LocalDate.now()));
        programForDeletion.setPlannedExecutionDate(DateUtils.asLocalDate(plannedExecutionDate));
        return programForDeletion;
    }

    public ArrayList<ProgramEscapes> getProgramEscapes(DataFactory df, ProgramForDeletion programForDeletion) {
        // 60% are marked for escapes
        Integer[] programEscapesValues = {0,1, 2, 3};
        Integer programEscatesChances = df.getItem(programEscapesValues);
        ArrayList<ProgramEscapes> programEscapesArrayList = new ArrayList<>();
        for (int j = 0; j < programEscatesChances; j++) {
            ProgramEscapes programEscapes = new ProgramEscapes();
            programEscapes.setProgramEscapesId(new ProgramEscapesId(programForDeletion.getProgramId(),j));
            programEscapes.setHelper(df.getFirstName() + " "+ df.getLastName());
            DeletionReason deletionReason2 = df.getItem(DeletionReason.values(), 80, DeletionReason.values()[0]);
            programEscapes.setPotentialDeletionReason(deletionReason2);
            Date escapeDate = df.getDateBetween(DateUtils.asDate(programForDeletion.getPlannedExecutionDate()), DateUtils.asDate(LocalDate.now()));
            programEscapes.setEscapeDate(DateUtils.asLocalDate(escapeDate));
            programEscapesArrayList.add(programEscapes);
        }
        return programEscapesArrayList;
    }
}
