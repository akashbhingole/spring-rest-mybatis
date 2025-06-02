package com.example.dto;

public class CommentOwnershipDTO {
    private Long commentAuthorId;
    private Long postAuthorId;
	public Long getCommentAuthorId() {
		return commentAuthorId;
	}
	public void setCommentAuthorId(Long commentAuthorId) {
		this.commentAuthorId = commentAuthorId;
	}
	public Long getPostAuthorId() {
		return postAuthorId;
	}
	public void setPostAuthorId(Long postAuthorId) {
		this.postAuthorId = postAuthorId;
	}

}

