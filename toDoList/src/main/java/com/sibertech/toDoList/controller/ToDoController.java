package com.sibertech.toDoList.controller;

import com.sibertech.toDoList.model.DTO.ToDoListForGetDTO;
import com.sibertech.toDoList.model.enteties.ToDoListModel;
import com.sibertech.toDoList.service.ToDoListServiceImpl;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("toDoList")
@RequiredArgsConstructor
@CrossOrigin
@ShellComponent
public class ToDoController {


    private final ToDoListServiceImpl toDoListService;



    @PostMapping(value =  "/addTask",produces = MediaType.APPLICATION_JSON_VALUE)
    public String createTask(@RequestBody ToDoListModel toDoListModel)
    {
        int i = 0;
        String answer;
        answer  = toDoListService.createTask(toDoListModel);
        return answer;
    }


    @ShellMethod(key = "get-tasks")
    @GetMapping(value =  "/seeAllTasks",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ToDoListModel> getAllTasks()
    {

        return toDoListService.getAllTasksModel();
    }


    @PutMapping(value =  "/updateTask",produces = MediaType.APPLICATION_JSON_VALUE)
   // public String updateTask(@RequestBody String name, String description, boolean isCompleted, @RequestParam Integer toDoListId)
    public String updateTask(@RequestBody ToDoListModel toDoListModel, @RequestParam Integer toDoListId)
    {

        int i = 0;
        String answer = toDoListService.updateTask(toDoListModel, toDoListId);
        return answer;
    }

    @ShellMethod(key = "delete-task")
    @DeleteMapping(value =  "/deleteTask",produces = MediaType.APPLICATION_JSON_VALUE)
    public String deleteTask(@RequestParam Integer toDoListId)
    {
        String answer = toDoListService.deleteTask(toDoListId);
        return answer;
    }


}
