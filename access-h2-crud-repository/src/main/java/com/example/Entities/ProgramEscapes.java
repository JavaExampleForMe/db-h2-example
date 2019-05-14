package com.example.Entities;

import lombok.Data;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
public class ProgramEscapes implements Serializable {
    @EmbeddedId
    private ProgramEscapesId programEscapesId;
    private LocalDate escapeDate;
    private String helper;
    private DeletionReason potentialDeletionReason;

}
