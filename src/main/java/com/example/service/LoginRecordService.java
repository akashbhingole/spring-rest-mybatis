package com.example.service;

import java.util.List;

import com.example.dto.LoginRecordViewDTO;


public interface LoginRecordService {

	public void recordLogin(Long userId, String ipAddress);
	public List<LoginRecordViewDTO> getRecentLogins();
	
}

