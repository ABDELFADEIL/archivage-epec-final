package org.simplon.epec.archivage.domain.classificationNature.repository;

import org.simplon.epec.archivage.domain.classificationNature.entity.ClassificationNature;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ClassificationNatureRepository {

     ClassificationNature addClassificationNature(ClassificationNature classificationNature);
     ClassificationNature findByClassificationNatureCode(int classificationNatureCode);
     ClassificationNature findById(Long id);
     ClassificationNature updateClassificationNature(ClassificationNature classificationNature);
     void removeClassificationNature(ClassificationNature classificationNature);
     ClassificationNature findByClassificationNatureId(Long classificationNatureId);
     List<ClassificationNature> getAllClassificationNature();
     Page<ClassificationNature> getAllClassificationNature(int page, int size);
    List<ClassificationNature> getAllClassificationNatureByKeyWord(String keyword);
}
