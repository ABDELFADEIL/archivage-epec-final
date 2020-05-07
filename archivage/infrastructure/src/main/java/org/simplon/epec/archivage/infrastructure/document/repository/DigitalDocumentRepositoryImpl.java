package org.simplon.epec.archivage.infrastructure.document.repository;


import org.simplon.epec.archivage.domain.document.repository.DigitalDocumentRepository;
import org.springframework.stereotype.Repository;

@Repository
public class DigitalDocumentRepositoryImpl implements DigitalDocumentRepository {

    private final transient DigitalDocumentJpaRepository digitalDocumentJpaRepository;

    public DigitalDocumentRepositoryImpl(DigitalDocumentJpaRepository digitalDocumentJpaRepository) {
        this.digitalDocumentJpaRepository = digitalDocumentJpaRepository;
    }
}
