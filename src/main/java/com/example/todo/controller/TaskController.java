package com.example.todo.controller;

import com.example.todo.entity.Task;
import com.example.todo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class TaskController {

    @Autowired
//    private TaskService taskService;
    private TaskService taskService;

    // creating and saving tasks in database
    @PostMapping("/tasks")
    public Task saveTask(@RequestBody Task task) {
        return taskService.saveTask(task);
    }
    // now getting all tasks
    @GetMapping("/tasks")
    public List<Task> fetchTaskList() {
        return taskService.fetchTaskList();
    }

}
