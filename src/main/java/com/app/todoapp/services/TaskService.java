package com.app.todoapp.services;

import com.app.todoapp.models.Task;
import com.app.todoapp.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service//marks as a spring service component.
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    public void createTask(String title){
        Task task = new Task();
        task.setTitle(title);
        task.setCompleted(false);
        taskRepository.save(task);

    }

    public void deleteTask(Long id){
        taskRepository.deleteById(id);
    }

//find the task by its id.
//    public void toggleTask(Long id){
//        Task task = taskRepository.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("Invalid task id"));
//                task.setCompleted(!task.isCompleted());
//                taskRepository.save(task);
//        }
}
//These class files are used to write business logic in a different layer.
//service layer acts as a bridge between Controller(which handles request) and the repo(which interacts with DB)