package com.dll.APIStream;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Person {
    private String name;
    private Integer age;

    public void print() {
        System.out.println("** NAME: " + name + " | AGE: " + age);
    }
}
