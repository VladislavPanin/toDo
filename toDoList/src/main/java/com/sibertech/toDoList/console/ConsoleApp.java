package com.sibertech.toDoList.console;

import com.sibertech.toDoList.controller.ToDoController;
import com.sibertech.toDoList.service.ToDoListServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component
public class ConsoleApp implements CommandLineRunner {



    @Override
    public void run(String... args) throws Exception {
        System.out.println("hi");


    }
}
