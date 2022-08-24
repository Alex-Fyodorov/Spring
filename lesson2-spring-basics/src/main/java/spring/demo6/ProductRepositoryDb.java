package spring.demo6;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProductRepositoryDb implements ProductRepository {
    @Override
    public List<Product> findAll() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Optional<Product> findById(Long id) {
        throw new UnsupportedOperationException();
    }
}
