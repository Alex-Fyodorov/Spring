package fyodorov.hw2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    private Cart cart;
    private ProductRepository productRepository;

    @Autowired
    public CartService(Cart cart, ProductRepository productRepository) {
        this.cart = cart;
        this.productRepository = productRepository;
    }

    public void setCart(Cart cart){
        this.cart = cart;
    }

    public Cart getCurrentCart(){
        return cart;
    }

    public void addToCartByProductId(Long productId) {
        Product product = productRepository.findById(productId).get();
        cart.add(product);
    }

    public void addToCartByProductTitle(String title) {
        Product product = productRepository.findByTitle(title).get();
        cart.add(product);
    }

    public void removeFromCartById(long id){
        cart.removeById(id);
    }

    public void removeFromCartByTitle(String title){
        cart.removeByTitle(title);
    }

    public void clearingCart(){
        cart.clear();
    }

}
