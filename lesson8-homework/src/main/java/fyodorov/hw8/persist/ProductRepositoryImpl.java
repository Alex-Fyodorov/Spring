package fyodorov.hw8.persist;

import org.springframework.stereotype.Repository;
import javax.annotation.PostConstruct;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    private List<Product> products;
    private AtomicLong identity = new AtomicLong(0);

    @Override
    @PostConstruct
    public void init(){
        this.products = new ArrayList<>();
        this.addProduct("Milk", 89);
        this.addProduct("Bread", 39);
        this.addProduct("Cheese", 139);
        this.addProduct("Potato", 69);
        this.addProduct("Carrot", 59);
    }

    @Override
    public void addProduct(String title, Integer price) {
        products.add(new Product(identity.incrementAndGet(), title, price));
    }

    @Override
    public List<Product> findAll(){
        return Collections.unmodifiableList(products);
    }

    @Override
    public Optional<Product> findById(Long id){
        return products.stream().filter(p -> Objects.equals(p.getId(), id)).findFirst();
    }

    public Optional<Product> findByTitle(String title){
        return products.stream().filter(p -> Objects.equals(p.getTitle(), title)).findFirst();
    }
}
