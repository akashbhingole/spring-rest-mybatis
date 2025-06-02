package com.example.dto;

import java.util.List;

public class CommentListResponseDTO {
    private List<CommentViewDTO> comments;
    private Long nextCursor;
	public List<CommentViewDTO> getComments() {
		return comments;
	}
	public void setComments(List<CommentViewDTO> comments) {
		this.comments = comments;
	}
	public Long getNextCursor() {
		return nextCursor;
	}
	public void setNextCursor(Long nextCursor) {
		this.nextCursor = nextCursor;
	} 

}
