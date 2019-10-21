package com.switchfully.sandbox.person;

import com.switchfully.sandbox.person.domain.Person;
import com.switchfully.sandbox.person.domain.PersonRepository;
import com.switchfully.sandbox.person.exceptions.PersonNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @CachePut(value = "persons", key = "#id")
    public Person update(String id, String name) {
        var person = personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException("No person found for ID " + id));
        person.updateName(name);
        return personRepository.save(person);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Cacheable(value = "persons", key = "#id")
    public Person getById(String id) {
        return personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException("No person found for ID " + id));
    }
}
