package com.sibertech.toDoList.service.impl;


import com.sibertech.toDoList.model.enteties.Roles;
import com.sibertech.toDoList.model.enteties.User;
import com.sibertech.toDoList.model.enteties.UserRole;
import com.sibertech.toDoList.repository.RoleRepository;
import com.sibertech.toDoList.repository.UserRepository;
import com.sibertech.toDoList.repository.UserRoleRepository;
import com.sibertech.toDoList.service.interf.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends AbstractCRUDService<User, Long> implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRoleRepository userRoleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    CrudRepository<User, Long> getRepository() {
        return userRepository;
    }

    @Override
    public void create(User user) {
        //encode password
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        //save user into user_table
        getRepository().save(user);

        //save user and role into user_role
        UserRole userRole = new UserRole();
        userRole.setUserId(user.getId());
        userRole.setRoleId(roleRepository.findByTitle(Roles.ROLE_USER.name()).get().getId());
        userRoleRepository.save(userRole);
    }
}