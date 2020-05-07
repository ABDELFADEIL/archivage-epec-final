package org.simplon.epec.archivage.application.user;

import org.simplon.epec.archivage.domain.user.entity.Role;

public interface RoleService {

     Role findByName(String rolename);
     Role saveRole(Role role);
}
