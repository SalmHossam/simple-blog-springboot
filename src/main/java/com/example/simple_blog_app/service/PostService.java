package com.example.simple_blog_app.service;

import com.example.simple_blog_app.dto.PostRequest;
import com.example.simple_blog_app.dto.PostResponse;
import com.example.simple_blog_app.entity.Post;
import com.example.simple_blog_app.repository.PostRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepo postRepo;

    public PostResponse createPost(PostRequest req) {
        Post post = new Post();
        post.setTitle(req.getTitle());
        post.setContent(req.getContent());
        post.setAuthor(req.getAuthor());
        Post savedPost = postRepo.save(post);
        return toResponse(savedPost);

    }
    public List<PostResponse>ListAllPosts() {
        return postRepo.findAll().stream().map(this::toResponse).toList();
    }
    public PostResponse getPostById(Long id) {
       Post  P = postRepo.findById(id).orElseThrow(() -> new RuntimeException("Post not found"));
       return toResponse(P);
    }
    public PostResponse updatePost(Long id, PostRequest req) {
        Post post = postRepo.findById(id).orElseThrow(() -> new RuntimeException("Post not found"));
        post.setTitle(req.getTitle());
        post.setContent(req.getContent());
        post.setAuthor(req.getAuthor());
        return toResponse(postRepo.save(post));
    }
    public void deletePost(Long id) {
        if (!postRepo.existsById(id)) {
            throw new RuntimeException("Post not found");
        }
        postRepo.deleteById(id);
    }
    public List<PostResponse> search(String keyWord) {
        return postRepo.findByTitleContainingIgnoreCaseOrContentContainingIgnoreCase(keyWord, keyWord).stream().map(this::toResponse).toList();
    }
    private PostResponse toResponse(Post post) {
        PostResponse r = new PostResponse();
        r.setId(post.getId());
        r.setTitle(post.getTitle());
        r.setContent(post.getContent());
        r.setCreatedAt(post.getCreatedAt());
        r.setAuthor(post.getAuthor());
        r.setUpdatedAt(post.getUpdatedAt());
        r.setComments(post.getComments().stream()
                .map(c -> new PostResponse.CommentSimple(c.getId(), c.getContent(), c.getAuthor()))
                .collect(Collectors.toList()));
        return r;

    }
}
