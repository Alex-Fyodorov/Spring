package spring.demo4;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.geekbrains.spring.demo4")
public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainApp.class);
        Printer printer = context.getBean(Printer.class);
        printer.printRandomNumber();
        context.close();
    }

    @Bean
    public NotMyBox notMyBox() {
        NotMyBox notMyBox = new NotMyBox("Red");
        return notMyBox;
    }
}
