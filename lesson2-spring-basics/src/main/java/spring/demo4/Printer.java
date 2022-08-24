package spring.demo4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Printer {
    private INumberGenerator iNumberGenerator;

    @Autowired
    public Printer(INumberGenerator iNumberGenerator) {
        this.iNumberGenerator = iNumberGenerator;
    }

    public void printRandomNumber() {
        System.out.println(iNumberGenerator.generateInt());
    }
}
