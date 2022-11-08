package fyodorov.hw8.controller;

import fyodorov.hw8.items.Product;
import fyodorov.hw8.items.User;
import fyodorov.hw8.services.CartService;
import fyodorov.hw8.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final CartService cartService;
    private final ProductService productService;

    @GetMapping
    public String productPage(
            Model model,
            @RequestParam(required = false) Integer min,
            @RequestParam(required = false) Integer max
    ) {
        model.addAttribute("products", productService.listOfProduct(min, max));
        return "product";
    }

    @GetMapping("/{id}")
    public String productSingle(Model model, @PathVariable Long id) {
        model.addAttribute("products", productService.findById(id));
        return "product";
    }

    @GetMapping("/new")
    public String newProduct(Model model) {
        model.addAttribute("product", new Product());
        return "add_product";
    }

    @PostMapping("/insert")
    public String saveProduct(@Valid Product product, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "add_product";
        }
        productService.save(product.getTitle(), product.getPrice());
        return "redirect:/product";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.delete(id);
        return "redirect:/product";
    }

//    @GetMapping("/remove/{id}")
//    public String removeFromCart(@PathVariable Long id) {
//        cartService.removeFromCart(id);
//        return "redirect:/product";
//    }

//    @GetMapping("/add/{user_id}/{product_id}")
//    public String addToCart(@PathVariable ("product_id") Long productId,
//                            @PathVariable ("user_id") Long userId) {
//        cartService.addToCart(productId, userId);
//        return "redirect:/user";
//    }
//
//    @GetMapping("/cart")
//    public String cartPage(Model model) {
//        model.addAttribute("products", cartService.getCurrentCart());
//        model.addAttribute("sum", cartService.sum());
//        return "cart";
//    }
//
//    @GetMapping("/cart/add/{id}")
//    public String addToCartPage(@PathVariable Long id) {
//        cartService.addToCartByProductId(id);
//        return "redirect:/product/cart";
//    }
//
//    @GetMapping("/cart/remove/{id}")
//    public String removeFromCartPage(@PathVariable Long id) {
//        cartService.removeFromCart(id);
//        return "redirect:/product/cart";
//    }
//

}
