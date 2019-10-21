package com.switchfully.orm.sandbox.person.exceptions;

public class PersonNotFoundException extends RuntimeException {

    public PersonNotFoundException(String personId) {
        super("Person for ID " + personId + " was not found");
    }

}
