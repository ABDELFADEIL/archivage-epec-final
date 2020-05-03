package org.simplon.epec.archivageElectronique.infrastructure.destructionList.repository;

import org.simplon.epec.archivageElectronique.domain.destructionList.entity.DestructionList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DestructionListJpaRepository extends JpaRepository<DestructionList, String> {
}
