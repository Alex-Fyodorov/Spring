package fyodorov.hw2;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Component
@Scope("prototype")
public class Cart {
    private List<Product> products;

    public Cart() {
        this.products = new ArrayList<>();
    }

    public void add(Product product){
        products.add(product);
    }

    public void removeById(long id){
        products.removeIf(p -> Objects.equals(p.getId(), id));
    }

    public void removeByTitle(String title){
        products.removeIf(p -> Objects.equals(p.getTitle(), title));
    }

    public void clear(){
        products.clear();
    }

    @Override
    public String toString() {
        return "Cart{" +
                "products=" + products +
                '}';
    }
}
