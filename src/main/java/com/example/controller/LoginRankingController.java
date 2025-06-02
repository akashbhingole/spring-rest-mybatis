package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.LoginRankingDTO;
import com.example.service.LoginRankingService;

@RestController
@RequestMapping("/api/rankings")
public class LoginRankingController {

    @Autowired
    private LoginRankingService loginRankingService;

    @GetMapping("/weekly-logins")
    public ResponseEntity<List<LoginRankingDTO>> getLoginRankings() {
        return ResponseEntity.ok(loginRankingService.getWeeklyRanking());
    }
}




