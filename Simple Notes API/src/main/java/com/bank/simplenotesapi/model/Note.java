package com.bank.simplenotesapi.model;

import java.time.Instant;
import java.util.UUID;

public class Note {
    private final String id;
    private String title;
    private String content;
    private final Instant createdAt;

    public Note(String title,String content){
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.content = content;
        this.createdAt = Instant.now();
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Instant getCreatedAt() {
        return createdAt;
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
