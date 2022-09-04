package fyodorov.hw4.persist;

import org.springframework.stereotype.Repository;
import javax.annotation.PostConstruct;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ProductRepository {
    private List<Product> products;
    private AtomicLong identity = new AtomicLong(0);

    @PostConstruct
    public void init(){
        this.products = new ArrayList<>();
        this.addProduct("Milk", 89);
        this.addProduct("Bread", 39);
        this.addProduct("Cheese", 139);
        this.addProduct("Potato", 69);
        this.addProduct("Carrot", 59);
    }

    public void addProduct(String title, Integer price) {
        products.add(new Product(identity.incrementAndGet(), title, price));
    }

    public List<Product> findAll(){
        return Collections.unmodifiableList(products);
    }

    public Optional<Product> findById(Long id){
        return products.stream().filter(p -> Objects.equals(p.getId(), id)).findFirst();
    }

    public Optional<Product> findByTitle(String title){
        return products.stream().filter(p -> Objects.equals(p.getTitle(), title)).findFirst();
    }
}
