package fyodorov.hw5.service;

import fyodorov.hw5.model.Cart;
import fyodorov.hw5.model.Product;
import fyodorov.hw5.model.User;
import fyodorov.hw5.repository.CartRepository;
import fyodorov.hw5.repository.interfaces.ProductRepository;
import fyodorov.hw5.repository.interfaces.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class CartService {
    private ProductRepository productRepository;
    private UserRepository userRepository;
    private CartRepository cartRepository;

    public CartService(ProductRepository productRepository, UserRepository userRepository, CartRepository cartRepository) {
        this.productRepository = productRepository;
        this.userRepository = userRepository;
        this.cartRepository = cartRepository;
    }

    public User addCart(Long userId) {
        User user = userRepository.findById(userId);
        if (user.getCart() == null) {
            Cart cart = new Cart(user);
            user.setCart(cart);
            userRepository.save(user);
        }
        return user;
    }

    public void addToCart(Long productId, Long userId) {
        User user = addCart(userId);
        user.getCart().add(productRepository.findById(productId).get());
        cartRepository.save(user.getCart());
    }

    public void clearingCart(Long userId) {
        User user = addCart(userId);
        user.getCart().clear();
        cartRepository.save(user.getCart());
    }

    public void removeFromCart(Long productId, Long userId) {
        User user = addCart(userId);
        user.getCart().removeFromCart(productRepository.findById(productId).get());
        cartRepository.save(user.getCart());
    }

    public Integer sum(Long userId) {
        User user = addCart(userId);
        int sum = 0;
        for (Product product : user.getCart().getCart()) {
            sum += product.getPrice();
        }
        return sum;
    }

    public List<Product> getCurrentCart(Long userId) {
        User user = addCart(userId);
        return Collections.unmodifiableList(user.getCart().getCart());
    }

    public List<User> findUserByProductId(Long productId) {
        List<Cart> carts = cartRepository.findCartByProductId(productId);
        List<User> users = new ArrayList<>();
        for (Cart cart : carts) {
            users.add(cart.getUser());
        }
        return users;
    }
}
