package fyodorov.hw8.services;

import fyodorov.hw8.items.Product;
import fyodorov.hw8.repositories.CartRepository;
import fyodorov.hw8.repositories.ProductRepository;
import fyodorov.hw8.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;
    private CartRepository cartRepository;
    private UserRepository userRepository;

    public ProductService(ProductRepository productRepository, CartRepository cartRepository, UserRepository userRepository) {
        this.productRepository = productRepository;
        this.cartRepository = cartRepository;
        this.userRepository = userRepository;
    }

    public List<Product> listOfProduct(Integer min, Integer max) {
        List<Product> productList;
        if (min != null || max != null) {
            productList = productRepository.priceFilter(min, max);
        } else {
            productList = productRepository.findAll();
        }

//        if (min != null) {
//            if (max != null) {
//                productList = productRepository.findProductByPriceBetween(min, max);
//            } else {
//                productList = productRepository.findProductByPriceGreaterThan(min);
//            }
//        } else {
//            if (max != null) {
//                productList = productRepository.findProductByPriceBetween(Integer.valueOf(0), max);
//            } else {
//                productList = productRepository.findAll();
//            }
//        }
        return productList;
    }

    public Product findById(Long id) {
        return productRepository.findById(id).get();
    }

    public void save(String title, Integer price) {
        productRepository.save(new Product(title, price));
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
