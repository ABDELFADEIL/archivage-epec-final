package org.simplon.epec.archivage.application.document;

import org.simplon.epec.archivage.domain.document.entity.Context;
import org.simplon.epec.archivage.domain.document.repository.ContextRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ContextServiceImpl implements ContextService {

    private final transient ContextRepository contextRepository;

    public ContextServiceImpl(ContextRepository contextRepository) {
        this.contextRepository = contextRepository;
    }

    @Override
    public Context createContext(Context context) {
        return contextRepository.createContext(context);
    }

    @Override
    public Context saveContext(Context context) {
        return contextRepository.saveContext(context);
    }
}
