package spring.demo6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;


@Service
public class OrderService {
    private UserService userService;
    private CartService cartService;
    private ProductService productService;

    @Autowired
    public OrderService(UserService userService, CartService cartService, ProductService productService) {
        this.userService = userService;
        this.cartService = cartService;
        this.productService = productService;
    }

    public Order createNewOrder() {
        Order order = new Order();

        order.setId(UUID.randomUUID().toString());

        User currentUser = userService.getCurrentUser();
        order.setUser(currentUser);

        Cart currentCart = cartService.getCurrentCart();

        for (Product p : currentCart.getProducts()) {
            if (!productService.isProductIdExist(p.getId())) {
                throw new RuntimeException("What???");
            }
        }

        order.setProducts(new ArrayList<>(currentCart.getProducts()));
        cartService.clearCurrentCart();

        return order;
    }
}
