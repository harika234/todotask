package com.example.todo.repository;

import com.example.todo.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long>  {
    public  Task fetchTaskByName(String taskName);

//    public Task findByTaskIgnoreCase(String taskName);

    public Task findByTaskNameIgnoreCase(String taskName);
}


