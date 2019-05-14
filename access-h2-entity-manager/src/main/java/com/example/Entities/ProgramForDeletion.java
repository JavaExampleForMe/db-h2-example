package com.example.Entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@Entity
public class ProgramForDeletion {
    @Id
    private int programId;
    private DeletionReason potentialDeletionReason;
    private LocalDate plannedExecutionDate;

}
