package spring.demo6;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        CartService cartService = context.getBean(CartService.class);
        System.out.println(cartService.getCurrentCart());
        cartService.addToCartByProductId(1L);
        cartService.addToCartByProductId(2L);
        System.out.println(cartService.getCurrentCart());

        OrderService orderService = context.getBean(OrderService.class);
        Order order = orderService.createNewOrder();
        System.out.println(order);

        System.out.println(cartService.getCurrentCart());

        context.close();

        // 1. Что такое спринг бин
        // 2. Какие есть способы инжекции зависимостей
    }
}
