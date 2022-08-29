package fyodorov.hw4.persist;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class Product {

    private Long id;

    @NotBlank(message = "Product title cannot be empty")
    private String title;

    @Min(value = 10, message = "The price cannot be lower than 10 eurodollars")
    private int price;

    public Product() {
    }

    public Product(long id, String title, int price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                '}';
    }
}
