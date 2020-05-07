package org.simplon.epec.archivage.infrastructure.statistic.repository;

import org.simplon.epec.archivage.domain.statistic.entity.Statistic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatisticJpaRepository extends JpaRepository<Statistic, String> {
}
