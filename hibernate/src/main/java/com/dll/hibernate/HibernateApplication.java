package com.dll.hibernate;

import com.dll.hibernate.dao.WorkerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;


@SpringBootApplication
@PropertySource("classpath:db/h2/application-h2.properties")
public class HibernateApplication implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    WorkerRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(HibernateApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//    Worker w = new Worker();
//    w.setName("Manolo");
//    w.setSurname("lolo");
//    w.setWorkerType(WorkerType.DESARROLLADOR);
//
//    repository.save(w);
//
//    logger.info(String.valueOf(repository.findAll()));

    }


}
