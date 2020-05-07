package org.simplon.epec.archivage.infrastructure.history.repository;

import org.simplon.epec.archivage.domain.history.repository.HistoryRepository;
import org.springframework.stereotype.Repository;

@Repository
public class HistoryRepositoryImpl implements HistoryRepository {

    private final transient HistoryJpaRepository historyJpaRepository;

    public HistoryRepositoryImpl(HistoryJpaRepository historyJpaRepository) {
        this.historyJpaRepository = historyJpaRepository;
    }
}
