package com.example.simple_blog_app.service;

import com.example.simple_blog_app.dto.CommentRequest;
import com.example.simple_blog_app.entity.Comment;
import com.example.simple_blog_app.entity.Post;
import com.example.simple_blog_app.exception.ResourceNotFoundException;
import com.example.simple_blog_app.repository.CommentRepo;
import com.example.simple_blog_app.repository.PostRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepo commentRepo;
    private final PostRepo postRepo;

    public Comment addComment(Long postId, CommentRequest req) {
        Post post = postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post not found: " + postId));
        Comment c = new Comment();
        c.setContent(req.getContent());
        c.setPost(post);
        c.setAuthor(req.getAuthor());
        return commentRepo.save(c);
    }

    public List<Comment> getCommentsByPostId(Long postId) {
        return commentRepo.findByPostId(postId);
    }
}
