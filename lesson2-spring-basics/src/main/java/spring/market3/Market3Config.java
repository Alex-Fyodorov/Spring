package spring.market3;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import spring.market2.DemoBean;

@Configuration
@ComponentScan(basePackages = {"market3"})
public class Market3Config {
    @Bean
    public DemoBean demoBean() {
        return new DemoBean("Java");
    }
}