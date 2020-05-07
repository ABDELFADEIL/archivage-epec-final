package org.simplon.epec.archivage.infrastructure.document.repository;

import org.simplon.epec.archivage.domain.document.entity.DigitalDocument;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DigitalDocumentJpaRepository extends JpaRepository<DigitalDocument, String> {
}
