package com.switchfully.sandbox.person.dto;

public class UpdatePersonRequest {

    private String name;

    public String getName() {
        return name;
    }

    public UpdatePersonRequest setName(String name) {
        this.name = name;
        return this;
    }

}
