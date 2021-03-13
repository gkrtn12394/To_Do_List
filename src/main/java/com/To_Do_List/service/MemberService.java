package com.To_Do_List.service;

import com.To_Do_List.domain.Member;
import com.To_Do_List.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    private MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    public long create(Member member){
        memberRepository.createMember(member);
        return member.getId();
    }

    public long update(Member member){
        memberRepository.updateMember(member);
        return member.getId();
    }

    public Optional<Member> findByID(long id){
        return memberRepository.findMemberById(id);
    }

    public Optional<Member> findByNick(String nick){
        return memberRepository.findMemberByNick(nick);
    }

    public List<Member> findAll(){
        return memberRepository.findAllMembers();
    }
}
