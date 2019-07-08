package com.stackroute.recommendationservice.service;

import com.stackroute.recommendationservice.model.Role;
import com.stackroute.recommendationservice.model.User;
import com.stackroute.recommendationservice.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class RoleServiceImplementation implements RoleService {

    @Autowired
    RoleRepository roleRepository;

    @Override
    public Role findByName(String roleName) {
        return roleRepository.getNode(roleName);
    }

    @Override
    public Role saveRole(Long roleId, String roleName) {
        return roleRepository.getRole(roleId,roleName);
    }

    @Override
    public User createRelations() {
        return roleRepository.createRelations();
    }

    @Override
    public Collection<Role> getAll() {
        return roleRepository.getAll();
    }

    @Override
    public void deleteRole(String roleName) {
        roleRepository.delete(roleName);
    }

    @Override
    public Role saved(Role role) {
        return roleRepository.save(role);
    }
}
