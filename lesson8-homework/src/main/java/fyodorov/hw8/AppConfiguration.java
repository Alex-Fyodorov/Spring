package fyodorov.hw8;

import fyodorov.hw8.repositories.*;
import fyodorov.hw8.services.CartService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("fyodorov.hw8")
public class AppConfiguration {

    @Bean
    public DataBaseManager dbm() {
        return new DataBaseManager();
    }

    @Bean
    public UserRepository userRepository(DataBaseManager dbm) {
        return new UserRepository(dbm);
    }

    @Bean
    public ProductRepository productRepository(DataBaseManager dbm) {
        return new ProductRepositoryDB(dbm);
    }

    @Bean
    public CartRepository cartRepository(DataBaseManager dbm) {return new CartRepository(dbm); }

    @Bean
    public CartService cartService(ProductRepositoryDB productRepository, UserRepository userRepository, CartRepository cartRepository) {
        return new CartService(productRepository, userRepository, cartRepository);
    }
}
