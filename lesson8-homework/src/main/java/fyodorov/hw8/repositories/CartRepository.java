package fyodorov.hw8.repositories;

import fyodorov.hw8.items.Cart;
import fyodorov.hw8.items.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CartRepository {

    private DataBaseManager dbm;

    public CartRepository(DataBaseManager dbm) {
        this.dbm = dbm;
    }

    public void insert(Cart cart) {
        dbm.getEm().getTransaction().begin();
        dbm.getEm().persist(cart);
        dbm.getEm().getTransaction().commit();
    }

    public void save(Cart cart) {
        dbm.getEm().getTransaction().begin();
        dbm.getEm().merge(cart);
        dbm.getEm().getTransaction().commit();
    }

    public List<Cart> findCaftByProductId(Long productId) {
        Product product = dbm.getEm().find(Product.class, productId);
        return product.getCarts();
    }
}
