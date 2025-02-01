package dev.fedosov.services;

import dev.fedosov.models.Book;
import dev.fedosov.models.Person;
import dev.fedosov.repositories.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PeopleService {
    private final PeopleRepository peopleRepository;

    @Autowired
    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @Transactional(readOnly = true)
    public List<Person> findAll() {
        return peopleRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Person findById(int id) {
        return peopleRepository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    public Person findByFullName(String fullName) {
        return peopleRepository.findByFullName(fullName);
    }

    public void save(Person person) {
        peopleRepository.save(person);
    }

    public void update(Person person, int id) {
        person.setId(id);
        peopleRepository.save(person);
    }

    public void delete(int id) {
        peopleRepository.deleteById(id);
    }
}
