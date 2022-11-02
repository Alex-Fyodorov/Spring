package fyodorov.hw8.repositories;

import fyodorov.hw8.items.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    void addProduct(String title, Integer price);

    List<Product> findAll();

    Optional<Product> findById(Long id);
}
