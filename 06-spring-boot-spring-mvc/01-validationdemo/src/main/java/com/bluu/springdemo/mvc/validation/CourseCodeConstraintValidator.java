package com.bluu.springdemo.mvc.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

    private String coursePrefix;

    @Override
    public void initialize(CourseCode courseCode) {
        coursePrefix = courseCode.value();
    }

    @Override
    public boolean isValid(String givenCode, ConstraintValidatorContext constraintValidatorContext) {
        boolean result;
        if(givenCode != null) result = givenCode.startsWith(coursePrefix);
        else result = false;

        return result;
    }
}
