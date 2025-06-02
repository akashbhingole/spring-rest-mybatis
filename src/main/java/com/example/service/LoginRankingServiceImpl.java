package com.example.service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.LoginRankingDao;
import com.example.dto.LoginRankingDTO;

@Service
public class LoginRankingServiceImpl implements LoginRankingService {

	@Autowired
	LoginRankingDao loginRankingDao;
	
	@Override
	public List<LoginRankingDTO> getWeeklyRanking() {
	    LocalDate now = LocalDate.now();
	    LocalDate monday = now.with(DayOfWeek.MONDAY);
	    LocalDate sunday = now.with(DayOfWeek.SUNDAY);
	    
	    LocalDateTime start = monday.atStartOfDay();
	    LocalDateTime end = sunday.atTime(LocalTime.MAX);

	    List<LoginRankingDTO> raw = loginRankingDao.getWeeklyLoginRankings(start, end, 20);

	    if (raw.isEmpty()) {
	        // Collections.singletonList(new LoginRankingDTO(null, 0, null, null));
	    }

	    List<LoginRankingDTO> ranked = new ArrayList<>();
	    int currentRank = 1;
	    int lastLoginCount = -1;
	    int tieCount = 0;

	    for (int i = 0; i < raw.size(); i++) {
	        LoginRankingDTO record = raw.get(i);

	        if (record.getLoginCount() != lastLoginCount) {
	            currentRank = i + 1;
	            tieCount = 1;
	        } else {
	            tieCount++;
	        }

	        record.setRank(currentRank);
	        record.setTieCount(tieCount);
	        ranked.add(record);

	        lastLoginCount = record.getLoginCount();
	    }

	    return ranked;
	}

}

