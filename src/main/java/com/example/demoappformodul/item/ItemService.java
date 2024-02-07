package com.example.demoappformodul.item;

import com.example.demomodule.item.Item;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ItemService {
    List<Item> getAllItems();
    Item getItemById(Long itemId);

    Item createItem(Item newItem);
    Item UpdateItem(Item UpdatedItem);
    void deleteItem(Long itemId);

}
