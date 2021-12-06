package com.dll.hibernate.controller;

import com.dll.hibernate.model.Document;
import com.dll.hibernate.service.DocumentService;
import com.dll.hibernate.service.DocumentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping(value = "/document")
public class DocumentController {

    DocumentService documentService;

    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @GetMapping
    public ResponseEntity<List<Document>> getAllDocuments() {

        List<Document> all = documentService.getAll();

        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Document> postDocument(@RequestBody Document Document) {

        Document postedDocument = documentService.postDocument(Document);

        return new ResponseEntity<>(postedDocument, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    ResponseEntity<?> updateDocument(@RequestBody Document Document, @PathVariable Long id) {

        Document updatedDocument = documentService.update(Document, id);

        return new ResponseEntity<>(updatedDocument, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteDocument(@PathVariable Long id) {

        String message = documentService.delete(id);

        return new ResponseEntity<>(message, HttpStatus.OK);

    }
}
