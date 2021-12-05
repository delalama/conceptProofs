package com.dll.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="COMPANY")
public class Company extends AbstractEntity {

    private static final long serialVersionUID = 1460669361717988469L;

    private String name;
    private String description;

    public Company() {
    }

    public Company(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Override
    public Long getId() {
        return id;
    }

    @Column(length=45, nullable=false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(length=255, nullable=true)
    public String getDescription() {
        return description;
    }

    public void setDescription(String notes) {
        this.description = notes;
    }
}
