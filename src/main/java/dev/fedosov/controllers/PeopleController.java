package dev.fedosov.controllers;

import dev.fedosov.models.Person;
import dev.fedosov.services.BooksService;
import dev.fedosov.services.PeopleService;
import dev.fedosov.util.PersonValidator;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/people")
public class PeopleController {

    private final PeopleService peopleService;
    private final BooksService booksService;
    private final PersonValidator personValidator;

    @Autowired
    public PeopleController(PeopleService peopleService, BooksService booksService, PersonValidator personValidator) {
        this.peopleService = peopleService;
        this.booksService = booksService;
        this.personValidator = personValidator;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("people", peopleService.findAll());
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

        peopleService.save(person);
        return "redirect:/people";
    }

    @GetMapping("/{id}/edit")
    public String update(@PathVariable("id") int id, Model model) {
        Person person = peopleService.findById(id);
        model.addAttribute("person", person);
        return "people/edit";
    }

    @PatchMapping("/{id}/edit")
    public String update(@PathVariable("id") int id, @Valid Person person, BindingResult bindingResult) {
        personValidator.validate(person, bindingResult);
        if (bindingResult.hasErrors())
            return "people/edit";

        peopleService.update(person, id);
        return "redirect:/people";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        Person person = peopleService.findById(id);
        model.addAttribute("person", person);
        model.addAttribute("booksService", booksService);
        return "people/show";
    }

    @DeleteMapping("/{id}")
    public String show(@PathVariable("id") int id) {
        peopleService.delete(id);
        return "redirect:/people";
    }
}
