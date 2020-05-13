package org.simplon.epec.archivage.infrastructure.ClassificationNature.repository;

import org.simplon.epec.archivage.domain.classificationNature.entity.ClassificationNature;
import org.simplon.epec.archivage.domain.classificationNature.repository.ClassificationNatureRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ClassificationNatureRepositoryImpl implements ClassificationNatureRepository {

    private final transient ClassificationJpaNatureRepository classificationJpaNatureRepository;

    public ClassificationNatureRepositoryImpl(ClassificationJpaNatureRepository classificationJpaNatureRepository) {
        this.classificationJpaNatureRepository = classificationJpaNatureRepository;
    }

    @Override
    public ClassificationNature addClassificationNature(ClassificationNature classificationNature) {
        ClassificationNature cn = new ClassificationNature(classificationNature.getClassification_nature_code(), classificationNature.getDuration());
        return classificationJpaNatureRepository.save(classificationNature);
    }

    @Override
    public ClassificationNature findByClassificationNatureCode(String classificationNatureCode) {
        return classificationJpaNatureRepository.findByClassification_nature_code(classificationNatureCode);
    }

    @Override
    public ClassificationNature findById(String id) {
        return classificationJpaNatureRepository.findById(id).get();
    }
}
