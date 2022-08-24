package spring.demo2;

import java.util.List;

public interface ItemRepository {
    List<Item> findAll();
    Item findItemById(Long id);
    void save(Item item);
}
