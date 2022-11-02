package fyodorov.hw8;

import fyodorov.hw8.items.Product;
import fyodorov.hw8.items.User;
import fyodorov.hw8.repositories.*;
import fyodorov.hw8.services.CartService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
        DataBaseManager dbm = context.getBean("dbm", DataBaseManager.class);
        UserRepository userRepository = context.getBean("userRepository", UserRepository.class);
        ProductRepository productRepository = context.getBean("productRepository", ProductRepositoryDB.class);
        CartService cartService = context.getBean("cartService", CartService.class);

        dbm.init();
//ADD USERS
//        userRepository.insert("Alex");
//        userRepository.insert("Bob");
//        userRepository.insert("Jack");
//ADD PRODUCTS
//        productRepository.addProduct("Milk", 89);
//        productRepository.addProduct("Bread", 39);
//        productRepository.addProduct("Cheese", 139);
//        productRepository.addProduct("Potato", 26);
//        productRepository.addProduct("Carrot", 42);
//        productRepository.addProduct("Water", 15);
//
//        cartService.addToCart(1L, 1L);
//        cartService.addToCart(2L, 1L);
//        cartService.addToCart(3L, 1L);
//        cartService.addToCart(6L, 1L);
//        cartService.addToCart(6L, 3L);

        List<User> users = cartService.findUserByProductId(6L);
        List<String> names = new ArrayList<>();
        for (User user : users) {
            names.add(user.getName());
        }

        System.out.println();
        System.out.println(names);
        System.out.println();

        List<Product> products = cartService.getCurrentCart(1L);
        List<String> titles = new ArrayList<>();
        for (Product product : products) {
            titles.add(product.getTitle());
        }

        System.out.println();
        System.out.println(titles);
        System.out.println();
        System.out.println(cartService.sum(1L));
        System.out.println();

        dbm.shutdown();
    }
}
