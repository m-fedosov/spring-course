package dev.fedosov.dao;

import dev.fedosov.models.Book;
import dev.fedosov.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BooksDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BooksDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> findAll() {
        return jdbcTemplate.query("SELECT * FROM Book", new BeanPropertyRowMapper<>(Book.class));
    }

    public Book findById(int id) {
        return jdbcTemplate.query("SELECT * FROM Book WHERE id = ?", new BeanPropertyRowMapper<>(Book.class), id).stream().findFirst().orElse(null);
    }

    public void save(Book book) {
        jdbcTemplate.update(
                "INSERT INTO Book (title, author, year, reserved_by) values (?, ?, ?, ?)",
                book.getTitle(),
                book.getAuthor(),
                book.getYear(),
                book.getReservedBy()
        );
    }

    public void update(Book book, int id) {
        jdbcTemplate.update(
                "UPDATE Book SET title=?, author=?, year=? WHERE id=?",
                book.getTitle(),
                book.getAuthor(),
                book.getYear(),
                id
        );
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM Book WHERE id=?", id);
    }
}
