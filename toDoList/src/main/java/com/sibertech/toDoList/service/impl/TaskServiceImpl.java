package com.sibertech.toDoList.service.impl;


import com.sibertech.toDoList.model.enteties.Task;
import com.sibertech.toDoList.repository.TaskRepository;
import com.sibertech.toDoList.service.interf.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl extends AbstractCRUDService<Task, Long> implements TaskService {

    @Autowired
    TaskRepository taskRepository;

    @Override
    CrudRepository<Task, Long> getRepository() {
        return taskRepository;
    }
}