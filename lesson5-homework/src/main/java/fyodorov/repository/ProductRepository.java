package fyodorov.repository;

import fyodorov.model.Product;

import java.util.*;

public interface ProductRepository {

    void addProduct(String title, Integer price);

    List<Product> findAll();

    Optional<Product> findById(Long id);
}
