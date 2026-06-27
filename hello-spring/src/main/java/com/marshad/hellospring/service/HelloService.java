package com.marshad.hellospring.service;

import com.marshad.hellospring.model.Task;
import com.marshad.hellospring.repository.TaskRepository;
import com.marshad.hellospring.util.Validation;
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
        Validation.validId(id,tRepository);
        tRepository.deleteById(id);
    }

    public void updateTask(Long id,Task task) {
        Validation.validId(id,tRepository);
        task.setId(id);
        tRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return tRepository.findAll();
    }
}
