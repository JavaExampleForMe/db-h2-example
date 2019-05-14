package com.example.jdbc.repository.entities;

import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class Program {
    private int id;
    private String name;
    private String purpose;
    private LocalDate creationDate;
    private boolean isActive;
    private double memoryConsumption;
    private String creator;

    public Program(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
