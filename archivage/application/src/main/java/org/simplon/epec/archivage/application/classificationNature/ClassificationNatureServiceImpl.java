package org.simplon.epec.archivage.application.classificationNature;

import org.simplon.epec.archivage.domain.classificationNature.entity.ClassificationNature;
import org.simplon.epec.archivage.domain.classificationNature.repository.ClassificationNatureRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ClassificationNatureServiceImpl implements ClassificationNatureService {

    private final transient ClassificationNatureRepository classificationNatureRepository;

    public ClassificationNatureServiceImpl(ClassificationNatureRepository classificationNatureRepository) {
        this.classificationNatureRepository = classificationNatureRepository;
    }

    @Override
    public ClassificationNature addClassificationNature(ClassificationNature classificationNature) {
        return classificationNatureRepository.addClassificationNature(classificationNature);
    }

    @Override
    public ClassificationNature findByClassificationNatureCode(int classificationNatureCode) {
        return classificationNatureRepository.findByClassificationNatureCode(classificationNatureCode);
    }

    @Override
    public ClassificationNature updateClassificationNature(ClassificationNature classificationNature) {
        return classificationNatureRepository.updateClassificationNature(classificationNature);
    }

    @Override
    public void removeClassificationNature(Long classificationNatureID) {
        ClassificationNature c = classificationNatureRepository.findById(classificationNatureID);
        classificationNatureRepository.removeClassificationNature(c);
    }

    @Override
    public ClassificationNature findByClassificationNatureId(Long classificationNatureId) {
        return classificationNatureRepository.findByClassificationNatureId(classificationNatureId);
    }

    @Override
    public List<ClassificationNature> getAllClassificationNature() {
        return classificationNatureRepository.getAllClassificationNature();
    }

    @Override
    public Page<ClassificationNature> getAllClassificationNature(int page, int size) {
        return classificationNatureRepository.getAllClassificationNature(page, size);
    }

    @Override
    public List<ClassificationNature> getAllClassificationNatureByKeyWord(String keyword) {
        return classificationNatureRepository.getAllClassificationNatureByKeyWord(keyword);
    }
}
