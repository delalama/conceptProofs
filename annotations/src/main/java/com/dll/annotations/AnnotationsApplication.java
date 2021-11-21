package com.dll.annotations;

import com.dll.annotations.annotations.DLLIzable;
import com.dll.annotations.model.DLLIzablePerson;
import com.dll.annotations.model.Person;
import com.dll.annotations.model.PersonValidator;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;


@SpringBootApplication
public class AnnotationsApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(AnnotationsApplication.class, args);
    }

    @Override
    public void run(String... args) {

        Person notDll = new Person(24D, "Flori", 33D);

        Person dll = new Person(24D, "DLL", 33D);

        List<Person> personList = Arrays.asList(notDll, dll);

        personList.stream()
                .forEach(PersonValidator::validate);
        System.out.println("************");

//        DLLIzablePerson
        DLLIzablePerson dllIzablePerson = new DLLIzablePerson(1D, "FLORI", 20D);

        boolean m = dllIzablePerson.getClass().isAnnotationPresent(DLLIzable.class);

        if(m){
            dllIzablePerson.setName(dllIzablePerson.getClass().getAnnotation(DLLIzable.class).name());
            System.out.println("Person name changes to : " + dllIzablePerson.getName());
        }

    }
}
