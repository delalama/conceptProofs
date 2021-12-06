package com.dll.hibernate.dao.converter;

import com.dll.hibernate.model.DocumentType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class DocumentTypeConverter implements AttributeConverter<DocumentType, String> {

    @Override
    public String convertToDatabaseColumn(DocumentType documentType) {
        if (documentType == null) {
            return null;
        }
        return documentType.getTxt();
    }

    @Override
    public DocumentType convertToEntityAttribute(String code) {
        if (code == null) {
            return null;
        }

        return Stream.of(DocumentType.values())
                .filter(c -> c.getTxt().equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
