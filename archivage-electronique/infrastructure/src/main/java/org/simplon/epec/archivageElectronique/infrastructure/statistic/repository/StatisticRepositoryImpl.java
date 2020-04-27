package org.simplon.epec.archivageElectronique.infrastructure.statistic.repository;

import org.simplon.epec.archivageElectronique.domain.statistic.repository.StatisticRepository;
import org.springframework.stereotype.Repository;

@Repository
public class StatisticRepositoryImpl implements StatisticRepository {

    private final transient StatisticJpaRepository statisticJpaRepository;

    public StatisticRepositoryImpl(StatisticJpaRepository statisticJpaRepository) {
        this.statisticJpaRepository = statisticJpaRepository;
    }
}
