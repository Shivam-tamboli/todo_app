package com.app.todoapp.repository;

import com.app.todoapp.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository  extends JpaRepository<Task,Long> {
}
//JpaRepository<Task,Long>: provides Basic CRUD Operations for the Task class.
//No need to write queries manually Spring data jpa handle it automatically.
