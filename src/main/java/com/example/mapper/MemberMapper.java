package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.model.Member;

@Mapper
public interface MemberMapper {
	List<Member> findAll();
	
    void insertMember(Member member);
    boolean existsById(@Param("id") String id);
    
    void updateMember(@Param("id") String id,
            @Param("password") String password,
            @Param("username") String username);

}
