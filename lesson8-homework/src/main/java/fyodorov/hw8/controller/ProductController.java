package fyodorov.hw8.controller;

import fyodorov.hw8.items.Product;
import fyodorov.hw8.items.User;
import fyodorov.hw8.repositories.ProductRepository;
import fyodorov.hw8.repositories.UserRepository;
import fyodorov.hw8.services.CartService;
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

    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final CartService cartService;

    @GetMapping
    public String productPage(
            Model model,
            @RequestParam(required = false) Integer min,
            @RequestParam(required = false) Integer max
    ) {
        List<Product> productList;
        if (min != null || max != null) {
            productList = productRepository.priceFilter(min, max);
        } else {
            productList = productRepository.findAll();
        }

//        if (min != null) {
//            if (max != null) {
//                productList = productRepository.findProductByPriceBetween(min, max);
//            } else {
//                productList = productRepository.findProductByPriceGreaterThan(min);
//            }
//        } else {
//            if (max != null) {
//                productList = productRepository.findProductByPriceBetween(Integer.valueOf(0), max);
//            } else {
//                productList = productRepository.findAll();
//            }
//        }
        model.addAttribute("products", productList);
        return "product";
    }

    @GetMapping("/{id}")
    public String productSingle(Model model, @PathVariable Long id) {
        model.addAttribute("products", productRepository.findById(id).get());
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
        productRepository.save(new Product(product.getTitle(), product.getPrice()));
        return "redirect:/product";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productRepository.deleteById(id);
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
