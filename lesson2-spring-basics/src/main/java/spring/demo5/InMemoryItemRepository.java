package spring.demo5;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@Primary
public class InMemoryItemRepository implements IItemRepository {
    private List<Item> items;

    @PostConstruct
    public void init() {
        items = new ArrayList<>(Arrays.asList(
                new Item(1L, "Milk", 85),
                new Item(2L, "Bread", 25)
        ));
    }

    public Item findById(Long id) {
        return items.stream().filter(i -> i.getId().equals(id)).findFirst().get();
    }

    public List<Item> findAll() {
        return items;
    }

    public void save(Item item) {
        Long newId = items.stream().mapToLong(Item::getId).max().getAsLong() + 1;
        item.setId(newId);
        items.add(item);
    }
}
