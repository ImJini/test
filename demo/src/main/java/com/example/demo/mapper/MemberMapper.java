package com.example.demo.mapper;

import com.example.demo.domain.MemberVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {
    List<MemberVO> getMemberList();
    MemberVO selectMemberId(int id);

    void registerMember(MemberVO member);

    MemberVO getMemberById(int id);

    void updateMember(MemberVO member);

    public void delete(int id);

}
