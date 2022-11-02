package fyodorov.hw8.repositories;

import fyodorov.hw8.items.Product;
import org.springframework.stereotype.Repository;

//import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepositoryDB implements ProductRepository {

    private DataBaseManager dbm;

    public ProductRepositoryDB(DataBaseManager dbm) {
        this.dbm = dbm;
    }

    /**
     * Только в первый раз
     */
//    @PostConstruct
//    public void init() {
//        dbm.getEm().getTransaction().begin();
//        dbm.getEm().getTransaction().begin();
//        dbm.getEm().persist(new Product("Milk", 89));
//        dbm.getEm().persist(new Product("Bread", 39));
//        dbm.getEm().persist(new Product("Cheese", 139));
//        dbm.getEm().persist(new Product("Potato", 69));
//        dbm.getEm().persist(new Product("Carrot", 59));
//        dbm.getEm().getTransaction().commit();
//        dbm.getEm().getTransaction().commit();
//    }

    @Override
    public void addProduct(String title, Integer price) {
        dbm.getEm().getTransaction().begin();
        dbm.getEm().persist(new Product(title, price));
        dbm.getEm().getTransaction().commit();
    }

    @Override
    public List<Product> findAll() {
        System.out.println();
        List<Product> products = dbm.getEm().createQuery(
                "select p from Product p", Product.class).getResultList();
        return products;
    }

    @Override
    public Optional<Product> findById(Long id) {
//        Optional<Product> product = Optional.ofNullable(dbm.getEm().createQuery(
//                "select p from Product p where id = :id", Product.class)
//                .setParameter("id", id)
//                .getSingleResult());
        Optional<Product> product = Optional.ofNullable(dbm.getEm().find(Product.class, id));
        return product;
    }
}
