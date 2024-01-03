package com.example.todo.service;


import com.example.todo.entity.Task;
import com.example.todo.error.TaskNotFoundException;
import com.example.todo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.time.LocalDate;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepository;


    public Task saveTask(Task task) {
        task.setTaskDate(LocalDate.now());
        return taskRepository.save(task);
    }

    public List<Task> fetchTaskList() {
        return taskRepository.findAll();
    }

    public Task fetchTaskById(Long taskId) throws TaskNotFoundException {
        Optional<Task> task = taskRepository.findById(taskId);

        if(!task.isPresent()) {
            throw new TaskNotFoundException("Task not Available");
        }
        return task.get();

    }
}
