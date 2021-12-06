package com.dll.hibernate.service;

import com.dll.hibernate.dao.DocumentRepository;
import com.dll.hibernate.dao.WorkerRepository;
import com.dll.hibernate.model.Document;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentService {
    private final DocumentRepository documentRepository;
    private final WorkerRepository workerRepository;

    public DocumentService(DocumentRepository documentRepository, WorkerRepository workerRepository) {
        this.documentRepository = documentRepository;
        this.workerRepository = workerRepository;
    }

    public Document postDocument(Document document) {
        return documentRepository.save(document);
    }

    public List<Document> getAll() {
        return documentRepository.findAll();
    }

    public Document update(Document document, Long id) {
        Document doc = null;
        try {
            doc = documentRepository.findById(id).orElseThrow(Exception::new);
        } catch (Exception e) {
            e.printStackTrace();
        }

        doc.setDocumentType(document.getDocumentType());
        doc.setContent(document.getContent());

        return doc;
    }

    public String delete(Long id) {
        Document doc = null;
        try {
            doc = documentRepository.findById(id).orElseThrow(Exception::new);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (doc == null) {
            return "Delete method failed, document with id " + id + " not found.";
        }
        documentRepository.deleteById(id);
        return "Delete method OK, document with id " + id + " deleted.";

    }

}
