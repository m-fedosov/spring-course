package dev.fedosov.controllers;

import dev.fedosov.dao.BooksDAO;
import dev.fedosov.dao.PersonDAO;
import dev.fedosov.models.Book;
import dev.fedosov.models.Person;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/people")
public class PeopleController {

    private final PersonDAO personDAO;
    private final BooksDAO booksDAO;

    @Autowired
    public PeopleController(PersonDAO personDAO, BooksDAO booksDAO) {
        this.personDAO = personDAO;
        this.booksDAO = booksDAO;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("people", personDAO.findAll());
        return "people/index";
    }

    @GetMapping("/new")
    public String create(Model model) {
        model.addAttribute("person", new Person());
        return "people/new";
    }

    @PostMapping("/new")
    public String create(@Valid Person person, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "people/new";

        personDAO.save(person);
        return "redirect:/people";
    }

    @GetMapping("/{id}/edit")
    public String update(@PathVariable("id") int id, Model model) {
        Person person = personDAO.findById(id);
        model.addAttribute("person", person);
        return "people/edit";
    }

    @PatchMapping("/{id}/edit")
    public String update(@PathVariable("id") int id, @Valid Person person, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "people/edit";

        personDAO.update(person, id);
        return "redirect:/people";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        Person person = personDAO.findById(id);
        model.addAttribute("person", person);
        model.addAttribute("booksDao", booksDAO);
        return "people/show";
    }

    @DeleteMapping("/{id}")
    public String show(@PathVariable("id") int id) {
        personDAO.delete(id);
        return "redirect:/people";
    }
}
