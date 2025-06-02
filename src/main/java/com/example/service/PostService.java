package com.example.service;

import java.util.List;

import com.example.dto.PostCreateDTO;
import com.example.model.PagedPosts;
import com.example.model.Post;
import com.example.model.PostDetail;


public interface PostService {
    
	public Post createPost(PostCreateDTO dto);
	
	public List<Post> getAllPosts();
	
	public PagedPosts getPostsByPage(int page);
	
	public PostDetail getPostDetail(Long id);
}

