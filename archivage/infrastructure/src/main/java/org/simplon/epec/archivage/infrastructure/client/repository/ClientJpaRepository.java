package org.simplon.epec.archivage.infrastructure.client.repository;

import org.simplon.epec.archivage.domain.client.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientJpaRepository extends JpaRepository<Client, String> {
    

}
