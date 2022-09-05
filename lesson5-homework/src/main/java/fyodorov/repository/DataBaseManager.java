package fyodorov.repository;

import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@Repository
public class DataBaseManager {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager em;

    @PostConstruct
    public void init() {
        entityManagerFactory = new Configuration()
                .configure("hibernate_hw.cfg.xml")
                .buildSessionFactory();
        em = entityManagerFactory.createEntityManager();
    }

    public EntityManager getEm() {
        return em;
    }

    public void shutdown() {
        em.close();
        entityManagerFactory.close();
    }
}
