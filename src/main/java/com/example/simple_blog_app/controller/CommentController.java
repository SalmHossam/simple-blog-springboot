package com.example.simple_blog_app.controller;

import com.example.simple_blog_app.dto.CommentRequest;
import com.example.simple_blog_app.entity.Comment;
import com.example.simple_blog_app.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts/{postId}/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public ResponseEntity<Comment> addComment(@PathVariable Long postId, @RequestBody CommentRequest req) {
        return ResponseEntity.ok(commentService.addComment(postId, req));
    }

    @GetMapping
    public ResponseEntity<List<Comment>> getAllComments(@PathVariable Long postId) {
        return ResponseEntity.ok(commentService.getCommentsByPostId(postId));
    }
}
