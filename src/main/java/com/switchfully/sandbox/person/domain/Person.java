package com.switchfully.sandbox.person.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Person {

    @Id
    private final String id;
    private String name;

    private Person() {
        this.id = null;
        this.name = null;
    }

    public Person(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void updateName(String name) {
        this.name = name;
    }
}
