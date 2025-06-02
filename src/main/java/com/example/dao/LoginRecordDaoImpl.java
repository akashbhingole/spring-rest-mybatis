package com.example.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.dto.LoginRecordViewDTO;
import com.example.mapper.LoginRecordMapper;

@Repository
public class LoginRecordDaoImpl implements LoginRecordDao {

    @Autowired
    private LoginRecordMapper loginRecordMapper;

    @Override
    public void recordLogin(Long userId, String ipAddress) {
    	loginRecordMapper.insertLoginRecord(userId, ipAddress, LocalDateTime.now());
    }

    @Override
    public List<LoginRecordViewDTO> getRecentLogins() {
        return loginRecordMapper.findLatestRecords(30);
    }

    
}
