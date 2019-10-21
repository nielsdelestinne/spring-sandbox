package com.switchfully.orm.sandbox.person.dto;

import com.switchfully.orm.sandbox.person.domain.Person;

public class PersonResponse {

    private String id;
    private String name;

    public static PersonResponse mapToResponse(Person person) {
        return new PersonResponse()
                .setId(person.getId())
                .setName(person.getName());
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public PersonResponse setId(String id) {
        this.id = id;
        return this;
    }

    public PersonResponse setName(String name) {
        this.name = name;
        return this;
    }
}
