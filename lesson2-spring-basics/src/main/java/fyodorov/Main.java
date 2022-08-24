package fyodorov;

import fyodorov.config.AppConfiguration;
import fyodorov.persist.User;
import fyodorov.persist.UserRepository;
import fyodorov.persist.UserRepositoryImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        ApplicationContext context =
//                new ClassPathXmlApplicationContext("spring-context.xml");
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
        UserService userService = context.getBean("userService", UserService.class);


        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter user name: ");
            String userName = scanner.nextLine();

            System.out.println("Enter user role: ");
            String userRole = scanner.nextLine();

            userService.insert(new User(userName, userRole));

            System.out.println("New user has been added.");
            System.out.println("Current user count: " + userService.findAll());

            System.out.println("Enter \"end\" to exist.");
            if (scanner.nextLine().equals("end")) {
                return;
            }
        }
    }
}
