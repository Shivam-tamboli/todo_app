package com.app.todoapp.controller;

import com.app.todoapp.models.Task;
import com.app.todoapp.services.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller//mark this class as a spring mvc controller.
@RequestMapping("/tasks")
public class TaskController {

    //dependency injection
    private final TaskService taskService;

    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    //an endpoint.
    @GetMapping
    public String getTasks(Model model ){//models pass data controller to view html.
        List<Task> tasks = taskService.getAllTasks();
        model.addAttribute("tasks", tasks);
        return "tasks";
    }

    @PostMapping
    public String createTask(@RequestParam String title){//models pass data controller to view html.
        taskService.createTask(title);
        return "redirect:/ ";
    }
}
//controller will have all the end points, method s here to handle users request related to task.