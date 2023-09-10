package com.example.taskmaster.service;

import com.example.taskmaster.api.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TaskRepository extends JpaRepository<Task, Integer> {

}
