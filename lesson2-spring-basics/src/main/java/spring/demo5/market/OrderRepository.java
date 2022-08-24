package spring.demo5.market;

import org.springframework.stereotype.Component;

@Component
public interface OrderRepository {
    void save(Order order);
}
