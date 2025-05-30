package com.example.dao;

import java.util.List;

import com.example.model.Member;

public interface MemberDao {
    List<Member> getAllMembers();
    
    void insertMember(Member member);
    
    public void updateMember(String id,String encodedPassword ,String username);
}
