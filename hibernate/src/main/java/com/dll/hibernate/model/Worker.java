package com.dll.hibernate.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "WORKER")
public class Worker extends AbstractEntity {

    private static final long serialVersionUID = 6430623703467941209L;

    private WorkerType workerType = WorkerType.DESARROLLADOR;
    private String name;
    private String surname;
    private Company company;

    @OneToMany(orphanRemoval = true)
    List<Document> documents;

    public Worker() {
    }

    public Worker(WorkerType workerType, String name, String surname, Company company) {
        this.workerType = workerType;
        this.name = name;
        this.surname = surname;
        this.company = company;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Override
    public Long getId() {
        return id;
    }

    @Column(length = 20, nullable = false)
    @Enumerated(EnumType.STRING)
    public WorkerType getWorkerType() {
        return workerType;
    }

    public void setWorkerType(WorkerType workerType) {
        this.workerType = workerType;
    }

    @Column(length = 255, nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(length = 255, nullable = false)
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @ManyToOne(targetEntity = Company.class)
    @JoinColumn(name = "COMPANY_id")
    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
