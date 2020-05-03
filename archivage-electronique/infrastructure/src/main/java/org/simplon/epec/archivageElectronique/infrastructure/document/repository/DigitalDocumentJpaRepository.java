package org.simplon.epec.archivageElectronique.infrastructure.document.repository;

import org.simplon.epec.archivageElectronique.domain.document.entity.DigitalDocument;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DigitalDocumentJpaRepository extends JpaRepository<DigitalDocument, String> {
}
