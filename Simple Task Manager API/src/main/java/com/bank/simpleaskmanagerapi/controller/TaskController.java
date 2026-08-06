package com.bank.simpleaskmanagerapi.controller;

import com.bank.simpleaskmanagerapi.dto.request.TaskRequest;
import com.bank.simpleaskmanagerapi.dto.response.TaskResponse;
import com.bank.simpleaskmanagerapi.model.Task;
import com.bank.simpleaskmanagerapi.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskController {
    private final TaskService taskService;
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/tasks")
    public ResponseEntity<List<TaskResponse>> getAllTasks(){
        List<TaskResponse> responses = taskService.getAllTasks();
        return ResponseEntity.ok(responses);
    }

    @GetMapping("/tasks/{title}")
    public ResponseEntity<TaskResponse> getTask(@PathVariable String title){
        TaskResponse taskResponse = taskService.getTaskByTitle(title);
        return ResponseEntity.ok(taskResponse);
    }

    @PutMapping("/tasks/{title}")
    public ResponseEntity<TaskResponse> updateTask(@PathVariable String title){
        TaskResponse taskResponse = taskService.updateTaskStatus(title);
        return ResponseEntity.ok(taskResponse);
    }

    @DeleteMapping("/tasks/{title}")
    public ResponseEntity<TaskResponse> deleteTask(@PathVariable String title){
        TaskResponse taskResponse = taskService.deleteTask(title);
        return ResponseEntity.ok(taskResponse);
    }

    @PostMapping("/tasks")
    public ResponseEntity<TaskResponse> createTask(@RequestBody TaskRequest taskRequest){
        TaskResponse taskResponse = taskService.createTask(taskRequest);
        return ResponseEntity.ok(taskResponse);
    }
}
