package spring.demo6;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public boolean isProductIdExist(Long id) {
        return productRepository.findAll().stream().anyMatch(p -> p.getId().equals(id));
    }
}
