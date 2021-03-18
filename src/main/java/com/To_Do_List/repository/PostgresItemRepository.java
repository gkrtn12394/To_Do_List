package com.To_Do_List.repository;

import com.To_Do_List.domain.Item;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostgresItemRepository implements ItemRepository{

    private SqlSession sqlSession;

    @Autowired
    public PostgresItemRepository(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public int createItem(Item item) {
        int n = sqlSession.insert("Item.CreateItem", item);

        if (n > 0) return 1;
        return -1;
    }

    @Override
    public int updateItem(Item item) {
        int n = sqlSession.update("Item.UpdateItem", item);

        if (n > 0) return 1;
        return -1;
    }

    @Override
    public int deleteItem(long id) {
        int n = sqlSession.delete("Item.DeleteItem", id);

        if (n > 0) return 1;
        return -1;
    }

    @Override
    public List<Item> findAll(String nick) {
        return sqlSession.selectList("Item.FindItems", nick);
    }
}
