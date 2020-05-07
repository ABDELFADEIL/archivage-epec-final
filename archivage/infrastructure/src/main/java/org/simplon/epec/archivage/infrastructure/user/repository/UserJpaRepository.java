package org.simplon.epec.archivage.infrastructure.user.repository;


import org.simplon.epec.archivage.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<User, String> {

    //public User findByEmailOrUID(String email, String UID);
    public User findByEmail(String emai);
    public User findByUID(String UID);

}
