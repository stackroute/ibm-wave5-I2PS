package com.stackroute.springneo4jexample.service;

import com.stackroute.springneo4jexample.model.Role;
import com.stackroute.springneo4jexample.model.User;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface RoleService {
    Role findByName(String spaceName);

    Role saveRole(Long roleId, String roleName);

    User createRelations();

    Collection<Role> getAll();

    void deleteRole(String roleName);

    Role saved(Role role);
}
