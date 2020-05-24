package org.simplon.epec.archivage.domain.classificationNature.repository;

import org.simplon.epec.archivage.domain.classificationNature.entity.ClassificationNature;

import java.util.List;

public interface ClassificationNatureRepository {

     ClassificationNature addClassificationNature(ClassificationNature classificationNature);
     ClassificationNature findByClassificationNatureCode(String classificationNatureCode);
     ClassificationNature findById(Long id);
     ClassificationNature updateClassificationNature(ClassificationNature classificationNature);
     void removeClassificationNature(Long classificationNatureID);
     ClassificationNature findByClassificationNatureId(Long classificationNatureId);
     List<ClassificationNature> getAllClassificationNature();
}
