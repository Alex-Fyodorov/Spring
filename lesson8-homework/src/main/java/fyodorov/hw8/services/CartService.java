package fyodorov.hw8.services;

import fyodorov.hw8.items.Cart;
import fyodorov.hw8.items.Product;
import fyodorov.hw8.items.User;
import fyodorov.hw8.repositories.CartRepository;
import fyodorov.hw8.repositories.ProductRepositoryDB;
import fyodorov.hw8.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class CartService {

    private ProductRepositoryDB productRepository;
    private CartRepository cartRepository;
    private UserRepository userRepository;

    public CartService(ProductRepositoryDB productRepository,
                       UserRepository userRepository, CartRepository cartRepository) {
        this.productRepository = productRepository;
        this.cartRepository = cartRepository;
        this.userRepository = userRepository;
    }

    public User addCart (Long userId) {
        User user = userRepository.findById(userId).get();
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
        List<Cart> carts = productRepository.findById(productId).get().getCarts();
        List<User> users = new ArrayList<>();
        for (Cart cart : carts) {
            users.add(cart.getUser());
        }
        return users;
    }
}
