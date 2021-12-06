package com.dll.hibernate.dao;

import com.dll.hibernate.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document, Long> {
}
