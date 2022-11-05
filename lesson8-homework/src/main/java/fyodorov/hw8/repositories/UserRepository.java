package fyodorov.hw8.repositories;

import fyodorov.hw8.items.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

//    @Query(value = "select user_id from carts c where id = " +
//            "(select cart_id from cart_products where product_id = :id)", nativeQuery = true)
//    List<User> findUserByProductId(Long id);
//
//    @Query(value = "select * from cart_products where product_id = :id", nativeQuery = true)
//    List<User> findCartByProductId(Long id);
}
