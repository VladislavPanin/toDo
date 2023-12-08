package com.sibertech.toDoList.repository;

import com.sibertech.toDoList.model.enteties.ToDoListModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface ToDoListRepository extends JpaRepository<ToDoListModel, Integer> {


    public ToDoListModel findByToDoListId(Integer toDoListId);

    @Transactional
    public void deleteByToDoListId(Integer toDoListId);

}
