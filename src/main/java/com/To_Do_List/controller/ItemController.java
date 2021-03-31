package com.To_Do_List.controller;

import com.To_Do_List.controller.form.ItemForm;
import com.To_Do_List.domain.Item;
import com.To_Do_List.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService){
        this.itemService = itemService;
    }

    // Item 추가
    @GetMapping("/item/create")
    public String createItem() {
        return "item/create";
    }

    @PostMapping("/item/create")
    public String createItemForm(ItemForm form) {
        Item item = new Item();
        item.setId(form.getId());
        item.setTitle(form.getTitle());
        item.setNote(form.getNote());
        item.setStatus(form.getStatus());
        item.setRegDate(form.getRegDate());
        item.setDueDate(form.getDueDate());

        itemService.create(item);

        return "redirect:/";
    }

    // Item 삭제
    @PostMapping("/item/delete")
    public String deleteItem(@RequestParam(name="id") String id) {
        itemService.delete(Long.parseLong(id));

        return "redirect:/";
    }

    // Item update
    @PostMapping("/item/update")
    public String updateItem(@ModelAttribute(name="item") Item item) {
        itemService.update(item);

        return "redirect:/";
    }

    // Item FindAll
    @GetMapping("/items")
    public String findAll(@RequestParam(name="nick") String nick) {
        List<Item> item = itemService.findAll(nick);

        return "redirect:/";
    }
}
