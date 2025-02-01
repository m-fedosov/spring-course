package dev.fedosov.controllers;

import dev.fedosov.models.Book;
import dev.fedosov.services.BooksService;
import dev.fedosov.services.PeopleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class BooksContoller {

    private final BooksService booksService;
    private final PeopleService peopleService;

    @Autowired
    public BooksContoller(BooksService booksDAO, PeopleService peopleService) {
        this.booksService = booksDAO;
        this.peopleService = peopleService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("books", booksService.findAll());
        return "books/index";
    }

    @GetMapping("/new")
    public String create(Model model) {
        model.addAttribute("book", new Book());
        return "books/new";
    }

    @PostMapping("/new")
    public String create(@Valid Book book, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "books/new";

        booksService.save(book);
        return "redirect:/books";
    }

    @GetMapping("/{id}/edit")
    public String update(@PathVariable("id") int id, Model model) {
        model.addAttribute("book", booksService.findById(id));
        return "books/edit";
    }

    @PatchMapping("/{id}/edit")
    public String update(@PathVariable("id") int id, @Valid Book book, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "books/edit";

        booksService.update(book, id);
        return "redirect:/books";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("book", booksService.findById(id));
        model.addAttribute("peopleService", peopleService);
        return "books/show";
    }

    @DeleteMapping("/{id}")
    public String show(@PathVariable("id") int id) {
        booksService.delete(id);
        return "redirect:/books";
    }
}
