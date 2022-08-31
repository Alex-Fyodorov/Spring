package fyodorov.hw5;

import fyodorov.hw5.model.UserHW;
import fyodorov.hw5.repository.UserRepository;
import fyodorov.hw5.repository.UserRepositoryImpl;

import java.util.List;

public class MainHW {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepositoryImpl();
        userRepository.init();

        userRepository.insert("Alex", 36);
        userRepository.insert("Bob", 18);
        userRepository.insert("Jack", 44);

        System.out.println(userRepository.findAll());
        System.out.println();

        UserHW user = userRepository.findById(1L);
        System.out.println(user);
        user.setName("John");
        userRepository.save(user);
        System.out.println(userRepository.findById(1L));
        System.out.println();

        userRepository.deleteById(1L);
        System.out.println(userRepository.findAll());
        System.out.println();

        List<UserHW> list = userRepository.findAll();
        for (UserHW u : list) {
            userRepository.deleteById(u.getId());
        }
        System.out.println(userRepository.findAll());
        System.out.println();

        userRepository.shutdown();
    }

}
