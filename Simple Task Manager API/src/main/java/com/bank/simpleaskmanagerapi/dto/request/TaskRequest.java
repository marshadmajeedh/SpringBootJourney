package com.bank.simpleaskmanagerapi.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class TaskRequest {

    @NotBlank(message = "Title cannot be blank")
    @Size(min = 4,max = 20,message = "Title must consist of minimum of 4 characters and maximum of 20 characters")
    private String title;

    @NotBlank(message= "Description cannot be blank")
    @Size(min = 10,max = 100,message = "Description must consist of minimum of 10 characters and maximum of 100 characters")
    private String description;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
