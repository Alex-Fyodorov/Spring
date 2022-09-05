package fyodorov.hw5.model;

import lombok.*;
import javax.persistence.*;
import javax.persistence.Table;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String title;

    @Column(nullable = false)
    private int price;

    @ManyToMany
    private List<Cart> carts;

    public Product(String title, int price) {
        this.title = title;
        this.price = price;
    }
}
