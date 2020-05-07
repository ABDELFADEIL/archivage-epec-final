package org.simplon.epec.archivage.domain.classificationNature.repository;

import org.simplon.epec.archivage.domain.classificationNature.entity.ClassificationNature;

public interface ClassificationNatureRepository {

    public ClassificationNature addClassificationNature(ClassificationNature classificationNature);
    public ClassificationNature findByClassificationNatureCode(String classificationNatureCode);
}
