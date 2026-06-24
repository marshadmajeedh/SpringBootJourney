package com.marshad.hellospring;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HelloService {

    private final TaskRepository tRepository;

    public HelloService(TaskRepository tRepository) {
        this.tRepository = tRepository;
    }

    public Task addTask(Task task) {
        return tRepository.save(task);
    }

    public void deleteTask(Long id) {
        tRepository.deleteById(id);
    }

    public void updateTask(Long id,Task task) {
        task.setId(id);
        tRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return tRepository.findAll();
    }
}
