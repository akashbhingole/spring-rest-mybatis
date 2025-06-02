package com.example.service;

import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.dao.PostDao;
import com.example.dto.PostCreateDTO;
import com.example.model.PagedPosts;
import com.example.model.Post;
import com.example.model.PostDetail;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostDao postDao;
    
    private static final int PAGE_SIZE = 1;

    @Override
    public Post createPost(PostCreateDTO dto) {
        Post post = new Post();
        post.setTitle(dto.getTitle());
        post.setContent(dto.getContent());
        post.setAuthorId(dto.getAuthorId()); // From DTO or Auth Context
        post.setCreatedAt(Instant.now().toString());

        postDao.insertPost(post);
        return post;
    }

    @Override
    public List<Post> getAllPosts() {
        return postDao.getAllPosts();
    }
    
    @Override
    public PagedPosts getPostsByPage(int page) {
        int offset = (page - 1) * PAGE_SIZE;
        List<Post> posts = postDao.findPostsByPage(offset, PAGE_SIZE);
        int total = postDao.countPosts();
        PagedPosts response = new PagedPosts();
        response.setPosts(posts);
        response.setTotalPosts(total);
        return response;
    }
    
    public PostDetail getPostDetail(Long id) {
        PostDetail post = postDao.getPostDetail(id);
        if (post == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Post not found");
        }
        return post;
    }
}

