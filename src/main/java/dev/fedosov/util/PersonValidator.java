package dev.fedosov.util;

import dev.fedosov.models.Person;
import dev.fedosov.services.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PersonValidator implements Validator {
    private final PeopleService peopleService;

    @Autowired
    public PersonValidator(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(Person.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person person = (Person) target;

        // есть человек с таким же email в бд
        if (peopleService.findByFullName(person.getFullName()) != null) {
            Person person1 = peopleService.findByFullName(person.getFullName());
            if (person1.getId() != person.getId()) {
                errors.rejectValue("fullName", "", "Человек с таким именем уже существует");
            }
        }
    }
}
