package fyodorov.hw5.repository;

import fyodorov.hw5.model.UserHW;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    @Override
    public void init() {
        entityManagerFactory = new Configuration()
                .configure("hibernate_hw.cfg.xml")
                .buildSessionFactory();
        entityManager = entityManagerFactory.createEntityManager();
    }

    @Override
    public void insert(String name, int age) {
        entityManager.getTransaction().begin();
        entityManager.persist(new UserHW(name, age));
        entityManager.getTransaction().commit();
    }

    @Override
    public UserHW findById(Long id) {
        UserHW user = entityManager.find(UserHW.class, id);
        return user;
    }

    @Override
    public List<UserHW> findAll() {
        List<UserHW> users = entityManager.createQuery("select u from UserHW u",
                UserHW.class).getResultList();
        return users;
    }

    @Override
    public void deleteById(Long id) {
        entityManager.getTransaction().begin();
        entityManager.createQuery("delete from UserHW u where u.id = " + id).executeUpdate();
        entityManager.getTransaction().commit();
    }

    @Override
    public void save(UserHW user) {
        entityManager.getTransaction().begin();
        entityManager.merge(user);
        entityManager.getTransaction().commit();
    }

    @Override
    public void shutdown() {
        entityManager.close();
        entityManagerFactory.close();
    }
}
