package spring.demo4;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class SquareNumberGenerator implements INumberGenerator {
    @Override
    public int generateInt() {
        return (int)(Math.pow(Math.random() * 1000, 2));
    }
}
