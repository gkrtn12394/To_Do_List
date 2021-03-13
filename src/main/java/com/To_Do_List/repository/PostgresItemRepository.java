package com.To_Do_List.repository;

import com.To_Do_List.domain.Item;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PostgresItemRepository implements ItemRepository{

    private SqlSession sqlSession;

    @Autowired
    public PostgresItemRepository(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public Item save(Item item) {
        return null;
    }

    @Override
    public Optional<Item> findById(long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Item> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public void updateById(long id, Item item) {

    }

    @Override
    public List<Item> findAll() {
        return null;
    }
}
