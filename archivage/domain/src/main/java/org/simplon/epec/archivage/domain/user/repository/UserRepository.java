package org.simplon.epec.archivage.domain.user.repository;

import org.simplon.epec.archivage.domain.user.entity.User;

public interface UserRepository {
     User findByEmailOrUID(String emaiOrUID);
     User saveUser(User user);
     User findByEmail(String emai);
     User findByUID(String UID);
     void resendPassword(String email);
     User getAuthenticatedUser();


}
