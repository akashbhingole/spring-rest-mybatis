package com.example.dao;

import java.util.List;

import com.example.model.Post;

public interface PostDao {
	public List<Post> getAllPosts();
	public Post insertPost(Post post);
	
	public List<Post> findPostsByPage(int offset,int pageSize);
	public int countPosts();
}
