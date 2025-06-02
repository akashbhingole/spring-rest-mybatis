package com.example.mapper;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.dto.LoginRecordViewDTO;

@Mapper
public interface LoginRecordMapper {

	void insertLoginRecord(@Param("userId") Long userId,
	        @Param("ipAddress") String ipAddress,
	        @Param("loginTime") LocalDateTime loginTime);
	
	List<LoginRecordViewDTO> findLatestRecords(@Param("limit") int limit);
	

}

