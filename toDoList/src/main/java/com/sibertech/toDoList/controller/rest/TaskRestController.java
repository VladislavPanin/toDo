package com.sibertech.toDoList.controller.rest;


import com.sibertech.toDoList.model.enteties.Task;
import com.sibertech.toDoList.service.interf.CRUDService;
import com.sibertech.toDoList.service.interf.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(TaskRestController.TASK_REST_URL)
public class TaskRestController extends CRUDRestController<Task, Long> {

    public static final String TASK_REST_URL = "task";

    @Autowired
    private TaskService taskService;

    @Override
    CRUDService<Task, Long> getService() {
        return taskService;
    }
}
