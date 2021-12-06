package com.dll.hibernate;

import com.dll.hibernate.dao.WorkerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;


@SpringBootApplication
@PropertySource("classpath:db/h2/application-h2.properties")
@Configuration
public class HibernateApplication {

    @Autowired
    private Environment environment;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    WorkerRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(HibernateApplication.class, args);
    }

}
