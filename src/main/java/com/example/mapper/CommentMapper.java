package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.dto.CommentOwnershipDTO;
import com.example.dto.CommentViewDTO;
import com.example.model.Comment;

@Mapper
public interface CommentMapper {
	void insertComment(@Param("comment") Comment comment);
	
	List<CommentViewDTO> findComments(@Param("postId") Long postId, @Param("cursor") Long cursor, @Param("limit") int limit);

	CommentOwnershipDTO findOwnershipById(@Param("commentId") Long commentId);

	void deleteComment(@Param("commentId") Long commentId);
}

