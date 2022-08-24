package spring.market2;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.List;

@Repository
public class ProductRepositoryDao implements ProductRepository {

    @PostConstruct
    public void init() {
    }

    public ProductRepositoryDao() {
    }

    @Override
    public List<Product> getAllProducts() {
        return Collections.emptyList();
    }

    @Override
    public void addProduct(Product product) {
    }
}
