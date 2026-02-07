package com.example.itemapi.service;

import com.example.itemapi.model.Item;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    private List<Item> itemList = new ArrayList<>();
    private Long idCounter = 1L;

    public Item addItem(Item item) {
        item.setId(idCounter++);
        itemList.add(item);
        return item;
    }

    public Optional<Item> getItemById(Long id) {
        return itemList.stream()
                .filter(item -> item.getId().equals(id))
                .findFirst();
    }
}
