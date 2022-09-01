package fyodorov.repository;

import fyodorov.model.Product;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepositoryDB implements ProductRepository{

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    @Override
    @PostConstruct
    public void init() {
        entityManagerFactory = new Configuration()
                .configure("hibernate_hw.cfg.xml")
                .buildSessionFactory();
        entityManager = entityManagerFactory.createEntityManager();

        /**
         * Только в первый раз
         */
//        entityManager.getTransaction().begin();
//        entityManager.persist(new Product("Milk", 89));
//        entityManager.persist(new Product("Bread", 39));
//        entityManager.persist(new Product("Cheese", 139));
//        entityManager.persist(new Product("Potato", 26));
//        entityManager.persist(new Product("Carrot", 42));
//        entityManager.getTransaction().commit();
    }

    @Override
    public void addProduct(String title, Integer price) {
        entityManager.getTransaction().begin();
        entityManager.persist(new Product(title, price));
        entityManager.getTransaction().commit();
    }

    @Override
    public List<Product> findAll() {
        List<Product> products = entityManager.createQuery(
                "select p from Product p", Product.class).getResultList();
        return products;
    }

    @Override
    public Optional<Product> findById(Long id) {
        Optional<Product> product = Optional.ofNullable(entityManager.find(Product.class, id));
        return product;
    }

    public void shutdown() {
        entityManager.close();
        entityManagerFactory.close();
    }
}
