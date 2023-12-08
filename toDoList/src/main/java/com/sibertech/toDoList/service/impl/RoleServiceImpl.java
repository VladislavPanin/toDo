package com.sibertech.toDoList.service.impl;


import com.sibertech.toDoList.model.enteties.Role;
import com.sibertech.toDoList.repository.RoleRepository;
import com.sibertech.toDoList.service.interf.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends AbstractCRUDService<Role, Long> implements RoleService {

    @Autowired
    RoleRepository roleRepository;

    @Override
    CrudRepository<Role, Long> getRepository() {
        return roleRepository;
    }
}
