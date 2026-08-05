package com.bank.simpleaskmanagerapi.service;

import com.bank.simpleaskmanagerapi.dto.request.TaskRequest;
import com.bank.simpleaskmanagerapi.dto.response.TaskResponse;
import com.bank.simpleaskmanagerapi.exception.TitleNotMatchException;
import com.bank.simpleaskmanagerapi.model.Task;
import com.bank.simpleaskmanagerapi.util.Validation;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {
    private final List<Task> tasks;

    public TaskService() {
        this.tasks = new ArrayList<>();
    }

    public TaskResponse createTask(TaskRequest taskRequest) {
        Task task = new Task(taskRequest.getTitle(),taskRequest.getDescription(),"TODO");
        this.tasks.add(task);

        return new TaskResponse(task.getTitle(),task.getDescription(),task.getStatus());
    }

    public TaskResponse deleteTask(String title) {
        Validation.checkTaskByTitle(tasks, title);

        Task taskToDelete = tasks.stream()
                .filter(task -> task.getTitle().equalsIgnoreCase(title))
                .findFirst()
                .orElseThrow(() -> new TitleNotMatchException(title+" was not found in the list"));

        tasks.remove(taskToDelete);

        return new TaskResponse(taskToDelete.getTitle(),taskToDelete.getDescription(),taskToDelete.getStatus());
    }

    public List<TaskResponse> getAllTasks() {
        return tasks.stream()
                .map(task -> new TaskResponse(task.getTitle(),task.getDescription(),task.getStatus()))
                .toList();
    }

    public TaskResponse getTaskByTitle(String title) {
        Validation.checkTaskByTitle(tasks, title);

        return tasks.stream()
                .filter(task -> task.getTitle().equalsIgnoreCase(title))
                .map(task -> new TaskResponse(task.getTitle(),task.getDescription(),task.getStatus()))
                .findFirst()
                .orElseThrow(() -> new TitleNotMatchException(title+" was not found in the list"));
    }

    public TaskResponse updateTaskStatus(String title) {
        Validation.checkTaskByTitle(tasks,title);

        return tasks.stream()
                .filter(task -> task.getTitle().equalsIgnoreCase(title))
                .peek(task -> {
                    if("TODO".equals(task.getStatus())){
                        task.setStatus("IN_PROGRESS");
                    }else if("IN_PROGRESS".equals(task.getStatus())){
                        task.setStatus(("DONE"));
                    }
                })
                .map(task -> new TaskResponse(task.getTitle(),task.getDescription(),task.getStatus()))
                .findFirst()
                .orElseThrow(() -> new TitleNotMatchException(title+" was not found in the list"));
    }
}
