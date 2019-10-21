package com.switchfully.orm.sandbox.person;

import com.switchfully.orm.sandbox.person.domain.Person;
import com.switchfully.orm.sandbox.person.dto.CreatePersonRequest;
import com.switchfully.orm.sandbox.person.dto.PersonResponse;
import com.switchfully.orm.sandbox.person.dto.UpdatePersonRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.switchfully.orm.sandbox.person.dto.PersonResponse.mapToResponse;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(PersonController.PERSON_RESOURCE)
public class PersonController {

    public static final String PERSON_RESOURCE = "/persons";

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping(path = "{id}", produces = APPLICATION_JSON_VALUE)
    public PersonResponse getPerson(@PathVariable String id) {
        return mapToResponse(
                personService.getById(id));
    }

    @PostMapping(produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    public PersonResponse createPerson(@RequestBody CreatePersonRequest createPersonRequest) {
        return mapToResponse(
                personService.save(
                        new Person(createPersonRequest.getName())));
    }

    @PutMapping(path = "{id}", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    public PersonResponse updatePerson(@PathVariable String id, @RequestBody UpdatePersonRequest updatePersonRequest) {
        return mapToResponse(
                personService.update(id, updatePersonRequest.getName()));
    }

}
