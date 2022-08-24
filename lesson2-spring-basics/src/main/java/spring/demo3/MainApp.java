package spring.demo3;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.geekbrains.spring.demo3")
public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainApp.class);

        SimpleBean sb = context.getBean("simpleBean", SimpleBean.class);

        StringStorage stringStorage = context.getBean("stringStorage", StringStorage.class);
        System.out.println(stringStorage.getList());

        StringService stringService = context.getBean("stringService", StringService.class);
        System.out.println(stringService.getConcatStringsFromStorage());

        context.close();
    }
}
