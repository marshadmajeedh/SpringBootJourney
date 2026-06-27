package com.marshad.hellospring.controller;

import com.marshad.hellospring.model.Task;
import com.marshad.hellospring.service.HelloService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HelloController {

    private final HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }
    @PostMapping("/tasks")
    public Task addTask(@Valid @RequestBody Task task){
        return helloService.addTask(task);
    }

    @GetMapping("/tasks")
    public List<Task> getTasks(){
       return helloService.getAllTasks();
    }

    @DeleteMapping("/tasks/{id}")
    public String deleteTask(@PathVariable Long id){
        helloService.deleteTask(id);
        return "Task "+id+" deleted successfully";
    }

    @PutMapping("/tasks/{id}")
    public String updateTask(@PathVariable Long id,@RequestBody Task task){
        helloService.updateTask(id,task);
        return "Task "+id+" updated successfully";
    }
}
