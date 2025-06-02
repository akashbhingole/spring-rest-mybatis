package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.LoginRecordDao;
import com.example.dto.LoginRecordViewDTO;

@Service
public class LoginRecordServiceImpl implements LoginRecordService {

    @Autowired
    private LoginRecordDao loginRecordDao;

    @Override
    public void recordLogin(Long userId, String ipAddress) {
    	loginRecordDao.recordLogin(userId, ipAddress);
    }

    @Override
    public List<LoginRecordViewDTO> getRecentLogins() {
        return loginRecordDao.getRecentLogins();
    }

}



