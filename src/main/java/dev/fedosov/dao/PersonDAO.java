package dev.fedosov.dao;

import dev.fedosov.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> findAll() {
        return jdbcTemplate.query("SELECT * FROM Person", new BeanPropertyRowMapper<>(Person.class));
    }

    public void save(Person person) {
        jdbcTemplate.update(
                "INSERT INTO Person(full_name, birth_year) VALUES (?, ?)",
                person.getFullName(),
                person.getBirthYear()
        );
    }

    public void update(Person person, int id) {
        jdbcTemplate.update(
                "UPDATE Person SET full_name=?, birth_year=? WHERE id=?",
                person.getFullName(),
                person.getBirthYear(),
                id
        );
    }
}
