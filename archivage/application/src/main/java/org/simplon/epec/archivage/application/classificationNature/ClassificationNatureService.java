package org.simplon.epec.archivage.application.classificationNature;

import org.simplon.epec.archivage.domain.classificationNature.entity.ClassificationNature;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ClassificationNatureService {

     ClassificationNature addClassificationNature(ClassificationNature classificationNature);
     ClassificationNature findByClassificationNatureCode(int classificationNatureCode);
     ClassificationNature updateClassificationNature(ClassificationNature classificationNature);
     void removeClassificationNature(Long classificationNatureID);
     ClassificationNature findByClassificationNatureId(Long classificationNatureId);
     List<ClassificationNature> getAllClassificationNature();
     Page<ClassificationNature> getAllClassificationNature(int page, int size);

    List<ClassificationNature> getAllClassificationNatureByKeyWord(String keyword);
}
