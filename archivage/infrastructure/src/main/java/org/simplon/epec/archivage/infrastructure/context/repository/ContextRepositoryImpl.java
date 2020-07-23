package org.simplon.epec.archivage.infrastructure.context.repository;

import org.simplon.epec.archivage.domain.document.entity.Context;
import org.simplon.epec.archivage.domain.document.repository.ContextRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ContextRepositoryImpl implements ContextRepository {

    private final transient ContextJpaRepository contextJpaRepository;

    public ContextRepositoryImpl(ContextJpaRepository contextJpaRepository) {
        this.contextJpaRepository = contextJpaRepository;
    }

    @Override
    public Context createContext(Context context) {
        return contextJpaRepository.save(context);
    }
}
