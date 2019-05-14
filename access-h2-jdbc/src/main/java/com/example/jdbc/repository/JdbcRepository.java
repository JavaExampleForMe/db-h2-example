package com.example.jdbc.repository;

import com.example.jdbc.repository.entities.Program;
import com.example.jdbc.repository.entities.ProgramRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Types;
import java.time.LocalDateTime;
import java.util.List;

public class JdbcRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;


    public List<Program> findAll() {
        return jdbcTemplate.query("select * from program", new ProgramRowMapper());
    }

    public Program findById(long id) {
        return jdbcTemplate.queryForObject("select * from program where id=?", new Object[] {
                        id
                },
                new BeanPropertyRowMapper<Program>(Program.class));
    }

    public int insert(Program program) {
        return jdbcTemplate.update("insert into program (ID, NAME, CREATION_DATE, MEMORY_CONSUMPTION) " + "values(?,  ?, ?, ?)",
                new Object[] {
                        program.getId(), program.getName(), LocalDateTime.now(), 30
                });
    }

    public int activate(String name) {
        int rows = jdbcTemplate.update("UPDATE program SET IS_ACTIVE=1 WHERE NAME = '" + name + "'");
        return rows;
    }


    public int delete(String name) {
        Object[] params = {name};
        int[] types = {Types.VARCHAR};

        int rows = jdbcTemplate.update("DELETE FROM program WHERE NAME = ?", params, types);
        return rows;
    }

}
