package fyodorov.hw8.repositories;

import fyodorov.hw8.items.Cart;
import fyodorov.hw8.items.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

//    @Query(value = "select * from products p join cart_products where p.id = " +
//            "(select cart_id from cart_products where product_id = :id)", nativeQuery = true)
//    List<Cart> findCartByProductId(Long id);

    List<Product> findProductByPriceBetween(int min, int max);

    List<Product> findProductByPriceGreaterThan(int min);

    @Query(value = "select * from products p where (:min is null or p.price >= :min) and (:max is null or p.price <= :max)",
            countQuery = "select count(*) from products p where (:min is null or p.price >= :min) and (:max is null or p.price <= :max)",
            nativeQuery = true)
    Page<Product> priceFilter(Integer min, Integer max, Pageable pageable);
}
