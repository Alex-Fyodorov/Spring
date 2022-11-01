package fyodorov.hw8.persist;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    void init();

    void addProduct(String title, Integer price);

    List<Product> findAll();

    Optional<Product> findById(Long id);
}
