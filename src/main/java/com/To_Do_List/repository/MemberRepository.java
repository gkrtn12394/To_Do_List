package com.To_Do_List.repository;

import com.To_Do_List.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    int createMember(Member member);
    int updateMember(Member member);
    Optional<Member> findMemberById(long id);
    Optional<Member> findMemberByNick(String nick);
    List<Member> findAllMembers();
}
