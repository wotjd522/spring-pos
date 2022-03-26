package itc.hoseo.pos.domain.repository;

import itc.hoseo.pos.domain.Item;

import java.util.List;

public interface ItemRepository {
    public void addItem(Item item);
    public void deleteItem(int id);
    public List<Item> findItem(String name);
}
