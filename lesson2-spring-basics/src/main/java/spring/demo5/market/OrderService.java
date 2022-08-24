package spring.demo5.market;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderService {
    private OrderRepository orderRepository;
    private UserService userService;
    private ItemService itemService;

    @Autowired
    public OrderService(OrderRepository orderRepository, UserService userService, ItemService itemService) {
        this.orderRepository = orderRepository;
        this.userService = userService;
        this.itemService = itemService;
    }

    public void createOrder(String username, List<Long> itemsIds) {
        Order order = new Order();
        User user = userService.findByUsername(username);
        // order.setUser(user);
        List<Item> items = itemService.findByIds(itemsIds);
        // order.setItems(items);
        orderRepository.save(order);
    }
}
