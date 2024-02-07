package com.example.demoappformodul.item;

import com.example.demomodule.item.Item;
import com.example.demomodule.item.ItemRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ItemServiceImpl implements ItemService {
    private ItemRepository repository;

    @Autowired
    public ItemServiceImpl(ItemRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Item> getAllItems() {
        return repository.findAll();
    }

    @Override
    public Item getItemById(Long itemId) {
        return repository.findById(itemId).orElse(null);
    }

    @Override
    public Item createItem(Item newItem) {
        return repository.save(newItem);
    }

    @Override
    public Item UpdateItem(Item updatedItem) {
        Optional<Item> item = repository.findById(updatedItem.getId());
        if (item.isPresent()){
            try{
                return repository.save(updatedItem);

            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }else {
            throw new EntityNotFoundException();
        }
        return null;
    }

    @Override
    public void deleteItem(Long itemId) {
        try{
            repository.deleteById(itemId);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
