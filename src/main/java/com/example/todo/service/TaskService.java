package com.example.todo.service;

import com.example.todo.entity.Task;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public interface TaskService {
    public  Task saveTask(Task task) ;

    public List<Task> fetchTaskList();
}
