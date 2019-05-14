package com.example.jdbc.repository.entities;

import com.example.jdbc.repository.JdbcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ProgramRowMapper implements RowMapper<Program> {
    @Autowired
    JdbcRepository repository;
    @Autowired
    JdbcTemplate jdbcTemplate;


    @Override
    public Program mapRow(ResultSet rs, int rowNum) throws SQLException {
        Program program = new Program(rs.getInt("id"),rs.getString("name"));
    //    program.setCreationDate(rs.getDate("creationDate"));
        return program;
    }

}