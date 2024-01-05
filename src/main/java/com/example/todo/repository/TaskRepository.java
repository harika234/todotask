package com.example.todo.repository;

import com.example.todo.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long>  {
//    @Query("SELECT t FROM Task t WHERE t.taskName = :taskName")
//    public  Task fetchTaskByName(String taskName);

//    public Task findByTaskIgnoreCase(String taskName);
//public Task findByTaskNameIgnoreCase(String taskName);


    public List<Task> findByTaskNameIgnoreCase(String taskName);

    public List<Task> findByTaskDateBetween(LocalDate startDate, LocalDate endDate);
}


