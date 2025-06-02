package com.example.dao;

import java.util.List;

import com.example.dto.CommentOwnershipDTO;
import com.example.dto.CommentViewDTO;
import com.example.model.Comment;

public interface CommentDao {
	public void createComment(Comment comment);
	
	List<CommentViewDTO> findComments(Long postId,Long cursor,int limit);

	CommentOwnershipDTO findOwnershipById(Long commentId);
	
	public void deleteComment(Long commentId);
}
