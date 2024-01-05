package com.example.todo.controller;
import com.example.todo.error.TaskNotFoundException;
import com.example.todo.entity.Task;
import com.example.todo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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


    @GetMapping("/tasks/id/{id}")
    public Task fetchTaskById(@PathVariable("id") Long taskId) throws  TaskNotFoundException {
        return taskService.fetchTaskById(taskId);
    }

    @GetMapping("/tasks/name/{name}")
    public List<Task> fetchByTaskName(@PathVariable("name") String taskName) {
        return taskService.fetchTaskByName(taskName);
    }

    @DeleteMapping ("/tasks/{id}")
    public String deleteTaskById(@PathVariable("id") Long taskId) {
        taskService.deleteTaskById(taskId);
        return("Task id is deleted succesfully");

    }

    @PutMapping("/tasks/{id}")
    public Task updateTaskById(@PathVariable("id") Long taskId,@RequestBody Task task){
        return taskService.updateTaskById(taskId,task);
    }

}
