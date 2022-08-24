package spring.market2;

import org.springframework.stereotype.Component;

@Component
public class SimpleBean {
    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public SimpleBean() {
    }
}