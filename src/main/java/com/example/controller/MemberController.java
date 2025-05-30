package com.example.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.MemberDTO;
import com.example.dto.UpdateMemberDTO;
import com.example.model.Member;
import com.example.service.MemberService;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Member> getAllMembers() {
        return memberService.getAllMembers();
    }
    
    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody MemberDTO dto) {
        MemberDTO result = memberService.register(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
    
    @PatchMapping("/{id}")
    public ResponseEntity<?> updateUser(
            @PathVariable String id,
            @Valid @RequestBody UpdateMemberDTO dto) {
        memberService.updateMember(id, dto);
        return ResponseEntity.noContent().build(); // 204 No Content
    }
}

