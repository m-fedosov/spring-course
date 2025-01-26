package dev.fedosov.controllers;

import dev.fedosov.dao.PersonDAO;
import dev.fedosov.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/people")
public class PeopleController {

    private final PersonDAO personDAO;

    @Autowired
    public PeopleController(PersonDAO personDAO) {
        this.personDAO = personDAO;
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
    public String create(Person person) {
        personDAO.save(person);
        return "redirect:/people";
    }

    @PatchMapping("/{id}/edit")
    public String update(@PathVariable("id") int id, Person person) {
        personDAO.update(person, id);
        return "redirect:/people";
    }
}
