package com.dll.hibernate.model;

public enum DocumentType {
    PDF("PDF"),
    TXT("TXT"),
    ODT("ODT");

    private String txt;

    public String getTxt() {
        return txt;
    }

    DocumentType(String txt) {
        this.txt = txt;
    }
}
