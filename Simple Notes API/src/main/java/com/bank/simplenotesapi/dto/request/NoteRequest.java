package com.bank.simplenotesapi.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class NoteRequest {
    @NotBlank(message = "Title cannot be blank")
    @Size(min = 5,max = 20,message = "Title must consist minimum if 5 characters and maximum of 20 characters")
    private  String title;

    @NotBlank(message = "Content cannot be blank")
    @Size(min=5,max=20, message = "Content must consist minimum if 5 characters and maximum of 20 characters")
    private String content;

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
