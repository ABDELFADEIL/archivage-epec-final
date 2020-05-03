package org.simplon.epec.archivageElectronique.infrastructure.account.repository;

import org.simplon.epec.archivageElectronique.domain.account.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountJpaRepository extends JpaRepository<Account, String> {


}
