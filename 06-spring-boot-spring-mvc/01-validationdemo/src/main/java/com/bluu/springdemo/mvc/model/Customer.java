package com.bluu.springdemo.mvc.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
public class Customer {
    @NotNull(message="required")
    @Size(min=1, message="required")
    private String firstName = "";
    @NotNull(message="required")
    @Size(min=1, message="required")
    private String lastName = "";


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
