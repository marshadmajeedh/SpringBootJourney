package com.marshad.hellospring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {

    private final TaskRepository taskRepository;

    public HelloController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    @GetMapping("/")
    public String hello(){
        return "Hello World!";
    }

    @GetMapping("/about")
    public String about(){
        return "First springboot class";
    }

    @PostMapping("/tasks")
    public Task addTask(@RequestBody Task task){
        return taskRepository.save(task);
    }

    @GetMapping("/tasks")
    public List<Task> getTasks(){
       return taskRepository.findAll();
    }
}
