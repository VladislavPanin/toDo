package com.sibertech.toDoList.validator;


import com.sibertech.toDoList.model.enteties.User;
import com.sibertech.toDoList.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

/**
 * @author Denys Laptiev
 * Date: 12.05.2023
 */
@Component
public class UserValidator implements Validator {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        User userToValidate = (User) obj;
        Optional<User> userFromDB = userDetailsService.loadUserOptionalByUsername(userToValidate.getUsername());
        if (userFromDB.isPresent()) {
            errors.rejectValue("username", "400", "Username already exists");
        }

    }
}
