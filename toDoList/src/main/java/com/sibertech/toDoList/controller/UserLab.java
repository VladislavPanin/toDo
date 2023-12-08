package com.sibertech.toDoList.controller;


import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class UserLab {
    @ShellMethod(key = "hello-world")
    public String hello(@ShellOption(defaultValue = "spring") String arg)
    {

        return "hello " + arg;
    }
}
