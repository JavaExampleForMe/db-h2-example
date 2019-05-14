package com.example.Entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
public class Program {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String purpose;
    private LocalDate creationDate;
    private LocalDate lastActive;
    private double memoryConsumption;
    private String creator;
    private ProgramCategory category;

    public Program(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
