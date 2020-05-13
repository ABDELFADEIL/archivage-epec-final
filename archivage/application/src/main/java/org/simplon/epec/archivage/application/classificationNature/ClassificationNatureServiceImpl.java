package org.simplon.epec.archivage.application.classificationNature;

import org.simplon.epec.archivage.domain.classificationNature.entity.ClassificationNature;
import org.simplon.epec.archivage.domain.classificationNature.repository.ClassificationNatureRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public ClassificationNature findByClassificationNatureCode(String classificationNatureCode) {
        return classificationNatureRepository.findByClassificationNatureCode(classificationNatureCode);
    }
}
