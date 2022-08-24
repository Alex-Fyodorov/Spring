package spring.demo2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ItemService itemService = context.getBean("itemService", ItemService.class);
        System.out.println(itemService.findAll());
        System.out.println(context.getBean("stdClass", StdClass.class).getValue());
        context.close();
    }
}
