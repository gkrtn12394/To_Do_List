package com.To_Do_List.repository;

import com.To_Do_List.domain.Follow;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PostgresFollowRepository implements FollowRepository {

    private SqlSession sqlSession;

    @Autowired
    public PostgresFollowRepository(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public Follow save(Follow follow) {
        return null;
    }

    @Override
    public Optional<Follow> findById(long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Follow> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public void updateById(long id, Follow follow) {

    }

    @Override
    public List<Follow> findAll() {
        return null;
    }
}
