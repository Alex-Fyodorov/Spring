package fyodorov.hw2;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;

@Component
public class ProductRepository {
    private List<Product> products;

    @PostConstruct
    public void init(){
        this.products = new ArrayList<>();
        this.products.add(new Product(1L, "Milk", 89));
        this.products.add(new Product(2L, "Bread", 39));
        this.products.add(new Product(3L, "Cheese", 139));
        this.products.add(new Product(4L, "Potato", 69));
        this.products.add(new Product(5L, "Carrot", 59));
    }

    public List<Product> findAll(){
        return Collections.unmodifiableList(products);
    }

    public Optional<Product> findById(long id){
        return products.stream().filter(p -> Objects.equals(p.getId(), id)).findFirst();
    }

    public Optional<Product> findByTitle(String title){
        return products.stream().filter(p -> Objects.equals(p.getTitle(), title)).findFirst();
    }
}
