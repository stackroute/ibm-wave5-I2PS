package com.stackroute.recommendationservice.service;

import com.stackroute.recommendationservice.model.Role;
import com.stackroute.recommendationservice.model.User;
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
