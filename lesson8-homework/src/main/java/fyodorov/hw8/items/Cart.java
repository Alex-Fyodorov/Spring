package fyodorov.hw8.items;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

@Entity
@Getter
@Setter
@Table(name = "carts")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany
    @JoinTable(
            name = "cart_products",
            joinColumns = @JoinColumn(name = "cart_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> cart;

    public Cart() {
        this.cart = new ArrayList<>();
    }

    public Cart(User user) {
        this.user = user;
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
