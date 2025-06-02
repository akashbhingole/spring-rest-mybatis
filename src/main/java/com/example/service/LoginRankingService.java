package com.example.service;

import java.util.List;

import com.example.dto.LoginRankingDTO;


public interface LoginRankingService {
	public List<LoginRankingDTO> getWeeklyRanking();
}

