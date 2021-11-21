package com.dll.APIStream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.lang.System.out;

@SpringBootApplication
public class ApiStreamApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ApiStreamApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<Person> persons = createPersonsList();

        printPersonWithNameDLL(persons);

        printPersonsAgeUpTo10(persons);

        sumAges(persons);

        printOnly2(persons);

        sort(persons);


    }

    private void sort(List<Person> persons) {
        out.println("\nSort list");
        persons.stream()
                .sorted(Comparator.comparing(Person::getName))
                .forEach(Person::Print);

    }

    private void printOnly2(List<Person> persons) {
        out.println("\nPrint only two of them");
        persons.stream()
                .limit(2)
                .forEach(Person::Print);
    }

    private void sumAges(List<Person> persons) {
        out.println("\nSUM OF PERSONS AGES");
        out.println(persons.stream()
                .map(p -> p.getAge())
                .reduce(0, Integer::sum)
        );
    }

    private void printPersonsAgeUpTo10(List<Person> persons) {
        out.println("\nAGES UP TO 10");
        persons.stream()
                .filter(p -> p.getAge() > 10)
                .forEach(Person::Print);
    }

    private List<Person> createPersonsList() {
        Person p1 = new Person("JesusDLL", 20);
        Person p2 = new Person("Flori", 30);
        Person p3 = new Person("Zupi", 8);

        List<Person> persons = Arrays.asList(p1, p2, p3);
        return persons;
    }

    private void printPersonWithNameDLL(List<Person> persons) {
        out.println("\nPerson with name DLL");

        persons.stream()
                .filter(p -> p.getName().contains("DLL"))
                .forEach(Person::Print);
    }
}
