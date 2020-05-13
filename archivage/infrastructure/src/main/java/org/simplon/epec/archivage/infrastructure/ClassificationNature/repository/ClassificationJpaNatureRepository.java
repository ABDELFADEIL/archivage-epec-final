package org.simplon.epec.archivage.infrastructure.ClassificationNature.repository;

import org.simplon.epec.archivage.domain.classificationNature.entity.ClassificationNature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClassificationJpaNatureRepository extends JpaRepository<ClassificationNature, String> {


    @Query("select cnc from ClassificationNature cnc where cnc.classification_nature_code=:classificationNatureCode")
    public ClassificationNature findByClassification_nature_code(@Param("classificationNature") String classificationNatureCode);
}
