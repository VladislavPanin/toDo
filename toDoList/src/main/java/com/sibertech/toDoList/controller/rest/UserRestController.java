package com.sibertech.toDoList.controller.rest;


import com.sibertech.toDoList.model.enteties.User;
import com.sibertech.toDoList.service.interf.CRUDService;
import com.sibertech.toDoList.service.interf.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(UserRestController.USER_REST_URL)
public class UserRestController extends CRUDRestController<User, Long> {

    public static final String USER_REST_URL = "user";

    @Autowired
    private UserService userService;

    @Override
    CRUDService<User, Long> getService() {
        return userService;
    }
}
