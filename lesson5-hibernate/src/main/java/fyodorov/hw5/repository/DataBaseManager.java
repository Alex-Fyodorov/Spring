package fyodorov.hw5.repository;

import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@Component
public class DataBaseManager {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager em;

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
