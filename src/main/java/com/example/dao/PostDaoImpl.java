package com.example.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.mapper.PostMapper;
import com.example.model.Post;
import com.example.model.PostDetail;

@Repository
public class PostDaoImpl implements PostDao {

    @Autowired
    private PostMapper postMapper;


    @Override
    public List<Post> getAllPosts() {
        return postMapper.findAll();
    }


	@Override
	public Post insertPost(Post post) {
		postMapper.insertPost(post);
		return post;
	}
	
	@Override
    public List<Post> findPostsByPage(int offset,int pageSize) {
        return postMapper.findPostsByPage(offset, pageSize);
    }
	
	@Override
    public int countPosts() {
        return postMapper.countPosts();
    }
	
	public PostDetail getPostDetail(Long id) {
		return postMapper.findPostById(id);
	}
	
    
}
