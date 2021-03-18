package com.To_Do_List.repository;

import com.To_Do_List.domain.Item;

import java.util.List;
import java.util.Optional;

public interface ItemRepository {
    int createItem(Item item);
    int updateItem(Item item);
    int deleteItem(long id);
    List<Item> findAll(String nick);
}
