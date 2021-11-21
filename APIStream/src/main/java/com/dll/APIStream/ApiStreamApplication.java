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

        filters(persons);

        reduce(persons);

        limit(persons);

        sort(persons);

        conditionalForEach(persons);

        count(persons);

    }

    private void count(List<Person> persons) {
        out.println("\n Count persons up to age 10 ");

        out.println(persons.stream()
                .filter(p -> p.getAge() > 10)
                .count());

    }

    private void conditionalForEach(List<Person> persons) {
        out.println("\n Conditional print");

        persons.stream()
                .forEach(p -> {
                    if (p.getAge() > 10) {
                        p.print();
                    } else {
                        out.println("alternate print -> " + p.getName() + " - " + p.getAge());
                    }
                });
    }

    private void sort(List<Person> persons) {
        out.println("\nSort list");
        persons.stream()
                .sorted(Comparator.comparing(Person::getName))
                .forEach(Person::print);

        out.println("\nSort list min age");
        persons.stream()
                .sorted(Comparator.comparing(Person::getAge))
                .findFirst()
                .get()
                .print();

        out.println("\nSort list min alternate");
        persons.stream()
                .min(Comparator.comparing(Person::getAge))
                .get()
                .print();
    }

    private void limit(List<Person> persons) {
        out.println("\nPrint only two of them");
        persons.stream()
                .limit(2)
                .forEach(Person::print);
    }

    private void reduce(List<Person> persons) {
        out.println("\nSUM OF PERSONS AGES");
        out.println(persons.stream()
                .map(p -> p.getAge())
                .reduce(0, Integer::sum)
        );
    }

    private void filters(List<Person> persons) {
        out.println("\nPerson with name DLL");

        persons.stream()
                .filter(p -> p.getName().contains("DLL"))
                .forEach(Person::print);

        out.println("\nAGES UP TO 10");
        persons.stream()
                .filter(p -> p.getAge() > 10)
                .forEach(Person::print);

        out.println("\nNames of persons up to 10");
        persons.stream()
                .map(p -> p.getAge() > 10 ? p.getName() : null)
                .forEach(out::println);
    }

    private List<Person> createPersonsList() {
        Person p1 = new Person("JesusDLL", 20);
        Person p2 = new Person("Flori", 30);
        Person p3 = new Person("Zupi", 8);

        List<Person> persons = Arrays.asList(p1, p2, p3);
        return persons;
    }


}
