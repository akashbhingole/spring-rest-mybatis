package com.example.service;

import com.example.dto.CommentListResponseDTO;
import com.example.dto.CommentRequestDTO;
import com.example.exception.ForbiddenException;
import com.example.exception.ResourceNotFoundException;


public interface CommentService {
    
	public void createComment(Long postId, Long authorId, CommentRequestDTO req);

	public CommentListResponseDTO getComments(Long postId, Long cursor);

	public void deleteComment(Long commentId, Long currentUserId) throws ResourceNotFoundException,ForbiddenException;
}

