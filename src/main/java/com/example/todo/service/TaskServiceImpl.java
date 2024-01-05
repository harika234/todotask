package com.example.todo.service;


import com.example.todo.entity.Task;
import com.example.todo.error.TaskNotFoundException;
import com.example.todo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.time.LocalDate;
import java.util.Objects;
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

    public List<Task> fetchTaskByName(String taskName) {
    return taskRepository.findByTaskNameIgnoreCase(taskName);
    }

    public void deleteTaskById(Long taskId) {
        taskRepository.deleteById((taskId));
    }

    public Task updateTaskById(Long taskId, Task task) {
        Task depDB = taskRepository.findById(taskId).get();

        if(Objects.nonNull(task.getTaskName()) && !"".
                equalsIgnoreCase(task.getTaskName())) {

            depDB.setTaskName(task.getTaskName());
        }
        if(Objects.nonNull(task.getTaskCategory()) && !"".
                equalsIgnoreCase(task.getTaskCategory())) {

            depDB.setTaskCategory(task.getTaskName());
        }
        if(Objects.nonNull(task.getTaskDescription()) && !"".
                equalsIgnoreCase(task.getTaskDescription())) {

            depDB.setTaskCategory(task.getTaskName());
        }
        return taskRepository.save(depDB);
    }

    public List<Task> getTasksBetweenDates(LocalDate startDate, LocalDate endDate) {
        // Implement your logic to retrieve tasks from the repository within the given date range
        return taskRepository.findByTaskDateBetween(startDate, endDate);
    }
}
