package fyodorov.hw8.persist;

import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepositoryDB implements ProductRepository {

    private EntityManagerFactory factory;
    private EntityManager em;

    @Override
    @PostConstruct
    public void init() {
        factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
        em = factory.createEntityManager();

        /**
         * Только в первый раз
         */
//        em.getTransaction().begin();
//        em.persist(new Product("Milk", 89));
//        em.persist(new Product("Bread", 39));
//        em.persist(new Product("Cheese", 139));
//        em.persist(new Product("Potato", 69));
//        em.persist(new Product("Carrot", 59));
//        em.getTransaction().commit();
    }


    @Override
    public void addProduct(String title, Integer price) {
        em.getTransaction().begin();
        em.persist(new Product(title, price));
        em.getTransaction().commit();
    }

    @Override
    public List<Product> findAll() {
        List<Product> products = em.createQuery(
                "select p from Product p", Product.class).getResultList();
        return products;
    }

    @Override
    public Optional<Product> findById(Long id) {
//        Optional<Product> product = Optional.ofNullable(em.createQuery(
//                "select p from Product p where id = :id", Product.class)
//                .setParameter("id", id)
//                .getSingleResult());
        Optional<Product> product = Optional.ofNullable(em.find(Product.class, id));
        return product;
    }

    public void shutdown() {
        em.close();
        factory.close();
    }
}
