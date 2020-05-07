package org.simplon.epec.archivage.domain.user.repository;

import org.simplon.epec.archivage.domain.user.entity.User;

public interface UserRepository {
    public User findByEmailOrUID(String emaiOrUID);
    public User saveUser(User user);
    public User findByEmail(String emai);
    public User findByUID(String UID);
    void resendPassword(String email);


}
