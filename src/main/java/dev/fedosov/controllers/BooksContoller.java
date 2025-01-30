package dev.fedosov.controllers;

import dev.fedosov.dao.BooksDAO;
import dev.fedosov.dao.PersonDAO;
import dev.fedosov.models.Book;
import dev.fedosov.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BooksContoller {

    private final BooksDAO booksDAO;
    private final PersonDAO personDAO;

    @Autowired
    public BooksContoller(BooksDAO booksDAO, PersonDAO personDAO) {
        this.booksDAO = booksDAO;
        this.personDAO = personDAO;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("books", booksDAO.findAll());
        return "books/index";
    }

    @GetMapping("/new")
    public String create(Model model) {
        model.addAttribute("book", new Book());
        return "books/new";
    }

    @PostMapping("/new")
    public String create(Book book) {
        booksDAO.save(book);
        return "redirect:/books";
    }

    @GetMapping("/{id}/edit")
    public String update(@PathVariable("id") int id, Model model) {
        model.addAttribute("book", booksDAO.findById(id));
        return "books/edit";
    }

    @PatchMapping("/{id}/edit")
    public String update(@PathVariable("id") int id, Book book) {
        booksDAO.update(book, id);
        return "redirect:/books";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("book", booksDAO.findById(id));
        model.addAttribute("personDao", personDAO);
        return "books/show";
    }

    @DeleteMapping("/{id}")
    public String show(@PathVariable("id") int id) {
        booksDAO.delete(id);
        return "redirect:/books";
    }
}
