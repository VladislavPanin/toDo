package com.sibertech.toDoList.model.enteties;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Date;

@Entity
@Table(name = "toDoList_table")
@Data
public class ToDoListModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer toDoListId;
    private String name;
    private String description;
    //    private Date dueDate;
    private boolean completed;



}
