package com.To_Do_List.repository;

import com.To_Do_List.domain.Item;

import java.util.List;
import java.util.Optional;

public interface ItemRepository {
    Item save(Item item);
    Optional<Item> findById(long id);
    Optional<Item> findByName(String name);
    void updateById(long id, Item item);
    List<Item> findAll();
}
