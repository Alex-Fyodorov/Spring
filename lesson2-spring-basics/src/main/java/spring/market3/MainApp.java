package spring.market3;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Market3Config.class);

//        SimpleItemService simpleItemService = context.getBean("simpleItemService", SimpleItemService.class);
//        System.out.println(simpleItemService.getAllItems());

        System.out.println(context.getBean("demoBean"));

        context.close();
    }
}
