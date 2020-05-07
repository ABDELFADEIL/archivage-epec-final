package org.simplon.epec.archivage.infrastructure.user.repository;

import org.simplon.epec.archivage.infrastructure.mailing.SendingMail;
import org.simplon.epec.archivage.domain.user.entity.User;
import org.simplon.epec.archivage.domain.user.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final transient UserJpaRepository userJpaRepository;
    private final transient SendingMail sendingMail;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserRepositoryImpl(UserJpaRepository userJpaRepository, SendingMail sendingMail) {
        this.userJpaRepository = userJpaRepository;
        this.sendingMail = sendingMail;
    }


    @Override
    public User findByEmailOrUID(String emailOrUid) {
        User u = null;
        u = userJpaRepository.findByEmail(emailOrUid);
        if (u == null) {
            return userJpaRepository.findByUID(emailOrUid);
        } else return u;
    }


    @Override
    public User saveUser(User user) {
        return userJpaRepository.save(user);
    }


    @Override
    public User findByEmail(String email) {
        return userJpaRepository.findByEmail(email);
    }

    @Override
    public User findByUID(String UID) {
        return userJpaRepository.findByUID(UID);
    }

    @Override
    public void resendPassword(String email) {
        User u = userJpaRepository.findByEmail(email);
        String uuid = UUID.randomUUID().toString();
        u.setPassword(bCryptPasswordEncoder.encode(uuid));
        userJpaRepository.save(u);
        String msg = "Votre mot de passe : "+ uuid;
       sendingMail.sendingMail(u.getEmail(), msg);
    }
}
