package spring.demo3;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class StringStorage {
    private List<String> list;

    public List<String> getList() {
        return list;
    }

    @PostConstruct
    public void init() {
        list = new ArrayList<>(Arrays.asList("A", "B", "C", "D"));
    }
}
