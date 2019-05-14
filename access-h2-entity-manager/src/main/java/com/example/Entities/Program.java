package com.example.Entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@Entity
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
}
