package com.sibertech.toDoList.controller.mvc;

import com.sibertech.toDoList.model.enteties.Role;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(RoleController.ROLE_URL)
public class RoleController extends CRUDController<Role, Long>{

    public static final String ROLE_URL = "ui/role";
    public static final String ROLE_NAME = "role";

    @Override
    String getEntityName() {
        return ROLE_NAME;
    }
}
