package fyodorov.hw5.repository;

import fyodorov.hw5.model.Cart;
import fyodorov.hw5.model.Product;
import fyodorov.hw5.model.User;
import fyodorov.hw5.repository.interfaces.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private DataBaseManager dbm;

    public UserRepositoryImpl(DataBaseManager dbm) {
        this.dbm = dbm;
    }

    @Override
    public void insert(String name) {
        dbm.getEm().getTransaction().begin();
        dbm.getEm().persist(new User(name));
        dbm.getEm().getTransaction().commit();
    }

    @Override
    public User findById(Long id) {
        User user = dbm.getEm().find(User.class, id);
        return user;
    }

    @Override
    public List<User> findAll() {
        List<User> users = dbm.getEm().createQuery("select u from User u",
                User.class).getResultList();
        return users;
    }

    @Override
    public void deleteById(Long id) {
        dbm.getEm().getTransaction().begin();
        dbm.getEm().createQuery("delete from User u where u.id = " + id).executeUpdate();
        dbm.getEm().getTransaction().commit();
    }

    @Override
    public void save(User user) {
        dbm.getEm().getTransaction().begin();
        dbm.getEm().merge(user);
        dbm.getEm().getTransaction().commit();
    }

    @Override
    public List<User> findUserByProductId(Long productId) {
        Product product = dbm.getEm().createQuery("select p from Product p where p.id = " +
                productId, Product.class).getSingleResult();
        /**
         * Эта строчка запроса не работает. Как в JPQL получить список, в котором
         * есть данный продукт я придумать не смог. Есть таблица, где есть эти соответствия,
         * но в отличие от SQL здесь идёт работа с сущностями и я не понимаю, как это сделать.
         * Это можно было бы сделать, если бы в поле Product.carts добавлять те корзины,
         * в которые этот продукт попал. Но уж больно это громоздкое решение.
         * Также можно было бы
         */
        List<Cart>carts = dbm.getEm().createQuery("select c from Cart c where " +
                product + " in c.cart", Cart.class).getResultList();
        List<User> users = dbm.getEm().createQuery( "select u from User u where u.cart in " +
                carts, User.class).getResultList();
        return users;
    }
}
