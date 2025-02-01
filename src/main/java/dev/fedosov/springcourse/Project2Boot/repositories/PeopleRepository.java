package dev.fedosov.springcourse.Project2Boot.repositories;

import dev.fedosov.springcourse.Project2Boot.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeopleRepository extends JpaRepository<Person, Integer> {
    Person findByFullName(String fullName);
}
