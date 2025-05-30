package com.example.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.mapper.MemberMapper;
import com.example.model.Member;

@Repository
public class MemberDaoImpl implements MemberDao {

    @Autowired
    private MemberMapper memberMapper;


    @Override
    public List<Member> getAllMembers() {
        return memberMapper.findAll();
    }


	@Override
	public void insertMember(Member member) {
		memberMapper.insertMember(member);
	}

	@Override
	public void updateMember(String id,String encodedPassword ,String username) {
		memberMapper.updateMember(id, encodedPassword, username);
	}
    
}
