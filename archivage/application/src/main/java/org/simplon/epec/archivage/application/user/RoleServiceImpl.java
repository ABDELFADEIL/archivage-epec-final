package org.simplon.epec.archivage.application.user;

import org.simplon.epec.archivage.domain.user.entity.Role;
import org.simplon.epec.archivage.domain.user.repository.RoleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoleServiceImpl implements RoleService{

    private final transient RoleRepository roleRepository;


    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }


    @Override
    public Role findByName(String rolename) {
        return roleRepository.findByName(rolename);
    }

    @Override
    public Role saveRole(Role role) {
        return roleRepository.saveRole(role);
    }
}
