package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.LoginRecordViewDTO;
import com.example.service.LoginRecordService;

@RestController
@RequestMapping("/api/login-records")
public class LoginRecordController {

    @Autowired
    private LoginRecordService loginRecordService;

    @GetMapping
    public ResponseEntity<List<LoginRecordViewDTO>> getLoginRecords() {
        return ResponseEntity.ok(loginRecordService.getRecentLogins());
    }
}



