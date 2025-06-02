package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.model.Post;
import com.example.model.PostDetail;

@Mapper
public interface PostMapper {
    void insertPost(Post post);
    List<Post> findAll();
    
    List<Post> findPostsByPage(@Param("offset") int offset, @Param("limit") int limit);
    int countPosts();
    
    PostDetail findPostById(@Param("id") Long id);
}

