package fyodorov.hw4.persist;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@Scope("prototype")
public class Cart {
    private List<Product> cart;

    public Cart() {
        this.cart = new ArrayList<>();
    }

    public List<Product> getCart() {
        return cart;
    }

    public void add(Product product){
        cart.add(product);
    }

    public void removeFromCart(Product product) {
        cart.remove(product);
    }

    public void clear(){
        cart.clear();
    }

    @Override
    public String toString() {
        return "Cart{" +
                "products=" + cart +
                '}';
    }
}
