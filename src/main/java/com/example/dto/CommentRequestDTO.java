package com.example.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CommentRequestDTO {
    @NotBlank
    @Size(min = 1, max = 500)
    private String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
    
}

