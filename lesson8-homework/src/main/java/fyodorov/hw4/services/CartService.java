package fyodorov.hw4.services;

import fyodorov.hw4.persist.Cart;
import fyodorov.hw4.persist.Product;
import fyodorov.hw4.persist.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CartService {
    private Cart cart;
    private ProductRepository productRepository;

    @Autowired
    public CartService(Cart cart, ProductRepository productRepository) {
        this.cart = cart;
        this.productRepository = productRepository;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public List<Product> getCurrentCart() {
        return Collections.unmodifiableList(cart.getCart());
    }

    public Integer sum() {
        int sum = 0;
        for (Product product : cart.getCart()) {
            sum += product.getPrice();
        }
        return sum;
    }

    public void addToCartByProductId(Long productId) {
        cart.add(productRepository.findById(productId).get());
    }

    public void removeFromCart(long id) {
        cart.removeFromCart(productRepository.findById(id).get());
    }

    public void clearingCart() {
        cart.clear();
    }
}
