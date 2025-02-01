package dev.fedosov.util;

import dev.fedosov.dao.PersonDAO;
import dev.fedosov.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PersonValidator implements Validator {
    private final PersonDAO personDAO;

    @Autowired
    public PersonValidator(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(Person.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person person = (Person) target;

        // есть человек с таким же email в бд
        if (personDAO.findByFullName(person.getFullName()).isPresent()) {
            Person person1 = personDAO.findByFullName(person.getFullName()).get();
            if (person1.getId() != person.getId()) {
                errors.rejectValue("fullName", "", "Человек с таким именем уже существует");
            }
        }
    }
}
