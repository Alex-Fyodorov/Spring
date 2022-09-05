package fyodorov.hw5;

import fyodorov.hw5.repository.*;
import fyodorov.hw5.repository.interfaces.ProductRepository;
import fyodorov.hw5.repository.interfaces.UserRepository;
import fyodorov.hw5.service.CartService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainHW {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
        DataBaseManager dbm = context.getBean("dbm", DataBaseManager.class);
        UserRepository userRepository = context.getBean("userRepository", UserRepositoryImpl.class);
        ProductRepository productRepository = context.getBean("productRepository", ProductRepositoryDB.class);
        CartService cartService = context.getBean("cartService", CartService.class);

        dbm.init();
//ADD USERS
        userRepository.insert("Alex");
        userRepository.insert("Bob");
        userRepository.insert("Jack");
//ADD PRODUCTS
        productRepository.addProduct("Milk", 89);
        productRepository.addProduct("Bread", 39);
        productRepository.addProduct("Cheese", 139);
        productRepository.addProduct("Potato", 26);
        productRepository.addProduct("Carrot", 42);
        productRepository.addProduct("Water", 15);

        cartService.addToCart(1L, 1L);
        cartService.addToCart(2L, 1L);
        cartService.addToCart(3L, 1L);
        cartService.addToCart(6L, 1L);
        cartService.addToCart(6L, 3L);

        System.out.println(cartService.getCurrentCart(1L));
        System.out.println(cartService.sum(1L));

        System.out.println(cartService.findUserByProductId(6L));

        dbm.shutdown();
    }
}
