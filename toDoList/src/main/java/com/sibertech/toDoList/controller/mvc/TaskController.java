package com.sibertech.toDoList.controller.mvc;


import com.sibertech.toDoList.model.enteties.Task;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(TaskController.TASK_URL)
public class TaskController extends CRUDController<Task, Long> {

    public static final String TASK_URL = "ui/task";
    public static final String TASK_NAME = "task";

    @Override
    String getEntityName() {
        return TASK_NAME;
    }
}