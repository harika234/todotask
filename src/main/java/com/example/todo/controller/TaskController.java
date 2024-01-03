package com.example.todo.controller;

import com.example.todo.entity.Task;
import com.example.todo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class TaskController {

    @Autowired
//    private TaskService taskService;
    private TaskService taskService;


    @PostMapping("/tasks")
    public Task saveTask(@RequestBody Task task) {
        return taskService.saveTask(task);
    }
}
