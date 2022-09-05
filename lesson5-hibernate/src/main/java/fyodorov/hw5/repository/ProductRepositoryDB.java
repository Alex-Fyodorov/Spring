package fyodorov.hw5.repository;

import fyodorov.hw5.model.Product;
import fyodorov.hw5.repository.interfaces.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepositoryDB implements ProductRepository {

    private DataBaseManager dbm;

    public ProductRepositoryDB(DataBaseManager dbm) {
        this.dbm = dbm;

//        /**
//         * Только в первый раз
//         */
//        dbm.getEm().getTransaction().begin();
//        dbm.getEm().persist(new Product("Milk", 89));
//        dbm.getEm().persist(new Product("Bread", 39));
//        dbm.getEm().persist(new Product("Cheese", 139));
//        dbm.getEm().persist(new Product("Potato", 26));
//        dbm.getEm().persist(new Product("Carrot", 42));
//        dbm.getEm().persist(new Product("Water", 15));
//        dbm.getEm().getTransaction().commit();
    }

    @Override
    public void addProduct(String title, Integer price) {
        dbm.getEm().getTransaction().begin();
        dbm.getEm().persist(new Product(title, price));
        dbm.getEm().getTransaction().commit();
    }

    @Override
    public List<Product> findAll() {
        List<Product> products = dbm.getEm().createQuery(
                "select p from Product p", Product.class).getResultList();
        return products;
    }

    @Override
    public Optional<Product> findById(Long id) {
        Optional<Product> product = Optional.ofNullable(dbm.getEm().find(Product.class, id));
        return product;
    }
}
