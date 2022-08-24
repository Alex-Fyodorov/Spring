package spring.demo5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ItemService {
    private IItemRepository itemRepository;

    @Autowired
    public void setItemRepository(IItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public int getSumPrice() {
        return itemRepository.findAll().stream().mapToInt(Item::getPrice).sum();
    }

    public Item findById(Long id) {
        return itemRepository.findById(id);
    }

    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    public void save(Item item) {
        itemRepository.save(item);
    }
}
