package org.simplon.epec.archivage.application.user;

import org.simplon.epec.archivage.domain.user.entity.Role;
import org.simplon.epec.archivage.domain.user.entity.User;
import org.simplon.epec.archivage.domain.user.repository.RoleRepository;
import org.simplon.epec.archivage.domain.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service @Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

        private final transient UserRepository userRepository;


    private final transient RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }


    @Override
    public User CreateUser(User user, String rolename) {

       if((findUserByEmail(user.getEmail()) != null)) throw new RuntimeException(user.getEmail()+ " existe déjà !");
       if((findUserByUID(user.getUID()) != null)) throw new RuntimeException(user.getUID()+ " existe déjà !");
        Role r =roleRepository.findByName(rolename);
        if (r==null){
            r=roleRepository.saveRole(new Role(rolename));
        }
        String newPasswprd = bCryptPasswordEncoder.encode(user.getPassword());
        User u = new User(user.getUID(), user.getEmail(), newPasswprd, r);
        try {
            // u = new User(user.getUID(), user.getEmail(), newPasswprd, r);
            userRepository.saveUser(u);
        } catch (Exception e) {
            e.getStackTrace();
            System.out.println("error creating user " + e);
        }
        return u;
    }

    @Override
    public User updateUser(User user) {
        String password = user.getPassword();
        String oldPassword = userRepository.findByEmail(user.getEmail()).getPassword();
        if (!password.equals(oldPassword)){
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        }
        return userRepository.saveUser(user);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User findUserByUID(String UID) {
        return userRepository.findByUID(UID);
    }

    @Override
    public User findByUserEmailOrUID(String emailOrUID) {
        return userRepository.findByEmailOrUID(emailOrUID);
    }
    @Override
    public void resendPassword(String email)  {
        userRepository.resendPassword(email);

    }
}
