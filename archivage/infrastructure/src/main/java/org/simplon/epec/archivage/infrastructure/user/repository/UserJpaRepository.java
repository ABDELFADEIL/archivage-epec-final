package org.simplon.epec.archivage.infrastructure.user.repository;


import org.simplon.epec.archivage.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

public interface UserJpaRepository extends JpaRepository<User, String> {

    @Query("select u from User u where u.email=:email or u.UID=:email")
    public User searchByEmailOrUID(@Param("email") String email);
    public User findByEmail(String emai);
    public User findByUID(String UID);

}
