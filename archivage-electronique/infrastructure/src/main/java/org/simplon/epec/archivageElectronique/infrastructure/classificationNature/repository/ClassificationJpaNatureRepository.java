package org.simplon.epec.archivageElectronique.infrastructure.classificationNature.repository;

import org.simplon.epec.archivageElectronique.domain.classificationNature.entity.ClassificationNature;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassificationJpaNatureRepository extends JpaRepository<ClassificationNature, String> {


}
