package fyodorov.hw8.repositories;

import fyodorov.hw8.items.Cart;
import fyodorov.hw8.items.Product;
import fyodorov.hw8.items.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {

    private DataBaseManager dbm;

    public UserRepository(DataBaseManager dbm) {
        this.dbm = dbm;
    }

    public void insert(String name) {
        dbm.getEm().getTransaction().begin();
        dbm.getEm().persist(new User(name));
        dbm.getEm().getTransaction().commit();
    }

    public void save(User user) {
        dbm.getEm().getTransaction().begin();
        dbm.getEm().merge(user);
        dbm.getEm().getTransaction().commit();
    }

    public Optional<User> findById(Long id) {
        Optional<User> user = Optional.ofNullable(dbm.getEm().find(User.class, id));
        return user;
    }

    public List<User> findAll() {
        List<User> users = dbm.getEm().createQuery("select u from User u", User.class).getResultList();
        return users;
    }

    public void deleteById(Long id) {
        dbm.getEm().getTransaction().begin();
        dbm.getEm().createQuery("delete u from User u where u.id = :id")
                .setParameter("id", id)
                .executeUpdate();
        dbm.getEm().getTransaction().commit();
    }

    public List<User> findUserByProductId(Long productId) {
        Optional<Product> product = Optional.ofNullable(dbm.getEm().find(Product.class, productId));
        List<Cart> carts = product.get().getCarts();
        List<User> users = new ArrayList<>();
        for (Cart cart : carts) {
            users.add(cart.getUser());
        }
        return users;
    }
}
