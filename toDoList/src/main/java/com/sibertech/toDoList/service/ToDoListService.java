package com.sibertech.toDoList.service;

import com.sibertech.toDoList.model.DTO.ToDoListForGetDTO;
import com.sibertech.toDoList.model.enteties.ToDoListModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ToDoListService {
    public String createTask(ToDoListModel toDoListModel);

    public List<ToDoListForGetDTO> getAllTasks();

    public String updateTask(ToDoListModel toDoListModel, Integer toDoListId);

    public String deleteTask(Integer toDoListId);
}
