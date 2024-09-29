package com.bluu.springdemo.mvc.model;

import jakarta.validation.constraints.*;

public class Customer {
    @NotNull(message = "required field")
    @Size(min = 1, message = "required field")
    private String firstName;
    @NotNull(message = "required field")
    @Size(min = 1, message = "required field")
    private String lastName;

    @Min(value = 1, message = "Enter a number between 1-100")
    @Max(value = 100, message = "Enter a number between 1-100")
    private Integer age;

    @Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "Postal code invalid")
    private String postalCode;

    public @Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "Postal code invalid") String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(@Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "Postal code invalid") String postalCode) {
        this.postalCode = postalCode;
    }

    @Min(value = 1, message = "Enter a number between 1-100")
    @Max(value = 100, message = "Enter a number between 1-100")

    public Integer getAge() {
        return age;
    }

    public void setAge(@Min(value = 1, message = "Enter a number between 1-100") @Max(value = 100, message = "Enter a number between 1-100") Integer age) {
        this.age = age;
    }

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
