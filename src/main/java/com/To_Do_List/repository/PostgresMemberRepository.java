package com.To_Do_List.repository;

import com.To_Do_List.domain.Member;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PostgresMemberRepository implements MemberRepository {

    @Autowired
    private SqlSession sqlSession;

    @Autowired
    public PostgresMemberRepository(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public int createMember(Member member) {
        int n = sqlSession.insert("Member.CreateMember", member);

        if (n > 0) return 1;
        return -1;
    }

    @Override
    public int updateMember(Member member) {
        int n = sqlSession.update("Member.UpdateMember", member);

        if (n > 0) return 1;
        return -1;
    }

    @Override
    public Optional<Member> findMemberById(long id) {
        return Optional.ofNullable(sqlSession.selectOne("Member.FindMemberById", id));
    }

    @Override
    public Optional<Member> findMemberByNick(String nick) {
        return Optional.ofNullable(sqlSession.selectOne("Member.FindMemberByNick", nick));
    }

    @Override
    public List<Member> findAllMembers() {
        return sqlSession.selectList("Member.FindAllMembers");
    }

    @Override
    public int nickCheck(String nick) {
        int result = sqlSession.selectOne("Member.NickCheck", nick);
        return result;
    }
}
