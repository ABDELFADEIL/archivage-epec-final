package org.simplon.epec.archivageElectronique.infrastructure.classificationNature.repository;

import org.simplon.epec.archivageElectronique.domain.classificationNature.entity.ClassificationNature;
import org.simplon.epec.archivageElectronique.domain.classificationNature.repository.ClassificationNatureRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ClassificationNatureRepositoryImpl implements ClassificationNatureRepository {

    private final transient ClassificationJpaNatureRepository classificationJpaNatureRepository;

    public ClassificationNatureRepositoryImpl(ClassificationJpaNatureRepository classificationJpaNatureRepository) {
        this.classificationJpaNatureRepository = classificationJpaNatureRepository;
    }

    @Override
    public ClassificationNature addClassificationNature(ClassificationNature classificationNature) {
        return null;
    }

    @Override
    public ClassificationNature findByClassificationNatureCode(String classificationNatureCode) {
        return null;
    }
}
