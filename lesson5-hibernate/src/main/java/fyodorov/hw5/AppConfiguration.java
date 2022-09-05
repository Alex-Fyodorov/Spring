package fyodorov.hw5;

import fyodorov.hw5.repository.CartRepository;
import fyodorov.hw5.repository.DataBaseManager;
import fyodorov.hw5.repository.ProductRepositoryDB;
import fyodorov.hw5.repository.UserRepositoryImpl;
import fyodorov.hw5.repository.interfaces.ProductRepository;
import fyodorov.hw5.repository.interfaces.UserRepository;
import fyodorov.hw5.service.CartService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("fyodorov.hw5")
public class AppConfiguration {

    @Bean
    public DataBaseManager dbm() {
        return new DataBaseManager();
    }

    @Bean
    public UserRepository userRepository(DataBaseManager dbm) {
        return new UserRepositoryImpl(dbm);
    }

    @Bean
    public ProductRepository productRepository(DataBaseManager dbm) {
        return new ProductRepositoryDB(dbm);
    }

    @Bean
    public CartRepository cartRepository(DataBaseManager dbm) {return new CartRepository(dbm); }

    @Bean
    public CartService cartService(ProductRepository productRepository, UserRepository userRepository, CartRepository cartRepository) {
        return new CartService(productRepository, userRepository, cartRepository);
    }
}
