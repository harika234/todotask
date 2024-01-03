package com.example.todo.service;


import com.example.todo.entity.Task;
import com.example.todo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepository;


    public Task saveTask(Task task) {
        task.setTaskDate(LocalDate.now());
        return taskRepository.save(task);
    }

}
