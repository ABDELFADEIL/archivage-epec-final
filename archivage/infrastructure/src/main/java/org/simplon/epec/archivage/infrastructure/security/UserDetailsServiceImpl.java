package org.simplon.epec.archivage.infrastructure.security;

import org.simplon.epec.archivage.domain.user.entity.Role;
import org.simplon.epec.archivage.domain.user.entity.User;
import org.simplon.epec.archivage.domain.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User u =null;
        System.out.println("email: "+s);
        //u=userRepository.findByEmailOrUID(email);
        u=userRepository.findByEmail(s);
        System.out.println("email: "+u.getEmail()+ " password: "+u.getPassword());
        if(u==null) throw new UsernameNotFoundException(s+ "est null .....");
        final User user = u;
        /*
          Collection<Role> roles = new ArrayList<>();
        roles.add(user.getRole());
        roles.add(new Role("USER_APP"));

        Collection<GrantedAuthority> authorities=new ArrayList<GrantedAuthority>();
        roles.forEach(r->
        { authorities.add(new SimpleGrantedAuthority(r.getName()));
        });
         */

        Collection<GrantedAuthority> authorities=new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole().getName()));
        System.out.println("email: "+user.getEmail()+ " password: "+user.getPassword());
        System.out.println("succès ....//////");
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
    }

}
