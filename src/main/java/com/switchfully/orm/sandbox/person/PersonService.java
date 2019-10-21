package com.switchfully.orm.sandbox.person;

import com.switchfully.orm.sandbox.person.domain.Person;
import com.switchfully.orm.sandbox.person.domain.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Person save(Person personToSave) {
        return personRepository.save(personToSave);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public Optional<Person> getById(String id) {
        return personRepository.findById(id);
    }

}
