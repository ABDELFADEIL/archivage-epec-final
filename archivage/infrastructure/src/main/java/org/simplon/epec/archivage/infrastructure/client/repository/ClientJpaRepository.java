package org.simplon.epec.archivage.infrastructure.client.repository;

import org.simplon.epec.archivage.domain.client.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface ClientJpaRepository extends JpaRepository<Client, String> {


    @Query("select client from Client client where client.client_number=:client_number")
    public Client findByClientNumber(@Param("client_number") String client_number);

    @Query("select client from Client client where client.client_number like %:client_number%")
    public Set<Client> findByClientNumberContains(@Param("client_number") String client_number);
    @Query("select client from Client client where client.client_name like %:client_name% or client.client_first_name like %:client_name%")
    public Set<Client> findByClientNameContains( @Param("client_name") String client_name);

            @Query(value="select MAX(c.client_number) from client c group by c.client_number order by c.client_number desc limit 1", nativeQuery=true)
            public String findMaxClientNumber();

/*
    @Query("select u from User u where u.email=:email or u.UID=:email")
    public User searchByEmailOrUID(@Param("email") String email);
    public User findByEmail(String emai);

     String client_id;
     String client_number;
     String client_nature_id;
     String client_name;

 */

}
