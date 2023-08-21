package com.example.demo.service;

import com.example.demo.domain.MemberVO;
import com.example.demo.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    @Autowired
    MemberMapper memberMapper;

    public List<MemberVO> getMemberList() {
        return memberMapper.getMemberList();
    }

    public void registerMember(MemberVO member){
       memberMapper.registerMember(member);
    }

    public MemberVO getMemberById(int id) {
        return memberMapper.getMemberById(id);
    }

    public void updateMember(MemberVO member) {
        memberMapper.updateMember(member);
    }

    public void delete(int id) {
        memberMapper.delete(id);
    }
}
