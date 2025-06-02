package com.example.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.dto.LoginRankingDTO;
import com.example.mapper.LoginRankingMapper;

@Repository
public class LoginRankingDaoImpl implements LoginRankingDao {

	@Autowired
    private LoginRankingMapper loginRankingMapper;
	

	@Override
	public List<LoginRankingDTO> getWeeklyLoginRankings(LocalDateTime start, LocalDateTime end, int limit) {
		List<LoginRankingDTO> raw = loginRankingMapper.getWeeklyLoginRankings(start, end, 20);
		return raw;
	}
}
