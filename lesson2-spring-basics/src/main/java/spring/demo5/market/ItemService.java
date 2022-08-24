package spring.demo5.market;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ItemService {
    List<Item> findByIds(List<Long> itemsIds);
}
