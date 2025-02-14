package dev.fedosov.springcourse.Project2Boot.services;

import dev.fedosov.springcourse.Project2Boot.models.Person;
import dev.fedosov.springcourse.Project2Boot.repositories.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @PreAuthorize("hasAuthority('write')")
    public void save(Person person) {
        peopleRepository.save(person);
    }

    @PreAuthorize("hasAuthority('write')")
    public void update(Person person, int id) {
        person.setId(id);
        peopleRepository.save(person);
    }

    @PreAuthorize("hasAuthority('write')")
    public void delete(int id) {
        peopleRepository.deleteById(id);
    }
}
