package com.example.service;

import java.util.List;

import com.example.dto.PostCreateDTO;
import com.example.model.PagedPosts;
import com.example.model.Post;


public interface PostService {
    
	public Post createPost(PostCreateDTO dto);
	
	public List<Post> getAllPosts();
	
	public PagedPosts getPostsByPage(int page);
}

