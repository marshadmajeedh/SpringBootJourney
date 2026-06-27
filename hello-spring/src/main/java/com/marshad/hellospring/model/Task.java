package com.marshad.hellospring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Title cannot be empty")
    private String title;
    private boolean completed;
    private String priority;

    public Task(String title, boolean completed, String priority) {
        setTitle(title);
        setCompleted(completed);
        setPriority(priority);
    }
    public Task(){}

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
    public String getPriority() {
        return priority;
    }
    public void setPriority(String priority) {
        this.priority = priority;
    }
    public long getId() {return id;}
    public void setId(long id) {this.id = id;}
}
