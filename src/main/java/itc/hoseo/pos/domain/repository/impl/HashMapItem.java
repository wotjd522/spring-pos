package itc.hoseo.pos.domain.repository.impl;

import itc.hoseo.pos.domain.Item;
import itc.hoseo.pos.domain.Member;
import itc.hoseo.pos.domain.repository.ItemRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapItem implements ItemRepository {
    private final Map<Integer, Item> itemRep = new HashMap<>();
    Integer key = 1;
    @Override
    public void addItem(Item item) {
        itemRep.put(key++, item);
    }

    @Override
    public void deleteItem(int id) {
        itemRep.remove(id);
    }

    @Override
    public List<Item> findItem(String name) {
        List<Item> items = new ArrayList<>();
        for(Item i:itemRep.values()){
            if (i.getName().equals(name)){
                items.add(i);
            }
        }

        return items;
    }
}
