package com.example.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.PostCreateDTO;
import com.example.model.PagedPosts;
import com.example.model.Post;
import com.example.service.PostService;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping
    public ResponseEntity<?> createPost(@Valid @RequestBody PostCreateDTO dto) {
        Post post = postService.createPost(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(post);
    }

    @GetMapping("/pages")
    public ResponseEntity<List<Post>> getPosts() {
        return ResponseEntity.ok(postService.getAllPosts());
    }
    
    @GetMapping
    public ResponseEntity<PagedPosts> getPagedPosts(@RequestParam(defaultValue = "1") int page) {
        PagedPosts pagedPosts = postService.getPostsByPage(page);
        return ResponseEntity.ok(pagedPosts);
    }
}


