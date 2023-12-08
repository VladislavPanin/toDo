package com.sibertech.toDoList.repository;

import com.sibertech.toDoList.model.enteties.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {
}

