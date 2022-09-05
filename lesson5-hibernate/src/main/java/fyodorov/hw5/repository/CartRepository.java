package fyodorov.hw5.repository;

import fyodorov.hw5.model.Cart;
import fyodorov.hw5.model.Product;
import fyodorov.hw5.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
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

    public List<Cart> findCartByProductId(Long productId) {
        List<Cart> carts = dbm.getEm().createQuery("select c from Cart c",
                Cart.class).getResultList();
        Product product = dbm.getEm().createQuery("select p from Product p where p.id = " +
                productId, Product.class).getSingleResult();
        List<Cart> result = new ArrayList<>();
        for (Cart cart : carts) {
            if (cart.getCart().contains(product)) {
                result.add(cart);
            }
        }
        return result;
    }

}
