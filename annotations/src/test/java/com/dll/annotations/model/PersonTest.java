package com.dll.annotations.model;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.Validator;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonTest extends TestCase {

    @Autowired
    private Validator validator;

    @Test
    public void shouldValidateDuplicatedLogin() throws Exception {
        // given
        String login = "daniel";
        Person predefinedPerson = new Person(1D, "pass", 44D);

        // when
        Person newPerson = new Person(4D, "DLdsdL",38D);

        // then

    }

}