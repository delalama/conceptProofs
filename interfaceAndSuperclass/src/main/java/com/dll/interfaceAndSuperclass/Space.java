package com.dll.interfaceAndSuperclass;

public abstract class Space implements InterfaceSpace {
    int squatedMeters;
    private String description;

    public Space(int squatedMeters, String description) {
        this.squatedMeters = squatedMeters;
        this.description = description;
    }

    public int getSquatedMeters() {
        return squatedMeters;
    }

    public String getDescription() {
        return description;
    }
}
