package com.example.todo.service;

import com.example.todo.entity.Task;
import com.example.todo.error.TaskNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public interface TaskService {
    public  Task saveTask(Task task) ;

    public List<Task> fetchTaskList();

    public Task fetchTaskById(Long taskId) throws TaskNotFoundException;

}
