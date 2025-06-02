package com.example.dao;

import java.util.List;

import com.example.dto.LoginRecordViewDTO;

public interface LoginRecordDao {
	public void recordLogin(Long userId, String ipAddress);
	public List<LoginRecordViewDTO> getRecentLogins();
}
