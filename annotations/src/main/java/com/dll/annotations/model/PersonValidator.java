package com.dll.annotations.model;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class PersonValidator {

    public static void validate(@Valid Person person) {
        System.out.println("Validating " + person.getName());

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        javax.validation.Validator validator = factory.getValidator();
        Set<ConstraintViolation<Person>> violations = validator.validate(person);

        if (violations.isEmpty() ) {
            System.out.println("Person :" + person.getName() + " is valid.");
        }

        for (ConstraintViolation<Person> violation : violations) {
            System.out.println(violation.getMessage());
        }
    }
}
