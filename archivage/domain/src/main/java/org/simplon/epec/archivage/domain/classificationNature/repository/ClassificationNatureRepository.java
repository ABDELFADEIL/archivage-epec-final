package org.simplon.epec.archivage.domain.classificationNature.repository;

import org.simplon.epec.archivage.domain.classificationNature.entity.ClassificationNature;

import java.util.List;

public interface ClassificationNatureRepository {

     ClassificationNature addClassificationNature(ClassificationNature classificationNature);
     ClassificationNature findByClassificationNatureCode(String classificationNatureCode);
     ClassificationNature findById(String id);
     ClassificationNature updateClassificationNature(ClassificationNature classificationNature);
     void removeClassificationNature(String classificationNatureID);
     ClassificationNature findByClassificationNatureId(String classificationNatureId);
     List<ClassificationNature> getAllClassificationNature();
}
