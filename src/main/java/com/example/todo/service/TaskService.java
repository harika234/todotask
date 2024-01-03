package com.example.todo.service;

import com.example.todo.entity.Task;
import org.springframework.stereotype.Service;

@Service
public interface TaskService {
    public  Task saveTask(Task task) ;


}
