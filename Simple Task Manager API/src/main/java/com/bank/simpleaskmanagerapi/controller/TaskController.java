package com.bank.simpleaskmanagerapi.controller;

import com.bank.simpleaskmanagerapi.model.Task;
import com.bank.simpleaskmanagerapi.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class TaskController {
    private final TaskService taskService;
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/tasks")
    public ResponseEntity<List<Task>> getAllTasks(){
        List<Task> tasks = taskService.getAllTasks();
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/tasks/{title}")
    public ResponseEntity<Task> getTask(@PathVariable String title){
        Task task = taskService.getTaskByTitle(title);

        return ResponseEntity.ok(task);
    }

    @PutMapping("/tasks/{title}")
    public ResponseEntity<Task> updateTask(@PathVariable String title){
        Task task = taskService.getTaskByTitle(title);
        taskService.updateTaskStatus(task);

        return ResponseEntity.ok(task);
    }

    @DeleteMapping("/tasks/{title}")
    public ResponseEntity<Task> deleteTask(@PathVariable String title){
        Task task = taskService.getTaskByTitle(title);
        taskService.deleteTask(task);

        return ResponseEntity.ok(task);
    }
}
