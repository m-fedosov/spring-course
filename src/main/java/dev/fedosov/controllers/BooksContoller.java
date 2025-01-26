package dev.fedosov.controllers;

import dev.fedosov.dao.BooksDAO;
import dev.fedosov.models.Book;
import dev.fedosov.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/books")
public class BooksContoller {

    private final BooksDAO booksDAO;

    @Autowired
    public BooksContoller(BooksDAO booksDAO) {
        this.booksDAO = booksDAO;
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
}
