package com.example.taskmaster.api.controller;

import com.example.taskmaster.api.model.Task;
import com.example.taskmaster.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/task")
    public ResponseEntity<Object> getTask(@RequestParam Integer id) {
        Optional<Task> task = taskService.getTask(id);
        if (task.isPresent()) {
            return ResponseEntity.ok(task.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Task not found");
    }

    @PostMapping("/task")
    public ResponseEntity<Object> postTask(@RequestBody Task newTask) {
        Task createdTask = taskService.createTask(newTask);
        if (createdTask != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdTask);
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Task creation failed");
        }
    }

    @DeleteMapping("/task")
    public ResponseEntity<Object> deleteTask(@RequestParam Integer id) {
        boolean deleted = taskService.deleteTask(id);
        if (deleted) {
            return ResponseEntity.ok("Task deleted");
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Task deletion failed");
        }
    }

    @PutMapping("/task")
    public ResponseEntity<Object> updateTask(@RequestBody Task task) {
        Task updatedTask = taskService.updateTask(task);
        if (updatedTask != null) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(task);
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Task update failed");
        }
    }
}
