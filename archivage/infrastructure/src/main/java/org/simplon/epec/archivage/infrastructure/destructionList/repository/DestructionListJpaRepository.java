package org.simplon.epec.archivage.infrastructure.destructionList.repository;

import org.simplon.epec.archivage.domain.destructionList.entity.DestructionList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DestructionListJpaRepository extends JpaRepository<DestructionList, Long> {
}
