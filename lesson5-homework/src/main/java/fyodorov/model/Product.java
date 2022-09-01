package fyodorov.model;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "Product title cannot be empty")
    private String title;

    @Column(nullable = false)
    @Min(value = 10, message = "The price cannot be lower than 10 eurodollars")
    private int price;

    public Product(String title, int price) {
        this.title = title;
        this.price = price;
    }
}
