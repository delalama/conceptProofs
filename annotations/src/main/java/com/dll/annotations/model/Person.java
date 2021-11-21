package com.dll.annotations.model;

import com.dll.annotations.annotations.DLLValidation;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;

@Getter
@Setter
public class Person {
    private Double id;

    @DLLValidation
    private String name;

    private Double age;

    public Person(Double id, @Valid String name, Double age) {

        this.id = id;
        this.name = name;
        this.age = age;


    }
}
