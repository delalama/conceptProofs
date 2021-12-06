package com.dll.hibernate.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "DOCUMENT")
public class Document extends AbstractEntity {

    private static final long serialVersionUID = 152434241181884L;

    //attributes
    @Column(name = "created_on", columnDefinition = "DATE")
    @OneToOne
    private LocalDate createdOn;

    private DocumentType documentType;

    private String content;
    @OneToOne
    private long workerId;

    //constructor
    public Document() {
    }

    @PrePersist
    public void prePersist() {
        createdOn = LocalDate.now();
    }

    @Column(length = 30, nullable = true)
    public LocalDate getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDate createdOn) {
        this.createdOn = createdOn;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Override
    public Long getId() {
        return id;
    }

    @Column(length = 10, nullable = false)
    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    @Column(length = 255, nullable = true)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Column(length = 10, nullable = true)
    public long getWorkerId() {
        return workerId;
    }

    public void setWorkerId(long workerId) {
        this.workerId = workerId;
    }
}
