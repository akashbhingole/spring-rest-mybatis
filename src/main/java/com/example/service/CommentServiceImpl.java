package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.CommentDao;
import com.example.dto.CommentListResponseDTO;
import com.example.dto.CommentOwnershipDTO;
import com.example.dto.CommentRequestDTO;
import com.example.dto.CommentViewDTO;
import com.example.exception.ForbiddenException;
import com.example.exception.ResourceNotFoundException;
import com.example.model.Comment;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;

    public void createComment(Long postId, Long authorId, CommentRequestDTO req) {
        Comment comment = new Comment();
        comment.setPostId(postId);
        comment.setAuthorId(authorId);
        comment.setContent(req.getContent());
        commentDao.createComment(comment);
    }
    
    public CommentListResponseDTO getComments(Long postId, Long cursor) {
        int limit = 10;
        List<CommentViewDTO> comments = commentDao.findComments(postId, cursor, limit + 1);

        Long nextCursor = null;
        if (comments.size() > limit) {
        	CommentViewDTO last = comments.remove(limit); // remove the extra fetched one
            nextCursor = last.getId();
        }

        CommentListResponseDTO response = new CommentListResponseDTO();
        response.setComments(comments);
        response.setNextCursor(nextCursor);
        return response;
    }
    
    public void deleteComment(Long commentId, Long currentUserId) throws ResourceNotFoundException,ForbiddenException {
        CommentOwnershipDTO ownership = commentDao.findOwnershipById(commentId);

        if (ownership == null) {
            throw new ResourceNotFoundException("Comment not found");
        }

        boolean isCommentOwner = ownership.getCommentAuthorId().equals(currentUserId);
        boolean isPostOwner = ownership.getPostAuthorId().equals(currentUserId);

        if (!isCommentOwner && !isPostOwner) {
            throw new ForbiddenException("You do not have permission to delete this comment");
        }

        commentDao.deleteComment(commentId);
    }

}


