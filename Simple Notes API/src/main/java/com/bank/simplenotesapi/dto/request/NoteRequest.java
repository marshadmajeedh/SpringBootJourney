package com.bank.simplenotesapi.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class NoteRequest {
    @NotBlank(message = "Title cannot be blank")
    @Size(min = 5,max = 20,message = "Title must consist minimum 0f 5 characters and maximum of 20 characters")
    private  String title;

    @NotBlank(message = "Content cannot be blank")
    @Size(min=5,max=100, message = "Content must consist minimum of 5 characters and maximum of 100 characters")
    private String content;

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
