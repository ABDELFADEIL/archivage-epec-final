package org.simplon.epec.archivage.infrastructure.ClassificationNature.repository;

import org.simplon.epec.archivage.domain.classificationNature.entity.ClassificationNature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClassificationJpaNatureRepository extends JpaRepository<ClassificationNature, Long> {


    @Query("select cnc from ClassificationNature cnc where cnc.classification_nature_code=:classificationNatureCode")
    public ClassificationNature findByClassification_nature_code(@Param("classificationNatureCode") int classificationNatureCode);
    @Query("select c from ClassificationNature c where c.classification_nature_label like %:keyword% or c.classification_nature_code like %:keyword%")
    public List<ClassificationNature> getAllClassificationNatureByKeyWord(@Param("keyword") String keyword);
}
