package fyodorov.repository;

import fyodorov.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "select * from products p where p.price >= :min and p.price <= :max", nativeQuery = true)
    List<Product> findProductByMaxPrice(BigDecimal min, BigDecimal max);

    @Query(value = "select * from products p where p.price >= :min", nativeQuery = true)
    List<Product> findProductByPrice(BigDecimal min);
}
