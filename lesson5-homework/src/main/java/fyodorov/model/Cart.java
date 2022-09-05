package fyodorov.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.*;

@Entity
@Component
@Scope("prototype")
@Getter
@Setter
@ToString
@Table(name = "carts")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @Column(nullable = false, unique = true)
    private Long userId;

    @ManyToMany(mappedBy = "carts")
    @Column
    private List<Product> cart;

    public Cart() {
        this.cart = new ArrayList<>();
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
}