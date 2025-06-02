package com.example.dao;

import java.time.LocalDateTime;
import java.util.List;

import com.example.dto.LoginRankingDTO;

public interface LoginRankingDao {
	List<LoginRankingDTO> getWeeklyLoginRankings(LocalDateTime start,LocalDateTime end,int limit);
}
