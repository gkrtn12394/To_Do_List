package com.To_Do_List.service;

import com.To_Do_List.domain.Item;
import com.To_Do_List.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }

    public long create(Item item){
        itemRepository.createItem(item);
        return item.getId();
    }

    public long update(Item item){
        itemRepository.updateItem(item);
        return item.getId();
    }

    public long delete(long id){
        itemRepository.deleteItem(id);
        return id;
    }

    public List<Item> findAll(String nick){
        return itemRepository.findAll(nick);
    }
}
