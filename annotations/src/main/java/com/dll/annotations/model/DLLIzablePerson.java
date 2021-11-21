package com.dll.annotations.model;

import com.dll.annotations.annotations.DLLIzable;
import com.dll.annotations.annotations.DLLValidation;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import java.lang.reflect.Method;
import java.util.Calendar;

import static java.util.Calendar.*;

@Getter
@Setter
public class DLLIzablePerson {
    private Double id;

    @DLLValidation
    private String name;

    private Double age;
    
    @DLLIzable()
    public DLLIzablePerson(Double id, String name, Double age)  {

        this.id = id;
        this.name = name;
        this.age = age;

        System.out.println("Person name is : " + name );

    }
}
