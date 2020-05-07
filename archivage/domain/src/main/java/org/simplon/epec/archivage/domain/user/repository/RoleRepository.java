package org.simplon.epec.archivage.domain.user.repository;

import org.simplon.epec.archivage.domain.user.entity.Role;

public interface RoleRepository {
    public Role findByName(String rolename);
    public Role saveRole(Role role);
}
