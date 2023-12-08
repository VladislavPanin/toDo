package com.sibertech.toDoList.repository;


import com.sibertech.toDoList.model.enteties.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
    Optional<Role> findByTitle(String title);
}
