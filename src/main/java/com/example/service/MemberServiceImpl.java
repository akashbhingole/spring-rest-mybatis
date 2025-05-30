package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.dao.MemberDao;
import com.example.dto.MemberDTO;
import com.example.dto.UpdateMemberDTO;
import com.example.mapper.MemberMapper;
import com.example.model.Member;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
    private MemberDao memberDao;
	
	@Autowired
    private MemberMapper memberMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<Member> getAllMembers() {
        return memberDao.getAllMembers();
    }
    
    @Override
    public MemberDTO register(MemberDTO dto) {
        if (memberMapper.existsById(dto.getId())) {
            throw new IllegalArgumentException("Email already exists.");
        }

        Member member = new Member();
        member.setId(dto.getId());
        member.setPassword(passwordEncoder.encode(dto.getPassword()));
        member.setUsername(dto.getUsername());
        member.setRegisteredAt("2025-05-30");

        memberDao.insertMember(member);

        MemberDTO result = new MemberDTO();
        result.setId(member.getId());
        result.setUsername(member.getUsername());
        result.setRegisteredAt(member.getRegisteredAt());
        return result;
    }
    
    @Override
    public void updateMember(String id, UpdateMemberDTO dto) {
        String encodedPassword = null;
        if (dto.getPassword() != null) {
            encodedPassword = passwordEncoder.encode(dto.getPassword());
        }

        String username = dto.getUsername();
        
        memberDao.updateMember(id,encodedPassword,username);

    }
}
