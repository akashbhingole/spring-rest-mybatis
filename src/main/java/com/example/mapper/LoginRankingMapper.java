package com.example.mapper;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.dto.LoginRankingDTO;

@Mapper
public interface LoginRankingMapper {

	List<LoginRankingDTO> getWeeklyLoginRankings(@Param("start") LocalDateTime startOfWeek,
            @Param("end") LocalDateTime endOfWeek,
            @Param("limit") int limit);
}

