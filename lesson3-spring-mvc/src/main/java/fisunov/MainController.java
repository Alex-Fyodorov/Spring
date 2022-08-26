package fisunov;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MainController {
    //                            [port][context-path]
    // base url - http://localhost:8189/market[/ подпадает под нашу обработку]

    // GET http://localhost:8189/market/add?param_123_param=10&b=20
    @GetMapping("/add")
    @ResponseBody
    public Integer calculateAdd(
            @RequestParam(name = "param_123_param") Integer a,
            @RequestParam Integer b
    ) {
        return a + b;
    }

    // GET http://localhost:8189/market/products/10/show
    @GetMapping("/products/{id}/show")
    @ResponseBody
    public String getProductTitle(@PathVariable Long id) {
        return "PRODUCT #" + id;
    }

    @GetMapping("/hello")
    public String showHelloPage(Model model) {
        List<Product> items = List.of(
                new Product(1L, "Milk"),
                new Product(2L, "Bread"),
                new Product(3L, "Cheese"),
                new Product(4L, "Water")
        );

        model.addAttribute("items", items);

        return "hello";
    }

    @GetMapping("/obj")
    @ResponseBody
    public Product showProduct() {
        return new Product(1L, "Milk");
    }
}
