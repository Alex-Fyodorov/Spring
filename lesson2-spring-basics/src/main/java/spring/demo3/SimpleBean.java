package spring.demo3;

import org.springframework.stereotype.Component;


@Component
public class SimpleBean {
    private String title = "A";

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
