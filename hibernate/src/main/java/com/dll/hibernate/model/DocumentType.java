package com.dll.hibernate.model;

public enum DocumentType {
    PDF("PDF"),
    TXT("TXT"),
    ODT("ODT");

    private final String txt;

    public String getTxt() {
        return txt;
    }

    DocumentType(String txt) {
        this.txt = txt;
    }
}
