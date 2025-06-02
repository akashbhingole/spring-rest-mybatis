package com.example.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.dto.CommentOwnershipDTO;
import com.example.dto.CommentViewDTO;
import com.example.mapper.CommentMapper;
import com.example.model.Comment;

@Repository
public class CommentDaoImpl implements CommentDao {

	@Autowired
    private CommentMapper commentMapper;
	
	public void createComment(Comment comment) {
		commentMapper.insertComment(comment);
	}
	
	public List<CommentViewDTO> findComments(Long postId,Long cursor,int limit){
		List<CommentViewDTO> comments = commentMapper.findComments(postId, cursor, limit);
		return comments;
	}
	
	public CommentOwnershipDTO findOwnershipById(Long commentId) {
		CommentOwnershipDTO ownership = commentMapper.findOwnershipById(commentId);
		return ownership;
	}
	
	public void deleteComment(Long commentId) {
		commentMapper.deleteComment(commentId);
	}
}
