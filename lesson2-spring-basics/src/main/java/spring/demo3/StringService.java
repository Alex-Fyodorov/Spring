package spring.demo3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class StringService {
    @Autowired
    private StringStorage stringStorage;

    public String getConcatStringsFromStorage() {
        return stringStorage.getList().stream().collect(Collectors.joining("; "));
    }
}
