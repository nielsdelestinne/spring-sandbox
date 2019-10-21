package com.switchfully.sandbox.person.dto;

public class CreatePersonRequest {

   private String name;

    public String getName() {
        return name;
    }

    public CreatePersonRequest setName(String name) {
        this.name = name;
        return this;
    }
}
