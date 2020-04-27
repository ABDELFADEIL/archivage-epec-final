package org.simplon.epec.archivageElectronique.domain.classificationNature.repository;

import org.simplon.epec.archivageElectronique.domain.classificationNature.entity.ClassificationNature;

public interface ClassificationNatureRepository {

    public ClassificationNature addClassificationNature(ClassificationNature classificationNature);
    public ClassificationNature findByClassificationNatureCode(String classificationNatureCode);
}
