package spring.demo4;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

// MyBox > myBox
@Component
public class MyBox {
    @Value("White")
    private String color;

    @Value("10")
    private int size;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
