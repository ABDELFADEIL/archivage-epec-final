package org.simplon.epec.archivage.application.classificationNature;

import org.simplon.epec.archivage.domain.classificationNature.entity.ClassificationNature;

import java.util.List;

public interface ClassificationNatureService {

     ClassificationNature addClassificationNature(ClassificationNature classificationNature);
     ClassificationNature findByClassificationNatureCode(String classificationNatureCode);
     ClassificationNature updateClassificationNature(ClassificationNature classificationNature);
     void removeClassificationNature(String classificationNatureID);
     ClassificationNature findByClassificationNatureId(String classificationNatureId);
     List<ClassificationNature> getAllClassificationNature();
}
