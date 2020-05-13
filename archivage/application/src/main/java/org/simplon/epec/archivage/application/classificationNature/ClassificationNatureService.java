package org.simplon.epec.archivage.application.classificationNature;

import org.simplon.epec.archivage.domain.classificationNature.entity.ClassificationNature;

public interface ClassificationNatureService {

     ClassificationNature addClassificationNature(ClassificationNature classificationNature);
     ClassificationNature findByClassificationNatureCode(String classificationNatureCode);
}
