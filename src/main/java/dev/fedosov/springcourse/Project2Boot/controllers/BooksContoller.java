package dev.fedosov.springcourse.Project2Boot.controllers;

import dev.fedosov.springcourse.Project2Boot.models.Book;
import dev.fedosov.springcourse.Project2Boot.services.BooksService;
import dev.fedosov.springcourse.Project2Boot.services.PeopleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
    public String index(
            @RequestParam(value = "sort_by_year", required = false) boolean sortByYear,
            Model model
    ) {
        model.addAttribute("books", booksService.findAll(sortByYear));
        return "books/index";
    }

    @GetMapping(params = {"page", "books_per_page", "sort_by_year"})
    public String index(
            @RequestParam("page") int page,
            @RequestParam("books_per_page") int booksPerPage,
            @RequestParam(value = "sort_by_year", required = false) boolean sortByYear,
            Model model
    ) {
        model.addAttribute("books", booksService.findAll(page, booksPerPage, sortByYear));
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
    public String delete(@PathVariable("id") int id) {
        booksService.delete(id);
        return "redirect:/books";
    }

    @GetMapping("/search")
    public String search() {
        return "books/search";
    }

    @GetMapping(path = "/search", params = {"text"})
    public String search(@RequestParam(value = "text", required = false) String text, Model model) {
        model.addAttribute("book", booksService.findByTitle(text));
        model.addAttribute("peopleService", peopleService);
        return "books/search_results";
    }
}
