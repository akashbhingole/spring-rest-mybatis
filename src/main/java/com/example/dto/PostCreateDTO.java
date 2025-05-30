package com.example.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class PostCreateDTO {

    @NotBlank
    @Size(min = 1, max = 30, message = "Title must be 1–30 characters.")
    private String title;

    @NotBlank
    @Size(min = 1, max = 1000, message = "Content must be 1–1000 characters.")
    private String content;

    // Optionally include user ID (e.g., if not extracted from auth token)
    private String authorId;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAuthorId() {
		return authorId;
	}

	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}

}
