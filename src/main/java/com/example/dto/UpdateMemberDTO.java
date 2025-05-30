package com.example.dto;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UpdateMemberDTO {

    @Size(min = 12, max = 20, message = "Password must be 12–20 characters.")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*\\d)(?=.*[!@#$%^&*()_+=-]).+$",
             message = "Password must include lowercase letters, numbers, and special characters.")
    private String password;

    @Pattern(regexp = "^[가-힣]{1,10}$", message = "Username must be in Korean and 1–10 characters.")
    private String username;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
