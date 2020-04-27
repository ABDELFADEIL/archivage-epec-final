package org.simplon.epec.archivageElectronique.infrastructure.statistic.repository;

import org.simplon.epec.archivageElectronique.infrastructure.statistic.entity.Statistic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatisticJpaRepository extends JpaRepository<Statistic, String> {
}
