package fyodorov.config;

import fyodorov.UserService;
import fyodorov.persist.UserRepository;
import fyodorov.persist.UserRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    @Bean
    public UserRepository userRepository() {
        return new UserRepositoryImpl();
    }

    @Bean
    public UserService userService(UserRepository userRepository){
        return new UserService(userRepository);
    }
}
