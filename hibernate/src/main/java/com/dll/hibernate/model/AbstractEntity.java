package com.dll.hibernate.model;

import java.io.Serializable;

public abstract class AbstractEntity implements Serializable {

    protected Long id;

    public abstract Long getId();

    // gestionado por la capa de persistencia
    protected void setId(final Long id) {
        this.id = id;
    }
}