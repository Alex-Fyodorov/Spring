package fyodorov;

import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        //CREATE

//        entityManager.getTransaction().begin();
//
//        entityManager.persist(new User("User1", "1@mail.ru", "1111"));
//        entityManager.persist(new User("User2", "2@mail.ru", "1112"));
//        entityManager.persist(new User("User3", "3@mail.ru", "1113"));
//        entityManager.persist(new User("User4", "4@mail.ru", "1114"));
//
//        entityManager.getTransaction().commit();

        //FIND

//        User user = entityManager.find(User.class, 1L);
//        System.out.println(user);

        //SELECT

        List<User> users = entityManager.createQuery("select u from User u where u.id in (2, 3)",
                User.class).getResultList();
        for (User userFromDB : users) {
            System.out.println(userFromDB);
        }

        //UPDATE

//        entityManager.getTransaction().begin();
//
//        User user = entityManager.find(User.class, 1L);
//        user.setName("Alex");
//
//        entityManager.getTransaction().commit();
//
//        user = entityManager.find(User.class, 1L);
//        System.out.println(user);

//        entityManager.getTransaction().begin();
//
//        User user = new User("John", "5@mail.ru", "1115");
//        user.setId(2L);
//        entityManager.merge(user);
//
//        entityManager.getTransaction().commit();
//
//        user = entityManager.find(User.class, 2L);
//        System.out.println(user);

        //DELETE

//        entityManager.getTransaction().begin();
//        entityManager.createQuery("delete from User u where u.id = 2").executeUpdate();
//
//        User user = entityManager.find(User.class, 1L);
//        entityManager.remove(user);
//        entityManager.getTransaction().commit();

        Object singleResult = entityManager.createNativeQuery("select u.id as userId\n" +
                        "from users u\n" +
                "where u.name like '%ser3%'").getSingleResult();
        System.out.println("id = " + singleResult);

        entityManager.close();
        entityManagerFactory.close();
    }
}
