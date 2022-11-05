package fyodorov.hw8.repositories;

import fyodorov.hw8.items.Cart;
import fyodorov.hw8.items.Product;
import fyodorov.hw8.items.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
//
//    @Query(value = "select * from carts c where c.id = " +
//            "(select cart_id from cart_products where product_id = :id)", nativeQuery = true)
//    public List<Cart> findCartByProductId(Long productId);
//
//    @Query(value = "select * from carts c where c.id = " +
//            "(select cart_id from cart_products where product_id = :id)", nativeQuery = true)
//    List<User> findUserByProductId(Long id);
//
//    Cart findCartByUserId(Long userId);
}
