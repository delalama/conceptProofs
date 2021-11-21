package com.dll.APIStream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class ApiStreamApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ApiStreamApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Person p1 = new Person("JesusDLL",20);
		Person p2 = new Person("Flori",20);

		List<Person> persons = Arrays.asList(p1, p2);

		persons.stream()
				.filter(p -> p.getName().contains("DLL"))
				.collect(Collectors.toList())
				.forEach( p -> p.Print());

		System.out.println("AGES UP TO 10");
		persons.stream()
				.filter(p -> p.getAge() > 10)
				.forEach(p -> p.Print());

	}
}
