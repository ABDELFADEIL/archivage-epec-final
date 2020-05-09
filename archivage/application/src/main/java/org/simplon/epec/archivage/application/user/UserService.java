package org.simplon.epec.archivage.application.user;


import org.simplon.epec.archivage.domain.user.entity.User;

public interface UserService {

    User CreateUser(User user, String rolename);
    User updateUser(User user);
    User findUserByEmail(String email);
    User findUserByUID(String UID);
    User findByUserEmailOrUID(String emailOrUID);
    void resendPassword(String email);
    User getAuthentificatedUser();

}
