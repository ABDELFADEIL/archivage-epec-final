package org.simplon.epec.archivage.infrastructure.ClassificationNature.repository;

import org.simplon.epec.archivage.domain.classificationNature.entity.ClassificationNature;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassificationJpaNatureRepository extends JpaRepository<ClassificationNature, String> {


}
