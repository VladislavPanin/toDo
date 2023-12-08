package com.sibertech.toDoList.repository;

import com.sibertech.toDoList.model.enteties.UserRole;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Denys Laptiev
 * Date: 19.05.2023
 */
public interface UserRoleRepository extends CrudRepository<UserRole, Long> {
    Iterable<UserRole> findAllByUserId(Long userId);
}

