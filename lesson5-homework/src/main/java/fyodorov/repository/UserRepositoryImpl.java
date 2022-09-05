package fyodorov.repository;

import fyodorov.model.User;
import java.util.List;

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
        List<User> users = dbm.getEm().createQuery("select u from UserHW u",
                User.class).getResultList();
        return users;
    }

    @Override
    public void deleteById(Long id) {
        dbm.getEm().getTransaction().begin();
        dbm.getEm().createQuery("delete from UserHW u where u.id = " + id).executeUpdate();
        dbm.getEm().getTransaction().commit();
    }

    @Override
    public void save(User user) {
        dbm.getEm().getTransaction().begin();
        dbm.getEm().merge(user);
        dbm.getEm().getTransaction().commit();
    }
}
