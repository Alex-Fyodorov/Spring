package fyodorov.controller;

import fyodorov.model.Product;
import fyodorov.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductRepository productRepository;

    @GetMapping
    public List<Product> productPage(
            @RequestParam(required = false) BigDecimal min,
            @RequestParam(required = false) BigDecimal max) {
        List<Product> productList;
        if (min != null) {
            if (max != null) {
                productList = productRepository.findProductByMaxPrice(min, max);
            } else {
                productList = productRepository.findProductByPrice(min);
            }
        } else {
            if (max != null) {
                productList = productRepository.findProductByMaxPrice(BigDecimal.valueOf(0), max);
            } else {
                productList = productRepository.findAll();
            }
        }
        return productList;
    }

    @GetMapping("/{id}")
    public Product productById(@PathVariable Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            return product.get();
        }
        return null;
    }

    @GetMapping("/delete/{id}")
    public List<Product> deleteProduct(@PathVariable Long id) {
        productRepository.deleteById(id);
        List<Product> productList = productRepository.findAll();
        return productList;
    }

    @PostMapping("/insert")
    public List<Product> saveProduct(@RequestBody Product product) {
        productRepository.save(product);
        List<Product> productList = productRepository.findAll();
        return productList;
    }
}
