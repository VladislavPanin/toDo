package com.sibertech.toDoList.model.DTO;

import lombok.Data;

@Data
public class ToDoListForGetDTO {

    private String name;
    private String description;
    //    private Date dueDate;
    private boolean completed;
}
