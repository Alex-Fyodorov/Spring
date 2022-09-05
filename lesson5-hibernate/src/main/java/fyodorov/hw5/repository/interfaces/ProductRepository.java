package fyodorov.hw5.repository.interfaces;

import fyodorov.hw5.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    void addProduct(String title, Integer price);

    List<Product> findAll();

    Optional<Product> findById(Long id);
}
