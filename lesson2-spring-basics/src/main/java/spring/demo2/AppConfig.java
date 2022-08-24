package spring.demo2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.geekbrains.spring.demo2"})
public class AppConfig {
    @Bean
    public StdClass stdClass() {
        StdClass stdClass = new StdClass();
        stdClass.setValue(50);
        return stdClass;
    }
}
