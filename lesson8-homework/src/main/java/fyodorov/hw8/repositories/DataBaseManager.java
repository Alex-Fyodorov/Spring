package fyodorov.hw8.repositories;

import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@Component
public class DataBaseManager {

    private EntityManagerFactory factory;
    private EntityManager em;

    @PostConstruct
    public void init() {
        factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
        em = factory.createEntityManager();
    }

    public EntityManager getEm() {
        return em;
    }

    public void shutdown() {
        em.close();
        factory.close();
    }
}
