package com.marshad.hellospring;

import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("/tasks/{id}")
    public String deleteTask(@PathVariable Long id){
        taskRepository.deleteById(id);
        return "Task "+id+" deleted successfully";
    }

    @PutMapping("/tasks/{id}")
    public String updateTask(@PathVariable Long id,@RequestBody Task task){
        task.setId(id);
        taskRepository.save(task);
        return "Task "+id+" updated successfully";
    }
}
