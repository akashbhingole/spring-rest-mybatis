package com.example.service;

import java.util.List;

import com.example.dto.MemberDTO;
import com.example.dto.UpdateMemberDTO;
import com.example.model.Member;


public interface MemberService {
    
    public List<Member> getAllMembers();
    
    public MemberDTO register(MemberDTO dto);
    
    public void updateMember(String id, UpdateMemberDTO dto);
}

