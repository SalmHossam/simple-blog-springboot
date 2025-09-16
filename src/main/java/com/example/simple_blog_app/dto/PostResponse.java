package com.example.simple_blog_app.dto;

import java.time.LocalDateTime;
import java.util.List;

public class PostResponse {

    private Long id;
    private String title;
    private String content;
    private String author;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    private List<CommentSimple> comments;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<CommentSimple> getComments() {
        return comments;
    }

    public void setComments(List<CommentSimple> comments) {
        this.comments = comments;
    }

    public static class CommentSimple {
        public Long id;
        public String content;
        public String author;
        public CommentSimple(Long id, String content, String author) {
            this.id = id;
            this.content = content;
            this.author = author;
        }
    }
}
