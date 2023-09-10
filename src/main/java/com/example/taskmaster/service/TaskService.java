package com.example.taskmaster.service;

import com.example.taskmaster.api.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaskService {

    // connect to DB
    @Autowired
    TaskRepository taskRepository;

    public Optional<Task> getTask(Integer id) {
        return taskRepository.findById(id);
    }

    public Task createTask(Task task) {
        // check if task already exists
        if (getTask(task.getId()).isPresent()) {
            return null;
        }
        return taskRepository.save(task);
    }
    public boolean deleteTask(Integer id) {
        // check if task exists
        if (getTask(id).isPresent()) {
            taskRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Task updateTask(Task task) {
        // check if task exists
        if (getTask(task.getId()).isPresent()) {
            taskRepository.save(task);
            return task;
        }
        return null;
    }
}
