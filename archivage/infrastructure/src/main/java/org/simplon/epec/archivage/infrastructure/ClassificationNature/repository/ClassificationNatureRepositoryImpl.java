package org.simplon.epec.archivage.infrastructure.ClassificationNature.repository;

import org.simplon.epec.archivage.domain.classificationNature.entity.ClassificationNature;
import org.simplon.epec.archivage.domain.classificationNature.repository.ClassificationNatureRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

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
    public ClassificationNature findById(Long id) {
        return classificationJpaNatureRepository.findById(id).get();
    }

    @Override
    public ClassificationNature updateClassificationNature(ClassificationNature classificationNature) {
        return classificationJpaNatureRepository.save(classificationNature);
    }

    @Override
    public void removeClassificationNature(Long classificationNatureID) {
          classificationJpaNatureRepository.deleteById(classificationNatureID);
    }

    @Override
    public ClassificationNature findByClassificationNatureId(Long classificationNatureId) {
        return classificationJpaNatureRepository.findById(classificationNatureId).get();
    }

    @Override
    public List<ClassificationNature> getAllClassificationNature() {
        return  classificationJpaNatureRepository.findAll();
    }
}
